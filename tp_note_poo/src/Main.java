import VueControleur.VueControleurPotager;
import modele.Ordonnanceur;
import modele.SimulateurPotager;
public class Main {
    public static void main(String[] args) {
        //potager
        SimulateurPotager simulateurPotager = new SimulateurPotager();
        // vue controleur
        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);
        //la vue observe l'etat de l'ordonanceur
        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        // 1 seconde = 1000  millisecondes la vitesse de simulation du potager
        Ordonnanceur.getOrdonnanceur().start(5000);
    }
}