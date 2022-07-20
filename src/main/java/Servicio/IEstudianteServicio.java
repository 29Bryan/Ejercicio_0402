/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Servicio;

import Modelo.Estudiante;
import java.util.List;

/**
 *
 * @author PCG
 */
public interface IEstudianteServicio {
    public Estudiante crear(Estudiante estudiante); 
    public Estudiante buscarPorNumeroCedula(int numeroCedula); 
    public List<Estudiante>listar(); 
    public boolean almacenarEnArchivo(Estudiante estudiante, String rutaArchivo) throws Exception;
    public List<Estudiante> recuperarDeArchivo(String rutaArchivo) throws Exception;
    
}
