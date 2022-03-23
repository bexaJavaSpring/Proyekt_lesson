package com.example.proyekt_lesson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = {"serial","number"})
})
public class Employee extends AbsNameEntity{

    @ManyToOne(optional = false)//majbury
    private Department department;

    @JsonIgnore
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Card> cardList;

    @Column(nullable = false)
    @Pattern(regexp = "/+998[0-9]{9}")
    private String phone;
    @Pattern(regexp = "[A-Z]{2}")
    private String serial; //AA
    @Pattern(regexp = "[0-9]{7}")
    private String number;//4444206
    private Double salary;

}
