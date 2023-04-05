import VueControleur.VueControleurPotager;
import modele.Ordonnanceur;
import modele.SimulateurMeteo;
import modele.SimulateurPotager;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SimulateurPotager simulateurPotager = new SimulateurPotager();
        //meteo
        SimulateurMeteo met = new SimulateurMeteo(simulateurPotager);
        //
        VueControleurPotager vc = new VueControleurPotager(simulateurPotager);
        vc.setVisible(true);
        Ordonnanceur.getOrdonnanceur().addObserver(vc);
        Ordonnanceur.getOrdonnanceur().start(300);
        //System.out.println("minute " + interval_meteo.getMinutes() + " Seocond " +interval_meteo.getSeconds() );

    }
}