import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Scanner entrada = new Scanner(System.in);

        Bingo bingo = new Bingo();
        String men = "\n 1 - Generar 1 carton nuevo "
                   + "\n 2 - Generar 3 cartones "
                   + "\n 3 - Mostrar cartones participantes "
                   + "\n 4 - Empezar el juego ";
        fin: do {
            System.out.println(men);
            int op = entrada.nextInt();

            switch (op) {
                case 1:
                    Carton carton = bingo.generate_carton();
                    break;
                case 2:
                    Carton carton1 = bingo.generate_carton();
                    Carton carton2 = bingo.generate_carton();
                    Carton carton3 = bingo.generate_carton();
                    break;
                case 3:
                    System.out.println("\n ----- || Cartones participantes: ");
                    bingo.show_cartons();
                    break;
                case 4:
                    int i = 0;
                    System.out.println("\n ----- || Que empieze el juego || -----");
                    while (!bingo.isFinalized()) {
                        i += 1;
                        int num = bingo.ball_drawn();
                        System.out.println(" Bola " + i + " --> " + num);
                        Thread.sleep(2500);
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
                    System.out.println(" Fin del juego ...");
                    break fin;

                default:
                    throw new AssertionError();
            }
        }while (true);
    }
}