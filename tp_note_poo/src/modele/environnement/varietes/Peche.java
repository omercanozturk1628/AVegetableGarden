package modele.environnement.varietes;

public class Peche extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.PECHE;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une peche pousse !!");
    }
}
