package modele;

import java.util.Observable;
import java.util.Vector;

import static java.lang.Thread.*;

public class Ordonnanceur extends Observable implements Runnable {

    private static Ordonnanceur ordonnanceur;
    private SimulateurPotager simulateurPotager;
    private long pause;//vitesse de la simulation
    private Vector<Runnable> lst = new Vector<Runnable>(); // liste synchronisée

    // design pattern singleton on utilise 1 seul objet de la class ordonnanceur
    public static Ordonnanceur getOrdonnanceur() {
        if (ordonnanceur == null) {
            ordonnanceur = new Ordonnanceur();

        }
        return ordonnanceur;
    }

    public void setPause(long pause) {
        this.pause = pause;
    }
    public void start(long _pause) {
        pause = _pause;
        Thread t1=new Thread(this);
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void add(Runnable r) {lst.add(r);}

    //méthode qui va exécuter la méthode run de chaque thread de la liste lst
    // dans notre cas va éxécuter la méthode run du simulateur météo
    // et la méthode run des cases cultivables
    //si update est vraie on prévient les objet Observable(la vue dans notre cas)
    //les objets observable vont lancer leurs méthode update
    @Override
    public void run() {
        boolean update = true;
        while(true) {

            for (Runnable r : lst) {
                r.run();
            }
            if (update) {
                setChanged();
                notifyObservers();
                update = false;
            }
           update = true;
            try {
                sleep(pause);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
