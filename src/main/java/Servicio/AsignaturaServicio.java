/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Asignatura;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author PCG
 */
public class AsignaturaServicio implements IAsignaturaServicio{
    
    private static List<Asignatura> asignaturaList = new ArrayList<>();

    @Override
    public Asignatura crear(Asignatura asignatura) {
        this.asignaturaList.add(asignatura); 
        return asignatura; 
    }

    @Override
    public Asignatura modificar(String codigo, Asignatura asignaturaNueva) {
        var posicion=this.buscarPosicion(this.buscarPorCodigoAsignatura(codigo)); 
        this.listar().get(posicion).setNombre(asignaturaNueva.getNombre());
        this.listar().get(posicion).setModalidad(asignaturaNueva.getModalidad());
        this.listar().get(posicion).setCostoHora(asignaturaNueva.getCostoHora());
        this.listar().get(posicion).setNumeroHoras(asignaturaNueva.getNumeroHoras());
        this.listar().get(posicion).setEstudiante(asignaturaNueva.getEstudiante());
        return asignaturaNueva; 
    }

    @Override
    public Asignatura eliminar(String codigo) {
        Asignatura asignatura=this.buscarPorCodigoAsignatura(codigo); 
        var posicion=this.buscarPosicion(asignatura); 
        this.listar().remove(posicion); 
        return asignatura; 
    }

    @Override
    public Asignatura buscarPorCodigoAsignatura(String codigo) {
        Asignatura asignatura=null; 
        for(var b:this.asignaturaList){
            if(codigo==b.getCodigo()){ 
                asignatura=b;
                break;
            } 
        }
        return asignatura; 
    }

    @Override
    public int buscarPosicion(Asignatura asignatura) {
        int posicion=-1; 
        for(var b:this.asignaturaList){
            posicion++; 
            if(b.getCodigo()==asignatura.getCodigo()){
                break;
            }
        }
        return posicion; 
    }

    @Override
    public List<Asignatura> listar() {
        return this.asignaturaList;
    }
    
}
