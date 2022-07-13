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
        var estudiante=new Estudiante(args[0],Integer.valueOf(args[1]),Integer.valueOf(args[2]),args[3],args[4]);
        this.estudianteServicio.crear(estudiante);
        return estudiante;
    }
    
    public List<Estudiante>listar(){
        return this.estudianteServicio.listar(); 
    }
}
