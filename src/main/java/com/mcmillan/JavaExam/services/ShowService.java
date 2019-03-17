package com.mcmillan.JavaExam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mcmillan.JavaExam.models.Show;
import com.mcmillan.JavaExam.repositories.ShowRepository;

@Service
public class ShowService {
	private final ShowRepository showRepository;
	
	public ShowService(ShowRepository showRepository) {
		this.showRepository = showRepository;
}
//-------------------create-----------------------
	public Show createdShow(Show s) {
		return showRepository.save(s);
	}
//----------------read----------------------
	public List<Show> findAllShows(){
		return showRepository.findAll();
	}
	
	public Show findShowById(Long id) {
		return showRepository.findById(id).get();
	}
	//------------------------------------update------------------
	public Show updateShow(Show s) {
		return showRepository.save(s);
	}
	//-------------------Destroy----------------------
	public void delete(Long id) {
		showRepository.deleteById(id);
	}
}
