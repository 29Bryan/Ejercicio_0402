/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Asignatura;
import Modelo.Estudiante;
import Servicio.AsignaturaServicio;
import Servicio.EstudianteServicio;
import java.util.List;

/**
 *
 * @author PCG
 */
public class AsignaturaControl {
    private final AsignaturaServicio asignaturaServicio = new AsignaturaServicio(); 
    private final EstudianteServicio estudianteServicio = new EstudianteServicio(); 
    
    public Asignatura crear(String [] args){
        Estudiante estudiante = this.estudianteServicio.buscarPorNumeroCedula(Integer.valueOf(args[5]));
        Asignatura asignatura = new Asignatura(args[0], args[1], args[2], args[3], Integer.valueOf(args[4]), estudiante); 
        this.asignaturaServicio.crear(asignatura); 
        return asignatura; 
    }
    
    public Asignatura buscarAsignatura(String arg){
        return this.asignaturaServicio.buscarPorCodigoAsignatura(arg); 
    }
    
    public Asignatura elminar(String arg){
        return this.asignaturaServicio.eliminar(arg);
    }
    
    public Asignatura modificar (String [] args){
        Estudiante estudiante = this.estudianteServicio.buscarPorNumeroCedula(Integer.valueOf(args[5])); 
        Asignatura asignaturaNueva = new Asignatura(args[0], args[1], args[2], args[3], Integer.valueOf(args[4]), estudiante);
        this.asignaturaServicio.modificar(args[1], asignaturaNueva);
        return asignaturaNueva;
    }
    
    public List<Asignatura>listar(){
        return this.asignaturaServicio.listar(); 
    }
}
