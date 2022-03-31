package com.app.service;

import java.util.List;

import com.app.pojos.Book;
import com.app.pojos.IssueBook;


public interface IBookService {

	
   List<Book> getAllBooks();
   List<Book> findByAuthor(String author);  //added
   List<Book> findByTitle(String title);//done
   Book addOrUpdateBookDetails(Book e);
   void issueBook(IssueBook issuebook);//to Add book

    
    
////  Book getBookById(int id);
//  void deleteBook(Integer deletebook);  //added not working
//  Book getBookById(Integer bookIds);          //added
// void updateBookQty(Integer bookId,Integer qty);  //yes it is working
   //issue book



//  //book renew 
//  void renewBook(Integer bookId, Integer memberId);//

//added
  //String returnBook(Integer issueId);  //added
  //String updateMemberFine(Integer memberId);
//  List<BookIdMemberMapping> bookForFine();
//  List<BookIdMemberMapping> getAllissueBook();//added
//   List<BookIdMemberMapping> getAllissueBookForReservation();
//   List<BookIdMemberMapping> getIssueBookOfMemebr(Integer memberId);

}
