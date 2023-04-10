package modele.environnement.varietes;

public class Ananas extends Legume {
    @Override
    public Varietes getVariete() {
        return Varietes.ANANAS;
    }

    @Override
    protected void croissance() {
        // TODO condition de croissance, faire grossir l'image quand l'annanas pousse
        System.out.println("Une ananas pousse !!");
    }
}
