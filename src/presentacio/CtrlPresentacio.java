package presentacio;

import javax.swing.*;
import domini.Ctrl_Domini;
import persistencia.ControladorPersistencia;

import java.sql.Timestamp;
import java.util.*;

public class CtrlPresentacio {

    private static CtrlPresentacio pr;

    private  static Ctrl_Domini ctrldom = new Ctrl_Domini();

    public CtrlPresentacio(){}

    public static CtrlPresentacio getInstance(){
        if(pr==null) pr= new CtrlPresentacio();
            return pr;
    }

    public boolean afegirUsuari(String nom){
        return ctrldom.AddHuma(nom,true);

    }

    public boolean jugarMVM(String Atacant, String Defensor, String Fen) {

        return ctrldom.jugarMVM(Atacant,Defensor,Fen);

    }

    public ArrayList<String> consultar_usuaris(){
        ArrayList<String> llistaUsuaris = ctrldom.getUsuaris();
        return llistaUsuaris;
    }
    public boolean afegirProblema(String problema, int mat ){
        return ctrldom.AddProblem(problema,mat,false);
    }
    public ArrayList<String> consultar_Problemas(){
        ArrayList<String> llistaProblemas = ctrldom.getProblemas();
        return llistaProblemas;
    }

    public void crearPartida(String atac, String def, String problem){

        ctrldom.crearPartida(atac,def,problem);
    }
    public ArrayList<Timestamp> consultar_Partidas(){
        ArrayList<Timestamp> llistaPartides = ctrldom.getPartidas();
        return llistaPartides;
    }
    public ArrayList<Integer> get_pecas(){
        // 0 1 2 3 4 5 peces blancas: peon alfil cavall torre reina rey
        // 6 7 8 9 10 11 peces negres: peon alfil cavall torre reina rey
        return ctrldom.getPecas();
    }

    public void delProblema(String FEN) {
        ctrldom.delProblema(FEN);
    }

    public boolean addTaulell(ArrayList<Integer> peces, int n) {
        return ctrldom.addTaulell(peces,n);
    }

    public boolean mourePeca(int xO,int yO, int xD, int yD){
        return ctrldom.mourePeca(xO,yO, xD, yD);
    }

    public void selecionar_Partida(Timestamp fecha){
        ctrldom.selecionar_Partida(fecha);
    }
    public ArrayList<Integer> PosiblesMoviments(int x, int y){
        return ctrldom.PosiblesMoviments(x,y);
    }

    //cargar
    public boolean CarregarProblemas() throws Exception{
        return ctrldom.CarregarProblemas();
    }
    public boolean CarregarUsuaris() throws Exception{
        return ctrldom.CarregarUsuaris();
    }

    public int getMov() {
        return ctrldom.getMov();
    }

    public ArrayList<Integer> turnMaquina(int i){
        return ctrldom.moureMaquina(i);

    }
    public String getDefensor(){
        return ctrldom.getDefensor();
    }
    public String getAtacant(){
        return ctrldom.getAtacant();
    }
    public int getN(){
        return ctrldom.getN();

    }

    public String getFen() {
        return ctrldom.getFen();
    }

    public boolean getTorn() {
        return ctrldom.getTorn();
    }

    public void setTorn(boolean torn) {
        ctrldom.setTorn(torn);
    }

    public void setMov(int mov) {
        ctrldom.setMov(mov);
    }

    public void setTemps(float temps) { ctrldom.setTemps(temps);}

    public float getTemps() { return ctrldom.getTemps();}

    public void delUsuari(String nom) {
        ctrldom.delUsuari(nom);
    }

    public void deleteParidaActual(){
        ctrldom.deletePartidaActual();
    }
    public ArrayList<Integer> mostrarTaulell(String FEN){
        return ctrldom.mostrarTaulell(FEN);
    }

    public ArrayList<String> getUsersRanking(){
        return ctrldom.getUsersRanking();
    }
    public ArrayList<String> getFensRanking(){
        return ctrldom.getFensRaning();
    }

    public ArrayList<Float> getSegons(){
        return ctrldom.getSegons();
    }


    public void addtoranking(String fen,String atacant, float temps){
        ctrldom.addtoranking(fen, atacant, temps);
    }

    public void deletePartida(Timestamp fecha) {
        ctrldom.deletePartida(fecha);
    }

    public static void main(String[] args){

            frame main = frame.getInstance();
            ctrldom.crearMaquina();
            main.setContentPane(new GUIMain().getMyGUIMain());
            main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            main.setBounds(300, 200, 700, 400);

            main.setVisible(true);

            CtrlPresentacio ctrl = CtrlPresentacio.getInstance();
            try{
                ctrl.CarregarProblemas();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            try{
                ctrl.CarregarUsuaris();
            }
            catch (Exception e){
                e.printStackTrace();
            }
    }

}
