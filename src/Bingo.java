import java.util.ArrayList;

import static java.util.Collections.shuffle;

public class Bingo {
    private ArrayList<Integer> bombo;
    private ArrayList<Integer> ball_drawn;
    private ArrayList<Player> players;
    private Player playerwin;

    public Player getPlayerwin() {
        return playerwin;
    }

    private Carton cartonWin;

    public Carton getCartonWin() {
        return cartonWin;
    }

    public final int GREATER_BALL = 30;
    public final int CARTON_SIZE = 9;

    public ArrayList<Player> getPlayers() {
        return players;
    }


    public Bingo() {
        ArrayList<Integer> bomboAux = new ArrayList<>();
        for (int i = 0; i < GREATER_BALL; i++) {
            bomboAux.add(i);
        }
        this.bombo = bomboAux;
        this.ball_drawn = new ArrayList<>();
        this.players = new ArrayList<>();
        this.cartonWin = null;
        this.playerwin= null;
    }

    public boolean isFinalized() {
        if (bombo.isEmpty() || playerwin!=null) {
            return true;
        }
        return false;
    }

    public boolean validate_carton(Player player) {
        boolean finded;

            for (Carton cartonPLayer:player.getCartonsPlayer()) {
                for (Integer numCarton : cartonPLayer.getNumbers()) {
                    finded = false;
                    for (Integer numBallDrawn : ball_drawn) {
                        if (numCarton == numBallDrawn) {
                            finded = true;
                            break;
                        }
                    }
                    if (!finded) return false;
                }
                cartonWin=cartonPLayer;
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
        Carton carton1 = new Carton(carton_numbers);
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

        for (Player player : players) {
            if(validate_carton(player)){
                playerwin = player;
            }
        }
        return num;
    }
    public void show_cartons(){
        int i=0;
        for (Player pl: players) {
            System.out.println("|| Cartones de "+ pl.getName());
            for (Carton car: pl.getCartonsPlayer()) {
                i+=1;
                System.out.println("Carton "+ i + " -> "+car.toString());
            }
            System.out.println();
        }
    }
    public void addPlayer(Player p){
        players.add(p);
    }

    public String showCartonPlayer(String nombre){
        String list = "";
        for (Player player:players) {
            if(player.getName().equals(nombre)){
                for (Carton numCarton:player.getCartonsPlayer()) {
                    list = list + numCarton.toString() +" \n";
                }
            }
        }
        return list;
    }

}
