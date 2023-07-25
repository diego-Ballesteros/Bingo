import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner entrada = new Scanner(System.in);
        int control=0, numCart=0;

        Bingo bingo = new Bingo();
        String men = "\n 1 - Agregar nuevo jugador y generar sus cartones "
                   + "\n 2 - Ver todos los cartones participantes "
                   + "\n 3 - Ver cartones de un jugador en especifico "
                   + "\n 4 - Empezar el juego "
                   + "\n ------> : ";
        fin: do {
            System.out.print(men);
            int op = entrada.nextInt();

            if(control==0){
                System.out.println(" || Para este juego Cuantos cartones corresponden a cada jugador ? (maximo 3)");
                numCart = entrada.nextInt();
                control = 1;
            }

            Carton carton = null;

            switch (op) {
                case 1:
                    System.out.println("Ingrese el nombre del jugador: ");
                    String name = entrada.next();

                    Player player = new Player(name);
                    boolean isAddPlayer = bingo.addPlayer(player);

                    if(isAddPlayer==true){
                        for (int i = 0; i < numCart; i++) {
                            carton = bingo.generate_carton();
                            player.addCarton(carton);
                        }
                        System.out.println("jugador inscrito con " + numCart + " Cartones en juego: ");
                    }else{
                        System.out.println("No puede Agregar 2 jugadores con el missmo nombre");
                    }

                    break;

                case 2:
                    System.out.println("\n ----- || Cartones participantes: ");
                    bingo.show_cartons();
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del jugador: ");
                    name = entrada.next();
                    System.out.println(bingo.showCartonPlayer(name));

                    break;
                case 4:
                    int i = 0;
                    System.out.println("\n ----- || Que empieze el juego || -----");
                    while (!bingo.isFinalized()) {
                        i += 1;
                        int num = bingo.ball_drawn();
                        System.out.println(" Bola " + i + " --> " + num);
                        Thread.sleep(9000);

                        for (Player playe : bingo.getPlayers()) {
                            bingo.validate_carton(playe);
                        }
                    }
                    if (bingo.getPlayerwin()!=null ) {
                        System.out.println("\n ---- || Felicidades! El Jugador ganador es: ");
                        System.out.println("    "+ bingo.getPlayerwin().getName());
                        System.out.println(bingo.getCartonWin());
                    }else{
                        System.out.println(" :( No hubo ganador, ¿ Otra partida o que ? ");
                    }
                    System.out.println(" Fin del juego ...");
                    break fin;

                default:
                    throw new AssertionError();
            }
        }while (true);
    }
}