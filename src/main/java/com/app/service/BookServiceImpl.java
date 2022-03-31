package com.app.service;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.constant.Constants;
import com.app.custom_exception.DependanceyException;
import com.app.custom_exception.RecordNotFound;
import com.app.dao.BookRepository;
import com.app.dao.UserBookRepository;
import com.app.dao.UserRepository;
import com.app.pojos.Book;
import com.app.pojos.BookIdUserMapping;
import com.app.pojos.IssueBook;
@Service
@Transactional
public class BookServiceImpl implements IBookService{
	@Autowired 
	private BookRepository bookRepo;

	@Autowired
	private EntityManager manager;
	
	   @Autowired
	   private UserBookRepository bmdao;
	   
	   @Autowired
	   private UserRepository userRepo;
	
	
	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return bookRepo.findAll();
	}

	@Override
	public List<Book> findByAuthor(String author) {
		List<Book> book=bookRepo.findByAuthor(author);
		return book;
	}

	@Override
	public List<Book> findByTitle(String title) {
		List<Book> book =bookRepo.findByTitle(title);
		return book;
	}

	@Override
	public Book addOrUpdateBookDetails(Book e) {
		// TODO Auto-generated method stub
		return bookRepo.save(e);
	}

	@Override
	public void issueBook(IssueBook issuebook) {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	public void issueBook(Integer bookId, Integer userId) {
//		bookRepo.findAllById(bookId)
//		.orElseThrow(()-> new RecordNotFound("book with givin Id not found"));
//		userRepo.findById(userId).ifPresentOrElse(
//        user->{
//        	if(user.getNumOfBooksPresent()>4)
//        	{
//        		throw new DependanceyException("Max books already issued .");
//        	}else if(user.getFine()!=Constants.INITIAL_FINE_FOR_MEMBER)
//        	{
//        		
//        		throw new DependanceyException("Fine is not cleared yet");
//        	}else
//        	{
//        		int numberOfBookPresent=user.getNumOfBooksPresent();
//        		user.setNumOfBooksPresent(numberOfBookPresent++);
//        		
//        	}
//        	 Consumer<Book> bookConsumer = book -> {
//                 Integer presentBooksAtLib = book.getAvailabilityCount();
//                 if(presentBooksAtLib>0)
//                 book.setAvailabilityCount(presentBooksAtLib--);
//                 else
//                	 throw new DependanceyException("Book not present in library");
//        	};
//        	
//        	bdao.findById(bookId).ifPresent(bookConsumer);
//        	userRepo.save(user);
//        	BookIdUserMapping bumapping=new BookIdUserMapping();
//        	bumapping.setId(userId);
//        	bumapping.setBookId(bookId);
//        	bumapping.setIssuedOn(new Date());
//        	bmdao.save(bumapping);
//        }, ()->{
//        	new RecordNotFound("member with givin Id is not found");
//        });
//		BookIdUserMapping bumapping=new BookIdUserMapping();
//    	bumapping.setId(userId);
//    	bumapping.setBookId(bookId);
//    	bumapping.setIssuedOn(new Date());
//    	bmdao.save(bumapping);
//		
//	}

}
