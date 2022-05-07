package nhom26.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeComtroller {

	@GetMapping
	private String home() {
		return "index";
	}
}
