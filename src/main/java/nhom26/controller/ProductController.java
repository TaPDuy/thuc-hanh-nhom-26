package nhom26.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import nhom26.repository.ProductRepository;
import nhom26.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("list")
	public String showProducts(Model model) {
		List<Product> products = productRepository.findAll();
		
		model.addAttribute(products);
		
		return "products";
	}
	
	@GetMapping("add")
	public String showAddProduct(Model model) {
		return "add";
	}
	
	@PostMapping
	public String addProduct(@ModelAttribute Product product, Model model) {
		Product p = productRepository.getById(product.getCode());
		
		if(p != null) {
			model.addAttribute("errorExistCode", "Trùng mã sản phẩm!!");
		} else {
			productRepository.save(product);
		}
		
		return "products";
	}
	
	@PostMapping
	public String updateProduct(@ModelAttribute Product product, Model model) {
		Product p = productRepository.getById(product.getCode());
		
		p.setDesc(product.getDesc());
		p.setPrice(product.getPrice());
		productRepository.save(p);
		
		return "products";
	}
	
	@PostMapping
	public String deleteProduct(@ModelAttribute Product product, Model model) {
		productRepository.deleteById(product.getCode());
		return "products";
	}
}
