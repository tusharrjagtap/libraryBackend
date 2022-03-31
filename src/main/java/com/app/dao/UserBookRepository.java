package com.app.dao;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.app.pojos.BookIdUserMapping;

public interface UserBookRepository extends JpaRepository<BookIdUserMapping,Integer>{
//	BookIdUserMapping findByBookId(Integer bookId);
//       List<BookIdUserrMapping> findByUserId(Integer userId);
//       BookIdUserMapping findByBookIdAndUserId(Integer bookId,Integer userId);
//	List<BookIdUserMapping> findByreturnDate(LocalDate now);
}
