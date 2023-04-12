import VueControleur.VueControleurPotager;
import modele.Ordonnanceur;
import modele.SimulateurMeteo;
import modele.SimulateurPotager;
public class Main {
    public static void main(String[] args) {
        //potager
        SimulateurPotager simulateurPotager = new SimulateurPotager();
        //meteo
        //SimulateurMeteo met = new SimulateurMeteo(simulateurPotager);
        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);
        //la vue observe l'etat de l'ordonanceur
        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        Ordonnanceur.getOrdonnanceur().start(5000);
        // 1 seconde = 1000  millisecondes
        //System.out.println("minute " + interval_meteo.getMinutes() + " Seocond " +interval_meteo.getSeconds() );


    }
}