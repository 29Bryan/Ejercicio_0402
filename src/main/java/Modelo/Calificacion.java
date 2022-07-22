/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author PCG
 */
public class Calificacion implements Serializable{
    private String nivel; 
    private String asignatura; 
    private int grupo; 
    private int calificacionFinal; 
    private String estadoAsignatura; 

    public Calificacion(String nivel, String asignatura, int grupo, int calificacionFinal, String estadoAsignatura) {
        this.nivel = nivel;
        this.asignatura = asignatura;
        this.grupo = grupo;
        this.calificacionFinal = calificacionFinal;
        this.estadoAsignatura = estadoAsignatura;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public int getCalificacionFinal() {
        return calificacionFinal;
    }

    public void setCalificacionFinal(int calificacionFinal) {
        this.calificacionFinal = calificacionFinal;
    }

    public String getEstadoAsignatura() {
        return estadoAsignatura;
    }

    public void setEstadoAsignatura(String estadoAsignatura) {
        this.estadoAsignatura = estadoAsignatura;
    }

    @Override
    public String toString() {
        return "Calificacion{" + "nivel=" + nivel + ", asignatura=" + 
                             asignatura + ", grupo=" + grupo + 
                             ", calificacionFinal=" + calificacionFinal + 
                             ", estadoAsignatura=" + estadoAsignatura + '}';
    }
}
