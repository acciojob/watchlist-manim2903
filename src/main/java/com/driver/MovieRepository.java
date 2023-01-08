package com.driver;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieMap;

    private HashMap<String,Director> directorMap;
    private HashMap<String,List<String>> directorMovieMap;
    //pair is directorName and list of movies

    //initialization of values is very important
    public MovieRepository(){
        this.movieMap=new HashMap<String,Movie>();
        this.directorMap=new HashMap<>();
        this.directorMovieMap=new HashMap<>();
    }

    public void saveMovie(Movie movie){
        movieMap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director){
        directorMap.put(director.getName(),director);
    }
    public void saveMovieDirectorPair(String movie,String director){
        if(movieMap.containsKey(movie) && directorMap.containsKey(director)){
            List<String> currentMoviesBYDirector=new ArrayList<>();
            if(directorMovieMap.containsKey(director))
                currentMoviesBYDirector=directorMovieMap.get(director);
            currentMoviesBYDirector.add(movie);
            directorMovieMap.put(director,currentMoviesBYDirector);
        }
    }
    public Movie findMovie(String movie){
        return movieMap.get(movie);
    }
    public Director findDirector(String director){
        return directorMap.get(director);
    }
    public List<String> findMoviesFromDirector(String director){
        List<String> moviesList=new ArrayList<>();
        if(directorMovieMap.containsKey(director))
            moviesList=directorMovieMap.get(director);
        return moviesList;
    }
    public String findDirectorOfMovie(String movie){
        String director="";
        for (Map.Entry<String,List<String>> entry: directorMovieMap.entrySet()){
            String key=entry.getKey();
            List<String> values= entry.getValue();
            for(String s : values){
                if(s.equals(movie))
                    director=key;
            }
        }
        return director;
    }
    public List<String> findAllMovies(){
        return new ArrayList<>(movieMap.keySet());
    }
    public void deleteDirector(String director){
        List<String> movies=new ArrayList<>();
        if(directorMovieMap.containsKey(director)){
            //1.Find the movie names by director name rom the pair
            movies=directorMovieMap.get(director);

            //2.Deleting all movies rom movieDb by using movie name
            for(String movie : movies){
                if(movieMap.containsKey(movie)){
                    movieMap.remove(movie);
                }
            }
            //3.Delete the pair
            directorMovieMap.remove(director);
        }
        //4.Delete the director from directorDb
        if(directorMap.containsKey(director)){
            directorMap.remove(director);
        }
    }
    public void deleteALlDirectors(){
        HashSet<String> moviesSet=new HashSet<>();

        //Delete the director map
        directorMap=new HashMap<>();

        //Finding all the movies by all the directors combined
        for(String director : directorMovieMap.keySet()){
            //Iterating in the list o movies by director
            for(String movie : directorMovieMap.get(director)){
                moviesSet.add(movie);
            }
        }
        //Deleting the movie rom the movieDb
        for(String movie : moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
        //Clearing the movie-director pair
        directorMovieMap=new HashMap<>();
    }
}
