/*
 * You can use the following import statements
 * 
 * import javax.persistence.*;
 * 
 */

// Write your code here
package com.example.movie.model;
import javax.persistence.*;
@Entity
@Table(name="movielist")
public class Movie{
    @Id
    @Column(name="movieid")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int movieId;
    @Column(name="moviename")
    private String movieName;
    @Column(name="leadactor")
    private String leadActor;

    public Movie(){}
    public Movie(int Id,String name,String lead){
        movieId=Id;
        movieName=name;
        leadActor=lead;
    }

    public int getMovieId(){
        return movieId;
    }
    public String getMovieName(){
        return movieName;
    }
    public String getLeadActor(){
        return leadActor;
    }

    public void setMovieId(int Id){
        movieId=Id;

    }
    public void setMovieName(String name){
        movieName=name;
    }
    public void setLeadActor(String lead){
        leadActor=lead;
    }
}