/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package homework1.exersice4;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author camm
 */
public class RandomList {
    private Integer randomList1 [];
    private Integer randomList2 [];
    private Random random;

    public RandomList(int minList1, int maxList1, int minList2, int maxList2, int start, int end) {
        this.random = new Random();
        this.randomList1 = new Integer [this.random.nextInt(maxList1 + 1) + minList1];
        this.randomList2 = new Integer [this.random.nextInt(maxList2 + 1) + minList2];
        generateRandomList(this.randomList1, start, end);
        generateRandomList(this.randomList2, start, end);
    }

    private void generateRandomList(Integer list[], int start, int end){
        for (int i = 0; i < list.length; i++) {
            list[i] = this.random.nextInt(end + 1) +start;
        }
    }

    public Integer[] getRandomList1() {
        return randomList1;
    }

    public Integer[] getRandomList2() {
        return randomList2;
    }

    public Integer[] generateThirdList() {
        ArrayList<Integer> thirdList = new ArrayList<>();
        for (int item : this.randomList1) {
            if(isInList(item, this.randomList2)){
                // Do nothing
            }
            else{
                thirdList.add(item);
            }
        }
        return thirdList.toArray(new Integer[thirdList.size()]);
    }

    public Integer[] generateFourthList() {
        ArrayList<Integer> fourthList = new ArrayList<>();
        for (int item : this.randomList1 ) {
            if (item % 2 == 0) {
                fourthList.add(item);
            } else { /* Do nothing */ }
        }
        for (int item : this.randomList2) {
            if (item % 2 != 0) {
                fourthList.add(item);
            } else { /* Do nothing */ }
        }
        return fourthList.toArray(new Integer[fourthList.size()]);
    }

    private boolean isInList(int i, Integer[] randomList2) {
        for (int j = 0; j < randomList2.length; j++) {
            if (i == randomList2[j]) {
                return true;
            }
        }
        return false;
    }
}
