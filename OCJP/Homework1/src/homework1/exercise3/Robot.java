package homework1.exercise3;

/**
 *
 * @author Cristhian Alberto Motoche Macas
 */
public class Robot {
    private int number;
    private int livePercentage;

    public Robot(int number, int livePercentage) {
        this.number = number;
        this.livePercentage = livePercentage;
    }

    public double getLivePercentage() {
        return livePercentage;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "Robot: "
                + "{\nnumber: " + this.number + "\n"
                + ", live: " + this.livePercentage + " %\n"
                + "}";
    }

    @Override
    public boolean equals(Object o) {
        Robot r = (Robot) o;
        return this.number == r.number
                && this.livePercentage == r.livePercentage;
    }
}
