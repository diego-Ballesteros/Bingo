import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Bingo {
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> ball_drawn;
    private ArrayList<Carton> cartons;
    private ArrayList<Carton> win_cartons;

    public final int GREATER_BALL = 30;
    public final int CARTON_SIZE = 9;

    public ArrayList<Carton> getCartons() {
        return cartons;
    }

    public ArrayList<Carton> getWin_cartons() {
        return win_cartons;
    }

    public Bingo() {
        ArrayList<Integer> bomboAux = new ArrayList<>();
        for (int i = 0; i < GREATER_BALL; i++) {
            bomboAux.add(i);
        }
        this.bombo = bomboAux;
        this.ball_drawn = new ArrayList<>();
        this.cartons = new ArrayList<>();
        this.win_cartons = new ArrayList<>();
    }

    public boolean isFinalized() {
        if (bombo.isEmpty() || win_cartons.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean validate_carton(Carton carton) {
        boolean finded;
        for (Integer numCarton : carton.getNumbers()) {
            finded = false;
            for (Integer numBallDrawn : ball_drawn) {
                if (numCarton == numBallDrawn) {
                    finded = true;
                    break;
                }
            }
            if (!finded) return false;
        }
        return true;
    }

    public Carton generate_carton(){
        ArrayList<Integer> all_numbers = new ArrayList<>();
        for (int i = 0; i < GREATER_BALL; i++) {
            all_numbers.add(i);
        }
        shuffle(all_numbers);
        ArrayList<Integer> carton_numbers = new ArrayList<>();
        for (int i = 0; i < CARTON_SIZE; i++) {
            carton_numbers.add(all_numbers.get(i));
        }
        Carton carton1;
        carton1 = new Carton(carton_numbers);
        cartons.add(carton1);
        return carton1;
    }

    public int ball_drawn(){
        Integer num = 0;
        if(isFinalized()){
            return 0;
        }
        shuffle(bombo);
        num = bombo.get(0);
        bombo.remove(num);
        ball_drawn.add(num);
        for (Carton c: cartons) {
            if(validate_carton(c)){
                win_cartons.add(c);
            }
        }
        return num;
    }

    public void show_carton(){
        int i=0;
        for (Carton car: cartons) {
            i+=1;
            System.out.println("Carton "+ i + " -> "+car.toString());
        }
    }
    public void show_carton_win(){
        for (Carton car: win_cartons) {
            System.out.println("Carton -> "+car.toString());
        }
    }

}
