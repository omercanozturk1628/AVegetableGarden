package modele.environnement.varietes;

import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Varietes;

public class Banane extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.BANANE;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une banane pousse !!");
    }
}
