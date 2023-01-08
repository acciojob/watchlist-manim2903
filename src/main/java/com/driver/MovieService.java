package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void addMovieDirectorPair(String movie,String director){
        movieRepository.saveMovieDirectorPair(movie,director);
    }
    public Movie findMovie(String movieName){
        return movieRepository.findMovie(movieName);
    }
    public Director findDirector(String directorName){
        return movieRepository.findDirector(directorName);
    }
    public List<String> findMovieFromDirector(String director){
        return movieRepository.findMoviesFromDirector(director);
    }
    public String findDirectorOfMovie(String movie){
        return movieRepository.findDirectorOfMovie(movie);
    }
    public List<String> findAllMovies(){
        return movieRepository.findAllMovies();
    }
    public void deleteDirector(String director){
        movieRepository.deleteDirector(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteALlDirectors();;
    }
}
