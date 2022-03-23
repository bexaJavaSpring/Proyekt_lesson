package com.example.proyekt_lesson.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Department extends AbsNameEntity{
    private String director;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REMOVE,fetch = FetchType.LAZY,
    mappedBy = "department")
    private List<Employee> employeeList;
}
