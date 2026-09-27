package kz.bitlab.G115rest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class G115RestApplicationTests {

	@Test
	void contextLoads() {
		int numberA = 2;
		int numberB = 2;
		Assertions.assertEquals(numberA, numberB);
	}

}
