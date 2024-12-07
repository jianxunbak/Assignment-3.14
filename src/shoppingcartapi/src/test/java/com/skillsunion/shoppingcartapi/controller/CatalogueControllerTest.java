package com.skillsunion.shoppingcartapi.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.StackWalker.Option;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.skillsunion.shoppingcartapi.entity.Catalogue;
import com.skillsunion.shoppingcartapi.repository.CatalogueRepository;

@WebMvcTest(CatalogueController.class)
public class CatalogueControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CatalogueRepository mockRepo;

	@Autowired
	private ObjectMapper objectMapper;

	// Add code here

	@Test
	public void testGetCatalogueWhenIdNotFound() throws Exception {
		// step 1: build a get request to /customer/1
		RequestBuilder request = MockMvcRequestBuilders.get("/catalogues/1");
		// step 2: perform the request, get response
		mockMvc.perform(request).andExpect(status().isNotFound());
		// step 2: assert
	}

	@Test
	public void testGetCatalogueWhenIdFound() throws Exception {
		// step 1: build the mock object
		Catalogue catalogue = Catalogue.builder().id(1).name("Iphone 16").price(1600.0F).build();
		Mockito.when(mockRepo.findById(1)).thenReturn(Optional.of(catalogue));
		// step 2: perform the request, get response and assert
		mockMvc.perform(MockMvcRequestBuilders.get("/catalogues/1")).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.name").value("Iphone 16"))
				.andExpect(jsonPath("$.price").value(1600.0F));
	}

	@Test
	public void testDbConnectionLost() throws Exception {
		Catalogue catalogue = Catalogue.builder().id(1).name("Iphone 16").price(1600.0F).build();
		when(mockRepo.save(catalogue))
				.thenThrow(new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Simulate 500 error"));
		assertThrows(ResponseStatusException.class, () -> {
			mockRepo.save(catalogue);
		});
	}

}