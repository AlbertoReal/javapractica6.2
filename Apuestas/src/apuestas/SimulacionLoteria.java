/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apuestas;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Alumnat
 */
public class SimulacionLoteria {
    private int numeroSimulaciones=2;
    private int apuestas[][];

    public SimulacionLoteria() {
    }

    public SimulacionLoteria(int numeroSimulaciones, int [][] apuestas) {
        this.setNumeroSimulaciones(numeroSimulaciones);
        this.setApuestas(apuestas);
    }

    public int[][] getApuestas() {
        return apuestas;
    }

    public void setApuestas(int[][] apuestas) {
        this.apuestas = apuestas;
    }
    
    public int getNumeroSimulaciones() {
        return numeroSimulaciones;
    }


    public void setNumeroSimulaciones(int numeroSimulaciones) {
        this.numeroSimulaciones = numeroSimulaciones;
    }

    
    public void mostrarMenu(){
        Scanner entrada = new Scanner(System.in);
        Primitiva p1 = new Primitiva();
        System.out.println("introduce:\n"
                + "1 para crear primnitiva\n"
                + "2 para crear quiniela\n"
                + "3 para simular apuestas\n"
                + "4 salir");
        int menu=entrada.nextInt();        
        switch(menu){
            case 1:{
                p1.crearApuesta();
                p1.añadirArray(p1);
                ArrayList <Apuesta> prueba = p1.getApuestas();
                for (int i = 0; i<prueba.size(); i++){
                    System.out.println(prueba.get(i).getNombre());
                }
                mostrarMenu();
                break;
            }case 2:{
                Quiniela q1 = new Quiniela();
                q1.crearApuesta();
                q1.añadirArray(q1);
                mostrarMenu();
                break;
            }case 3:{
                p1.apuestaAleatoria();
                p1.añadirArray(p1);
                mostrarMenu();
                break;
            }
        }
    }
}
