package com.example.proyekt_lesson.entity;

import com.example.proyekt_lesson.enums.CardType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Card extends AbsEntity{
    @ManyToOne
    private Employee employee;
    @ManyToOne
    private Bank bank;
    private Double balance;
    @Enumerated(EnumType.STRING)
    private CardType type;
    private Date expiratedDate;
    @Column(unique = true)
    private String cardNumber;

    private String password;
    @Column(nullable = false)
    private String cv;
}
