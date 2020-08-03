package com.jpop4.repository.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "books")
public class Book {

    @EqualsAndHashCode.Include
    @Id
    private BigInteger id;
    private String name;
    private String author;
    private String description;
    private String category;
}
