package pl.product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import pl.product.model.Product;



public class ProductControllerTest  extends AbstractTest{

	@Override
	   @Before
	   public void setUp() {
	      super.setUp();
	   }
	
	@Test
	   public void createCustomer() throws Exception {
	      String uri = "/createProduct";
	      Product product = new Product(102, "Nazwa produktu", 1442);

	      String inputJson = super.mapToJson(product);
	      System.out.println("################ CREATE PRODUCT");
	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
	         .contentType(MediaType.APPLICATION_JSON_VALUE)
	         .content(inputJson)).andReturn();
	      
	      int status = mvcResult.getResponse().getStatus();
	      assertEquals(200, status);
	      String content = mvcResult.getResponse().getContentAsString();
	      assertEquals(content, "Produkt zostal stworzony: " + product);
	   }
	
	
//	@Test
//	   public void getProductsList() throws Exception {
//	      String uri = "/getProduct";
//	      
//	      int[] tabNumb = {102};
//	      String inputJsonTab = super.mapToJson(tabNumb);
//	      
//	      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
//	 	         .contentType(MediaType.APPLICATION_JSON_VALUE)
//	 	         .content(inputJsonTab)).andReturn();
//	      
//	      int status = mvcResult.getResponse().getStatus();
//	      assertEquals(200, status);
//	      String content = mvcResult.getResponse().getContentAsString();
//	      Product[] customer = super.mapFromJson(content, Product[].class);
//	      assertTrue(customer.length > 0);
//	   }
	
	
	

}
