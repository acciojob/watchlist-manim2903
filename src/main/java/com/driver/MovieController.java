package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {
    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("New Movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("New Director added successfully",HttpStatus.CREATED);
    }
    @PostMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieService.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added successfully",HttpStatus.CREATED);
    }
    @GetMapping("/get-movie-by-name/{Movie}")
    public ResponseEntity<Movie> getMovieByName(@RequestParam("Movie") String movie){
        Movie result=movieService.findMovie(movie);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    @GetMapping("/get-director-by-name/{Director}")
    public ResponseEntity<Director> getDirectorByName(@RequestParam("Director") String director){
        Director result=movieService.findDirector(director);
        return new ResponseEntity<>(result,HttpStatus.FOUND);
    }
    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        List<String> movies =movieService.findMovieFromDirector(director);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> movies=movieService.findAllMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete-director-by-name/{director}")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("director") String director){
        movieService.deleteDirector(director);
        return new ResponseEntity<>("Director and all his movies has been deleted successfully",HttpStatus.OK);
    }
    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("All Directors and their movies deleted successully",HttpStatus.OK);
    }
}
