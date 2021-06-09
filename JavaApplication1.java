import java.util.*;

public class JavaApplication1 {

    static int golf[] = new int[3];
    static int Resultats[][] = new int[3][3];

    static int InyDistancia; // Variable con la que inyectamos la distancia en distancia
    static int DistHoyo = 0;// inidcamos cuanta distancia hay hasta ek hoyo a la hora de golpear
    static int i;// el valor de esta variablr indica en que hoyo nos encontramos
    static int golpes_jugador_1 = 0, golpes_jugador_2 = 0, golpes_jugador_3 = 0; // los golpes que va a dar cada jugador
    static int jugador;

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // TODO code application logic here
        DistanciaForats();
        EmpiezaElJuego();
        ImprimirResultados(golf);

    }

    public static void DistanciaForats() {// Pedimos la distancia de los hoyos

        for (int i = 0; i < 3; i++) {// anadimos la distancia de los hoyos con el for en la array

            System.out.println("Distancia del forat " + (i + 1));
            InyDistancia = sc.nextInt();
            sc.nextLine();
            golf[i] = InyDistancia;
        }
    }

    public static void EmpiezaElJuego() {// empezamos a jugar, llamamos al juegos ya.
        for (int i = 0; i < 3; i++) {// aqui imprimimos el valor de la array dentro de una valor para
            System.out.println("Estamos en el Hoyo; " + (i + 1));
            DistHoyo = golf[i];
            Jugar(i);
        }

    }

    public static void Jugar(int hoyo) {
        int distancia[] = new int[3];
        DistanciaInicial(i, distancia);
        while (distancia[0] != 0 || distancia[1] != 0 || distancia[2] != 0) {
            for (int i = 0; i < 3; i++) {
                if (distancia[i] != 0) {
                    System.out.println("el jugador que debe tirar es el " + (i + 1));
                    System.out.println("Con una distancia de; " + distancia[i]);
                   
                    distancia[i] = CalcularDis(jugador, distancia[i], i);

                    if (distancia[i] == 0) {
                        System.out.println("dentro");
                    }

                    if (distancia[i] == 1) {
                        System.out.println("fuera");
                    }
                    Resultats[i][hoyo]++;
                }

            }
        }
    }

    public static void DistanciaInicial(int hoyo, int distancia[]) {// Copia de la distancia dels forats a una nova
                                                                    // array que modificarem
        for (int i = 0; i < 3; i++) {
            distancia[i] = golf[hoyo];
        }
    }

    public static int CalcularDis(int jugador, int distancia, int hoyo) {
        int distanciafinal;

        if (distancia > 50) {
            int palo = Palos();
            distanciafinal = LLancamentJugador(palo, distancia, hoyo);
        } else {
            System.out.println("vamos a usar el  palo put");
            distanciafinal = Put();
        }
        return distanciafinal;
    }

    public static int LLancamentJugador(int pals, int distancia, int hoyo) {// Depenent del pal seleccionat fem un
                                                                            // random a la distancia
        int Llancament = 0;
        if (pals == 1) {
            int N = 220;
            int M = 264;

            Llancament = (int) Math.floor(Math.random() * (N - M + 1) + M);

        } else if (pals == 2) {
            int N = 170;
            int M = 203;

            Llancament = (int) Math.floor(Math.random() * (N - M + 1) + M);

        } else if (pals == 3) {
            int N = 100;
            int M = 120;

            Llancament = (int) Math.floor(Math.random() * (N - M + 1) + M);
        }

        int NovaDistancia = Math.abs(distancia - Llancament);

        return NovaDistancia;
    }

    public static int Palos() {

        System.out.println("Que palo vas a utilizar? " + "\n" + "1.Driver(220m Base)" + "\n" + "2.Fusta (170m Base)"
                + "\n" + "3.Ferro (100m Base)");
        int palo = sc.nextInt();
        return palo;
    }

    public static int Put() { // Random del Put

        int putrandom = (int) Math.round(Math.random());

        return putrandom;
    }

    public static int Porcentaje(int P, int M) {
        int ValorPorcentaje = (int) Math.floor(Math.random() * (M - P + 1) + P);

        return ValorPorcentaje;
    }

    public static void OrdenarLlancaments() { // Volem endrecar els resultats per saber qui es el que a fet menys forats
                                              // i qui a fet mes

        int suma[] = new int[3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma[j] = suma[j] + Resultats[j][i];
            }
        }

        if (suma[0] <= suma[1] && suma[0] <= suma[2] && suma[1] <= suma[2]) {
            System.out.println("\nEl primer es el J1 amb " + suma[0] + " llancaments, el segon es el J2 amb " + suma[1]
                    + " llancaments i l'ultim es el J3 amb " + suma[2] + " llancaments");

        } else if (suma[0] <= suma[1] && suma[0] <= suma[2] && suma[2] <= suma[1]) {
            System.out.println("\nEl primer es el J1 amb " + suma[0] + " llancaments, el segon es el J3 amb " + suma[2]
                    + " llancaments i l'ultim es el J2 amb " + suma[1] + " llancaments");

        } else if (suma[1] <= suma[0] && suma[1] <= suma[2] && suma[0] <= suma[2]) {
            System.out.println("\nEl primer es el J2 amb " + suma[1] + " llancaments, el segon es el J1 amb " + suma[0]
                    + " llancaments i l'ultim es el J3 amb " + suma[2] + " llancaments");

        } else if (suma[1] <= suma[0] && suma[1] <= suma[2] && suma[2] <= suma[0]) {
            System.out.println("\nEl primer es el J2 amb " + suma[1] + " llancaments, el segon es el J3 amb " + suma[2]
                    + " llancaments i l'ultim es el J1 amb " + suma[0] + " llancaments");

        } else if (suma[2] <= suma[1] && suma[2] <= suma[0] && suma[1] <= suma[0]) {
            System.out.println("\nEl primer es el J3 amb " + suma[2] + " llancaments, el segon es el J2 amb " + suma[1]
                    + " llancaments i l'ultim es el J1 amb " + suma[0] + " llancaments");

        } else if (suma[2] <= suma[1] && suma[2] <= suma[0] && suma[0] <= suma[1]) {
            System.out.println("\nEl primer es el J3 amb " + suma[2] + " llancaments, el segon es el J1 amb " + suma[0]
                    + " llancaments i l'ultim es el J2 amb " + suma[1] + " llancaments");
        }

    }

    public static void Targetes() {// Targetes per a cada jugador
        System.out.println("\nTARGETES: ");
        for (int j = 0; j < 3; j++) { // Mostrem les targetes dels jugadors mitjancant un for
            System.out.println("Jugador " + (j + 1) + ":");
            for (int i = 0; i < golf.length; i++) {
                System.out.print("|" + Resultats[j][i]);
            }
            System.out.println("|");
        }
    }

    public static void MinMaxJugadors() { // Fem el minim i maxim per cada jugador
        // Jugador 1
        int minJ1 = Resultats[0][0];
        int maxJ1 = Resultats[0][0];
        int posminJ1 = 1;
        int posmaxJ1 = 1;

        for (int i = 0; i < golf.length; i++) {
            if (Resultats[0][i] > maxJ1) {
                maxJ1 = Resultats[0][i];
                posmaxJ1 = (i + 1);
            }

            if (Resultats[0][i] < minJ1) {
                minJ1 = Resultats[0][i];
                posminJ1 = (i + 1);
            }
        }
        // Jugador 2
        int minJ2 = Resultats[1][0];
        int maxJ2 = Resultats[1][0];
        int posminJ2 = 1;
        int posmaxJ2 = 1;

        for (int i = 0; i < golf.length; i++) {
            if (Resultats[1][i] > maxJ2) {
                maxJ2 = Resultats[1][i];
                posmaxJ2 = (i + 1);
            }

            if (Resultats[1][i] < minJ2) {
                minJ2 = Resultats[1][i];
                posminJ2 = (i + 1);
            }
        }
        // Jugador 3
        int minJ3 = Resultats[2][0];
        int maxJ3 = Resultats[2][0];
        int posminJ3 = 1;
        int posmaxJ3 = 1;

        for (int i = 0; i < golf.length; i++) {
            if (Resultats[2][i] > maxJ3) {
                maxJ3 = Resultats[2][i];
                posmaxJ3 = (i + 1);
            }

            if (Resultats[2][i] < minJ3) {
                minJ3 = Resultats[2][i];
                posminJ3 = (i + 1);
            }
        }

        // Mostrem els resultas del minim y maxim de cada jugador
        System.out.println("\nEl minim de llancaments que a fet el jugador 1 han estat " + minJ1 + " al forat numero "
                + posminJ1 + " i maxims " + maxJ1 + " al forat numero " + posmaxJ1);
        System.out.println("El minim de llancaments que a fet el jugador 2 han estat " + minJ2 + " al forat numero "
                + posminJ2 + " i maxims " + maxJ2 + " al forat numero " + posmaxJ2);
        System.out.println("El minim de llancaments que a fet el jugador 3 han estat " + minJ3 + " al forat numero "
                + posminJ3 + " i maxims " + maxJ3 + " al forat numero " + posmaxJ3);

    }

    public static void ImprimirResultados(int Hoyos[]) {

        // Mostrar Targetes
        Targetes();
        // ResultadoOrden
        OrdenarLlancaments();
        // Minim i Maxim
        MinMaxJugadors();

    }

}
