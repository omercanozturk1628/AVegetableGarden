package modele;
import java.awt.*;
import java.util.Random;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;

    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
    }

    @Override
    public void run() {

        int min_precipitations=0;
        int max_precipitations=100;
        int min_ensolleillement=-1;
        int max_ensolleillement=42;
        Random nb_aleatoire = new Random();
        int precipitations = nb_aleatoire.nextInt(max_precipitations-min_precipitations) + min_precipitations;
        int ensolleillement = nb_aleatoire.nextInt(max_ensolleillement-min_ensolleillement) + min_ensolleillement;
        //on change la meteo de chaque case du tableau
        for(int i=0; i<this.simPot.getGrilleCases().length; i++) {
            for(int j=0; j<this.simPot.getGrilleCases()[i].length; j++) {
                // change la valeurs des précipitations et l'ensoleillement de chaque case
                Point current = new Point(i,j);
                if(this.simPot.objetALaPosition(current)!=null) {
                    this.simPot.objetALaPosition(current).setPrécipitations(precipitations);
                    this.simPot.objetALaPosition(current).setEnsolleillement(ensolleillement);
                }
            }
        }
    }
}

