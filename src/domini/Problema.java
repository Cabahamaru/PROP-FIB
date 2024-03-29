package domini;


public class Problema {

    private String FEN;
    private String ID;
    private Integer N;
    private char whoStarts;

    Problema(String FEN) {
        this.FEN = FEN;
    }

    public String getFEN() {
        return FEN;
    }

/*
   public char whoStarts() {
        return FEN[FEN.length() - 9];
    }
*/
    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return ID;
    }

    public void setN(Integer n) { this.N = n;}

    public Integer getN() {return N;}


    //PeoPeoPeoPeoPeoPeoPeoPeoAlfAlfCavCavTorTorReinaRei;

    //aixo passa de FEN a un tauler decente de personas
    public Tauler FENtoHuman() {

        char[] FEN = this.FEN.toCharArray();

        int BnP = 0, BnC = 0, BnA = 0, BnT = 0, BnR = 0, BnD = 0;
        int NnP = 0, NnC = 0, NnA = 0, NnT = 0, NnR = 0, NnD = 0;

        int BAF = 0,BAC = 0;
        int NAF = 0, NAC = 0;

        boolean numero = false;

        Tauler T = new Tauler();
        int tam = FEN.length;
        int x = 0, y = 0;
        for (int i = 0; i < tam; ++i) {

            switch (FEN[i]) {

                case '/':
                    ++y;
                    if ( y > 7) return null;
                    x = 0;
                    numero = false;
                    break;
                case 'K':
                    if(x >= 8) return null;
                    Rei R = new Rei(15,x, y,true);
                    ++BnR;
                    if (BnR > 1) return null;
                    T.setRei(R);
                    ++x;
                    numero = false;
                    break;
                case 'k':
                    if(x >= 8) return null;
                    Rei r = new Rei(15,x, y, false);
                    ++NnR;
                    if (NnR > 1) return null;
                    T.setRei(r);
                    ++x;
                    numero = false;
                    break;
                case 'Q':
                    if(x >= 8) return null;
                    Reina D = new Reina(14,x, y, true);
                    ++BnD;
                    if (BnD > 1) return null;
                    T.setReina(D);
                    ++x;
                    numero = false;
                    break;
                case 'q':
                    if(x >= 8) return null;
                    Reina d = new Reina(14,x, y, false);
                    ++NnD;
                    if (NnD > 1) return null;
                    T.setReina(d);
                    ++x;
                    numero = false;
                    break;
                case 'R':
                    if(x >= 8) return null;
                    Torre To = new Torre(12 +BnT,x, y, true);
                    ++BnT;
                    if (BnT > 2) return null;
                    T.setTorre(To);
                    ++x;
                    numero = false;
                    break;
                case 'r':
                    if(x >= 8) return null;
                    Torre to = new Torre(12+NnT, x, y, false);
                    ++NnT;
                    if (NnT > 2) return null;
                    T.setTorre(to);
                    ++x;
                    numero = false;
                    break;
                case 'B':
                    if(x >= 8) return null;
                    Alfil A = new Alfil(8+BnA,x, y, true);
                    ++BnA;
                    if((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) ++BAC;
                    else ++BAF;

                    if (BnA > 2 || BAC > 1 || BAF > 1) return null;
                    T.setAlfil(A);
                    ++x;
                    numero = false;
                    break;
                case 'b':
                    if(x >= 8) return null;
                    Alfil a = new Alfil(8+NnA,x, y, false);
                    ++NnA;
                    if((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)) ++NAC;
                    else ++NAF;
                    if (NnA > 2 || NAC > 1 || NAF > 1) return null;
                    T.setAlfil(a);
                    ++x;
                    numero = false;
                    break;
                case 'N':
                    if(x >= 8) return null;
                    Cavall C = new Cavall(10+BnC,x, y, true);
                    ++BnC;
                    if(BnC > 2) return null;
                    T.setCavall(C);
                    ++x;
                    numero = false;
                    break;
                case 'n':
                    if(x >= 8) return null;
                    Cavall c = new Cavall(10+NnC,x, y, false);
                    ++NnC;
                    if (NnC > 2) return null;
                    T.setCavall(c);
                    ++x;
                    numero = false;
                    break;
                case 'P':
                    if(x >= 8) return null;
                    Peo P = new Peo(BnP,x, y, true);
                    ++BnP;
                    if (BnP > 8) return null;
                    T.setPeo(P);
                    ++x;
                    numero = false;
                    break;
                case 'p':
                    if(x >= 8) return null;
                    Peo p = new Peo(NnP,x, y, false);
                    ++NnP;
                    if (NnP > 8) return null;
                    T.setPeo(p);
                    ++x;
                    numero = false;
                    break;
                default:
                    if (FEN[i] == ' ') {
                        i = 1000;
                        break;
                    }
                    else if (FEN[i] == '1' || FEN[i] == '2' ||FEN[i] == '3' ||FEN[i] == '4' ||FEN[i] == '5' ||FEN[i] == '6' ||FEN[i] == '7' || FEN[i] == '8') {
                        if (numero) return null;
                        x += Character.getNumericValue(FEN[i]);
                        if (x > 8) return null;
                        numero = true;
                        break;
                    }
                    else return null;


            }
        }

        if (BnR == 1 && NnR == 1) return T;
        else return null;
    }
}











    //public bool teSolucio() {}

