package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itpark.entity.Account;
import ru.itpark.service.AccountService;
import ru.itpark.service.AccountServiceImpl;
import ru.itpark.service.MobileService;
import ru.itpark.service.ShirtService;

@Controller
@RequestMapping("/")
public class ProductController {

    private final MobileService mobileService;
    private final ShirtService shirtService;
    private final AccountServiceImpl accountService;

    public ProductController(MobileService mobileService, ShirtService shirtService, AccountServiceImpl accountService) {
        this.mobileService = mobileService;
        this.shirtService = shirtService;
        this.accountService = accountService;
    }

    @GetMapping("/")
    public String open(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);

        return "index";
    }

    @GetMapping(params = {"name"})
    public String findByName(@RequestParam String name, Model model) {
        model.addAttribute("mobiles", mobileService.findByName(name));
        model.addAttribute("shirts", shirtService.findByName(name));
        model.addAttribute("name", name);

        return "index";
    }

    @GetMapping("registration")
    public String getRegistration() {

        return "registration";
    }

    @PostMapping("registration")
    public String doneRegistration(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        accountService.createAccount(username, email, password);

        return "redirect:/login";
    }


}
