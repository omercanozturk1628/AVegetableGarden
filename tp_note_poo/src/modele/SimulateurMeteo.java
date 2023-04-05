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
        int min_hydrometrie=0;
        int max_hydrometrie=100;
        int min_temperature=-10;
        int max_temperature=40;
        int temperature;
        int hydrometrie;
        Random r = new Random();
        temperature=  min_temperature + r.nextInt() * (max_temperature - min_temperature);
        hydrometrie=  min_hydrometrie + r.nextInt() * (max_hydrometrie - min_hydrometrie);
        //change la meteo de chaque case du tableau
        for(int i=0; i<this.simPot.getGrilleCases().length; i++) {
            for(int j=0; j<this.simPot.getGrilleCases()[i].length; j++) {
                // on génère les précipitations et l'ensoleillement au hazard
                Point current = new Point(i,j);
                if(this.simPot.objetALaPosition(current)!=null) {
                    Case current_case=this.simPot.objetALaPosition(current);
                    current_case.setEnsolleillement(temperature);
                    current_case.setPrécipitations(hydrometrie);
                }
                //this.simPot.getGrilleCases()[i][j].setPrécipitations(hydrometrie);
            }
        }


        /*
        //on choisi une meteo au hazard dans la liste de meteo
        int random_meteo_index_ = (int)(Math.random() * liste_meteo_possible.size());
        meteo=liste_meteo_possible.get(random_meteo_index_);
        // on génère l'hydrométrie et la temperature au hazard
        int min_hydrometrie=0;
        int max_hydrometrie=100;
        int min_temperature=-10;
        int max_temperature=40;
        Random r = new Random();
        temperature=  min_temperature + r.nextFloat() * (max_temperature - min_temperature);
        hydrometrie=  min_hydrometrie + r.nextFloat() * (max_hydrometrie - min_hydrometrie);
        */
    }
}

