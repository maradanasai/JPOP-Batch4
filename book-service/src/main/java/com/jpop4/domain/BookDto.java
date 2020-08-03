package com.jpop4.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BookDto {

    @EqualsAndHashCode.Include
    private BigInteger id;
    private String name;
    private String author;
    private String description;
    private String category;
}
