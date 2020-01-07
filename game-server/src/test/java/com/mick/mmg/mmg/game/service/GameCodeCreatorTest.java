package com.mick.mmg.mmg.game.service;

import com.mick.mmg.game.service.GameCodeCreator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class GameCodeCreatorTest {
    @Test
    public void testCodeCreation(){
        assertEquals(4, GameCodeCreator.create().length());
        assertNotEquals(GameCodeCreator.create(), GameCodeCreator.create());
    }
}
