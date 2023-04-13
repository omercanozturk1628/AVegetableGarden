package modele.environnement.varietes;

public class Salade extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.SALADE;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected void croissance() {
        // TODO
        // idéé retourne une vitesse de croissance
        // dans mettre affichage on aggrandit l'icone en fonction des conditions
        System.out.println("Une salade pousse !!");
    }
}
