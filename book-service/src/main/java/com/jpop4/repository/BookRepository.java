package com.jpop4.repository;


import com.jpop4.repository.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface BookRepository extends JpaRepository<Book, BigInteger> {
}
