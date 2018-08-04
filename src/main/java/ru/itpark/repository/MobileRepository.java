package ru.itpark.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itpark.entity.Mobile;


import java.util.List;
import java.util.Optional;

@Repository
public interface MobileRepository
        extends JpaRepository<Mobile, Integer> {


    List<Mobile> findByNameContains(String name);

    @Override
    List<Mobile> findAllById(Iterable<Integer> iterable);

    List<Mobile> findAllByAccount_Id(int accountId);

    @Override
    Optional<Mobile> findById(Integer id);

    @Override
    void deleteById(Integer id);
}
