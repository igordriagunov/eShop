package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.entity.Account;
import ru.itpark.service.MobileService;
import ru.itpark.service.ShirtService;

@Controller
@RequestMapping("/")
public class ProductController {

    private final MobileService mobileService;
    private final ShirtService shirtService;
    public ProductController(MobileService mobileService, ShirtService shirtService) {
        this.mobileService = mobileService;
        this.shirtService = shirtService;
    }

    @GetMapping("/")
    public String open(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account",account);

        return "index";
    }

    @GetMapping(params = {"name"})
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("mobiles", mobileService.findByName(name));
        model.addAttribute("shirts", shirtService.findByName(name));
        model.addAttribute("name", name);

        return "index";
    }


}
