package modele.environnement.varietes;

public class Peche extends Legume {
    private int size;//taille du legume sur l'image
    private int speed_growth;//vitesse de croissance du legume
    private int resistance;// une fois que le legume a finis de atteint sa taille taille max il disparaitra après un temps

    @Override
    public Varietes getVariete() {
        return Varietes.PECHE;
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public void setSize(int size) {

    }

    @Override
    public int getSpeed_growth() {
        return 0;
    }

    @Override
    public void setSpeed_growth(int speed_growth) {

    }

    @Override
    public int getResistance() {
        return 0;
    }

    @Override
    public void setResistance(int resistance) {

    }

    @Override
    protected void croissance() {
        // TODO
        System.out.println("Une peche pousse !!");
    }
}
