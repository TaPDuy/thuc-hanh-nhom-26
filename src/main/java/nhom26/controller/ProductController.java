package nhom26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import nhom26.model.Product;

@Controller
public class ProductController {
	
	@GetMapping("/products")
	public String showProducts() {
		return "products";
	}
	
	@GetMapping("/updateProduct")
	public String updateProduct(Model model) {
		model.addAttribute("product", new Product());
		return "update";
	}
}
