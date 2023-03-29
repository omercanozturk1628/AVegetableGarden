package modele.environnement.varietes;

public class Ananas extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.ANANAS;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une ananas pousse !!");
    }
}
