package com.mick.mmg.round.service;

import com.mick.mmg.exceptions.NotFoundException;
import com.mick.mmg.game.entity.GameEntity;
import com.mick.mmg.game.entity.GameRepository;
import com.mick.mmg.game.service.GameStartedEvent;
import com.mick.mmg.json.JsonCodec;
import com.mick.mmg.round.RoundStartEvent;
import com.mick.mmg.round.entity.RoundEntity;
import com.mick.mmg.round.entity.RoundRepository;
import com.mick.mmg.round.entity.UserGuessResult;
import com.mick.mmg.round.entity.UserRoundGuess;
import io.micronaut.context.event.ApplicationEventPublisher;
import io.micronaut.runtime.event.annotation.EventListener;
import io.micronaut.scheduling.annotation.Async;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;
import java.util.Optional;

@Singleton
public class RoundService {
    private final RoundRepository roundRepository;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final GuessAccuracyService guessAccuracyService;
    private final ScoreCalculatorFactory scoreCalculatorFactory;
    private final GameRepository gameRepository;

    @Inject
    public RoundService(
            final RoundRepository roundRepository,
            final ApplicationEventPublisher applicationEventPublisher,
            final GuessAccuracyService guessAccuracyService,
            final ScoreCalculatorFactory scoreCalculatorFactory,
            final GameRepository gameRepository) {
        this.roundRepository = roundRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.guessAccuracyService = guessAccuracyService;
        this.scoreCalculatorFactory = scoreCalculatorFactory;
        this.gameRepository = gameRepository;
    }

    public List<RoundEntity> createRounds(List<RoundEntity> rounds){
        return roundRepository.create(rounds);
    }

    public UserGuessResult roundGuess(String code, UserRoundGuess userRoundGuess) {
        GameEntity gameEntity = gameRepository.get(code);

        List<RoundEntity> roundsForGame = roundRepository.getRoundsForGame(code);
        RoundEntity roundEntity = roundsForGame
                .stream()
                .filter(round -> round.getRoundNumber() == userRoundGuess.getRoundNumber())
                .findFirst()
                .orElseThrow(() -> new NotFoundException("That round doesn't exist for game " + userRoundGuess));

        UserGuessResult userGuessResult = guessAccuracyService.calculatePercentCorrect(roundEntity, userRoundGuess);
        ScoredRoundResult scoredRound = scoreCalculatorFactory.getScoreCalculator().getScoredRound(userGuessResult, userRoundGuess.getTimeTaken(), gameEntity.getGameRules());
        userGuessResult.setScoredRoundResult(scoredRound);

        applicationEventPublisher.publishEvent(userGuessResult);

        return userGuessResult;
    }

    @EventListener
    @Async
    public void gameStarted(GameStartedEvent gameStartedEvent){
        //get first round
        List<RoundEntity> roundsForGame = roundRepository.getRoundsForGame(gameStartedEvent.getCode());

        Optional<RoundEntity> firstRoundOptional = roundsForGame.stream().filter(round -> round.getRoundNumber() == 0).findFirst();

        RoundEntity roundEntity = firstRoundOptional.get();

        applicationEventPublisher.publishEvent(new RoundStartEvent().setRoundEntity(roundEntity));
    }

    @EventListener
    @Async
    public void userSubmitted(UserGuessResult userGuessResult){
        //check if the round has finished
        //report that round has finished
        //start new round if there are still rounds remaining
        //or
        //finish game
    }
}
