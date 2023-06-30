/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import homework1.exercise3.RandomList;
import homework1.exercise3.Robot;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class TestExercise3 {
    private RandomList randomList;
    private Robot fixture [] = { new Robot(1, 20), new Robot(2, 30), new Robot(3, 15), new Robot(5, 55) };

    @Before
    public void before() {
        this.randomList = new RandomList(0, 0, 0, 0);
        this.randomList.setRandomList(fixture);
    }

    @Test
    public void testSortByLivePercentage(){
        Robot sortedList [] = { new Robot(3, 15), new Robot(1, 20), new Robot(2, 30), new Robot(5, 55) };
        this.randomList.sort();
        assertArrayEquals(this.randomList.getRandomList(), sortedList);
    }
    
    @Test
    public void testGetRobotsWithMoreThanHalfLive(){
        Robot [] expected = { new Robot(5, 55) };
        assertArrayEquals(this.randomList.getRobotsWithMoreThan50LivePercentage(), expected);
    }
    
    @Test
    public void testGetRobotsWithMoreLife(){
        Robot [] expected = { new Robot(5, 55) };
        assertArrayEquals(this.randomList.getRobotsWithMoreLife(1), expected);
    }
}
