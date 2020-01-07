package com.mick.mmg.round.service;

import com.mick.mmg.exceptions.NotFoundException;
import com.mick.mmg.game.service.GameStartedEvent;
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
    private final UserGuessService userGuessService;

    @Inject
    public RoundService(
            final RoundRepository roundRepository,
            final ApplicationEventPublisher applicationEventPublisher,
            final UserGuessService userGuessService) {
        this.roundRepository = roundRepository;
        this.applicationEventPublisher = applicationEventPublisher;
        this.userGuessService = userGuessService;
    }

    public List<RoundEntity> createRounds(List<RoundEntity> rounds){
        return roundRepository.create(rounds);
    }

    public UserRoundGuess roundGuess(String code, UserRoundGuess userRoundGuess) {
        List<RoundEntity> roundsForGame = roundRepository.getRoundsForGame(code);
        RoundEntity roundEntity = roundsForGame
                .stream()
                .filter(round -> round.getRoundNumber() == userRoundGuess.getRoundNumber())
                .findFirst()
                .orElseThrow(() -> new NotFoundException("That round doesn't exist for game " + userRoundGuess));

        UserGuessResult userGuessResult = userGuessService.calculatePercentCorrect(roundEntity, userRoundGuess);
        return null;
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
}
