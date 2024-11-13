package algorithms.data.structures;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {
    public ArrayList<Movie> readMovies(String filePath) {
        ArrayList<Movie> movies = new ArrayList<>();

        try {
            File file = new File(filePath);
            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] data = line.split(";");

                if (data.length < 6) {
                    System.out.println("Skipper linje med for mange felter: " + line);
                    continue;
                }

                try {
                    String title = data[2].trim();

                    int year = Integer.parseInt(data[0].trim());
                    int length = Integer.parseInt(data[1].trim());

                    boolean wonAward = data[5].trim().equalsIgnoreCase("yes");
                    String series = "";

                    Movie movie = new Movie(title, year, length, wonAward, series);
                    movies.add(movie);
                } catch (NumberFormatException e) {
                    System.out.println("Skipper linje med en formatteringsfejl på et tal: " + line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        }

        return movies;
    }
}
