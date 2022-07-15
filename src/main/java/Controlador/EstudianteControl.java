/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Estudiante;
import Servicio.EstudianteServicio;
import java.util.List;

/**
 *
 * @author PCG
 */
public class EstudianteControl {
    private final EstudianteServicio estudianteServicio = new EstudianteServicio();
    
    public Estudiante crear(String [] args)throws RuntimeException{
        var estudiante=new Estudiante(args[0],convertirEntero(args[1]),convertirEntero(args[2]),args[3],args[4]);
        this.estudianteServicio.crear(estudiante);
        return estudiante;
    }
    
    public List<Estudiante>listar(){
        return this.estudianteServicio.listar(); 
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
