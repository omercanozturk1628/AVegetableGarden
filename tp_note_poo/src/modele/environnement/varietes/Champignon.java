package modele.environnement.varietes;

public class Champignon extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.CHAMPIGNON;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une champignon pousse !!");
    }
}
