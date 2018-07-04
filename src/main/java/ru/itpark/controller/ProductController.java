package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public String getAll(Model model) {
        model.addAttribute("products", productService.findAll());
        return "index";
    }

    @GetMapping(params = {"name"})
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("products", productService.findByName(name));
        model.addAttribute("name", name);

        return "index";
    }

}
