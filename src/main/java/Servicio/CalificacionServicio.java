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
        
        var calificacionBuscando = this.buscarPorNombreAsignatura(calificacion.getGrupo());
        
        if(calificacionBuscando==null){
            this.calificacionList.add(calificacion);
        }
        else{
            throw new RuntimeException("El Grupo ingresada ya se encuentra "+
                    "asignado a la Asignatura: "+ calificacionBuscando.getAsignatura()); 
        }
//        else{
//                throw new RuntimeException("Solo se acepta valores enteros en Grupo "+calificacionBuscando.getGrupo()); 
//        } 
        return calificacion; 
    }

    @Override
    public Calificacion buscarPorNombreAsignatura(int grupo) {
        Calificacion calificacion = null; 
        for(var w:this.calificacionList){
            if(grupo == w.getGrupo()){
                calificacion =w; 
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
