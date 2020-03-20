/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apuestas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Alumnat
 */
public class SimulacionLoteria {

    private int numeroSimulaciones;
    public ArrayList<Apuesta> apuestasHumanas = new ArrayList<>();
    public ArrayList<Apuesta> apuestasAleatorias = new ArrayList<>();

    public SimulacionLoteria() {
    }

    public SimulacionLoteria(int numeroSimulaciones) {
        this.setNumeroSimulaciones(numeroSimulaciones);
    }

    public ArrayList<Apuesta> getApuestasHumanas() {
        return apuestasHumanas;
    }

    public void setApuestasHumanas(ArrayList<Apuesta> apuestasHumanas) {
        this.apuestasHumanas = apuestasHumanas;
    }

    public ArrayList<Apuesta> getApuestasAleatorias() {
        return apuestasAleatorias;
    }

    public void setApuestasAleatorias(ArrayList<Apuesta> apuestasAleatorias) {
        this.apuestasAleatorias = apuestasAleatorias;
    }
    
    public int getNumeroSimulaciones() {
        return numeroSimulaciones;
    }

    public void setNumeroSimulaciones(int numeroSimulaciones) {
        this.numeroSimulaciones = numeroSimulaciones;
    }

    public void mostrarMenu() {
        Scanner entrada = new Scanner(System.in);
        Primitiva p1 = new Primitiva();
        Quiniela q1 = new Quiniela();
        System.out.println("introduce:\n"
                + "1 para crear primnitiva\n"
                + "2 para crear quiniela\n"
                + "3 para simular apuestas\n"
                + "4 salir");
        int menu = entrada.nextInt();
        switch (menu) {
            case 1: {
                p1.crearApuesta();
                apuestasHumanas.add(p1);
                mostrarMenu();
                break;
            }
            case 2: {
                q1.crearApuesta();
                apuestasHumanas.add(q1);
                mostrarMenu();
                break;
            }
            case 3: {
                System.out.println("primitivas a simular;");
                p1.apuestaAleatoria();
                apuestasAleatorias.add(p1);
                System.out.println("quinielas a simular;");
                q1.apuestaAleatoria();
                apuestasAleatorias.add(q1);
                ganadorPrimitiva();
                ganadorQuiniela();
                mostrarMenu();
                break;
            }
            case 4: {
                break;
            }
        }
    }

    public void ganadorPrimitiva() {
        for (int i = 0; i < apuestasHumanas.size(); i++) {
            if (apuestasHumanas.get(i) instanceof Primitiva) {
                for (int j = 0; j < apuestasAleatorias.size(); j++) {
                    if (apuestasAleatorias.get(j) instanceof Primitiva) {
                        Apuesta Humana = apuestasHumanas.get(i);
                        Apuesta Aleatoria = apuestasAleatorias.get(j);
                        int[][] humana = ((Primitiva) Humana).getListaNumeros();
                        int[][] aleatoria = ((Primitiva) Aleatoria).getListaNumeros();
                        for (int k = 0; k < humana.length; k++) {
                            int[] apuestaHumana = humana[k];
                            Arrays.sort(apuestaHumana);
                            for (int l = 0; l < aleatoria.length; l++) {
                                int[] apuestaAleatoria = aleatoria[l];
                                Arrays.sort(apuestaAleatoria);
                                if (Arrays.equals(apuestaHumana, apuestaAleatoria)) {
                                    System.out.println("suerte");
                                    Humana.mostrarApuesta(); 
                                }
                            }

                        }
                    }
                }
            }
        }
    }
        public void ganadorQuiniela() {
        for (int i = 0; i < apuestasHumanas.size(); i++) {
            if (apuestasHumanas.get(i) instanceof Quiniela) {
                for (int j = 0; j < apuestasAleatorias.size(); j++) {
                    if (apuestasAleatorias.get(j) instanceof Quiniela) {
                        Apuesta Humana = apuestasHumanas.get(i);
                        Apuesta Aleatoria = apuestasAleatorias.get(j);
                        int[][] humana = ((Quiniela) Humana).getListanumeros();
                        int[][] aleatoria = ((Quiniela) Aleatoria).getListanumeros();
                        for (int k = 0; k < humana.length; k++) {
                            int[] apuestaHumana = humana[k];
                            for (int l = 0; l < aleatoria.length; l++) {
                                int[] apuestaAleatoria = aleatoria[l];
                                if (Arrays.equals(apuestaHumana, apuestaAleatoria)) {
                                    System.out.println("suerte quiniela");
                                    Humana.mostrarApuesta();
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
