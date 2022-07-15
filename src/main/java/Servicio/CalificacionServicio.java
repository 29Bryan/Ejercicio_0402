/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Calificacion;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCG
 */
public class CalificacionServicio implements ICalifiacionServicio{
    private static List<Calificacion> calificacionList = new ArrayList<>();

    @Override
    public Calificacion crear(Calificacion calificacion) {
        
        var calificacionBuscando = this.buscarPorNombreAsignatura(calificacion.getAsignatura());
        
        if(calificacionBuscando==null){
            this.calificacionList.add(calificacion);
        }else{
            throw new RuntimeException("La Asigntarura ingresada ya se encuentra "+
                    "asignado a la Calificacion: "+ calificacionBuscando.getAsignatura()); 
        } 
        return calificacion; 
    }

    @Override
    public Calificacion buscarPorNombreAsignatura(String asignatura) {
        Calificacion calificacion = null; 
        for(var x:this.calificacionList){
            if(calificacion.equals(x.getAsignatura())){
                calificacion = x; 
                break;
            }
        }
        return calificacion; 
    }
    
    @Override
    public List<Calificacion> listar() {
        return this.calificacionList; 
    }


}
