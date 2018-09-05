package ru.itpark.repository;

import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Order;
import ru.itpark.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository
        extends JpaRepository<Product, Integer> {

    List<Product> findByNameContains(String name);

    @Override
    List<Product> findAllById(Iterable<Integer> iterable);

    List<Product> findAllByAccount_Id(int accountId);

    @Override
    Optional<Product> findById(Integer id);


    @Override
    void deleteById(Integer id);

    @Override
    <S extends Product> S saveAndFlush(S s);
}
