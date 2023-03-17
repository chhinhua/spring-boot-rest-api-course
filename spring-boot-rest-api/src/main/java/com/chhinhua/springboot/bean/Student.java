package com.chhinhua.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

/**
 * @author Chhin_Hua - 17/03
 **/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class Student {

    private int id;
    private String firstName;
    private String lastName;

}
