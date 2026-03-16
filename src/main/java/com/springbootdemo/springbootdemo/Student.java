package com.springbootdemo.springbootdemo;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private int id;
    private String name;
    private String email;
}
