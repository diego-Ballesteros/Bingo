public class Main {
    public static void main(String[] args) {

        Bingo bingo = new Bingo();

        Carton carton1 = bingo.generate_carton();
        Carton carton2 = bingo.generate_carton();
        Carton carton3 = bingo.generate_carton();

        System.out.println("\n ----- || Cartones participantes: ");
        bingo.show_carton();

        int i = 0;
        System.out.println("\n ----- || Que empieze el juego || -----");
        while (!bingo.isFinalized()) {
            i += 1;
            int num = bingo.ball_drawn();
            System.out.println(" Bola " + i + " --> " + num);
            for (Carton car : bingo.getCartons()) {
                bingo.validate_carton(car);
            }
        }
        if (bingo.getWin_cartons().size() > 0) {
            System.out.println("\n ---- || Felicidades! El carton ganador es: ");
            bingo.show_carton_win();
        }else{
            System.out.println(" :( No hubo ganador, ¿ Otra partida o que ? ");
        }


    }
}