package homework1.exercise1;

import java.util.Random;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class RandomList {
    private double randomList [];
    private Random random;

    public RandomList(int min, int max, double start, double end) {
        this.random = new Random();
        this.randomList = new double [this.random.nextInt(max + 1) + min];
        generateRandomList(start, end);
    }

    private void generateRandomList(double start, double end){
        for (int i = 0; i < this.randomList.length; i++) {
            this.randomList[i] = start + this.random.nextDouble() * (end - start);
        }
    }

    public String getListAsString(){
        String result = "[";
        for (double d : randomList) {
            result += " " + d + " ";
        }
        result += "]";
        return result;
    }

    public void setRandomList(double[] randomList) {
        this.randomList = randomList;
    }

    public double getAverage() {
        double total = 0.0;
        for (double d : randomList) {
            total += d;
        }
        return total/this.randomList.length;
    }

    public double getMaxNumber() {
        double max = Double.MIN_VALUE;
        for (double d : randomList) {
            if (d > max) {
                max = d;
            } else {
                // Do nothing
            }
        }
        return max;
    }

    public void sort(){
        double aux;
        for (int i = 1; i < this.randomList.length; i++) {
            for (int j = 0; j < this.randomList.length - i; j++) {
                if (this.randomList[j] > this.randomList[j+1]) {
                    aux = this.randomList[j];
                    this.randomList[j] = this.randomList[j+1];
                    this.randomList[j+1] = aux;
                }
            }
        }
    }
    
    public double getDifference() {
        sort();
        return getSencondMax() - getSecondMin();
    }

    private double getSencondMax() {
        return this.randomList[this.randomList.length - 2];
    }

    private double getSecondMin() {
        return this.randomList[1];
    }
}
