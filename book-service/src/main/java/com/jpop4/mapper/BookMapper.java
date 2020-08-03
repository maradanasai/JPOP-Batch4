package com.jpop4.mapper;

import com.jpop4.domain.BookDto;
import com.jpop4.repository.entity.Book;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {
    BookDto toBookDto(Book bookEntity);
    Book toBook(BookDto bookDto);
    List<BookDto> toBookDtos(Iterable<Book> bookEntities);
}
