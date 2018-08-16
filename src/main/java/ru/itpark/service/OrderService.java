package ru.itpark.service;

import org.springframework.stereotype.Service;
import ru.itpark.entity.Account;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Order;
import ru.itpark.entity.Shirt;
import ru.itpark.repository.OrderRepository;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

//    public void createOrder(String date) {
//
//        Order order = new Order(
//                0,
//                date,
//                new Mobile(),
//                new Shirt(),
//                new Account()
//        );
//
//        orderRepository.saveAndFlush(order);
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

    public Optional<Order> findById(int id) {
        return orderRepository.findById(id);
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
