package fr.wildcodeschool.serialSeries;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import fr.wildcodeschool.serialSeries.entity.User;
import fr.wildcodeschool.serialSeries.repository.UserRepository;

@SpringBootTest
class SerialSeriesApplicationTests {
	@Autowired MockMvc mvc;
	@Test
	void contextLoads() {
	}
	
	@Test
	void userCreator() {
		UserRepository repository = new UserRepository();
		
		
		repository.getUsers();

		

	}

}
