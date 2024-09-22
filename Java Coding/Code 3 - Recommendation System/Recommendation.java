import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Recommendation {

    static class Movie {
        String title;
        String genre;

        Movie(String title, String genre) {
            this.title = title;
            this.genre = genre;
        }
    }

    public static List<String> recommendMovies(String inputGenre, List<Movie> movies) {
        List<String> recommendedMovies = new ArrayList<>();
        for (Movie movie : movies) {
            if (movie.genre.equalsIgnoreCase(inputGenre)) {
                recommendedMovies.add(movie.title);
            }
        }
        return recommendedMovies;
    }

    public static List<String> getRecommendations(String genre, List<Movie> movies) {
        List<String> recommendations = recommendMovies(genre, movies);

        if (recommendations.size() < 5) {
            String alternateGenre = genre.equalsIgnoreCase("Sci-Fi") ? "Action" : "Sci-Fi";
            List<String> alternateRecommendations = recommendMovies(alternateGenre, movies);
            recommendations.addAll(alternateRecommendations);
        }

        return recommendations.subList(0, Math.min(5, recommendations.size()));
    }

    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Matrix", "Sci-Fi"));
        movies.add(new Movie("Inception", "Sci-Fi"));
        movies.add(new Movie("The Dark Knight", "Action"));
        movies.add(new Movie("Interstellar", "Sci-Fi"));
        movies.add(new Movie("Gladiator", "Action"));
        movies.add(new Movie("Mad Max: Fury Road", "Action"));
        movies.add(new Movie("Blade Runner 2049", "Sci-Fi"));
        movies.add(new Movie("Terminator 2: Judgment Day", "Action"));
        movies.add(new Movie("The Avengers", "Action"));
        movies.add(new Movie("Star Wars: A New Hope", "Sci-Fi"));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your preferred genre (Sci-Fi/Action): ");
        String userPreferredGenre = scanner.nextLine();

        List<String> recommendations = getRecommendations(userPreferredGenre, movies);

        System.out.println("\nRecommended movies for genre " + userPreferredGenre + ":");
        for (String movie : recommendations) {
            System.out.println(movie);
        }
        
        scanner.close();
    }
}
