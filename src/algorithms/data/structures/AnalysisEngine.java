package algorithms.data.structures;

import java.util.ArrayList;
import java.util.Comparator;

public class AnalysisEngine {

    private ArrayList<Movie> movies;

    public AnalysisEngine(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public Movie findMovieWithLongestTitle() {
        if (movies.isEmpty()) {
            return null;
        }

        Movie longestTitleMovie = null;
        int maxLength = 0;
        for (Movie movie : movies) {
            int titleLength = movie.getTitle().length();
            if (titleLength > maxLength) {
                maxLength = titleLength;
                longestTitleMovie = movie;
            }
        }
        return longestTitleMovie;
    }

    public long countStarTrekMovies() {
        long count = 0;
        for (Movie movie : movies) {
            if ("Star Trek".equalsIgnoreCase(movie.getSeries())) {
                count++;
            }
        }
        return count;
    }

    public double calculateAverageLengthInHours() {
        if (movies.isEmpty()) {
            return 0;
        }

        int totalLength = 0;
        for (Movie movie : movies) {
            totalLength += movie.getLength();
        }
        return (totalLength / (double) movies.size()) / 60.0;
    }

    public int findMaxTitleWordCount() {
        int maxWordCount = 0;
        for (Movie movie : movies) {
            int wordCount = movie.getTitleWordCount();
            if (wordCount > maxWordCount) {
                maxWordCount = wordCount;
            }
        }
        return maxWordCount;
    }

    public long countAwardWinningMovies() {
        long count = 0;
        for (Movie movie : movies) {
            if (movie.hasWonAward()) {
                count++;
            }
        }
        return count;
    }

    public int getMostAwardWinningYear() {
        int mostRecentAwardYear = 0;
        for (Movie movie : movies) {
            if (movie.hasWonAward()) {
                int year = movie.getYear();
                if (year > mostRecentAwardYear) {
                    mostRecentAwardYear = year;
                }
            }
        }
        return mostRecentAwardYear;
    }

    public long countSequels() {
        long count = 0;
        for (Movie movie : movies) {
            String series = movie.getSeries();
            if (series != null && !series.isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
