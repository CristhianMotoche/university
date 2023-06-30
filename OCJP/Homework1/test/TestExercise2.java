import homework1.exercise2.RandomList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class TestExercise2 {

    private RandomList randomList;
    private int fixture [] = { 1, 2, 3, 4, 5 };

    @Before
    public void before() {
        this.randomList = new RandomList(0, 0, 0, 0);
        this.randomList.setRandomList(fixture);
    }

    @Test
    public void testGetSumEvenNumbers(){
        assertEquals(this.randomList.getSumEvenNumbers(), 6);
    }

    @Test
    public void testGetOddEvenNumbers(){
        assertEquals(this.randomList.getSumOddNumbers(), 9);
    }
}
