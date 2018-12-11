/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;
import javax.naming.OperationNotSupportedException;


/**
 *
 * @author Carlos
 */
//Crea la clase Agenda con sus atributos
public class Agenda {    
    private static final int MAX_CONTACTOS=5;
    private int numContactos=0;
    private Contacto [] contactos=null;
    
    //crea el constructor y los metodos metodos get que se especifican
    public Agenda (int numContactos){
        if (numContactos>0){
            this.numContactos=numContactos;
        }else{
            throw new IllegalArgumentException("Se ha introducido un numero no válido");
        }
    }
    
    public void aniadir (Contacto contacto) throws OperationNotSupportedException{ //lo cambio a aniadir para el test
        int indice=0;
        try{
            indice=buscarPrimerIndiceComprobadoExistencia(contacto);
        }catch(OperationNotSupportedException e){
            e.getMessage();
            }
        if (indiceNoSuperaTamano(indice)){
            contactos[indice]=contacto;
        }else{
            throw new OperationNotSupportedException("El array esta lleno");
        }
    }
    
    private int buscarPrimerIndiceComprobadoExistencia (Contacto contacto)throws OperationNotSupportedException {
        int indice=0;
        boolean encontrado=false;
        for(int i=0;i<contactos.length && !encontrado;i++){
            if(contactos[i]==null){
                encontrado=true;
                indice=i;
            }else{
                if(contactos[i].equals(contacto)){
                    throw new OperationNotSupportedException("Ya existe ese contacto");
                }
            }
        }
        return indice;
    }
        
    private boolean indiceNoSuperaTamano(int i){
        if(i>=contactos.length){
            return true;
        }else{
            return false;
        }
    }
    
    public int getNumContactos() {
        return numContactos;
    }

    public Contacto [] getContacto() {
        return contactos;
    }
}

