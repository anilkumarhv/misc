package com.company.java8.streamss;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Sort1 {
    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Lord of the rings", 8.8, true),
                new Movie("Back to the future", 8.5, false),
                new Movie("Carlito's way", 7.9, true),
                new Movie("Pulp fiction", 8.9, false));

        System.out.println(movies);
        movies.sort(Comparator.comparing(Movie::getTitle, String::compareToIgnoreCase));
        System.out.println(movies);
        movies.sort((m1, m2) -> {
            if (m1.isStarted() == m2.isStarted()) {
                return 0;
            }
            return m1.isStarted() ? -1 : 1;
        });
        movies.forEach(System.out::println);

        movies.sort(Comparator.comparing(Movie::isStarted, (star1, star2) -> {
            if (star1 == star2) {
                return 0;
            }
            return star1 ? -1 : 1;
        }));
        movies.forEach(System.out::println);

        System.out.println("Sort a List With Chain of Comparators");
        movies.sort(Comparator.comparing(Movie::isStarted).reversed().thenComparing(Comparator.comparing(Movie::getRating).reversed()));
        movies.forEach(System.out::println);
    }
}

class Movie {
    private String title;
    private double rating;
    private boolean started;

    public Movie(String title, double rating, boolean started) {
        this.title = title;
        this.rating = rating;
        this.started = started;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        this.started = started;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", rating=" + rating +
                ", started=" + started +
                '}';
    }
}