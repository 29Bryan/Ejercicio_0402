/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Asignatura;
import java.util.List;

/**
 *
 * @author PCG
 */
public interface IAsignaturaServicio {
    public Asignatura crear(Asignatura asignatura); 
    public Asignatura modificar(String codigo, Asignatura asignaturaNueva); 
    public Asignatura eliminar(String codigo); 
    public Asignatura buscarPorCodigoAsignatura(String codigo); 
    public int buscarPosicion(Asignatura asignatura); 
    public List<Asignatura>listar();
    public boolean almacenarEnArchivo(Asignatura asignatura, String rutaArchivo) throws Exception;
    public List<Asignatura> recuperarDeArchivo(String rutaArchivo) throws Exception;
}
