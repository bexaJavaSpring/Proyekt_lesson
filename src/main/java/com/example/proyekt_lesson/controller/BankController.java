package com.example.proyekt_lesson.controller;

import com.example.proyekt_lesson.dto.ApiResponse;
import com.example.proyekt_lesson.dto.BankDto;
import com.example.proyekt_lesson.entity.Bank;
import com.example.proyekt_lesson.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @PostMapping
    public HttpEntity<?> save(@Valid @RequestBody BankDto dto) {
        ApiResponse response = bankService.add(dto);
        return ResponseEntity.status(response.isActive() ?
                        HttpStatus.CREATED : HttpStatus.CONFLICT).
                body(response);
    }

    @GetMapping
    public HttpEntity<?> getAll() {
        List<Bank> all = bankService.getAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public HttpEntity<?> getOne(@PathVariable Integer id) {
        Optional<Bank> optional = bankService.getOne(id);
        return ResponseEntity.status(optional.isPresent() ?
                HttpStatus.OK :
                HttpStatus.NOT_FOUND).body(optional.orElse(null));
    }
    @PutMapping("/{id}")
    public HttpEntity<?> edit(@PathVariable Integer id,@RequestBody BankDto dto){
        ApiResponse response=bankService.edit(id,dto);
        return ResponseEntity.status(response.isActive() ?
                HttpStatus.OK:HttpStatus.CONFLICT).body(response);
    }
}
