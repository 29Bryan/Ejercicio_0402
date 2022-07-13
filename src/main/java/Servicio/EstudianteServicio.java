/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCG
 */
public class EstudianteServicio implements IEstudianteServicio{
    
    private static List<Estudiante> estudianteList = new ArrayList<>(); 

    @Override
    public Estudiante crear(Estudiante estudiante) {
        var estudianteBuscado = this.buscarPorNumeroCedula(estudiante.getNumeroCedula()); 
        if(estudianteBuscado==null){
            this.estudianteList.add(estudiante);
        }else{
            throw new RuntimeException("La Cedula ingresada ya se encuentra "
                    +"asignado el Estudiante: "+ estudianteBuscado.getNombre()); 
        }
        return estudiante;
    }

    @Override
    public Estudiante buscarPorNumeroCedula(int numeroCedula) {
        Estudiante estudiante=null;
        for(var c:this.estudianteList){
            if(numeroCedula==c.getNumeroCedula()){
                estudiante=c;
                break;
            }
        }
        return estudiante;
    }

    @Override
    public List<Estudiante> listar() {
        return this.estudianteList; 
    }
}
