/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Calificacion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
        
        var calificacionBuscando = this.buscarPorNombreAsignatura(calificacion.getGrupo());
        
        if(calificacionBuscando==null){
            this.calificacionList.add(calificacion);
        }
        else{
            throw new RuntimeException("El Grupo ingresada ya se encuentra "+
                    "asignado a la Asignatura: "+ calificacionBuscando.getAsignatura()); 
        }try{
            this.almacenarEnArchivo(calificacion,"C:/Capeta_04_02/archivoCalificacion.dat"); 
        }catch(Exception ex){
            throw new RuntimeException("No se puede almacenar en archivo"+ex.getMessage()); 
        }
        return calificacion; 
    }

    @Override
    public Calificacion buscarPorNombreAsignatura(int grupo) {
        Calificacion calificacion = null; 
        for(var w:this.calificacionList){
            if(grupo == w.getGrupo()){
                calificacion =w; 
                break;
            }
        }
        return calificacion; 
    }
    
    @Override
    public List<Calificacion> listar() {
        return this.calificacionList; 
    }

    @Override
    public boolean almacenarEnArchivo(Calificacion calificacion, String rutaArchivo) throws Exception {
        var retorno = false; 
        DataOutputStream salida = null; 
        try{
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo,true)); 
            salida.writeUTF(calificacion.getNivel());
            salida.writeUTF(calificacion.getAsignatura());
            salida.writeInt(calificacion.getGrupo());
            salida.writeInt(calificacion.getCalificacionFinal());
            salida.writeUTF(calificacion.getEstadoAsignatura());
            retorno = true; 
        }catch(IOException e){
            salida.close();
        }
        return retorno; 
    }

    @Override
    public List<Calificacion> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var calificacionList = new ArrayList<Calificacion>(); 
        DataInputStream entrada = null; 
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo)); 
            while(true){
                var nivel = entrada.readUTF(); 
                var asignatura = entrada.readUTF(); 
                var grupo = entrada.readInt(); 
                var calificacionFinal = entrada.readInt(); 
                var estadoAsignatura = entrada.readUTF(); 
                var calificacion = new Calificacion(nivel, asignatura, grupo, calificacionFinal, estadoAsignatura); 
                calificacionList.add(calificacion); 
            }
        }catch(IOException e){
            entrada.close();
        }
        return CalificacionServicio.calificacionList; 
    }


}
