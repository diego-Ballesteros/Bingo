import java.util.ArrayList;

public class Carton {
    private final ArrayList<Integer> numbers;

    @Override
    public String toString() {
        return "numbers=" + numbers +
                '}';
    }

    public ArrayList<Integer> getNumbers() {
        return numbers;
    }

    public Carton(ArrayList<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getSize(){
        return numbers.size();
    }
}

