package nhom26.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import nhom26.repository.ProductRepository;
import nhom26.model.Product;

@Slf4j
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
	
	@GetMapping("update/{code}")
	public String showUpdateProduct(@PathVariable(value="code") String code, Model model) {
		Optional<Product> product = productRepository.findById(code);
		if (product.isPresent())
			model.addAttribute("product", product.get());
		
		return "update";
	}
	
	@GetMapping("delete/{code}")
	public String showDeleteProduct(@PathVariable(value="code") String code, Model model) {
		Optional<Product> product = productRepository.findById(code);
		if (product.isPresent())
			model.addAttribute("product", product.get());
		
		return "confirmDelete";
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
	
	@PostMapping("update")
	public String updateProduct(@ModelAttribute("product") Product product, Model model) {
		productRepository.save(product);
		return "redirect:/products";
	}
	
	@PostMapping("delete")
	public String deleteProduct(@ModelAttribute("product") Product product, Model model) {
		productRepository.deleteById(product.getCode());
		return "redirect:/products";
	}
}
