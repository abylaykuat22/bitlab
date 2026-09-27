package com.example.g139springfirst.service;

import com.example.g139springfirst.model.Phone;
import com.example.g139springfirst.repository.PhoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhoneService {

    private final PhoneRepository phoneRepository;

    public List<Phone> getPhones() {
        return phoneRepository.getPhones().stream()
                .sorted(Comparator.comparing(phone -> phone.getPrice()))
                .toList();
    }

    public void addPhone(Phone phone) {
        double price = 200000;
        if (phone.getMemory().equals("256 gb")) {
            price = price * 2;
        } else if (phone.getMemory().equals("512 gb")) {
            price = price * 4;
        } else if (phone.getMemory().equals("1024 gb")) {
            price = price * 8;
        }

        phone.setPrice(price);
        phoneRepository.save(phone);

        // comment test Daniyar
    }

    //Коммент Нурлыбека
    //Арсенал говно
}
