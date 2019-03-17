package com.mcmillan.JavaExam.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="shows")
public class Show {
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, max=255,message="Title must be present")
	private String title;
	
	@Size(min=1, max=255,message="Network must be present")
	private String network;
	
	@Column(updatable=false)
	private Date createdAt;
	
	@Column
	private Date updatedAt;
	
	//------------many to one--------------
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
//----------one to many------------
	@OneToMany(mappedBy="show", fetch=FetchType.LAZY)
	private List<Review> reviews;
	
	public Show() {
		
	}
//==============getter and setters==========================
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getNetwork() {
		return network;
	}

	public void setNetwork(String network) {
		this.network = network;
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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
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
