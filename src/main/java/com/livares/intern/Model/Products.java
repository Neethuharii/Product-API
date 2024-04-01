package com.livares.intern.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@jakarta.persistence.Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Products {

    @jakarta.persistence.Id
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;

}
