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
        
        this.calificacionList.add(calificacion); 
        return calificacion; 
    }

    @Override
    public List<Calificacion> listar() {
        return this.calificacionList; 
    }
}
