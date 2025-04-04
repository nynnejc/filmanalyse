package algorithms.data.structures;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReader();
        ArrayList<Movie> movies = fileReader.readMovies("./FilmAnalyse/film-imdb.csv");

        if (movies.isEmpty()) {
            System.out.println("No movies found in the file.");
            return;
        }

        AnalysisEngine engine = new AnalysisEngine(movies);

        Movie longestTitleMovie = engine.findMovieWithLongestTitle();
        if (longestTitleMovie != null) {
            System.out.println("Filmene med de længste titler: " + longestTitleMovie.getTitle());
        }

        System.out.println("Antal Star Trek film: " + engine.countStarTrekMovies());
        System.out.println("Gennemsnits længde på film i timer: " + engine.calculateAverageLengthInHours());
        System.out.println("Højeste antal ord i en filmtitel fra listen: " + engine.findMaxTitleWordCount());
        System.out.println("Hvor mange film der har vundet priser: " + engine.countAwardWinningMovies());
        System.out.println("Hvilket år der vandt flest priser: " + engine.getMostAwardWinningYear());
        System.out.println("Hvor mange film er sequels: " + engine.countSequels());
    }
}
