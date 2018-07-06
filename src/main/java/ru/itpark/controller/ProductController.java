package ru.itpark.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.service.MobileService;

@Controller
@RequestMapping("/")
public class ProductController {

    private final MobileService mobileService;

    public ProductController(MobileService mobileService) {
        this.mobileService = mobileService;
    }

    @GetMapping("/")
    public String open() {

        return "index";
    }

    @GetMapping(params = {"name"})
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("mobiles", mobileService.findByName(name));
        model.addAttribute("name", name);

        return "index";
    }

}
