import java.util.Random;
import java.util.Scanner;

public class Main {
    private static String generaTarga() {
        Random random = new Random();
        String lettere = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numeri = "0123456789";
        return "" + lettere.charAt(random.nextInt(lettere.length())) + lettere.charAt(random.nextInt(lettere.length())) +

                numeri.charAt(random.nextInt(numeri.length())) + numeri.charAt(random.nextInt(numeri.length())) +

                lettere.charAt(random.nextInt(lettere.length())) + lettere.charAt(random.nextInt(lettere.length()));
    }

    private static String generaCasa_Automobilistica() {
        String[] casa_automobilistica = {"FIAT", "TOYOTA", "BMW", "AUDI", "FERRARI", "MERCEDES", "PORSCHE", "MG", "ASTON MARTIN", "LANCIA", "ALFA ROMEO", "TESLA", "MASERATI", "LAMBORHINI", "SKODA", "SEAT"};
        return casa_automobilistica[new Random().nextInt(casa_automobilistica.length)];
    }


    public static void main(String[] args) {
        Parcheggio parcheggio = new Parcheggio(5);
        Scanner in = new Scanner(System.in);
        String[] entrate = {"Entrata 1", "Entrata 2", "Entrata 3"};
        boolean running = true;

        System.out.println("Premi 1, 2 o 3 per accodare un'auto alle relative entrate. Premi 0 per uscire.");

        while (running) {
            int scelta_parcheggio = in.nextInt();
            switch (scelta_parcheggio) {
                case 1:
                case 2:
                case 3:
                    String targa = generaTarga();
                    String casa_automobilistica = generaCasa_Automobilistica();
                    Auto auto = new Auto(targa, casa_automobilistica, parcheggio, entrate[scelta_parcheggio - 1]);
                    auto.start();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Input non valido. Premi 1, 2, 3 per accodare un'auto, o 0 per uscire.");
            }
        }
        System.out.println("Programma terminato.");
        in.close();
    }
}
