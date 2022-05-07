package nhom26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom26.model.Product;
import nhom26.repository.ProductRepository;

@Controller
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping
	public String showProducts(Model model) {
		List<Product> products = productRepository.findAll();
		
		model.addAttribute(products);
		
		return "products";
	}
	

	@PostMapping
	public String addProduct(Model model) {
		Product product = new Product();
		model.addAttribute(product);
		
		return "add";
	}
	
	
	
}
