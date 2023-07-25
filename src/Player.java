import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Carton> cartonsPlayer;

    public Player(String name) {
        this.name = name;
        this.cartonsPlayer = new ArrayList<>();
    }

    public void addCarton(Carton  c){
        cartonsPlayer.add(c);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Carton> getCartonsPlayer() {
        return cartonsPlayer;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                '}';
    }
}
