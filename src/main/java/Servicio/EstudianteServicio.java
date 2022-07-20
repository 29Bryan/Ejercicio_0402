/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Estudiante;
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
        }try{
            this.almacenarEnArchivo(estudiante,"C:/Capeta_04_02/archivoEstudiante.dat"); 
        }catch(Exception ex){
            throw new RuntimeException("No se puede almacenar en archivo"+ex.getMessage()); 
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

    @Override
    public boolean almacenarEnArchivo(Estudiante estudiante, String rutaArchivo) throws Exception {
        var retorno = false; 
        DataOutputStream salida = null; 
        try{
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo,true)); 
            salida.writeUTF(estudiante.getNombre());
            salida.writeInt(estudiante.getEdad());
            salida.writeInt(estudiante.getNumeroCedula());
            salida.writeUTF(estudiante.getGrado());
            salida.writeUTF(estudiante.getLugarNacimiento());
            retorno = true; 
        }catch(IOException e){
            salida.close();
        }
        return retorno; 
    }

    @Override
    public List<Estudiante> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var estudianteList = new ArrayList<Estudiante>(); 
        DataInputStream entrada = null; 
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo)); 
            while(true){
                var nombre = entrada.readUTF(); 
                var edad = entrada.readInt(); 
                var numeroCedula = entrada.readInt(); 
                var grado = entrada.readUTF(); 
                var lugarNacimiento = entrada.readUTF(); 
                var estudiante = new Estudiante(nombre, edad, numeroCedula, grado, lugarNacimiento); 
                estudianteList.add(estudiante); 
            }
        }catch(IOException e){
            entrada.close();
        }
        return EstudianteServicio.estudianteList; 
    }
}
