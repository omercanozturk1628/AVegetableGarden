package modele.environnement.varietes;

public class Tomate extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.TOMATE;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une tomate pousse !!");
    }
}
