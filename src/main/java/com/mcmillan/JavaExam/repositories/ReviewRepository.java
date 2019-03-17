package com.mcmillan.JavaExam.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcmillan.JavaExam.models.Review;

@Repository
public interface ReviewRepository extends CrudRepository<Review, Long>{

}
