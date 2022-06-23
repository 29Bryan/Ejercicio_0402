/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VistaCalificacion;

import Modelo.Calificacion;
import Servicio.CalificacionServicio;
import java.util.List;

/**
 *
 * @author PCG
 */
class CalificacionControl {
    private final CalificacionServicio calificacionServicio = new CalificacionServicio();
    
    public Calificacion crear(String [] args){
        var calificacion = new Calificacion(args[0], args[1], Integer.valueOf(args[2]),Integer.valueOf(args[3]), args[4]);
        this.calificacionServicio.crear(calificacion); 
        return calificacion; 
    }
    
    public List<Calificacion>listar(){
        return this.calificacionServicio.listar(); 
    }
}
