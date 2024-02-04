package com.pocs.apisecurityapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer empId;
    private String firstname;
    private String lastName;
    private String email;
}
