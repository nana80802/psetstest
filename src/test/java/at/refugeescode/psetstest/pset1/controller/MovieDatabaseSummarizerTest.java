package at.refugeescode.psetstest.pset1.controller;

import at.refugeescode.psetstest.pset1.model.Summary;
import org.junit.jupiter.api.Assertions;

import java.util.List;

class MovieDatabaseSummarizerTest {
    MovieDatabaseSummarizer movieDatabaseSummarizer = new MovieDatabaseSummarizer();
    @org.junit.jupiter.api.Test
    void summarize() {
        Summary summary = movieDatabaseSummarizer.summarize();
        Integer numberOfMovies = summary.getNumberOfMovies();
        Integer numberOfActors = summary.getNumberOfActors();
        List<String> mostRatedMovies = summary.getMostRatedMovies();
        List<String> mostHiredActors = summary.getMostHiredActors();
        List<String> mostAppearingGenres = summary.getMostAppearingGenres();
        String maleFemaleRatio = summary.getMaleFemaleRatio();

        Assertions.assertAll (
                () -> {
                    Assertions.assertEquals(Integer.valueOf(29947), numberOfMovies);
                    Assertions.assertEquals(Integer.valueOf(274570), numberOfActors);

                    Assertions.assertEquals((5), mostRatedMovies.size() );
                    Assertions.assertEquals("Reckless (10.0)", mostRatedMovies.get(0));
                    Assertions.assertEquals("Girl in the Cadillac (10.0)",mostRatedMovies.get(1));
                    Assertions.assertEquals("The Haunted World of Edward D. Wood, Jr. (10.0)", mostRatedMovies.get(2));
                    Assertions.assertEquals("Carmen Miranda: Bananas Is My Business (10.0)", mostRatedMovies.get(3));
                    Assertions.assertEquals("Other Voices Other Rooms (10.0)", mostRatedMovies.get(4));
                }
        );
    }
}