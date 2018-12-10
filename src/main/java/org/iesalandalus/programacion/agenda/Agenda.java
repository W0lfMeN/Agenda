/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;


/**
 *
 * @author Carlos
 */
//Crea la clase Agenda con sus atributos
public class Agenda {    
    private static final int MAX_CONTACTOS=100;
    private int numContactos;
    private Contacto [] contacto=null;
    
    
    public Agenda (int numContactos){
        if (numContactos>0){
            this.numContactos=numContactos;
        }else{
            throw new IllegalArgumentException("Se ha introducido un numero no válido");
        }
    }

    public int getNumContactos() {
        return numContactos;
    }

    public Contacto [] getContacto() {
        return contacto;
    }
}

