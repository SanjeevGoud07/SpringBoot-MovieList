/*
 * You can use the following import statements
 * 
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.movie.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;

import com.example.movie.repository.MovieRepository;
import com.example.movie.repository.MovieJpaRepository;
import com.example.movie.model.Movie;

@Service
public class MovieJpaService implements MovieRepository{

    @Autowired
    private MovieJpaRepository movieJpaRepository;
    private Movie Save;

    @Override
    public ArrayList<Movie> getMovies(){
        List<Movie> movieLists=movieJpaRepository.findAll();
        ArrayList<Movie> movies=new ArrayList<>(movieLists);
        return movies;
    }

	@Override
	public Movie getMovieById(int movieId) {
		try{
			Movie movie=movieJpaRepository.findById(movieId).get();
			return movie;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Movie addMovie(Movie movie) {
		// TODO Auto-generated method stub
		movieJpaRepository.save(movie);
		return movie;
	}

	@Override
	public Movie updateMovie(int movieId, Movie movie) {
		// TODO Auto-generated method stub
		try{
			Movie newMovie=movieJpaRepository.findById(movieId).get();
			if(movie.getMovieName()!=null){
				newMovie.setMovieName(movie.getMovieName());
			}
			if(movie.getLeadActor()!=null){
				newMovie.setLeadActor(movie.getLeadActor());
			}
			movieJpaRepository.save(newMovie);
			return newMovie;
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteMovie(int movieId) {
		// TODO Auto-generated method stub
		try{
			movieJpaRepository.deleteById(movieId);
		}
		catch(Exception e){
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}

}