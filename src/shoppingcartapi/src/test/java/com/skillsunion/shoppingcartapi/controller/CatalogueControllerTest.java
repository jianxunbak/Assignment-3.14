package com.skillsunion.shoppingcartapi.controller;

import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.skillsunion.shoppingcartapi.entity.Catalogue;
import com.skillsunion.shoppingcartapi.repository.CatalogueRepository;

@WebMvcTest(CatalogueController.class)
public class CatalogueControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CatalogueRepository mockRepo;
	
	@Test
	public void givenNoDataExist_whenFetchById_thenReturnNotFound() throws Exception {
		
		int mockId = 1;
		Optional<Catalogue> catalogue = Optional.empty();
		when(mockRepo.findById(mockId)).thenReturn(catalogue);
		this.mockMvc.perform(get("/catalogues/"+mockId)).andDo(print()).andExpect(status().isNotFound());
		
	}
	
	@Test
	public void givenDataExist_whenFetchById_thenReturnOkAndData() throws Exception {
		Catalogue cat = new Catalogue();
		cat.setId(1);
		cat.setName("cat");
		cat.setPrice(1.9f);
		Optional<Catalogue> dataToReturn = Optional.of(cat);
		when(mockRepo.findById(cat.getId())).thenReturn(dataToReturn);
		ResultActions result = this.mockMvc.perform(get("/catalogues/"+cat.getId()))
				.andDo(print())	
				.andExpect(jsonPath("$.name").value(cat.getName()))
				.andExpect(status().isOk());
	}
}
