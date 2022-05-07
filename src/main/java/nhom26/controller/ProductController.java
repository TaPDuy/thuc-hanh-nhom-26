package nhom26.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import nhom26.repository.ProductRepository;
import nhom26.model.Product;

@Controller
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping()
	public String showProducts(Model model) {
		List<Product> products = productRepository.findAll();
		
		model.addAttribute("products", products);
		
		
		return "products";
	}
	
	@GetMapping("add")
	public String showAddProduct(Model model) {
		Product p = new Product();
		model.addAttribute("product", p);
		return "add";
	}
	
	@PostMapping
	public String addProduct(@ModelAttribute Product product, Model model) {
		Optional<Product> p = productRepository.findById(product.getCode());
		
		if(p.isPresent()) {
			model.addAttribute("errorExistCode", "Trùng mã sản phẩm!!");
			return "add";
		} else {
			productRepository.save(product);
		}
		
		return "redirect:/products";
	}
	
	@PutMapping
	public String updateProduct(@ModelAttribute Product product, Model model) {
		Product p = productRepository.getById(product.getCode());
		
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		productRepository.save(p);
		
		return "products";
	}
	
	@DeleteMapping
	public String deleteProduct(@ModelAttribute Product product, Model model) {
		productRepository.deleteById(product.getCode());
		return "products";
	}
}
