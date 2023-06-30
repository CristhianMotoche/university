import homework1.exercise1.RandomList;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class TestExercise1 {
    private RandomList randomList = new RandomList(5, 10, 45.0, 90.0);
    private double fixture [] = { 0.1, 2.3, 4.5, 5.2 };

    @Before
    public void initTest(){
        this.randomList.setRandomList(fixture);
    }

    @Test
    public void TestGetListAsString() {
        assertEquals(this.randomList.getListAsString(), "[ 0.1  2.3  4.5  5.2 ]");
    }

    @Test
    public void TestGetAverage() {
        assertEquals(this.randomList.getAverage(), 3.025, 0.1);
    }

    @Test
    public void TestGetMaxNumber() {
        assertTrue(this.randomList.getMaxNumber() == 5.2);
    }

    @Test
    public void TestDifference() {
        assertEquals(this.randomList.getDifference(), 2.2, 0.1);
    }
}
