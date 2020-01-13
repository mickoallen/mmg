package com.mick.mmg.round.service;

import com.mick.mmg.game.entity.GameRules;
import com.mick.mmg.round.entity.UserGuessResult;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.LinkedHashMap;
import java.util.Map;

@Singleton
public class ClassicScoreCalculator implements ScoreCalculator {
    private static final Map<Integer, Integer> TIME_TAKEN_MULTIPLIER;

    static {
        TIME_TAKEN_MULTIPLIER = new LinkedHashMap<>();

        TIME_TAKEN_MULTIPLIER.put(5, 5);
        TIME_TAKEN_MULTIPLIER.put(10, 4);
        TIME_TAKEN_MULTIPLIER.put(30, 3);
        TIME_TAKEN_MULTIPLIER.put(60, 2);
    }

    @Inject
    public ClassicScoreCalculator() {
    }

    @Override
    public ScoredRoundResult getScoredRound(UserGuessResult userGuessResult, long timeTaken, GameRules gameRules) {
        return new ScoredRoundResult()
                .setSongGuessScore(gameRules.isSongNameGuess() ? getMultipliedScore(userGuessResult.getSongNameGuessAccuracy(), timeTaken) : 0)
                .setArtistNameGuessScore(gameRules.isArtistNameGuess() ? getMultipliedScore(userGuessResult.getArtistNameGuessAccuracy(), timeTaken) : 0)
                .setYearReleasedGuessScore(gameRules.isYearReleasedGuess() ? getMultipliedScore(userGuessResult.getYearReleasedGuessAccuracy(), timeTaken) : 0);
    }

    public int getMultipliedScore(int accuracy, long timeTaken) {
        for (Map.Entry<Integer, Integer> timeScoreMultiplierEntry : TIME_TAKEN_MULTIPLIER.entrySet()) {
            if (timeTaken < timeScoreMultiplierEntry.getKey()) {
                return accuracy * timeScoreMultiplierEntry.getValue();
            }
        }

        return accuracy;
    }
}
