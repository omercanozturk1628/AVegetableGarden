package modele.environnement.varietes;

public class Carrotte extends Legume {

    @Override
    public Varietes getVariete() {
        return Varietes.CARROTTE;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("une carrotte est pousse!");
    }
}
