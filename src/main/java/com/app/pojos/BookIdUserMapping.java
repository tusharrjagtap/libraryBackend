package com.app.pojos;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name = "scholarId_bookid_mapping")
public class BookIdUserMapping extends BaseEntity{

    @NotEmpty(message = "bookId cannot be null")
    private Integer bookId;

    @NotEmpty(message = "scholarId cannot be null ")
    
    private Integer scholarId;
    
    
    @UpdateTimestamp
    @NotEmpty(message = "issuedon cannot be null ")
    private Date issuedOn;

    
    private Date returnDate;
    
    @Column(name = "expectedReturn")
    private LocalDate expectedReturn;
    
    
    private Date renewedAt;

    @Column(name = "num_of_times_renewed")
    private Integer numOfTimesRenewed;
    
    @Column(name="fine")
    private  Float fineOnBook;

	public BookIdUserMapping() {
		
		// TODO Auto-generated constructor stub
	}

	public BookIdUserMapping(@NotEmpty(message = "bookId cannot be null") Integer bookId,
			@NotEmpty(message = "scholarId cannot be null ") Integer scholarId,
			@NotEmpty(message = "issuedon cannot be null ") Date issuedOn, Date returnDate, LocalDate expectedReturn,
			Date renewedAt, Integer numOfTimesRenewed, Float fineOnBook) {
		super();
		this.bookId = bookId;
		this.scholarId = scholarId;
		this.issuedOn = issuedOn;
		this.returnDate = returnDate;
		this.expectedReturn = expectedReturn;
		this.renewedAt = renewedAt;
		this.numOfTimesRenewed = numOfTimesRenewed;
		this.fineOnBook = fineOnBook;
	}

	public Integer getBookId() {
		return bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public Integer getScholarId() {
		return scholarId;
	}

	public void setScholarId(Integer scholarId) {
		this.scholarId = scholarId;
	}

	public Date getIssuedOn() {
		return issuedOn;
	}

	public void setIssuedOn(Date issuedOn) {
		this.issuedOn = issuedOn;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public LocalDate getExpectedReturn() {
		return expectedReturn;
	}

	public void setExpectedReturn(LocalDate expectedReturn) {
		this.expectedReturn = expectedReturn;
	}

	public Date getRenewedAt() {
		return renewedAt;
	}

	public void setRenewedAt(Date renewedAt) {
		this.renewedAt = renewedAt;
	}

	public Integer getNumOfTimesRenewed() {
		return numOfTimesRenewed;
	}

	public void setNumOfTimesRenewed(Integer numOfTimesRenewed) {
		this.numOfTimesRenewed = numOfTimesRenewed;
	}

	public Float getFineOnBook() {
		return fineOnBook;
	}

	public void setFineOnBook(Float fineOnBook) {
		this.fineOnBook = fineOnBook;
	}

	@Override
	public String toString() {
		return "BookIdUserMapping [bookId=" + bookId + ", scholarId=" + scholarId + ", issuedOn=" + issuedOn + ", returnDate="
				+ returnDate + ", expectedReturn=" + expectedReturn + ", renewedAt=" + renewedAt
				+ ", numOfTimesRenewed=" + numOfTimesRenewed + ", fineOnBook=" + fineOnBook + "]";
	}
    
    
    
    
	
}
