package ru.itpark.service;

import org.springframework.stereotype.Service;


import ru.itpark.entity.Mobile;
//import ru.itpark.entity.Product;
import ru.itpark.repository.MobileRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MobileService {

    private final MobileRepository mobileRepository;

    public MobileService(MobileRepository mobileRepository) {
        this.mobileRepository = mobileRepository;
    }

    public void save(Mobile mobile) {
        mobileRepository.saveAndFlush(mobile);
    }

    public List<Mobile> findAll() {
        return mobileRepository.findAll();
    }

    public List<Mobile> findByName(String name) {
        return mobileRepository.findByNameContains(name);
    }

    public List<Mobile> findAllByAccountId(int accountId) {
        return mobileRepository.findAllByAccount_Id(accountId);
    }

    public Optional<Mobile> findById(int id) {
        return mobileRepository.findById(id);
    }
}
