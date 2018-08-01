package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.entity.Account;
import ru.itpark.entity.Order;
import ru.itpark.repository.OrderRepository;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    public void createOrder(Date date, Account account) {
//
//        Order order = new Order(
//                0,
//                date,
//                account
//        );
//
//        orderRepository.save(order);
//
//    }

    public void save(Order order) {
        orderRepository.saveAndFlush(order);
    }

    public List<Order> findAllByAccountId(int accountId) {
        return orderRepository.findAllByAccount_Id(accountId);
    }

    public OrderRepository getOrderRepository() {
        return orderRepository;
    }
}
