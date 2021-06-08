
import java.util.*;

public class JavaApplication1 {

    static ArrayList golf = new ArrayList();

    static int InyDistancia; // Variable con la que inyectamos la distancia en distancia
    static int DistHoyo = 0;// inidcamos cuanta distancia hay hasta ek hoyo a la hora de golpear
    static int NumHoyo;// el valor de esta variablr indica en que hoyo nos encontramos
    static int golpes_jugador_1 = 0, golpes_jugador_2 = 0, golpes_jugador_3 = 0; // los golpes que va a dar cada jugador
    static int jugador;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO code application logic here
        DistanciaForats();
        EmpiezaElJuego();

    }

    public static void DistanciaForats() {// Pedimos la distancia de los hoyos

        for (NumHoyo = 0; NumHoyo < 3; NumHoyo++) {// anadimos la distancia de los hoyos con el for en la array

            System.out.println("Distancia del forat " + (NumHoyo + 1));
            InyDistancia = sc.nextInt();
            sc.nextLine();
            golf.add(NumHoyo, InyDistancia);
        }
    }

    public static void EmpiezaElJuego() {// empezamos a jugar, llamamos al juegos ya.
        for (NumHoyo = 0; NumHoyo < 3; NumHoyo++) {// aqui imprimimos el valor de la array dentro de una valor para
            // poder trabajr
            DistHoyo = (int) golf.get(NumHoyo);
            Jugar();
        }

    }

    public static void Jugar() {
        for (jugador = 0; jugador < 3; jugador++) {
            System.out.println("Estamos en el Hoyo; " + (NumHoyo + 1) + " ,con una distancia de; " + DistHoyo
                    + " y el jugador que debe tirar es el " + (jugador + 1));
            while (DistHoyo > 50) {
                System.out.println("Estas a la distancia de " + DistHoyo + "\n"
                        + "Vamos a elegir el palo que queremos usar para jugar esta partida, lo primero de todo decir que se va a sumar un valor positivo entre 0 y 20 al valor de golpe");

                System.out.println("Que palo vas a utilizar? " + "\n" + "1.Driver(220m Base)" + "\n"
                        + "2.Fusta (170m Base)" + "\n" + "3.Ferro (100m Base)");
                int Palo = sc.nextInt();
                int ValorGolpe = Palos(Palo);// valor que dice que palo vamos a usar es entre 1 y 3
                DistHoyo = DistHoyo - Porcentaje(ValorGolpe, ValorGolpe * 20 / 100);
                math.abs(DistHoyo);
            }
            Porcentaje(0, 1);
        }
    }

    public static int Palos(int EleccionPalo) {
        int ValorGolpe = 0;
        while (EleccionPalo == 1 || EleccionPalo == 2 || EleccionPalo == 3) {

            if (EleccionPalo == 1) {
                ValorGolpe = 220;

                return 220;
            }
            if (EleccionPalo == 2) {
                ValorGolpe = 170;
                return 170;
            }
            if (EleccionPalo == 3) {
                ValorGolpe = 100;
                return 100;
            }
        }
        return ValorGolpe;
    }

    public static int Porcentaje(int P, int M) {
        int ValorPorcentaje = (int) Math.floor(Math.random() * (M - P + 1) + P);

        return ValorPorcentaje;
    }

    public static void contador() {
        if (jugador == 1) {

        }
        if (jugador == 2) {

        }
        if (jugador == 3) {

        }
    }

}
