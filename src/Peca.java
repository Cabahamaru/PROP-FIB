import java.util.*;


public abstract class Peca {
    private String id=null;
    private int x; //[0..7]
    private int y; //[0..7]
    private boolean es_blanca;

    class IntPair {
        int x;
        int y;
        IntPair(){}
        IntPair(int x, int y) {this.x=x;this.y=y;}
    }

    protected ArrayList<IntPair> moviments = new ArrayList<IntPair>();


    //id setter
    public void setId(String id) {
        this.id=id;
    }

    //id getter
    public String getId() {
        return id;
    }

    //color setter
    public void setColor(boolean color) {
        this.es_blanca=color;
    }

    //color getter blanca
    public boolean esBlanca() {
        return es_blanca;
    }

    //color getter negra
    public boolean esNegra() {
        return !es_blanca;
    }

    //x setter
    public void setX(int x) {
        this.x = x;
    }

    //y setter
    public void setY(int Y) {
        this.y = y;
    }

    //x getter
    public int getX() {
        return x;
    }

    //y getter
    public int getY() {
        return y;
    }

    public abstract ArrayList<IntPair> posibles_moviments(Tauler t);


}
