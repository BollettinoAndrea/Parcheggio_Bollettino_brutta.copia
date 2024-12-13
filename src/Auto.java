import java.util.concurrent.TimeUnit;

class Auto extends Thread {
    private String targa;
    private String casa_automobilistica;
    private Parcheggio parcheggio;
    private String entrata;

    public Auto(String targa, String casa_automobilistica, Parcheggio parcheggio, String entrata) {
        this.targa = targa;
        this.casa_automobilistica = casa_automobilistica;
        this.parcheggio = parcheggio;
        this.entrata = entrata;
    }

    @Override
    public void run() {

        parcheggio.entra(casa_automobilistica, targa, entrata);
        try {
            System.out.println("Auto targata: " + targa + " di casa automobilistica: " + casa_automobilistica + " è nel parcheggio.");
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            TimeUnit.SECONDS.sleep((int)((Math.random()*10)+1));
        }catch(Exception e) {
            System.out.println(e);
        }

        parcheggio.exit(casa_automobilistica, targa, "Uscita 1");
    }
}