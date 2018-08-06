package ru.itpark.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Order;
import ru.itpark.service.MobileService;
import ru.itpark.service.OrderService;

import java.sql.Timestamp;

@Controller
@RequestMapping("/")
public class OrderController {

    private final OrderService orderService;
    private final MobileService mobileService;

    public OrderController(OrderService orderService, MobileService mobileService) {
        this.orderService = orderService;
        this.mobileService = mobileService;
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
}
