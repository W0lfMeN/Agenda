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
    /*Crea el método anadir para añadir un contacto a la agenda de forma que ésta se quede ordenada
    por orden de inserción y sin que admita contactos repetidos.
    Apóyate en los métodos privados buscarPrimerIndiceComprobandoExistencia e IndiceNoSuperaTamano.
    El método debe informar de todos los posibles errores mediante la excepcion OperationNotSupportedException:
    ya existe ese contacto, el array está lleno, etc*/
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
    
    //Crea el método buscar que recibirá el nombre del contacto y devolverá el contacto.
    //creamos primero el metodo buscarIndiceCliente
    private int buscarIndiceCliente(String cliente){
        int indiceCliente=0;
        Contacto contacto=null;
        for (int i=0;i<contactos.length;i++){
            if (contactos[i]!=null && contacto.getNombre().equals(contacto)){
                return indiceCliente =i;
            }
        }
      return indiceCliente;
    }
    //ahora el metodo buscar
    public Contacto buscar(String contacto){
        //se llama al metodo creado anteriormente
        int indice=buscarIndiceCliente(contacto);
        Contacto encontrado=null;
        if(indice<contactos.length){
            encontrado=contactos[indice];
        }else{
            return null;
        }
        return encontrado;
    }
    
    public int getNumContactos() {
        return numContactos;
    }

    public Contacto [] getContacto() {
        return contactos;
    }
}

