package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.*;

import java.util.ArrayList;
import java.util.Random;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }


    public String getRandomVegetable() {
        String vegetable="";
        ArrayList<String> liste_variete_possible= new ArrayList<String>();
        liste_variete_possible.add("Ananas");
        liste_variete_possible.add("Banane");
        liste_variete_possible.add("Carrote");
        liste_variete_possible.add("Cerise");
        liste_variete_possible.add("Champignon");
        liste_variete_possible.add("Peche");
        liste_variete_possible.add("Salade");
        liste_variete_possible.add("Tomate");
        int rnd= new Random().nextInt(liste_variete_possible.size());
        return liste_variete_possible.get(rnd);
    }

    @Override
    public void actionUtilisateur() {
        // à l'initialisation de la grille si la case est cultivable on genère un legume au hazard
        if (legume == null) {
            //
            String legume_aleatoire=getRandomVegetable();
            if(legume_aleatoire=="Ananas") {
                legume = new Ananas();
            }
            else if (legume_aleatoire=="Banane" ){
                legume = new Banane();
            }
            else if (legume_aleatoire=="Carrote" ){
                legume = new Carrotte();
            }
            else if (legume_aleatoire=="Cerise" ){
                legume = new Cerise();
            }
            else if (legume_aleatoire=="Champignon" ){
                legume = new Champignon();
            }
            else if (legume_aleatoire=="Peche" ){
                legume = new Peche();
            }
            else if (legume_aleatoire=="Salade" ){
                legume = new Salade();
            }
            else if (legume_aleatoire=="Tomate" ){
                legume = new Tomate();
            }
        }  else {
            legume = null;
        }
    }

    public Legume actionLegumePotager(String type){
        if(type.equals("SALADE")){
            legume = new Salade();
        }
        else if(type.equals("BANANE")){
            legume = new Banane();
        }
        else if(type.equals("CERISE")){
            legume = new Cerise();
        }
        else if(type.equals("CHAMPIGNON")){
            legume = new Champignon();
        }
        else if(type.equals("TOMATE")){
            legume = new Tomate();
        }
        else if(type.equals("PECHE")){
            legume = new Peche();
        }
        else if(type.equals("CARROTTE")){
            legume = new Carrotte();
        }

        else if(type.equals("ANANAS")){
            legume = new Ananas();
        }
        else if(type.equals("TERRE")){
            legume = null;
        }
        return legume;
    }
    public Legume getLegume() {
        return legume;
    }

    @Override
    public void run() {
        if (legume != null) {
            legume.nextStep();
        }
    }
}
