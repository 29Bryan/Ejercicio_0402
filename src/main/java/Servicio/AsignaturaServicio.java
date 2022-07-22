/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Modelo.Asignatura;
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
public class AsignaturaServicio implements IAsignaturaServicio{
    
    private static List<Asignatura> asignaturaList = new ArrayList<>();

    @Override
    public Asignatura crear(Asignatura asignatura) {
        var asignaturaBuscada = this.buscarPorCodigoAsignatura(asignatura.getCodigo()); 
        if(asignaturaBuscada==null){
            this.asignaturaList.add(asignatura); 
        }else{
            throw new RuntimeException("El Codigo ingresado ya se encuentra" 
                                    + "asignado a la Asignatura: "+ asignaturaBuscada.getNombre()); 
        }try{
            this.almacenarEnArchivo(asignatura,"C:/Capeta_04_02/archivoAsignatura.dat"); 
        }catch(Exception ex){
            throw new RuntimeException("No se puede almacenar en archivo"+ex.getMessage()); 
        }
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
            if(codigo.equals(b.getCodigo())){ 
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
            if(b.getCodigo().equals(asignatura.getCodigo())){
                break;
            }
        }
        return posicion; 
    }

    @Override
    public List<Asignatura> listar() {
        return this.asignaturaList;
    }

    @Override
    public boolean almacenarEnArchivo(Asignatura asignatura, String rutaArchivo) throws Exception {
        var retorno = false; 
        DataOutputStream salida = null; 
        try{
            salida = new DataOutputStream(new FileOutputStream(rutaArchivo,true)); 
            salida.writeUTF(asignatura.getNombre());
            salida.writeUTF(asignatura.getCodigo());
            salida.writeUTF(asignatura.getModalidad());
            salida.writeUTF(asignatura.getCostoHora());
            salida.writeInt(asignatura.getNumeroHoras());
            retorno = true; 
        }catch(IOException e){
            salida.close();
        }
        return retorno; 
    }

    @Override
    public List<Asignatura> recuperarDeArchivo(String rutaArchivo) throws Exception {
        var asignaturaList = new ArrayList<Asignatura>(); 
        DataInputStream entrada = null; 
        try{
            entrada = new DataInputStream(new FileInputStream(rutaArchivo)); 
            while(true){
                var nombre = entrada.readUTF(); 
                var codigo = entrada.readUTF(); 
                var modalidad = entrada.readUTF(); 
                var costoHora = entrada.readUTF(); 
                var numeroHoras = entrada.readInt(); 
                var asignatura = new Asignatura(nombre, codigo, modalidad, costoHora, numeroHoras); 
                asignaturaList.add(asignatura); 
            }
        }catch(IOException e){
            entrada.close();
        }
        return AsignaturaServicio.asignaturaList; 
    }
    
}
