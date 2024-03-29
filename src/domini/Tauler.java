package domini;

import java.util.*;


public class Tauler {
    //vector< vector<Cela> > tauler;
    private Peca[] peces_blanques; // peces_blanques {p,p,p,p,p,p,p,p,a,a,c,c,t,t,d,r}
    private Peca[] peces_negres;

    private Integer BnT, BnC, BnA, BnP, NnT, NnC, NnA, NnP;

    public Tauler() {

        peces_blanques = new Peca[16];
        peces_negres = new Peca[16];

        BnT = 0;
        BnC = 0;
        BnA = 0;
        BnP = 0;
        NnT = 0;
        NnC = 0;
        NnA = 0;
        NnP = 0;

    }

    public Tauler(Peca[] peces_blanques, Peca[] peces_negres) {

        this.peces_blanques = peces_blanques;
        this.peces_negres = peces_negres;

        BnT = 0;
        BnC = 0;
        BnA = 0;
        BnP = 0;
        NnT = 0;
        NnC = 0;
        NnA = 0;
        NnP = 0;
    }


    //mourePeça

//java overloading function

    private Peca[] matar(Peca[] vector, int x, int y) {

        for (int i = 0; i < 16; ++i) {
            if (vector[i] != null) {

                if (vector[i].getX() == x && vector[i].getY() == y) {
                    vector[i] = null;
                }

            }
        }

        return vector;

    }

    private boolean posinmoviments(IntPair pos, ArrayList<IntPair> moviments) {

        for (int i = 0; i < moviments.size(); ++i) {

            if (moviments.get(i).getX() == pos.getX() && moviments.get(i).getY() == pos.getY()) return true;
        }

        return false;


    }

    public void actualitzar() {

        for (int i = 0; i < 16; ++i) {

            if (peces_blanques[i] != null) peces_blanques[i].posibles_moviments(peces_blanques, peces_negres);
            if (peces_negres[i] != null) peces_negres[i].posibles_moviments(peces_blanques, peces_negres);
        }

    }


    public boolean MourePeca(Peca t, int newX, int newY) {
        actualitzar();
        IntPair pos = new IntPair(newX, newY);


        if (posinmoviments(pos, t.getMoviments())) {

            if (getPeca(newX, newY) != null) {
                if (t.esBlanca()) peces_negres = matar(peces_negres, newX, newY);
                else peces_blanques = matar(peces_blanques, newX, newY);
            }

            t.setX(newX);
            t.setY(newY);

            actualitzar();

            return true;
        } else return false;
    }

    public Tauler getTauler(String FEN) {

        Problema p = new Problema(FEN);

        return p.FENtoHuman();

    }


    public void setRei(Rei R) {

        if (R.esBlanca()) peces_blanques[15] = R;
        else peces_negres[15] = R;

    }

    public void setReina(Reina D) {

        if (D.esBlanca()) peces_blanques[14] = D;
        else peces_negres[14] = D;

    }

    public void setTorre(Torre To) {

        if (To.esBlanca()) {

            this.peces_blanques[12 + BnT] = To;
            ++BnT;
        } else {
            this.peces_negres[12 + NnT] = To;
            ++NnT;
        }

    }

    public void setCavall(Cavall C) {

        if (C.esBlanca()) {
            peces_blanques[10 + BnC] = C;
            ++BnC;
        } else {
            peces_negres[10 + NnC] = C;
            ++NnC;
        }

    }

    public void setAlfil(Alfil A) {

        if (A.esBlanca()) {
            peces_blanques[8 + BnA] = A;
            ++BnA;
        } else {
            peces_negres[8 + NnA] = A;
            ++NnA;
        }

    }

    public void setPeo(Peo P) {

        if (P.esBlanca()) {
            peces_blanques[BnP] = P;
            ++BnP;
        } else {
            peces_negres[NnP] = P;
            ++NnP;
        }

    }

    public boolean white_king_in_mate(Tauler t) {
        Peca rei = new Rei();

        rei = peces_blanques[15];

        boolean b1,b2,b3,b4,b5,b6,b7,b8,b9;
        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = false;

        for (int i = 0; i < peces_negres.length; i++) {

            if (peces_negres[i] != null ) {
                for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                    if (peces_negres[i].moviments.get(j).getX() == rei.getX() && peces_negres[i].moviments.get(j).getY() == rei.getY())
                        b1 = true;
                }

                if (rei.getX() + 1 < 8 && t.getPeca(rei.getX() + 1 , rei.getY()) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() + 1 && peces_negres[i].moviments.get(j).getY() == rei.getY())
                            b2 = true;
                    }
                } else b2 = true;

