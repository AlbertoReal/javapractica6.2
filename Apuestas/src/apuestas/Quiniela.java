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
 * @author Alberto Real
 */
public class Quiniela extends Apuesta {
    private int listanumeros[][];
    private int aciertos;

    public Quiniela() {
    }
    
    
    
    public Quiniela(int[][] listanumeros, int aciertos, String nombre, String apellidos, int numeroDeApuestas) {
        super(nombre, apellidos, numeroDeApuestas);
        this.setListanumeros(listanumeros);
        this.setAciertos(aciertos);
    }
    public Quiniela (Quiniela t1){
        super((Apuesta)t1);
        this.setListanumeros(t1.getListanumeros());
        this.setAciertos(t1.getAciertos());
    }
    
    public int[][] getListanumeros() {
        return listanumeros;
    }

    public void setListanumeros(int[][] listanumeros) {
        this.listanumeros = listanumeros;
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
        System.out.println("aciertos "+this.getAciertos());
        for (int i = 0; i <listanumeros.length;i++){
            for (int j = 0; j<15;j++){
                System.out.print(listanumeros[i][j]+",");
            }System.out.println("siguiente apuesta");
        } 
    }
    @Override
    public void crearApuesta(){
        super.crearApuesta();
        Scanner entrada = new Scanner(System.in);
        int apuestasTotales = super.getNumeroDeApuestas();
        int quiniela [][]= new int [apuestasTotales][15];
        for(int i = 0;i<apuestasTotales; i++){
            for (int j =0;j<15;j++){
                System.out.println("apuesta");
                quiniela[i][j]=entrada.nextInt();
            }System.out.println("siguiente quiniela\n");
        }this.setListanumeros(quiniela);
    }
    public void comprovarApuesta(){
        
    }

   private static int getRandomNumberInRange(int min, int max) {
		if (min >= max) {
                throw new IllegalArgumentException("max must be greater than min");
		}
		Random r = new Random();
		return r.nextInt((max - min)+1)+min;
	}
    
        public void apuestaAleatoria(){
            System.out.println("numero de simulacion de quinielas");
            Scanner entrada=new Scanner(System.in);
            int tope = entrada.nextInt();
            int [][] quiniela = new int [3][15];
            for (int j = 0; j<tope;j++){
      		for (int i = 0; i < 15; i++) {
			quiniela [i][j]=getRandomNumberInRange(0,2);
		}
            }this.setListanumeros(quiniela);
	}

    @Override
    public void comprovarGanador() {
         int [][] salida = this.getListanumeros();
       for (int i = 0;i<salida.length; i++){
           for(int j = 0; j<6; j++){
               System.out.println(salida[i][j]);
           }System.out.println("siguiente");
       }
    }
}
