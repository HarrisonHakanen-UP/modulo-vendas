package br.edu.up.jpa;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import br.edu.up.jpa.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=Vendas.class)
public class ClienteTest {
	 @Autowired
	 ClienteRepository ClienteRepository;
	 
}
