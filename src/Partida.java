

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Partida {

    private static Timestamp fecha;
    private Problema p;
    private Tauler t;
    private Atacant a;
    private Defensor d;

    Partida(Timestamp f,Problema p, Tauler t, Atacant a, Defensor d){
        fecha=f;
        this.p=p;
        this.t=t;
        this.a=a;
        this.d=d;
    }


    public void mourePeça(Peça A, int x, int y){
        char whoStarts = p.whoStarts();


    }

    public Atacant getA() {
        return a;
    }

    public Defensor getD() {
        return d;
    }

    public Problema getP() {
        return p;
    }

    public Tauler getT() {
        return t;
    }

    public void setA(Atacant a) {
        this.a = a;
    }

    public void setD(Defensor d) {
        this.d = d;
    }

    public void setP(Problema p) {
        this.p = p;
    }

    public void setT(Tauler t) {
        this.t = t;
    }

    public Timestamp getFecha() {
        return fecha;
    }
}
