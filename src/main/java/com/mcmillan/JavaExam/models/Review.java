package com.mcmillan.JavaExam.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="reviews")
public class Review {
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=1)
	private Float rating;
	
	@Column(updatable=false)
	private Date createdAt;
	
	@Column
	private Date updatedAt;
	
	//---------many to one-----------------------
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="show_id")
	private Show show;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
//	//-----------many to many on the review table---------------
//		@ManyToMany(fetch = FetchType.LAZY)
//		@JoinTable(
//				name = "reviews_shows",
//				joinColumns = @JoinColumn(name = "review_id"),
//				inverseJoinColumns = @JoinColumn(name = "show_id")
//		)
//		private List<Show> shows;
	//-----------------constructor-----------------------
		
		public Review() {
			
		}
//-----------------getters and setters------------------

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Float getRating() {
			return rating;
		}

		public void setRating(Float rating) {
			this.rating = rating;
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

		public Show getShow() {
			return show;
		}

		public void setShow(Show show) {
			this.show = show;
		}

		public User getUser() {
			return user;
		}

		public void setUser(User user) {
			this.user = user;
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
