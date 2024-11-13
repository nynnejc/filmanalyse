package algorithms.data.structures;

public class Movie {
    private String title;
    private int year;
    private int length;
    private boolean wonAward;
    private String series;

    public Movie(String title, int year, int length, boolean wonAward, String series) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.wonAward = wonAward;
        this.series = series;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getLength() {
        return length;
    }

    public boolean hasWonAward() {
        return wonAward;
    }

    public String getSeries() {
        return series;
    }

    public int getTitleWordCount() {
        return title.split("\\s+").length;
    }
}
