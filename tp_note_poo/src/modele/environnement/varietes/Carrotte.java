package modele.environnement.varietes;

public class Carrotte extends Legume {

    @Override
    public Varietes getVariete() {
        return Varietes.CARROTTE;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("une carrotte est pousse!");
    }
}
