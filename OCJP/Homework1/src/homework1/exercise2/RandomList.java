package homework1.exercise2;
import java.util.Random;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class RandomList {
    private int randomList [];
    private Random random;

    public RandomList(int min, int max, int start, int end) {
        this.random = new Random();
        this.randomList = new int [this.random.nextInt(max + 1) + min];
        generateRandomList(start, end);
    }

    private void generateRandomList(int start, int end){
        for (int i = 0; i < this.randomList.length; i++) {
            this.randomList[i] = this.random.nextInt(end + 1) +start ;
        }
    }

    public String getListAsString(){
        String result = "[";
        for (int d : randomList) {
            result += " " + d + " ";
        }
        result += "]";
        return result;
    }

    public void setRandomList(int[] randomList) {
        this.randomList = randomList;
    }

    public int getSumEvenNumbers() {
        int total = 0;
        for (int i : this.randomList){
            if( i % 2 == 0){
                total += i;
            }
            else {
                // Do nothing
            }
        }
        return total;
    }

    public Object getSumOddNumbers() {
        int total = 0;
        for (int i : this.randomList){
            if( i % 2 != 0){
                total += i;
            }
            else {
                // Do nothing
            }
        }
        return total;
    }
}
