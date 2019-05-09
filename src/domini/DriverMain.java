package domini;

import java.sql.Timestamp;
import java.util.*;

public class DriverMain {

    private static inout io;
    private static Ctrl_Domini ctrldom = new Ctrl_Domini();


    private static void pintarTauler(Tauler t){
        Peca[] peces_blanques = t.getPeces_blanques();
        Peca[] peces_negres = t.getPeces_negres();
        int a=0, b=0;
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
                    mapa[a][b] = 'A';
                } else if (i <= 11) {
                    mapa[a][b] = 'C';
                } else if (i <= 13) {
                    mapa[a][b] = 'T';
                } else if (i == 14) {
                    mapa[a][b] = 'D';
                } else {
                    mapa[a][b] = 'R';
                }
            }

            if (peces_negres[i] != null) {

                a = peces_negres[i].getX();
                b = peces_negres[i].getY();

                if (i <= 7) {

                    mapa[a][b] = 'p';

                } else if (i <= 9) {
                    mapa[a][b] = 'a';
                } else if (i <= 11) {
                    mapa[a][b] = 'c';
                } else if (i <= 13) {
                    mapa[a][b] = 't';
                } else if (i == 14) {
                    mapa[a][b] = 'd';
                } else {
                    mapa[a][b] = 'r';
                }
            }
        }
        System.out.print("\n");
        System.out.print("  ");
        for (int xx = 0; xx < 8;++xx){
            System.out.print(xx);
        }
        System.out.println();

        for(int z=0; z<8;++z){
            System.out.print(z);
            System.out.print(" ");

            for(int w=0;w<8;++w){
                System.out.print(mapa[w][z]);
            }
            System.out.print("\n");
        }

    }


    public static void main(String[] args) throws Exception {
        io = new inout();
        int s = -1;


        Scanner scanner = new Scanner(System. in);

        ctrldom.crearMaquina();

        while (s != 4) {
            io.write("Opcions: \n 1.Gestio Usuaris \n 2.Gestio problemas  \n 3.Gestio partidas \n 4. Exit \n");
            s = io.readint();
            if(s == 1){
                io.write("Opcions: \n 1.Crear domini.Huma \n 2.Borrar domini.Huma \n 3.Consultar Usuaris \n");
                s = io.readint();
                if (s == 1){
                    io.write("Introdueix nom: \n");
                    String stg= io.readname();
                    //io.write("Introdueix password: ");
                    //String stg2= io.readname();
                    ctrldom.AddHuma(stg);
                }
                else if (s == 2){

                }
                else if (s == 3){
                    io.write("Usuaris disponibles: \n");
                    for(String elem : ctrldom.getUsuaris()){
                        System.out.println(elem);
                    }
                }

            }
            else if(s==2){
                io.write("Opcions: \n 1.Crear domini.Problema \n 2.Consultar problemas \n 3.Borrar domini.Problema");
                s = io.readint();
                if (s == 1){
                    io.write("Introdueix FEN: \n");
                    String stg = scanner. nextLine();
                    io.write("Introdueix Nºmat: \n");
                    int mat = scanner.nextInt();

                    ctrldom.AddProblem(stg,mat);
                }
                else if (s == 2){
                    io.write("Problemas disponibles: \n");
                    for(String elem : ctrldom.getProblemas()){
                        System.out.println(elem);
                    }
                }
                else if (s == 3){

                }

            }
            else if(s==3){
                io.write("Opcions: \n 1.Crear domini.Partida \n 2.Jugar Parttida ");
                s = io.readint();
                if(s==1){
                    int a, b,c = -1;
                    io.write("Seleciona usuaris: \n");
                    for(int i=0; i<ctrldom.getUsuaris().size(); ++i){
                        System.out.print(i+1);
                        System.out.print(".");
                        System.out.println(ctrldom.getUsuaris().get(i));
                    }

                    io.write("domini.Usuari atacant:");
                    a = io.readint();
                    io.write("domini.Usuari defensor:");
                    b = io.readint();
                    if (a <= ctrldom.getUsuaris().size()+1 || a > 0) {
                        String atc = ctrldom.getUsuaris().get(a-1);
                        String def = ctrldom.getUsuaris().get(b-1);
                        io.write("Selecciona problema: \n");

                        for(int i=0; i<ctrldom.getProblemas().size(); ++i){
                            System.out.print(i+1);
                            System.out.print(".");
                            System.out.println(ctrldom.getProblemas().get(i));
                        }
                        c = io.readint();
                        if(c <= ctrldom.getProblemas().size()+1 || c > 0){
                            String pro= ctrldom.getProblemas().get(c-1);

                            ctrldom.crearPartida(atc,def,pro);

                            //domini.Tauler t= ctrldom.getTauler(pro);

                            //pintarTauler(t);

                            //s = io.readint();
                        }
                    }
                    else {
                        // TODO
                    }

                }
                else if(s==2) {
                    int a = -1;
                    io.write("Seleciona partida: \n");
                    for (int i = 0; i < ctrldom.getPartidas().size(); ++i) {
                        System.out.print(i + 1);
                        System.out.print(".");
                        System.out.println(ctrldom.getPartidas().get(i));
                    }
                    a = io.readint();
                    Timestamp fecha = ctrldom.getPartidas().get(a - 1);

                    Partida joc = ctrldom.getPartida(fecha);


                    //Aqui juga domini.Huma vs domini.Maquina.
                    if (joc.getD().getNom().equals("M1")) {

                        pintarTauler(joc.getT());
                        int ss = -1;
                        io.write("Opcions: \n 1.Moure peça \n 2.Exit \n");
                        ss = io.readint();
                        int count = 1;
                        System.out.println(joc.te_solucio());
                        while (ss != 2) {
                            if (count % 2 != 0) {
                                io.write("Posicio de la peça a moure:  \n");
                                io.write("X: \n");
                                int posicio_x = io.readint();
                                io.write("Y: \n");
                                int posicio_y = io.readint();

                                io.write("Posicio desti: \n");
                                io.write("X: \n");
                                int newposicio_x = io.readint();
                                io.write("Y: \n");
                                int newposicio_y = io.readint();

                                if (joc.mourePeca(posicio_x, posicio_y, newposicio_x, newposicio_y)) {
                                    pintarTauler(joc.getT());
                                } else {
                                    System.out.println("Error al moure");
                                }
                                count++;
                            } else {
                                System.out.println("Turn de la maquina \n");
                                //pintarTauler(joc.getT());
                                Jugada j = joc.moureMaquina(joc.getP().getN());
                                if (j != null) {
                                    joc.mourePeca(j.getPeca().getX(), j.getPeca().getY(), j.getPos_fin_x(), j.getPos_fin_y());
                                } else {
                                    System.out.println("No hi ha possibles jugades");
                                }
                                pintarTauler(joc.getT());
                                ++count;
                                io.write("Opcions: \n 1.Moure peça \n 2.Exit \n");
                                ss = io.readint();
                            }
                        }
                    }
                    //Aqui juga HUMA CONTRA HUMA
                    else {
                        pintarTauler(joc.getT());
                        int jj = -1;
                        io.write("Opcions: \n 1.Moure peça \n 2.Exit \n");
                        jj = io.readint();
                        while (jj != 2) {
                            io.write("Posicio de la peça a moure:  \n");
                            io.write("X: \n");
                            int posicio_x = io.readint();
                            io.write("Y: \n");
                            int posicio_y = io.readint();

                            io.write("Posicio desti: \n");
                            io.write("X: \n");
                            int newposicio_x = io.readint();
                            io.write("Y: \n");
                            int newposicio_y = io.readint();

                            if (joc.mourePeca(posicio_x, posicio_y, newposicio_x, newposicio_y)) {
                                pintarTauler(joc.getT());
                            } else {
                                System.out.println("Error al moure");
                                pintarTauler(joc.getT());
                            }

                            io.write("Opcions: \n 1.Moure peça \n 2.Exit \n");
                            jj = io.readint();
                        }

                    }

                }

                else if(s==3);

            }


        }


    }

}