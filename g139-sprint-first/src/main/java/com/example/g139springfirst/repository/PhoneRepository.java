package com.example.g139springfirst.repository;

import com.example.g139springfirst.model.Phone;
import lombok.Getter;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PhoneRepository {

    @Getter
    private List<Phone> phones = new ArrayList<>();

    public void save(Phone phone) {
        phone.setId(phones.size() + 1L);
        phones.add(phone);
    }
}
