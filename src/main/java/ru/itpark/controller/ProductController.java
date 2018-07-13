package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.service.*;

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

    @GetMapping("account-mobiles")
    public String getAccountProducts(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("mobiles", mobileService.findAllByAccountId(account.getId()));

        return "account-products/account-mobiles";
    }

    @PostMapping("account-mobiles")
    public String addMobileToAccount(@ModelAttribute Mobile mobile, @AuthenticationPrincipal Account account) {
        mobile.setAccount(account);
        mobileService.save(mobile);

        return "redirect:/account-mobiles";

    }

    @GetMapping("account-mobiles/{id}")
    public String getMobiles(@PathVariable int id, Model model) {
        model.addAttribute("mobile", mobileService.findById(id));

        return "entities/mobile";
    }

}
