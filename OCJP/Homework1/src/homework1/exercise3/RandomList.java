package homework1.exercise3;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class RandomList {
    private Robot randomList [];
    private Random random;

    public RandomList(Robot[] randomList){
        this.randomList = randomList;
    }

    public RandomList(int min, int max, int start, int end) {
        this.random = new Random();
        this.randomList = new Robot [this.random.nextInt(max + 1) + min];
        generateRandomList(start, end);
    }

    private void generateRandomList(int start, int end){
        for (int i = 0; i < this.randomList.length; i++) {
            this.randomList[i] = new Robot(i, this.random.nextInt(end + 1) +start);
        }
    }

    public void sort(){
        Robot aux;
        for (int i = 1; i < this.randomList.length; i++) {
            for (int j = 0; j < this.randomList.length - i; j++) {
                if (this.randomList[j].getLivePercentage() > this.randomList[j+1].getLivePercentage()) {
                    aux = this.randomList[j];
                    this.randomList[j] = this.randomList[j+1];
                    this.randomList[j+1] = aux;
                }
            }
        }
    }

    public Robot[] getRobotsWithMoreThan50LivePercentage(){
        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < this.randomList.length; i++) {
            if (this.randomList[i].getLivePercentage() > 50) {
                robots.add(this.randomList[i]);
            }
        }

        return robots.toArray(new Robot[robots.size()]);
    }

    public String getListAsString(){
        String result = "[";
        for (Robot d : this.randomList) {
            result += "\n" + d + "\n";
        }
        result += "]";
        return result;
    }

    public void setRandomList(Robot list []){
        this.randomList = list;
    }

    public Robot[] getRandomList() {
        return randomList;
    }

    public String getRobotsWithMoreThan50AsString() {
        RandomList newRandomList = new RandomList(getRobotsWithMoreThan50LivePercentage());
        return newRandomList.getListAsString();
    }

    public Robot [] getRobotsWithMoreLife(int i) {
        sort();
        int count = 0;
        int size = this.randomList.length - 1;
        Robot [] robotsWithMoreLife = new Robot [i];
        while( count < i ){
            robotsWithMoreLife[count] = this.randomList[size - count];
            count++;
        }
        return robotsWithMoreLife;
    }

    public String getRobotsNumberWithMoreLifeAsString(int i){
        String robotNumbers = "[";
        for (Robot robot : getRobotsWithMoreLife(i)) {
            robotNumbers += " " + robot.getNumber() + " ";
        }
        return robotNumbers + "]";
    }
}
