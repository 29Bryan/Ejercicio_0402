/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Calificacion;
import java.util.List;

/**
 *
 * @author PCG
 */
public interface ICalifiacionServicio {
    public Calificacion crear (Calificacion calificacion);
    public Calificacion buscarPorNombreAsignatura(int grupo); 
    public List<Calificacion>listar(); 
            
            
}
