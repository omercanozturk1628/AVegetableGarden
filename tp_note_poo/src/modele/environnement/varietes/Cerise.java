package modele.environnement.varietes;

public class Cerise extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.CERISE;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une cerise pousse !!");
    }
}
