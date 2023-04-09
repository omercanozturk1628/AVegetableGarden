package modele;

import modele.Ordonnanceur;
import modele.SimulateurPotager;
import modele.environnement.Case;

import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class SimulateurMeteo implements Runnable {
    private SimulateurPotager simPot;
    // on créer les attribus qui correspondent au condition météo début
    private String meteo;// la météo actuel
    private Date interval;// l'interval du temps auuquel la météo change
    private ArrayList<String> liste_meteo_possible= new ArrayList<String>();

    public String getMeteo() {
        return meteo;
    }







    // on créer les attribus qui correspondent au condition météo fin
    public SimulateurMeteo(SimulateurPotager _simPot) {
        Ordonnanceur.getOrdonnanceur().add(this);
        simPot = _simPot;
    }

    public SimulateurMeteo(SimulateurPotager _simPot, Date interval) {
        Ordonnanceur.getOrdonnanceur().add(this);
        this.simPot = _simPot;
        this.interval=interval;
        this.liste_meteo_possible.add("ensoleille");
        this.liste_meteo_possible.add("nuageux");
        this.liste_meteo_possible.add("pluvieux");
        this.liste_meteo_possible.add("venteux");
        this.liste_meteo_possible.add("neigeux");
        meteo="test";
    }

    @Override
    public void run() {
        // TODO
        int min_precipitations=0;
        int max_precipitations=100;
        int min_ensolleillement=-1;
        int max_ensolleillement=42;
        Random nb_aleatoire = new Random();
        int precipitations = nb_aleatoire.nextInt(max_precipitations-min_precipitations) + min_precipitations;
        int ensolleillement = nb_aleatoire.nextInt(max_ensolleillement-min_ensolleillement) + min_ensolleillement;;
        //change la meteo de chaque case du tableau
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

