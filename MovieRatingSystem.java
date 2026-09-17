import java.util.Scanner;

/**
 * Movie Rating System
 *
 * Collects a user's name and ratings for five recently watched movies,
 * then uses that data to demonstrate several kinds of decision structures:
 * if-else, nested if, logical operators (&&, ||), switch, and the
 * conditional (ternary) operator.
 */
public class MovieRatingSystem {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ------------------------------------------------------------
        // Step 1: Get the user's name
        // ------------------------------------------------------------
        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        System.out.println("\nWelcome, " + userName + "! Let's talk about the movies you've watched.");

        // ------------------------------------------------------------
        // Step 2: Accept and validate movie ratings
        // ------------------------------------------------------------
        final int NUMBER_OF_MOVIES = 5;

        // Parallel arrays: movieNames[i] and movieRatings[i] describe the
        // same movie.
        String[] movieNames = new String[NUMBER_OF_MOVIES];
        int[] movieRatings = new int[NUMBER_OF_MOVIES];

        for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
            System.out.println("\nMovie #" + (i + 1));

            System.out.print("Enter the movie's name: ");
            movieNames[i] = scanner.nextLine();

            int rating = 0;
            boolean validRating = false;

            // Loop until the user enters a rating between 1 and 10
            while (!validRating) {
                System.out.print("Rate \"" + movieNames[i] + "\" from 1 to 10: ");

                if (scanner.hasNextInt()) {
                    rating = scanner.nextInt();
                    scanner.nextLine(); // consume the leftover newline

                    if (rating >= 1 && rating <= 10) {
                        validRating = true;
                    } else {
                        System.out.println("Please enter a number between 1 and 10.");
                    }
                } else {
                    System.out.println("Please enter a valid whole number between 1 and 10.");
                    scanner.nextLine(); // discard the invalid, non-numeric input
                }
            }

            movieRatings[i] = rating;
        }

        // ------------------------------------------------------------
        // Step 3: Calculate the average rating
        // ------------------------------------------------------------
        int totalRating = 0;
        for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
            totalRating += movieRatings[i];
        }

        double averageRating = (double) totalRating / NUMBER_OF_MOVIES;

        System.out.println("\n================================");
        System.out.println("       RATING SUMMARY");
        System.out.println("================================");
        for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
            System.out.println(movieNames[i] + ": " + movieRatings[i] + "/10");
        }
        System.out.printf("%nAverage Rating: %.2f%n", averageRating);

        // ------------------------------------------------------------
        // Step 4: Rating classification using if-else
        // ------------------------------------------------------------
        System.out.println();
        if (averageRating >= 9) {
            System.out.println("You are a cinephile!");
        } else if (averageRating >= 7) {
            System.out.println("You enjoy movies quite a bit.");
        } else if (averageRating >= 5) {
            System.out.println("You have mixed feelings about movies.");
        } else {
            System.out.println("You are a tough critic!");
        }

        // ------------------------------------------------------------
        // Step 5: Check for a favorite / disliked movie using nested if
        // ------------------------------------------------------------
        // "Nested" means an if statement placed inside another if
        // statement's block, so the inner check only runs when the
        // outer condition is true.
        for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
            if (movieRatings[i] == 10) {
                if (movieNames[i] != null) {
                    System.out.println("Wow! You found a masterpiece: " + movieNames[i]);
                }
            }

            if (movieRatings[i] < 4) {
                if (movieNames[i] != null) {
                    System.out.println("That movie didn't impress you much: " + movieNames[i]);
                }
            }
        }

        // ------------------------------------------------------------
        // Step 6: Logical operators to identify consistent ratings
        // ------------------------------------------------------------
        boolean allRatingsHigh = true;
        for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
            allRatingsHigh = allRatingsHigh && (movieRatings[i] >= 7);
        }

        if (allRatingsHigh) {
            System.out.println("You seem to enjoy most movies.");
        } else {
            boolean hasVeryLowRating = false;
            for (int i = 0; i < NUMBER_OF_MOVIES; i++) {
                hasVeryLowRating = hasVeryLowRating || (movieRatings[i] < 3);
            }

            if (hasVeryLowRating) {
                System.out.println("You have strong opinions on movies!");
            }
        }

        // ------------------------------------------------------------
        // Step 7: Genre preference using a switch statement
        // ------------------------------------------------------------
        System.out.println("\nWhat is your favorite movie genre?");
        System.out.println("(Action, Comedy, Horror, Drama, Sci-Fi)");
        System.out.print("Enter your favorite genre: ");
        String favoriteGenre = scanner.nextLine().trim();

        String genreResponse;

        switch (favoriteGenre.toLowerCase()) {
            case "action":
                genreResponse = "You love excitement and thrills!";
                break;
            case "comedy":
                genreResponse = "You enjoy a good laugh.";
                break;
            case "horror":
                genreResponse = "You have a taste for fear!";
                break;
            case "drama":
                genreResponse = "You appreciate deep storytelling.";
                break;
            case "sci-fi":
                genreResponse = "You love futuristic and imaginative worlds!";
                break;
            default:
                genreResponse = "That's a unique taste in movies!";
                break;
        }

        System.out.println(genreResponse);

        // ------------------------------------------------------------
        // Step 8: Movie recommendation using the conditional (ternary) operator
        // ------------------------------------------------------------
        String recommendation = favoriteGenre.equalsIgnoreCase("sci-fi")
                ? "Interstellar"
                : "The Dark Knight";

        System.out.println("Based on your favorite genre, we recommend: " + recommendation);

        System.out.println("\nThanks for using the Movie Rating System, " + userName + "!");

        scanner.close();
    }
}