package domini;

import java.sql.Timestamp;
import java.util.ArrayList;

public class MVM {

    private Problema p;
    private Tauler t;
    private Usuari a;
    private Usuari d;

    MVM (Problema p, Tauler t, Usuari a, Usuari d){
        this.p=p;
        this.t=t;
        this.a=a;
        this.d=d;
    }


    public boolean PlayMaquines() {

        int movs = 0;
        Jugada JAtac;
        Jugada JDef;
        int n = p.getN();
        String nomA = a.getNom(), nomD = d.getNom();

        while (t.getPeces_negres()[15] != null && t.getPeces_blanques()[15] != null && movs < n) {
            if (nomA == "M1") {
                JAtac = a.play(t.getPeces_negres(),t.getPeces_blanques() , n, movs);
            }
            else {
                JAtac = a.playPRO( t.getPeces_negres(),t.getPeces_blanques(), n, movs);
            }

            ArrayList<Integer> aux = new ArrayList<>();
            if (JAtac != null) {
                aux.add(JAtac.getPeca().getX());
                aux.add(JAtac.getPeca().getY());
                aux.add(JAtac.getPos_fin_x());
                aux.add(JAtac.getPos_fin_y());
                t.MourePeca(t.getPeca(JAtac.getPeca().getX(), JAtac.getPeca().getY()), JAtac.getPos_fin_x(), JAtac.getPos_fin_y());
                ++movs;
            }
            else {
                return false;
            }

            if(t.getPeces_negres()[15]==null) return true;

            if (nomD == "M1") {
               JDef  = a.play(t.getPeces_blanques(), t.getPeces_negres(), n, movs);
            }
            else {
                JDef = a.playPRO(t.getPeces_blanques(), t.getPeces_negres(), n, movs);
            }

            ArrayList<Integer> aux2 = new ArrayList<>();
            if (JDef != null) {
                aux2.add(JAtac.getPeca().getX());
                aux2.add(JAtac.getPeca().getY());
                aux2.add(JAtac.getPos_fin_x());
                aux2.add(JAtac.getPos_fin_y());
                t.MourePeca(t.getPeca(JDef.getPeca().getX(), JDef.getPeca().getY()), JDef.getPos_fin_x(), JDef.getPos_fin_y());
            }
            else {
                return true;
            }
        }

        if (t.getPeces_negres()[15] == null) return true;
        if (t.getPeces_blanques()[15] == null) return false;
        if (movs >= n) return false;

        return false;



    }



}
