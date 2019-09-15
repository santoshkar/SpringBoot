package com.learning;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = { RestfulControllerWithRepo.class })
@WebAppConfiguration
public class ControllerTest {

	protected MockMvc mvc;

	@Autowired
	WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	}

	@Test
	public void getProductsList() throws Exception {
	   String uri = "/employee/1";
	   MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
	      .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
	   
	   System.out.println(mvcResult);
	   
	   int status = mvcResult.getResponse().getStatus();
	   Assert.isTrue(HttpStatus.FOUND.value() == status, "Response Status doesn't match");
	   String content = mvcResult.getResponse().getContentAsString();
	   Assert.notNull(content, "Content is null");
	}
	
	// TODO: Write test case for other request methods
}
