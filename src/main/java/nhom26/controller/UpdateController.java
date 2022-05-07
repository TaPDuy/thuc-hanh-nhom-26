package nhom26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom26.model.Product;

@Controller
@RequestMapping("/updateProduct")
public class UpdateController {
	
	@GetMapping
	public String updateProduct(Model model) {
		model.addAttribute("product", new Product());
		return "update";
	}
}