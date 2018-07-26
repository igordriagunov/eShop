package ru.itpark.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Shirt;
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

    @GetMapping("all-products")
    public String getAccountProducts(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("mobiles", mobileService.findAllByAccountId(account.getId()));
        model.addAttribute("shirts", shirtService.findAllByAccountId(account.getId()));

        return "account/all-products";
    }

    @GetMapping("add-mobile")
    public String getAddMobileForm(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("mobiles", mobileService.findAllByAccountId(account.getId()));

        return "account/add-mobile";
    }

    @PostMapping("add-mobile")
    public String addMobileToAccount(@ModelAttribute Mobile mobile, @AuthenticationPrincipal Account account) {
        mobile.setAccount(account);
        mobileService.save(mobile);

        return "redirect:/add-mobile";
    }

    @GetMapping("add-shirt")
    public String getAddShirtForm(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("shirts",shirtService.findAllByAccountId(account.getId()));

        return "account/add-shirt";
    }

    @PostMapping("add-shirt")
    public String addShirtToAccount(@ModelAttribute Shirt shirt, @AuthenticationPrincipal Account account) {
        shirt.setAccount(account);
        shirtService.save(shirt);

        return "redirect:/add-shirt";
    }

    @GetMapping("add-shirt/{id}")
    public String getShirtById(@PathVariable int id, Model model) {
        model.addAttribute("shirt", shirtService.findById(id));

        return "entities/shirt";
    }

    @GetMapping("add-mobile/{id}")
    public String getMobileById(@PathVariable int id, Model model) {
        model.addAttribute("mobile", mobileService.findById(id));

        return "entities/mobile";
    }

//    @PreAuthorize("hasAnyAuthority(account)")
    @PostMapping("add-shirt/{id}/remove")
    public String removeShirtById(@PathVariable int id, @AuthenticationPrincipal Account account, @ModelAttribute Shirt shirt) {
        shirtService.deleteById(id);

        return "redirect:/add-shirt";
    }

//    @PreAuthorize("hasAnyAuthority(account)")
    @PostMapping("add-mobile/{id}/remove")
    public String removeMobileById(@PathVariable int id, @AuthenticationPrincipal Account account, @ModelAttribute Mobile mobile) {
        shirtService.deleteById(id);

        return "redirect:/add-mobile";
    }
}
