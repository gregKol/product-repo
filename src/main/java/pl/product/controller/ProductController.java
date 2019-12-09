package pl.product.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.SocketUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import pl.product.dao.ProductRepository;
import pl.product.model.Product;

@RestController
public class ProductController {
	protected final Logger log = Logger.getLogger(getClass().getName());

	@Autowired
	ProductRepository productRepository; // Na potrzeby zapisu do bazy

	// Servis tworzacy produkt
	@RequestMapping(value = "/createProduct", method = RequestMethod.POST)
	public String createProduct(@RequestBody Product product) throws Exception {

		log.log(Level.INFO, "Produkt zawiera", product.toString());
		productRepository.save(product); // Zapis do bazy

		return "Produkt zostal stworzony: " + product;
	}

	// Servis zwracajaca wszystkie produkty z bazy
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	public List<Product> getProduct(@RequestBody Set<Integer> setCreditNumbers) throws Exception {
		List<Product> sendListOfAllProducts = productRepository.findAll();
		
		for (Product product : productRepository.findAll()) {
			if (setCreditNumbers.contains(product.getCreditNumber())) {
				sendListOfAllProducts.add(product);
			}
		}
		return sendListOfAllProducts;
	}
}
