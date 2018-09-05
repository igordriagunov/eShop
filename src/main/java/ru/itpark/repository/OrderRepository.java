package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Order;

import java.util.List;

@Repository
public interface OrderRepository
        extends JpaRepository<Order, Integer> {

    List<Order> findAllByAccount_Id(int accountId);

    List<Order> findByProductId(int productId);

}
