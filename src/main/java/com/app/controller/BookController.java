package com.app.controller;
import javax.validation.Valid;

import org.hibernate.cache.CacheException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Book;
import com.app.pojos.IssueBook;
import com.app.service.IBookService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BookController {


	@Autowired
	private IBookService bookService;

	@PostMapping
	public Book addBookDetails(@RequestBody  Book e) //de-serial (un marshalling)
	{
		
		System.out.println("in add Book "+e);
		return bookService.addOrUpdateBookDetails(e);
	}
	
	
	  @GetMapping("/allbooks")
	  public ResponseEntity<?> allBooks()  
		{
		  System.out.println("in member all books method");
			try {
			
			return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
			}catch(RuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	 @GetMapping("/author/{author}")  //working
	   
	  public ResponseEntity<?> serchByAuthor(@PathVariable String author)
		{
		  System.out.println("in serch author ");
			try {
			
			return new ResponseEntity<>(bookService.findByAuthor(author), HttpStatus.OK);
			}catch(RuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	
	  @GetMapping("/title/{title}")//working
	   
	  public ResponseEntity<?> serchByTitle(@PathVariable String title)
		{
		  System.out.println("in search title");
			try {
			
			return new ResponseEntity<>(bookService.findByTitle(title), HttpStatus.OK);
			}catch(RuntimeException e)
			{
				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
			}
		
		}
	  @PutMapping
		public Book addorUpdateBookDetails(@RequestBody  Book e) //de-serial (un marshalling)
		{
			
			System.out.println("in add Book "+e);
			return bookService.addOrUpdateBookDetails(e);
		}
//	  @GetMapping("/issuebook") //working for reservation
//	  public ResponseEntity<?> allIssueBook()
//		{
//		System.out.println("in allBook");
//			try {
//			
//			return new ResponseEntity<>(bookService.getAllissueBookForReservation(), HttpStatus.OK);
//			}catch(RuntimeException e)
//			{
//				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
//			}
//		
//		}
	  
	  @PostMapping("/issue")   //working
		public void issueBook( @RequestBody IssueBook issuebook)
		{
		    System.out.println("in issue book ****");
			bookService.issueBook(issuebook);
			
		}
	  
	  //issuebook of member by memberID
	  
//	  @GetMapping("/issuebook/{memberId}")//working
//	  public ResponseEntity<?> allMembers(@PathVariable Integer memberId)
//		{
//		System.out.println("in allBook");
//			try {
//			
//			return new ResponseEntity<>(bookService.getIssueBookOfMemebr(memberId), HttpStatus.OK);
//			}catch(RuntimeException e)
//			{
//				return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
//			}
//		
//		}
	  	  
	  
	  
	  

	
	
//	@GetMapping("login")
//	public ResponseEntity<?> userValidation(@RequestBody Login details)
//	{
//	  System.out.println("in member login");
//		try {
//		
//		return new ResponseEntity<>(bookService.validateUser(details), HttpStatus.OK);
//		}catch(RuntimeException e)
//		{
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
//		}
//	
//	}
	
//	@PutMapping("/issuebook/{issueId}")  //working
//	
//	public ResponseEntity<?> userValidation(@PathVariable Integer issueId)
//	{
//	  System.out.println("fine pay");
//		try {
//		
//		return new ResponseEntity<>(bookService.fineToPay(issueId), HttpStatus.OK);
//		}catch(RuntimeException e)
//		{
//			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);	
//		}
//	
//	}
}
