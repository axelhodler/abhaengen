package co.hodler.hang;

import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HangmanApplication.class)
@AutoConfigureMockMvc
public abstract class HangBase {

	@Autowired
	MockMvc mockMvc;

	@Before
	public void before_each() {
		RestAssuredMockMvc.mockMvc(mockMvc);
	}

}