                if (rei.getY() + 1 < 8 && t.getPeca(rei.getX() , rei.getY() + 1) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() && peces_negres[i].moviments.get(j).getY() == rei.getY() + 1)
                            b3 = true;
                    }
                } else b3 = true;

                if (rei.getY() + 1 < 8 && rei.getX() + 1 < 8 && t.getPeca(rei.getX() + 1 , rei.getY() + 1 ) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() + 1 && peces_negres[i].moviments.get(j).getY() == rei.getY() + 1)
                            b4 = true;
                    }
                } else b4 = true;

                if (rei.getX() - 1 >= 0 && t.getPeca(rei.getX() - 1 , rei.getY()) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() - 1 && peces_negres[i].moviments.get(j).getY() == rei.getY())
                            b5 = true;
                    }
                } else b5 = true;

                if (rei.getY() - 1 >= 0 && t.getPeca(rei.getX() ,rei.getY() -1 ) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() && peces_negres[i].moviments.get(j).getY() == rei.getY() - 1)
                            b6 = true;
                    }
                } else b6 = true;

                if (rei.getY() - 1 >= 0 && rei.getX() - 1 >= 0 &&  t.getPeca(rei.getX() - 1 , rei.getY() -1) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() - 1 && peces_negres[i].moviments.get(j).getY() == rei.getY() - 1)
                            b7 = true;
                    }
                } else b7 = true;

                if (rei.getX() + 1 < 8 && rei.getY() - 1 >= 0 && t.getPeca(rei.getX() + 1 , rei.getY() - 1) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() + 1 && peces_negres[i].moviments.get(j).getY() == rei.getY() - 1)
                            b8 = true;
                    }
                } else b8 = true;

                if (rei.getX() - 1 >= 0 && rei.getY() + 1 < 8 && t.getPeca(rei.getX() - 1 , rei.getY() + 1) == null) {
                    for (int j = 0; j < peces_negres[i].moviments.size(); ++j) {
                        if (peces_negres[i].moviments.get(j).getX() == rei.getX() - 1 && peces_negres[i].moviments.get(j).getY() == rei.getY() + 1)
                            b9 = true;
                    }
                } else b9 = true;
            }
        }
        return (b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8 && b9);
    }

    public boolean black_king_in_mate(Tauler t) {

        Peca rei = new Rei();

        rei = peces_negres[15];

        boolean b1,b2,b3,b4,b5,b6,b7,b8,b9;
        b1 = b2 = b3 = b4 = b5 = b6 = b7 = b8 = b9 = false;

        for (int i = 0; i < peces_blanques.length; i++) {

            if (peces_blanques[i] != null ) {
                for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                    if (peces_blanques[i].moviments.get(j).getX() == rei.getX() && peces_blanques[i].moviments.get(j).getY() == rei.getY())
                        b1 = true;
                }

                if (rei.getX() + 1 < 8 && t.getPeca(rei.getX() + 1 , rei.getY()) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() + 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY())
                            b2 = true;
                    }
                } else b2 = true;

                if (rei.getY() + 1 < 8 && t.getPeca(rei.getX() , rei.getY() + 1) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() && peces_blanques[i].moviments.get(j).getY() == rei.getY() + 1)
                            b3 = true;
                    }
                } else b3 = true;

                if (rei.getY() + 1 < 8 && rei.getX() + 1 < 8 && t.getPeca(rei.getX() + 1 , rei.getY() + 1 ) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() + 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY() + 1)
                            b4 = true;
                    }
                } else b4 = true;

                if (rei.getX() - 1 >= 0 && t.getPeca(rei.getX() - 1 , rei.getY()) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() - 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY())
                            b5 = true;
                    }
                } else b5 = true;

                if (rei.getY() - 1 >= 0 && t.getPeca(rei.getX() ,rei.getY() -1 ) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() && peces_blanques[i].moviments.get(j).getY() == rei.getY() - 1)
                            b6 = true;
                    }
                } else b6 = true;

                if (rei.getY() - 1 >= 0 && rei.getX() - 1 >= 0 &&  t.getPeca(rei.getX() - 1 , rei.getY() -1) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() - 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY() - 1)
                            b7 = true;
                    }
                } else b7 = true;

                if (rei.getX() + 1 < 8 && rei.getY() - 1 >= 0 && t.getPeca(rei.getX() + 1 , rei.getY() - 1) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() + 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY() - 1)
                            b8 = true;
                    }
                } else b8 = true;

                if (rei.getX() - 1 >= 0 && rei.getY() + 1 < 8 && t.getPeca(rei.getX() - 1 , rei.getY() + 1) == null) {
                    for (int j = 0; j < peces_blanques[i].moviments.size(); ++j) {
                        if (peces_blanques[i].moviments.get(j).getX() == rei.getX() - 1 && peces_blanques[i].moviments.get(j).getY() == rei.getY() + 1)
                            b9 = true;
                    }
                } else b9 = true;
            }
        }
        return (b1 && b2 && b3 && b4 && b5 && b6 && b7 && b8 && b9);
    }


    public Peca getPeca(int x, int y) {
        for (Peca p : peces_blanques) {
            if (p != null && p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        for (Peca p : peces_negres) {
            if (p != null && p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return null;
    }

    public Peca[] getPeces_blanques() {
        return peces_blanques;
    }

    public Peca[] getPeces_negres() {
        return peces_negres;
    }

    public String HumantoFEN(Peca[] peces_blanques, Peca[] peces_negres) {
        int a, b;
        char[] FEN = new char[64];
        char[][] mapa = new char[8][8];


        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                mapa[i][j] = '-';
            }
        }

        for (int i = 0; i < 16; ++i) {
            if (peces_blanques[i] != null) {

                a = peces_blanques[i].getX();
                b = peces_blanques[i].getY();

                if (i <= 7) {

                    mapa[a][b] = 'P';

                } else if (i <= 9) {
                    mapa[a][b] = 'B';
                } else if (i <= 11) {
                    mapa[a][b] = 'N';
                } else if (i <= 13) {
                    mapa[a][b] = 'R';
                } else if (i == 14) {
                    mapa[a][b] = 'Q';
                } else {
                    mapa[a][b] = 'K';
                }
            }

            if (peces_negres[i] != null) {

                a = peces_negres[i].getX();
                b = peces_negres[i].getY();

                if (i <= 7) {

                    mapa[a][b] = 'p';

                } else if (i <= 9) {
                    mapa[a][b] = 'b';
                } else if (i <= 11) {
                    mapa[a][b] = 'n';
                } else if (i <= 13) {
                    mapa[a][b] = 'r';
                } else if (i == 14) {
                    mapa[a][b] = 'q';
                } else {
                    mapa[a][b] = 'k';
                }
            }
        }
        int iter = 0;
        for (int i = 0; i < 8; ++i) {
            int buit = 0;
            for (int j = 0; j < 8; ++j) {
                if (mapa[j][i] == '-') ++buit;
                else {
                    if (buit != 0) {
                        FEN[iter] = (char) (buit +'0');
                        buit=0;
                        ++iter;

                    }
                    FEN[iter] = mapa[j][i];
                    ++iter;
                }
            }
            if(buit!=0) {
                FEN[iter] = (char)(buit +'0');
                ++iter;
            }

            if(i!=7) {
                FEN[iter] = '/';
                ++iter;
            }

        }
        for(int i= iter;i<64;i++){
            FEN[iter] = ' ';
        }
        String res = String.valueOf(FEN);
        //res = res + " ";
        return res;
    }
}


        /*
        domini.Peca[][] mapa = new domini.Peca[8][8];

        char[] FEN = new char[64];

        int whiteX, whiteY, blackX, blackY;

        for (int i = 0; i < 16; ++i) {
            whiteX = peces_blanques[i].getX();
            whiteY = peces_blanques[i].getY();

            blackX = peces_negres[i].getX();
            blackY = peces_negres[i].getY();

            mapa[whiteX][whiteY] = peces_blanques[i];
            mapa[blackX][blackY] = peces_negres[i];



/*
        int iter = 0;
        for (int i = 0; i < 8; ++i) {
            int buit = 0;
            for (int j = 0; j < 8; ++j) {
                //if(getPeça(i,j) is null)
                if (getPeca(i,j) == null) ++buit;
                else {
                    if (buit != 0) {
                        FEN[iter] = (char) buit;
                        ++iter;
                    }
                    FEN[iter] = mapa[i][j].tipus();
                }
            }
            FEN[iter] = '/';
        } //falta el i el guionet i bla bla
        return FEN;
    }
*/

