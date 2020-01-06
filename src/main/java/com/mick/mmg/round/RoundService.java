package com.mick.mmg.round;

import com.mick.mmg.round.entity.RoundEntity;
import com.mick.mmg.round.entity.RoundRepository;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

@Singleton
public class RoundService {
    private final RoundRepository roundRepository;

    @Inject
    public RoundService(RoundRepository roundRepository) {
        this.roundRepository = roundRepository;
    }

    public List<RoundEntity> createRounds(List<RoundEntity> rounds){
        return roundRepository.create(rounds);
    }
}
