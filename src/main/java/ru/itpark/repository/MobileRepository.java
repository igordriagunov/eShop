package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//import ru.itpark.entity.AbstractProduct;
import ru.itpark.entity.Mobile;
import ru.itpark.entity.Product;
//import ru.itpark.entity.Product;


import java.util.List;

@Repository
public interface MobileRepository
        extends JpaRepository<Mobile, Integer> {


    List<Mobile> findByNameContains(String name);

    @Override
    List<Mobile> findAllById(Iterable<Integer> iterable);

    List<Mobile> findAllByAccount_Id(int accountId);
}
