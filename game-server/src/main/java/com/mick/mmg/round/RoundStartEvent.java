package com.mick.mmg.round;

import com.mick.mmg.round.entity.RoundEntity;

public class RoundStartEvent {
    private RoundEntity roundEntity;

    public RoundEntity getRoundEntity() {
        return roundEntity;
    }

    public RoundStartEvent setRoundEntity(RoundEntity roundEntity) {
        this.roundEntity = roundEntity;
        return this;
    }
}
