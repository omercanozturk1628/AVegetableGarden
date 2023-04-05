/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;


import modele.environnement.Case;
import modele.environnement.CaseCultivable;
import modele.environnement.CaseNonCultivable;
import modele.environnement.varietes.*;

import java.awt.Point;
import java.util.Date;
import java.util.Random;


public class SimulateurPotager {

    public static final int SIZE_X = 20;
    public static final int SIZE_Y = 10;

    public SimulateurMeteo getSimMet() {
        return simMet;
    }

    private SimulateurMeteo simMet;

    public Case[][] getGrilleCases() {
        return grilleCases;
    }

    // private HashMap<Case, Point> map = new  HashMap<Case, Point>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    public SimulateurPotager() {

        initialisationDesEntites();

        //simMet = new SimulateurMeteo(this);
        // météo
        Date interval_meteo = new Date();
        interval_meteo.setMinutes(0);
        interval_meteo.setSeconds(2);
        simMet = new SimulateurMeteo(this,interval_meteo);

    }


    
    public Case[][] getPlateau() {
        return grilleCases;
    }

    private void initialisationDesEntites() {

        // murs extérieurs horizontaux
        for (int x = 0; x < 20; x++) {
            addEntite(new CaseNonCultivable(this), x, 0);
            addEntite(new CaseNonCultivable(this), x, 9);
        }

        // murs extérieurs verticaux
        for (int y = 1; y < 9; y++) {
            addEntite(new CaseNonCultivable(this), 0, y);
            addEntite(new CaseNonCultivable(this), 19, y);
        }

        addEntite(new CaseNonCultivable(this), 2, 6);
        addEntite(new CaseNonCultivable(this), 3, 6);

        Random rnd = new Random();

        for (int x = 5; x < 15; x++) {
            for (int y = 3; y < 7; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                addEntite(cc , x, y);
                if (rnd.nextBoolean()) {
                    cc.actionUtilisateur();
                }
                Ordonnanceur.getOrdonnanceur().add(cc);

            }
        }

    }

    public void actionUtilisateur(int x, int y,String type) {
        if (grilleCases[x][y] != null) {

            if(type.equals("SALADE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("SALADE");
            }
            else if(type.equals("BANANE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("BANANE");
            }
            else if(type.equals("CERISE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("CERISE");
            }
            else if(type.equals("CHAMPIGNON")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("CHAMPIGNON");
            }
            else if(type.equals("TOMATE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("TOMATE");
            }
            else if(type.equals("PECHE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("PECHE");
            }
            else if(type.equals("CARROTTE")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("CARROTTE");
            }

            else if(type.equals("ANANAS")){
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("ANANAS");
            }
            else {
                ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("TERRE");
            }
        }

    }

    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
        //map.put(e, new Point(x, y));
    }


    public Case objetALaPosition(Point p) {
        Case retour = null;
        return grilleCases[p.x][p.y];
    }
}
