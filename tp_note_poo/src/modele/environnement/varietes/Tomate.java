package modele.environnement.varietes;

public class Tomate extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.TOMATE;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une tomate pousse !!");
    }
}
