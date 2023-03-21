import VueControleur.VueControleurPotager;
import modele.Ordonnanceur;
import modele.SimulateurPotager;
public class Main {
    public static void main(String[] args) {
        SimulateurPotager simulateurPotager = new SimulateurPotager();
        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);
        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        Ordonnanceur.getOrdonnanceur().start(300);

    }
}