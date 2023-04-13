package modele.environnement.varietes;

public abstract class Legume {
    public abstract Varietes getVariete();
    public void nextStep() {
        croissance();
    }
    public abstract int getSize();
    public abstract void setSize(int size);
    public abstract int getSpeed_growth();
    public abstract void setSpeed_growth(int speed_growth);
    public abstract int getResistance();
    public abstract void setResistance(int resistance);
    protected abstract void croissance(); // définir selon les conditions

}
