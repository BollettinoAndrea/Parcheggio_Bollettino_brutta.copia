import java.util.concurrent.Semaphore;

public class Parcheggio {
    private Semaphore postiDisponibili;

    public Parcheggio(int postiTotali) {
        this.postiDisponibili = new Semaphore(postiTotali, true);
    }

    public void entra(String casa_automobilistica, String targa, String entrata) {
        try {
            System.out.println(casa_automobilistica + " targata:" + targa + " in attesa di entrare da " + entrata + "...");
            postiDisponibili.acquire();
            System.out.println(casa_automobilistica + " targata:" + targa + " è entrata da " + entrata + ". Posti disponibili: " + postiDisponibili.availablePermits());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void exit(String casa_automobilistica, String targa, String uscita) {
        postiDisponibili.release();
        System.out.println(casa_automobilistica + " targata:" + targa + " è uscita da " + uscita + ". Posti disponibili: " + postiDisponibili.availablePermits());
        System.out.println(" ");
    }
}