package modele.environnement.varietes;

public class Cerise extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.CERISE;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une cerise pousse !!");
    }
}
