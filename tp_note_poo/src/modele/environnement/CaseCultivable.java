package modele.environnement;

import modele.SimulateurPotager;
import modele.environnement.varietes.*;

public class CaseCultivable extends Case {

    private Legume legume;
    public CaseCultivable(SimulateurPotager _simulateurPotager) {
        super(_simulateurPotager);
    }

    @Override
    public void actionUtilisateur() {
        if (legume == null) {
            legume = new Cerise();
        } else {
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
