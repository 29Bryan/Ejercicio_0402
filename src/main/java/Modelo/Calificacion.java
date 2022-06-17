/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author PCG
 */
public class Calificacion {
    private int notafinal;
    private int notaObtenida; 
    private int notaMaxima; 
    private int notaMinima; 

    public Calificacion(int notafinal, int notaObtenida, int notaMaxima, int notaMinima) {
        this.notafinal = notafinal;
        this.notaObtenida = notaObtenida;
        this.notaMaxima = notaMaxima;
        this.notaMinima = notaMinima;
    }

    public int getNotafinal() {
        return notafinal;
    }

    public void setNotafinal(int notafinal) {
        this.notafinal = notafinal;
    }

    public int getNotaObtenida() {
        return notaObtenida;
    }

    public void setNotaObtenida(int notaObtenida) {
        this.notaObtenida = notaObtenida;
    }

    public int getNotaMaxima() {
        return notaMaxima;
    }

    public void setNotaMaxima(int notaMaxima) {
        this.notaMaxima = notaMaxima;
    }

    public int getNotaMinima() {
        return notaMinima;
    }

    public void setNotaMinima(int notaMinima) {
        this.notaMinima = notaMinima;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "notafinal=" + notafinal + ", notaObtenida=" + notaObtenida + ", notaMaxima=" + notaMaxima + ", notaMinima=" + notaMinima + '}';
    }

    
}
