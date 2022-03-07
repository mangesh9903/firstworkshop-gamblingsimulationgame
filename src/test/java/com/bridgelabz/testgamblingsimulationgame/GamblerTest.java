package com.bridgelabz.testgamblingsimulationgame;

import com.bridgelabz.gamblingsimulationgame.Gambler;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GamblerTest {

    Gambler gambler = new Gambler();

    @BeforeClass
    public static void beforeClass() {
        System.out.println(" Testing started...");
    }

    @Test
    public void testGamePlay_Win() {

        assertEquals(150, gambler.gamePlay(150, 50));

    }

    @Test
    public void testGamePlay_Lose() {

        assertEquals(50, gambler.gamePlay(150, 50));

    }

    @AfterClass
    public static void afterClass() {
        System.out.println(" Testing Finished...");
    }

}
