package com.mick.mmg.round.service;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ScoreCalculatorFactory {
    private final ClassicScoreCalculator classicScoreCalculator;

    @Inject
    public ScoreCalculatorFactory(ClassicScoreCalculator classicScoreCalculator) {
        this.classicScoreCalculator = classicScoreCalculator;
    }

    public ScoreCalculator getScoreCalculator() {
        //just one game type for now
        return classicScoreCalculator;
    }
}
