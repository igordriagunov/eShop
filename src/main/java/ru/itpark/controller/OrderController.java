package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.Account;
import ru.itpark.entity.Order;
import ru.itpark.entity.Product;
import ru.itpark.service.MobileService;
import ru.itpark.service.OrderService;
import ru.itpark.service.ProductService;

@Controller
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;
    private final MobileService mobileService;
    private final ProductService productService;

    public OrderController(OrderService orderService, MobileService mobileService, ProductService productService) {
        this.orderService = orderService;
        this.mobileService = mobileService;
        this.productService = productService;
    }


    @GetMapping("add-order")
    public String getOrderForm(Model model, @AuthenticationPrincipal Account account) {
        model.addAttribute("account", account);
        model.addAttribute("orders", orderService.findAllByAccountId(account.getId()));

        return "order/add-order";
    }

    @PostMapping("add-order")
    public String addOrder(@ModelAttribute Order order, @AuthenticationPrincipal Account account) {
        order.setAccount(account);
        orderService.save(order);

        return "redirect:/add-order";
    }

    @GetMapping("add-order/{id}")
    public String getOrderById(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));

        return "order/order";
    }

    @PostMapping("add-order/{id}/remove")
    public String deleteOrderById(@PathVariable int id, @ModelAttribute Order order,
                                  @AuthenticationPrincipal Account account, Model model) {
        model.addAttribute("account", account);
        orderService.deleteById(id);

        return "redirect:/add-order";
    }
}
