package com.mcmillan.JavaExam.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mcmillan.JavaExam.models.Show;

@Repository
public interface ShowRepository extends CrudRepository<Show, Long>{
	
	public List<Show> findAll();
}





