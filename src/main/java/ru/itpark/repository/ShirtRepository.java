package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Shirt;

import java.util.List;

//import ru.itpark.entity.AbstractProduct;
//import ru.itpark.entity.Product;

@Repository
public interface ShirtRepository
        extends JpaRepository<Shirt, Integer> {


    List<Shirt> findByNameContains(String name);

    @Override
    List<Shirt> findAllById(Iterable<Integer> iterable);

    List<Shirt> findAllByAccount_Id(int accountId);
}
