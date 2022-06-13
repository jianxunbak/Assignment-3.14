package com.skillsunion.shoppingcartapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/*
 * Note that you should not accidentally import JUnit v4. All codes are using JUnit v5.
 */

@SpringBootTest
public class TestServiceForTest {

	@Autowired ServiceForTest service;
	
	@Test
	public void givenPasswordWithLengthEight_whenMethodIsCalled_thenReturnIntEight() throws Exception {
		String password = "long password";
		int length = service.verifyPassword(password);
		assertEquals(password.length(), length);
	}
	
	@Test
	public void givenPasswordWithLengthFour_whenMethodIsCalled_thenThrowsAnError() {
		String password = "1234";
		
		try {
			service.verifyPassword(password);
		}catch(Exception e) {
			assertEquals("Password must be at least 8 characters", e.getMessage());
		}
	}
}
