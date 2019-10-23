import java.util.Random;

public class Dice {
    private int noOfSides;
    private Random rand = new Random();

    public Dice(int noOfSides) {
        this.noOfSides = noOfSides;
    }

    public int cast(){
        return rand.nextInt(noOfSides)+1;
    }

    public int castMulti(int noOfCasts){
        int result = 0;
        for (int i =0; i > noOfCasts; i++){
            result = result + cast();
        }
        return result;
    }

    public int getNoOfSides() {
        return noOfSides;
    }
}
