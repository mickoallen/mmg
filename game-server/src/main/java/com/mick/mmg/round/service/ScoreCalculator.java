package com.mick.mmg.round.service;

import com.mick.mmg.game.entity.GameRules;
import com.mick.mmg.round.entity.UserGuessResult;

public interface ScoreCalculator {
    ScoredRoundResult getScoredRound(UserGuessResult userGuessResult, long timeTaken, GameRules gameRules);
}
