package com.driver;

public class Director {
    private String name;
    private int numberOMovies;
    private double imdbRating;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOMovies() {
        return numberOMovies;
    }

    public void setNumberOMovies(int numberOMovies) {
        this.numberOMovies = numberOMovies;
    }

    public double getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(double imdbRating) {
        this.imdbRating = imdbRating;
    }

    public Director(){

    }
    public Director(String name,int numberOfMovies,double imdbRating){
        this.name=name;
        this.numberOMovies=numberOfMovies;
        this.imdbRating=imdbRating;
    }
}
