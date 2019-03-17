package com.mcmillan.JavaExam.services;

import org.springframework.stereotype.Service;

import com.mcmillan.JavaExam.models.Review;
import com.mcmillan.JavaExam.repositories.ReviewRepository;

@Service
public class ReviewService {
		private ReviewRepository reviewRepository;
		
		public ReviewService(ReviewRepository reviewRepository) {
			this.reviewRepository = reviewRepository;
		}
		
		public void leaveReview(Review review) {
			this.reviewRepository.save(review);
		}

}
