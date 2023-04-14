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
import java.util.HashMap;
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

    private HashMap<Point, Case> map = new  HashMap<Point, Case>(); // permet de récupérer la position d'une entité à partir de sa référence
    private Case[][] grilleCases = new Case[SIZE_X][SIZE_Y]; // permet de récupérer une entité à partir de ses coordonnées

    public SimulateurPotager() {

        initialisationDesEntites();

        Date interval_meteo = new Date();
        interval_meteo.setMinutes(0);
        interval_meteo.setSeconds(2);
        simMet = new SimulateurMeteo(this);


        simMet = new SimulateurMeteo(this);

    }


    
    public Case[][] getPlateau() {
        return grilleCases;
    }
    
    //initialise la grille de départ
    private void initialisationDesEntites() {
        System.out.println("on créer le potager ******************************************************");
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
        // les 2 cases non cultivable de la grille à supprimer
        //addEntite(new CaseNonCultivable(this), 2, 6);
        //addEntite(new CaseNonCultivable(this), 3, 6);

        Random rnd = new Random();

        for (int x = 1; x < SIZE_X-1; x++) {
            for (int y = 1; y < SIZE_Y-1; y++) {
                CaseCultivable cc = new CaseCultivable(this);
                addEntite(cc , x, y);
                if (rnd.nextBoolean()) {
                    // pour les cases cultivable on peut planter ou non un legume au hazrd pendant l'initialisation
                    cc.actionUtilisateur();
                }
                Ordonnanceur.getOrdonnanceur().add(cc);
            }
        }

    }

    public Legume actionUtilisateur(int x, int y,String type) {
        if (grilleCases[x][y] != null) {

            if(type.equals("SALADE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("SALADE");
                return l;
            }
            else if(type.equals("BANANE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("BANANE");
                return l;
            }
            else if(type.equals("CERISE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("CERISE");
                return l;
            }

            else if(type.equals("TOMATE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("TOMATE");
                return l;
            }
            else if(type.equals("PECHE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("PECHE");
                return l;
            }
            else if(type.equals("CARROTTE")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("CARROTTE");
                return l;
            }

            else if(type.equals("ANANAS")){
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("ANANAS");
                return l;
            }
            else if(type.equals("TERRE")) {
                Legume l = ((CaseCultivable) grilleCases[x][y]).actionLegumePotager("TERRE");
                return l;
            }


        }
        return null;

    }

    private void addEntite(Case e, int x, int y) {
        grilleCases[x][y] = e;
        map.put(new Point(x, y),e);
    }


    public Case objetALaPosition(Point p) {
        Case retour = null;
        return map.get(p);
    }



    public boolean isCultivable(Case ca){
        if(ca instanceof CaseCultivable){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean isPresentLegume(CaseCultivable cas){
        // retourne faux si la case ne contient pas de legume pas
        if(cas.getLegume() == null){
            return false;
        }
        else{
            return true;
        }
    }

}
