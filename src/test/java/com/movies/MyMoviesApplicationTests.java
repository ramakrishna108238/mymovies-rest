package com.movies;

import static org.junit.Assert.assertEquals;

import javax.servlet.ServletContext;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = MyMoviesApplication.class)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:application-test.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyMoviesApplicationTests {

	@Autowired
	private ServletContext servletContext;

	@Autowired
	private TestRestTemplate restTemplate;

	// Set up data - Create Movie
	@Test
	public void test_A() {
		MovieDto movieDto = new MovieDto();
		movieDto.setName("Junit Movie");
		movieDto.setCast("Test Cast");
		movieDto.setDirector("Test Director");
		movieDto.setYear("2018");

		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity("/movies", movieDto, String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	@Test
	public void test_B() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/movies").queryParam("name", "Junit Movie");

		ResponseEntity<String> responseEntity = this.restTemplate.getForEntity(builder.toUriString(), String.class);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}

	// Update a movie
	@Test
	public void test_C() {
		MovieDto movieDto = new MovieDto();
		movieDto.setName("Junit Movie");
		movieDto.setCast("Test Cast1");
		movieDto.setDirector("Test Director1");
		movieDto.setYear("2018");

		this.restTemplate.put("/movies", movieDto);
	}

	// Delete a movie
	@Test
	public void test_D() {

		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/movies").queryParam("name", "JunitMovie");

		this.restTemplate.delete(builder.toUriString(), String.class);
	}
}
