/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.ejercicio_03_04;

import Vista.CreateAsignatura;
import Vista.CreateEstudiante;

/**
 *
 * @author PCG
 */
public class Ejercicio_03_04 {

    public static void main(String[] args) {
        var v1 = new CreateEstudiante();
        var v2 = new CreateAsignatura();
        
        v1.setVisible(true);
        v2.setVisible(true);
    }
}
