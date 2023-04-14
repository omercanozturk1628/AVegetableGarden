package modele.environnement.varietes;

public class Cerise extends Legume {
    private int size;//taille du legume sur l'image
    private int speed_growth;//vitesse de croissance du legume
    private int resistance;// une fois que le legume a finis de atteint sa taille taille max il disparaitra après un temps
    private int score;// le score que rapporte un legume quand on le recolte
    public Cerise() {
        size=40;// taille de base du legume sur la grille
        speed_growth=10;// à chaque maj la taille augmentera de 10
        resistance=1;
        score=8;
    }

    @Override
    public int getScore() {
        return score;
    }
    @Override
    public Varietes getVariete() {
        return Varietes.CERISE;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public int getSpeed_growth() {
        return speed_growth;
    }

    @Override
    public void setSpeed_growth(int speed_growth) {
        this.speed_growth = speed_growth;
    }

    @Override
    public int getResistance() {
        return resistance;
    }

    @Override
    public void setResistance(int resistance) {
        this.resistance = resistance;
    }
    @Override
    protected void croissance() {
        System.out.println("Une cerise pousse !!");
        if(size<120) {
            size=size+speed_growth;
        }
        else {
            resistance--;// si le legume à atteint sa taille max il disparaitra après un certain temps
        }
    }



}
