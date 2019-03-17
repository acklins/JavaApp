package com.mcmillan.JavaExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="users")
public class User {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
//---------name------------------
	@Size(min=1, max=255, message="Input a name of 1 or more characters.")
	private String name;
	
//-----------email-----------------
	@Email(message="Invalid Email")
	@Size(min=1, max=255, message="Valid email required")
	private String email;
//--------------password---------------------
	@Size(min=8, max=255, message="Input a password greater than 8 characters")
	private String password;
//------------------password confirmation------------
	@Size(min=8, max=255, message="Input a password greater than 8 characters")
	@Transient
	private String confirmation;
//-------------created at and updated at-----------------
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
//-----------------One to Many relationships Show and Review----------
	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Show> shows; 
	

	@OneToMany(mappedBy="user", fetch = FetchType.LAZY)
	private List<Review> reviews; 

	//---------------------constructor------------------------------
	public User() {
	}
////-----------------may not need this---------------------------
	public User(Long id, @Size(min = 1, max = 255, message = "Input a name of 1 or more characters.") String name,
		@Email(message = "Invalid Email") @Size(min = 1, max = 255, message = "Valid email required") String email,
		@Size(min = 8, max = 255, message = "Input a password greater than 8 characters") String password,
		@Size(min = 8, max = 255, message = "Input a password greater than 8 characters") String confirmation,
		List<Show> shows, List<Show> show,List<Review> reviews, List<Review> review){
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmation = confirmation;
		this.shows = show;
		this.reviews = review;
		
}
//-----------------------------getters and setters-------------------------
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Show> getShows(){
		return shows;
	}
	public void setShows(List<Show> shows){
		this.shows = shows;
	}
	
	public List<Review> getReviews(){
		return reviews;
	}
	public void setReviews(List<Review> reviews){
		this.reviews = reviews;
	}

	//-------------------creating and updating----------------
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	}
	
