package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Product;
import ru.itpark.entity.Shirt;
import ru.itpark.service.*;

@Controller
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;
    private final MobileService mobileService;
    private final ShirtService shirtService;
    private final AccountServiceImpl accountService;

    public ProductController(ProductService productService, MobileService mobileService, ShirtService shirtService, AccountServiceImpl accountService) {
        this.productService = productService;
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
//        model.addAttribute("mobiles", mobileService.findByName(name));
//        model.addAttribute("shirts", shirtService.findByName(name));
        model.addAttribute("products", productService.findByName(name));
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

//    @GetMapping("all-products")
//    public String getAccountProducts(Model model, @AuthenticationPrincipal Account account) {
//        model.addAttribute("account", account);
//        model.addAttribute("mobiles", mobileService.findAllByAccountId(account.getId()));
//        model.addAttribute("shirts", shirtService.findAllByAccountId(account.getId()));
//
//        return "account/all-products";
//    }

    @GetMapping("all-products")
    public String getAccountProducts(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("products", productService.findAllByAccountId(account.getId()));

        return "account/all-products";
    }

    @GetMapping("add-mobile")
    public String addProductMobileForm(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("mobiles", productService.findAllByAccountId(account.getId()));

        return "account/add-mobile";
    }

    @PostMapping("add-mobile")
    public String addProductMobile(@ModelAttribute Mobile mobile, @AuthenticationPrincipal Account account) {
        mobile.setAccount(account);
        productService.saveMobile(mobile);

        return "redirect:/add-mobile";
    }

    @GetMapping("add-shirt")
    public String getAddShirtForm(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("shirts", productService.findAllByAccountId(account.getId()));

        return "account/add-shirt";
    }

    @PostMapping("add-shirt")
    public String addShirtToAccount(@ModelAttribute Shirt shirt, @AuthenticationPrincipal Account account) {
        shirt.setAccount(account);
        productService.saveShirt(shirt);

        return "redirect:/add-shirt";
    }


    @GetMapping("add-product/{id}")
    public String getProductById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "entities/product";
    }

    @GetMapping("add-mobile/{id}")
    public String getMobileById(@PathVariable int id, Model model) {
        model.addAttribute("mobile", productService.findById(id));

        return "entities/mobile";
    }

    @PostMapping("add-mobile/{id}/remove")
    public String removeMobileById(@PathVariable int id, @AuthenticationPrincipal Account account, @ModelAttribute Mobile mobile, Model model) {
        model.addAttribute("account", account);
        productService.deleteById(id);

        return "redirect:/add-mobile";
    }

    @GetMapping("add-shirt/{id}")
    public String getShirtById(@PathVariable int id, Model model) {
        model.addAttribute("shirt", productService.findById(id));

        return "entities/shirt";
    }

    @PostMapping("add-shirt/{id}/remove")
    public String removeShirtById(@PathVariable int id, @AuthenticationPrincipal Account account, @ModelAttribute Shirt shirt, Model model) {
        model.addAttribute("account", account);
        productService.deleteById(id);

        return "redirect:/add-shirt";
    }

//    @PostMapping("add-product/{id}/remove")
//    public String removeProductById(@PathVariable int id, @AuthenticationPrincipal Account account, @ModelAttribute Product product, Model model) {
//        model.addAttribute("account", account);
//        productService.deleteById(id);
//
//        return "redirect:/add-product";
//    }
}
