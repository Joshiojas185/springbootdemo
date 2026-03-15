package com.springbootdemo.springbootdemo;

import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
public class Student {

    public int id;
    public String name;
    public String email;

}
