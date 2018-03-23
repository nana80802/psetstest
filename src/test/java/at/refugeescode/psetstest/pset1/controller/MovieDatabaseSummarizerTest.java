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

                    Assertions.assertEquals(5, mostHiredActors.size());
                    Assertions.assertEquals("Bess Flowers (82)", mostHiredActors.get(0));
                    Assertions.assertEquals("Christopher Lee (69)", mostHiredActors.get(1));
                    Assertions.assertEquals("Grey Griffin (58)", mostHiredActors.get(2));
                    Assertions.assertEquals("Danny Trejo (54)", mostHiredActors.get(3));
                    Assertions.assertEquals("Eric Roberts (52)", mostHiredActors.get(4));

                    Assertions.assertEquals(2, mostAppearingGenres.size());
                    Assertions.assertEquals("Drama (14495)", mostAppearingGenres.get(0));
                    Assertions.assertEquals("Comedy (8955)", mostAppearingGenres.get(1));

                    Assertions.assertEquals("64.1 %female, 35.9 %male",maleFemaleRatio);
                }
        );
    }
}