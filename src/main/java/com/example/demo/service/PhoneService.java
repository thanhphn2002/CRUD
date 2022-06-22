package com.example.demo.service;

import com.example.demo.models.Phone;
import com.example.demo.repo.PhoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PhoneService {
    private final PhoneRepository phoneRepository;

    @Autowired
    public PhoneService(PhoneRepository phoneRepository) {
        this.phoneRepository = phoneRepository;
    }

    public List<Phone> getPhones() {
        return phoneRepository.findAll();
    }

    public Optional<Phone> getPhoneId(Long id) {
        return phoneRepository.findById(id);
    }

    public void addPhone(Phone phone) {
        phoneRepository.save(phone);
    }
}
