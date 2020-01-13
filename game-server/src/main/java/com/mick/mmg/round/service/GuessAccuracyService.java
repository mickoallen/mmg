package com.mick.mmg.round.service;

import com.mick.mmg.round.entity.RoundEntity;
import com.mick.mmg.round.entity.UserGuessResult;
import com.mick.mmg.round.entity.UserRoundGuess;
import org.apache.commons.text.similarity.LevenshteinDetailedDistance;
import org.apache.commons.text.similarity.LevenshteinResults;

import javax.inject.Singleton;

@Singleton
public class GuessAccuracyService {
    private final LevenshteinDetailedDistance detailedDistance;

    public GuessAccuracyService() {
        detailedDistance = LevenshteinDetailedDistance.getDefaultInstance();
    }

    public UserGuessResult calculatePercentCorrect(RoundEntity roundEntity, UserRoundGuess userRoundGuess) {
        UserGuessResult userGuessResult = new UserGuessResult(userRoundGuess);

        if (userRoundGuess.getSongName() != null && !userRoundGuess.getSongName().isEmpty()) {
            int score = calculatePercentCorrect(roundEntity.getSongName(), userRoundGuess.getSongName());
            userGuessResult.setSongNameGuessAccuracy(score);
        }

        if (userRoundGuess.getArtistName() != null && !userRoundGuess.getArtistName().isEmpty()) {
            int score = calculatePercentCorrect(roundEntity.getArtistName(), userRoundGuess.getArtistName());
            userGuessResult.setArtistNameGuessAccuracy(score);
        }

        if (userRoundGuess.getYearReleased() != null) {
            int yearsOff = roundEntity.getYearReleased() - userRoundGuess.getYearReleased();

            userGuessResult.setYearReleasedGuessAccuracy(calculatePercent(yearsOff, roundEntity.getYearReleased()));
        }

        return userGuessResult;
    }

    private int calculatePercentCorrect(String expected, String guess) {
        int expectedLength = expected.length();
        expected = preprocessString(expected);
        guess = preprocessString(guess);
        LevenshteinResults levenshteinResults = detailedDistance.apply(expected, guess);

        int wrongByAmount = levenshteinResults.getDistance();

        return calculatePercent(wrongByAmount, expectedLength);
    }

    private String preprocessString(String guess) {
        return guess.toLowerCase().replaceAll("\\s", "");
    }

    private int calculatePercent(int offByAmount, int totalAmount) {
        return (int) (((double) ((totalAmount - offByAmount)) / (totalAmount)) * 100);
    }
}
