/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author PCG
 */
public class Asignatura {
    private String nombre;
    private String codigo;
    private String modalidad; 
    private String costoHora; 
    private int numeroHoras;  
    private Estudiante estudiante; 

    public Asignatura(String nombre, String codigo, String modalidad, String costoHora, int numeroHoras) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modalidad = modalidad;
        this.costoHora = costoHora;
        this.numeroHoras = numeroHoras;
    }

    public Asignatura(String nombre, String codigo, String modalidad, String costoHora, int numeroHoras, Estudiante estudiante) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.modalidad = modalidad;
        this.costoHora = costoHora;
        this.numeroHoras = numeroHoras;
        this.estudiante = estudiante;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getCostoHora() {
        return costoHora;
    }

    public void setCostoHora(String costoHora) {
        this.costoHora = costoHora;
    }

    public int getNumeroHoras() {
        return numeroHoras;
    }

    public void setNumeroHoras(int numeroHoras) {
        this.numeroHoras = numeroHoras;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    @Override
    public String toString() {
        return "Asignatura{" + "nombre=" + nombre + ", codigo=" + codigo + 
                           ", modalidad=" + modalidad + ", costoHora=" + 
                           costoHora + ", numeroHoras=" + numeroHoras + 
                           ", estudiante=" + estudiante.toString() + '}';
    }
}
