# moviething# Movie Rating System

A Java console program that collects a user's ratings for five recently watched movies and uses that data to demonstrate several kinds of decision structures. It covers if-else, nested if, logical operators (&& and ||), switch, and the conditional (ternary) operator.

## How to Compile and Run

```bash
javac MovieRatingSystem.java
java MovieRatingSystem
```

## My Approach

- User input (Step 1): Scanner reads the user's name with nextLine().
- Ratings (Step 2): Movie names and ratings are stored in two parallel arrays, movieNames[] and movieRatings[]. Index i in one array always describes the same movie as index i in the other. Each rating is collected inside a while loop that keeps re-prompting until the user enters a whole number from 1 to 10, and it also guards against non-numeric input using scanner.hasNextInt() so the program can't get stuck or crash on bad input.
- Average (Step 3): The five ratings are summed in a loop and divided by the number of movies, cast to double first so the division isn't truncated to an integer.
- Classification (Step 4): An if, else if, else chain checks the average against the 9, 7, and 5 thresholds from highest to lowest.
- Masterpiece or disappointment check (Step 5): A loop walks the ratings array. Inside it, an outer if checks the rating value and an inner, nested if checks that the movie name exists before printing. This is the nested if the assignment asks for.
- Consistency check (Step 6): A boolean flag, allRatingsHigh, is combined with && across every rating to see if all of them are 7 or higher. If not, a second flag uses || to see if any rating is below 3.
- Genre response (Step 7): A switch on the lowercase genre string picks the matching response, with a default case for anything not on the list.
- Recommendation (Step 8): A single ternary expression, condition ? "Interstellar" : "The Dark Knight", picks the recommended movie based on whether the genre was Sci-Fi.

## Testing

I ran the program several times with different inputs to exercise every branch.

- All high ratings, average 9.20, gave "cinephile." A 10 out of 10 rating triggered the masterpiece message. All ratings 7 or higher triggered "enjoy most movies." The genre "Sci-Fi" gave the correct response and the "Interstellar" recommendation.
- Low and mixed ratings, average 4.60, gave "tough critic." Ratings below 4 triggered the disappointment messages. A rating below 3 triggered "strong opinions." The genre "Comedy" gave the correct response and the "The Dark Knight" recommendation.
- Mid-range ratings, average 6.00, gave "mixed feelings." An unrecognized genre, "Anime," fell through to the switch statement's default case.
- Invalid rating input, typing "abc" for non-numeric and "15" for out of range, was correctly rejected and re-prompted before the program accepted a valid rating.

## Reflection

A nested if is an if statement placed inside the body of another if, so the inner condition is only evaluated when the outer one is already true. This lets you check something more specific once a broader condition has been met. An if-else statement, by contrast, picks between two or more mutually exclusive branches at the same level. Switch is often cleaner than a long chain of if statements when you're comparing one variable against many specific, discrete values, since it avoids repeating variable.equals() over and over and makes the set of possible cases easier to scan at a glance. The conditional operator simplifies decision-making by collapsing a short if-else that only assigns or returns a value into a single expression, which is handy for simple, one-line choices like picking a recommended movie. Short-circuit evaluation means Java stops evaluating a && expression as soon as it finds a false operand, and stops evaluating a || expression as soon as it finds a true one, since the overall result is already determined at that point. This matters because it avoids unnecessary work and lets you safely write conditions like obj != null && obj.value > 0, where the second check would fail if the first one hadn't already stopped it from running.