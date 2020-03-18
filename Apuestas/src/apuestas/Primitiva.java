/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package apuestas;

import java.util.Random;
import java.util.Scanner;

/**
 * 
 * @
 */
public class Primitiva  extends Apuesta {
    private String quiniela;
    private int listaNumeros[][];
    private int aciertos;
    public Primitiva() {
    }


    public Primitiva(int[][] listaNumeros, int aciertos, String nombre, String apellidos, int numeroDeApuestas, String quiniela ) {
        super(nombre, apellidos, numeroDeApuestas);
        this.setListaNumeros(listaNumeros);
        this.setAciertos(aciertos);
        this.setQuiniela(quiniela);
    }
    public Primitiva (Primitiva t1){
        super((Apuesta)t1);
        this.setAciertos(t1.getAciertos());
        this.setListaNumeros(t1.getListaNumeros());
        this.setQuiniela(t1.getQuiniela());
    }

    public String getQuiniela() {
        return quiniela;
    }

    public void setQuiniela(String quiniela) {
        this.quiniela = quiniela;
    }
    
    public int[][] getListaNumeros() {
        return listaNumeros;
    }

    public void setListaNumeros(int[][] listaNumeros) {
        this.listaNumeros = listaNumeros;
    }
    
    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }
    
    @Override
    public void mostrarApuesta(){
        super.mostrarApuesta();
        for(int i = 0;i<listaNumeros.length; i++){
            for (int j =0; j<6;j++){
                System.out.print(listaNumeros[i][j]);
            }System.out.println("siguiente apuesta");
        }
    }
    @Override
    public void crearApuesta(){
        Scanner entrada = new Scanner(System.in);
        super.crearApuesta();
        int apuestasTotales = super.getNumeroDeApuestas();
        int primitiva [][]= new int [apuestasTotales][6];
        for(int i = 0;i<apuestasTotales; i++){
            for (int j =0;j<6;j++){
                System.out.println("apuesta");
                primitiva[i][j]=entrada.nextInt();
            }System.out.println("sihuiente primitiva\n");
        }this.setListaNumeros(primitiva);
    }
    
    public void comprovarGanador (){
       int [][] salida = this.getListaNumeros();
       for (int i = 0;i<salida.length; i++){
           for(int j = 0; j<6; j++){
               System.out.println(salida[i][j]);
           }System.out.println("siguiente");
       }
    }
     private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min)+1)+min;
	}
     
    public void apuestaAleatoria(){
        System.out.println("numero de simulacion de primitivas");
            Scanner entrada=new Scanner(System.in);
            int tope = entrada.nextInt();
            int primitiva [][]= new int [tope][6];
            for (int j = 0; j<tope;j++){
      		for (int i = 0; i < 6; i++) {
                        primitiva[j][i]=getRandomNumberInRange(1,49);
		}
            }this.setListaNumeros(primitiva);
    }
}
