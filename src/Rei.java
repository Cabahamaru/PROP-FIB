import java.util.*;


public class Rei extends Peca {

    public Rei(String i, int x, int y, boolean color) {
        setId(i);
        setX(x);
        setY(y);
        setColor(color);
    }

    public ArrayList<IntPair> posibles_moviments(Tauler t) {
        //el rei es pot moure a qualsevol casella que estigui a 1 de distancia
        this.moviments.clear();
        int posx[] = {this.getX() - 1, this.getX(), this.getX() + 1, this.getX() - 1, this.getX() + 1, this.getX() - 1, this.getX(), this.getX() + 1};
        int posy[] = {this.getY() - 1, this.getY() - 1, this.getY() - 1, this.getY(), this.getY(), this.getY() + 1, this.getY() + 1, this.getY() + 1};
        for (int i = 0; i < 8; ++i) {
            if (posx[i] >= 0 && posx[i] < 8 && posy[i] >= 0 && posy[i] < 8) {
                if (t.getPeca(posx[i],posy[i]) == null || t.getPeca(posx[i],posy[i]).getColor() != this.getColor()) {
                    IntPair aux = new IntPair(posx[i], posy[i]);
                    this.moviments.add(aux);
                }
            }
        }
        return this.moviments;
    }

    //Funcio que mira si el Rei esta en perill
    //Donat un estat del Tauler, mira si hi alguna peça de color contrari que pugui atacar al Rei
    public boolean en_perill(Tauler t){
        //en construccio
        return false;
    }
}

//IGNORAR A PARTI D'AQUI
    /*
    public boolean moviment_valid(Tauler t, int desti_x, int desti_y) {
        //El Rei es pot moure a qualsevol cel·la a distancia 1 de la seva posicio actual

        //Si hi ha una peça aliada a la posició destí, no ens podem moure
        Peca p_aux = t.getPeca(desti_x,desti_y);
        if (p_aux != null) {
            if (p_aux.esBlanca() && this.esBlanca()) return false;
            if (p_aux.esNegra() && this.esNegra()) return false;
        }

        //tots els moviments a distancia 1 son valids
        int dist_x = Math.abs(desti_x - this.getX());
        int dist_y = Math.abs(desti_y - this.getY());
        if (dist_x == 1 && dist_y == 1) return true; //moviment diagonal
        if (dist_x == 1 && dist_y == 0) return true; //moviment horitzontal
        if (dist_x == 0 && dist_y == 1) return true; //moviment vertical
        return false; //qualsevol altre moviment no es valid
    }
     */
