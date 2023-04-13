package modele.environnement.varietes;

import modele.environnement.varietes.Legume;
import modele.environnement.varietes.Varietes;


public class Banane extends Legume {
    private int size;//taille du legume sur l'image
    private int speed_growth;//vitesse de croissance du legume
    private int resistance;// une fois que le legume a finis de atteint sa taille taille max il disparaitra après un temps

    public Banane() {
        size=40;// taille de base du legume sur la grille
        speed_growth=20;// à chaque maj la taille augmentera de 10
        resistance=10;
    }
    @Override
    public Varietes getVariete() {
        return Varietes.BANANE;
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
        System.out.println("Une banane pousse !!");
        if(size<120) {
            size=size+10;
        }
        else {
            resistance--;// si le legume à atteint sa taille max il disparaitra après un certain temps
        }
    }
}
