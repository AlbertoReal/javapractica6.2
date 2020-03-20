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
 * @
 */
public abstract class Apuesta {
    private String nombre;
    private String apellidos;
    private int numeroDeApuestas;
    private ArrayList <Apuesta> apuestas;

    public Apuesta() {
        this.apuestas = new ArrayList<Apuesta>();
    }
    public Apuesta(String nombre, String apellidos, int numeroDeApuestas) {
        this.apuestas = new ArrayList<Apuesta>();
        this.setNombre(nombre);
        this.setApellidos(apellidos);
        this.setNumeroDeApuestas(numeroDeApuestas);
    }
    
    public Apuesta (Apuesta t1){
        this.apuestas = new ArrayList<Apuesta>();
        this.setNombre(t1.getNombre());
        this.setApellidos(t1.getApellidos());
        this.setNumeroDeApuestas(t1.getNumeroDeApuestas());
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumeroDeApuestas() {
        return numeroDeApuestas;
    }

    public void setNumeroDeApuestas(int numeroDeApuestas) {
        this.numeroDeApuestas = numeroDeApuestas;
    }

    public ArrayList<Apuesta> getApuestas() {
        return apuestas;
    }

    public void setApuestas(ArrayList<Apuesta> apuestas) {
        this.apuestas = apuestas;
    }
    
    public void añadirArray(Apuesta boletos){
        apuestas.add(boletos);
    }
    
    public boolean comprovarMayusculas(String datos){
        boolean salida = true;
        try{
        if (datos.equals(datos.toLowerCase())){
            throw new miExcepcion();
        }
        }catch(miExcepcion es){
           SimulacionLoteria s1 = new SimulacionLoteria();
           s1.mostrarMenu();
        }return salida;
    }

    
    public void mostrarApuesta(){
        System.out.println("mombre: " +this.getNombre());
        System.out.println("apellidos: " +this.getApellidos());
        System.out.println("numero de apuestas: " +this.getNumeroDeApuestas());
    }
    public void crearApuesta(){
        Scanner entrada = new Scanner(System.in);
        System.out.println("nombre:\n");
        String nombreMay = entrada.nextLine();
        if (comprovarMayusculas(nombreMay)==true){
            this.setNombre(nombreMay);
        }
        System.out.println("apellidos \n");
        String apellido = entrada.nextLine();
        if (comprovarMayusculas(apellido)==true){
            this.setApellidos(apellido);
        }
        System.out.println("apuestas a realizar");
        this.setNumeroDeApuestas(entrada.nextInt());
    }
    public abstract void apuestaAleatoria ();
}
