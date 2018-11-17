package br.edu.up.controller;


import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.up.jpa.dominio.*;
import br.edu.up.jpa.repository.*;



@RestController
@RequestMapping("/moeda")//(value ="/moeda", produces = MediaType.APPLICATION_JSON_VALUE)
public class MoedaController {

	@Autowired
	private MoedaRepository repository;
    //private VendasService service;

    @PostMapping
    public Moeda adicionar(@Valid @RequestBody Moeda moeda) {
        return repository.save(moeda);
    }

    @GetMapping
    public @ResponseBody Iterable<Moeda> listar() {
    	Iterable<Moeda> moeda = repository.findAll();
		return moeda;
    }
    
    /*@GetMapping
	public @ResponseBody Iterable<Moeda> moeda() {
		Iterable<Moeda> moeda = repository.findAll();
		return moeda;
	}*/

    @GetMapping("/{id}") // /moeda/{$id}
    public ResponseEntity<Optional<Moeda>> buscar(@PathVariable int id) {
        Optional<Moeda> moeda  = repository.findById(id);

        if(moeda == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(moeda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Moeda> atualizar(@PathVariable int id,
                                                       @Valid @RequestBody Moeda moeda) {

    	Moeda moedaExistente = repository.findById(id).get();

        if(moedaExistente == null) {
            return ResponseEntity.notFound().build();
        }

        BeanUtils.copyProperties(moeda, moedaExistente, "MoedaID");
        moeda = repository.save(moedaExistente);

        return ResponseEntity.ok(moeda);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable int id) {
    	Moeda moeda = repository.findById(id).get();

        if(moeda == null) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(moeda);

        return ResponseEntity.noContent().build();
    }
	/*
	@RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Moeda> save(@RequestBody  Moeda moeda){
        return ResponseEntity.ok(service.save(moeda));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Optional<Moeda>> findById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(service.findById(id));
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Moeda>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    */
}
