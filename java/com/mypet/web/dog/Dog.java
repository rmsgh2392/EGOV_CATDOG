package com.mypet.web.dog;

import org.springframework.stereotype.Component;

import org.springframework.context.annotation.Lazy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Lazy
@Component
public class Dog {
	private String species, size, name, hairLength, color, sex, breed, age, birthdate,vaccin;
}
