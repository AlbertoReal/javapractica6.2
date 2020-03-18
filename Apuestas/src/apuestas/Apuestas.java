/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apuestas;

/**
 *
 * @
 */
public class Apuestas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        Primitiva p1  = new Primitiva();
        //p1.setListaNumeros(cargaBilletes);
        p1.crearApuesta();
        p1.añadirArray(p1);
        p1.getApuestas().get(0).mostrarApuesta();
 
        SimulacionLoteria p3 = new SimulacionLoteria();
        p3.simularPrimitiva();
        p1.comprovarGanador(p3);
        p3.simularQuiniela();
       */ 
       SimulacionLoteria p1 = new SimulacionLoteria();
        p1.mostrarMenu();
    }
}
