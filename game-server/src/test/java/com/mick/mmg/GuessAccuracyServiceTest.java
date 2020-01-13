package com.mick.mmg;

import com.mick.mmg.round.entity.RoundEntity;
import com.mick.mmg.round.entity.UserGuessResult;
import com.mick.mmg.round.entity.UserRoundGuess;
import com.mick.mmg.round.service.GuessAccuracyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class GuessAccuracyServiceTest {
    private GuessAccuracyService guessAccuracyService;
    private RoundEntity roundEntity;

    @BeforeEach
    public void beforeEach() {
        guessAccuracyService = new GuessAccuracyService();

        roundEntity = new RoundEntity()
                .setSongName("dead or alive")
                .setArtistName("bon jovi")
                .setYearReleased(1997);
    }

    @Test
    public void testEmptyGuess() {
        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(
                roundEntity,
                new UserRoundGuess()
        );

        assertEquals(0, userGuessResult.getArtistNameGuessAccuracy());
        assertEquals(0, userGuessResult.getSongNameGuessAccuracy());
        assertEquals(0, userGuessResult.getYearReleasedGuessAccuracy());
    }

    @Test
    public void testExactGuess() {
        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(
                roundEntity,
                new UserRoundGuess()
                        .setSongName("dead or alive")
                        .setArtistName("bon jovi")
                        .setYearReleased(1997)
        );

        assertEquals(100, userGuessResult.getArtistNameGuessAccuracy());
        assertEquals(100, userGuessResult.getSongNameGuessAccuracy());
        assertEquals(100, userGuessResult.getYearReleasedGuessAccuracy());
    }

    @Test
    public void testExactGuessWithWrongSpaces() {
        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(
                roundEntity,
                new UserRoundGuess()
                        .setSongName("dead oralive")
                        .setArtistName("bon          jovi")
                        .setYearReleased(1997)
        );

        assertEquals(100, userGuessResult.getArtistNameGuessAccuracy());
        assertEquals(100, userGuessResult.getSongNameGuessAccuracy());
        assertEquals(100, userGuessResult.getYearReleasedGuessAccuracy());
    }

    @Test
    public void testCloseGuess() {
        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(
                roundEntity,
                new UserRoundGuess()
                        .setSongName("dead r alive")
                        .setArtistName("bor jovi")
                        .setYearReleased(1998)
        );

        assertEquals(87, userGuessResult.getArtistNameGuessAccuracy());
        assertEquals(92, userGuessResult.getSongNameGuessAccuracy());
        assertEquals(100, userGuessResult.getYearReleasedGuessAccuracy());
    }

    @Test
    public void testLessClose() {
        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(
                roundEntity,
                new UserRoundGuess()
                        .setSongName("dead r alive!!!!!!")
                        .setArtistName("bjovi")
                        .setYearReleased(1990)
        );

        assertEquals(46, userGuessResult.getSongNameGuessAccuracy());
        assertEquals(75, userGuessResult.getArtistNameGuessAccuracy());
        assertEquals(99, userGuessResult.getYearReleasedGuessAccuracy());
    }
}
