/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Calificacion;
import Servicio.CalificacionServicio;
import java.util.List;

/**
 *
 * @author PCG
 */
public class CalifiacionControl {
    private final CalificacionServicio calificacionServicio = new CalificacionServicio(); 
    
    public Calificacion crear(String [] args) throws RuntimeException{
        var calificacion = new Calificacion(args[0], args[1], convertirEntero(args[2]), convertirEntero(args[3]), args[4]); 
        this.calificacionServicio.crear(calificacion); 
        return calificacion; 
    }
    
    public List<Calificacion> listar(){
        return this.calificacionServicio.listar(); 
    }
    
    private int convertirEntero(String numero)
    {
        try{
            return Integer.valueOf(numero);
        }catch(NumberFormatException e){
            throw new RuntimeException("Valor ingresado no es un número entero"); 
        }catch(Exception e){
            throw new RuntimeException("Error inesperado"); 
        }
    }
}
