package pl.coderslab.typ_enum;

public class Movie {
    private String title;
    private Genre genre;
    private String director;

    public Movie(String title, Genre genre, String director) {
        this.title = title;
        this.genre = genre;
        this.director = director;
    }

    public enum Genre {
        HORROR("Designed to scare and shock viewers"),
        DRAMA("Serious stories about real‑life problems"),
        COMEDY("Movies made to make people laugh"),
        ROMANCE("Stories focused on love and relationships"),
        ACTION("Fast‑paced films with fights and explosions"),
        ADVENTURE("Exciting journeys and dangerous quests"),
        FANTASY("Magical worlds with mythical creatures"),
        DOCUMENTARY("Films based on real events"),
        SCIENCE_FICTION("Futuristic worlds, technology, space, science");

        private final String description;

        Genre(String description) {
            this.description = description;
        }

        public void displayDescription() {
            System.out.println(description);
        }

    }


    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Genre: " + genre);
        System.out.println("Genre description: ");
        genre.displayDescription();
        System.out.println("Director: " + director);
    }

    public static void main(String[] args) {
        Movie movie = new Movie(
                "Harry Potter",
                Movie.Genre.FANTASY,
                "J. K. Rowling"
        );
        movie.displayDetails();
    }
}
