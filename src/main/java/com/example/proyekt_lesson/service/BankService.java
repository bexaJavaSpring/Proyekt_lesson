package com.example.proyekt_lesson.service;

import com.example.proyekt_lesson.dto.ApiResponse;
import com.example.proyekt_lesson.dto.BankDto;
import com.example.proyekt_lesson.entity.Address;
import com.example.proyekt_lesson.entity.Bank;
import com.example.proyekt_lesson.repository.AddressRepository;
import com.example.proyekt_lesson.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankService {
    @Autowired
    BankRepository bankRepository;
    @Autowired
    AddressRepository addressRepository;

    public List<Bank> getAll() {
        return bankRepository.findAll();
    }

    public Optional<Bank> getOne(Integer id) {
        return bankRepository.findById(id);
    }

    public ApiResponse add(BankDto dto) {
        Bank bank = new Bank();
        bank.setName(dto.getName());
        bank.setPhone(dto.getPhone());
        Address address = new Address();
        address.setCity(dto.getCity());
        address.setHome(dto.getHome());
        address.setStreet(dto.getStreet());
        Address save = addressRepository.save(address);
        bank.setAddress(save);
        bankRepository.save(bank);
        return new ApiResponse("Mana", true);
    }

    public ApiResponse edit(Integer id, BankDto dto) {
        Optional<Bank> byId = bankRepository.findById(id);
        if (!byId.isPresent()) {
            return new ApiResponse("Bunday bank yoq",true);
        }
        Bank bank = byId.get();
        Address address=bank.getAddress();
        address.setCity(dto.getCity());
        address.setStreet(dto.getStreet());
        address.setHome(dto.getHome());
        bank.setName(dto.getName());
        bank.setPhone(dto.getPhone());
        bank.setAddress(address);
        bankRepository.save(bank);
        return new ApiResponse("Edit",true);
    }
}
