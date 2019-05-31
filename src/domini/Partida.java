package domini;

import java.sql.Timestamp;

public class Partida {

    private Timestamp fecha;
    private Problema p;
    private Tauler t;
    private Usuari a;
    private Usuari d;
    private Integer Mov;
    private boolean tornBlanques;
    //private Rellotge timer;
    private float temps;

    Partida(Timestamp f,Problema p, Tauler t, Usuari a, Usuari d){
        this.fecha=f;
        this.p=p;
        this.t=t;
        this.a=a;
        this.d=d;
        this.Mov = 0;
        this.tornBlanques = true;
        this.temps = 180;
    }

    public boolean getTorn() {
        return tornBlanques;
    }
    public void setTorn(boolean torn) {
        this.tornBlanques = torn;
    }

    public boolean te_solucio(){
        return d.te_solucio(t.getPeces_blanques(),t.getPeces_negres(),2);
    }

    public int getN(){
        return p.getN();
    }

    public int getMov() {return Mov;}

    public void setTemps(float temps) {
        this.temps = temps;
    }

    public float getTemps() {
        return this.temps;
    }

    public void setMov(int mov) {
        this.Mov = mov;
    }

    public Problema getProblema() {
        return this.p;
    }


    public boolean mourePeca(int x, int y, int xnew, int ynew){

        boolean espotmoure = t.MourePeca(t.getPeca(x,y),xnew,ynew);

        return espotmoure;
    }

    public Jugada moureMaquina(int mat,int i){
        Jugada j = d.play(t.getPeces_blanques(),t.getPeces_negres(),mat,i);
        return j;
    }
    public Jugada moureMaquina2(int mat,int i){
        Jugada j= d.playPRO(t.getPeces_blanques(),t.getPeces_negres(),mat,i);
        return j;
    }

    public Usuari getA() {
        return a;
    }

    public Usuari getD() {
        return d;
    }

    public Problema getP() {
        return p;
    }

    public Tauler getT() {
        return t;
    }

    public void setA(Usuari a) {
        this.a = a;
    }

    public void setD(Usuari d) {
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
