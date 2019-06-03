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
    
    //crea el constructor y los metodos metodos get que se especifican (constructor por defecto)
    public Agenda(){
       this.contactos=new Contacto[MAX_CONTACTOS];
       this.numContactos=0;
       
    }
    /*Crea el método anadir para añadir un contacto a la agenda de forma que ésta se quede ordenada
    por orden de inserción y sin que admita contactos repetidos.
    Apóyate en los métodos privados buscarPrimerIndiceComprobandoExistencia e IndiceNoSuperaTamano.
    El método debe informar de todos los posibles errores mediante la excepcion OperationNotSupportedException:
    ya existe ese contacto, el array está lleno, etc*/
    public void anadir (Contacto contacto) throws OperationNotSupportedException{ //lo cambio a aniadir para el test
        if(contacto==null){
            throw new IllegalArgumentException("No se puede añadir un contacto nulo");
        }
        int indice=buscarPrimerIndiceComprobadoExistencia(contacto);
        
        if(indiceNoSuperaTamano(indice)){
            throw new OperationNotSupportedException("El contacto ya existe");
        }else{
            contactos[indice]=contacto;
            
        }
    }
    
    private int buscarPrimerIndiceComprobadoExistencia (Contacto contacto)throws OperationNotSupportedException {
        int indice=-1;
        boolean encontrado=false;
        for(int i=0;i<contactos.length && !encontrado;i++){
            if(contactos[i]==null){
                encontrado=true;
                indice=i;
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
        for (int i=0;i<contactos.length;i++){
            if (contactos[i]!=null && contactos[i].getNombre().equals(cliente)){
                return i;
            }
        }
      return MAX_CONTACTOS;
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
    /*Crea el método borrar que borrará un contacto de la lista dejando la misma compactada
    (los contactos válidos al principio y los nulos al final).
    Apóyate en el método desplazarUnaPosicionHaciaIzquierda.
    El método debe informar de los posibles errores mediante la excepcion OperationNotSupportedException*/
    
    //creamos el metodo borrar
    public void borrar(String contacto)throws OperationNotSupportedException{
        int i=buscarIndiceCliente(contacto);
        if(i==-1){
            throw new OperationNotSupportedException("El contacto a borrar no existe.");
        }else{
            desplazarUnaPosicionHaciaIzquierda(i);
            numContactos--;
        }
    }
    //Ahora el metodo desplazarUnaPosicionHaciaIzquierda
    private void desplazarUnaPosicionHaciaIzquierda(int indice){
        for (int i=indice; i<contactos.length-1 && contactos[i]!=null;i++){
            contactos[i]=contactos[i+1];
        }
    }
    
    public int getNumContactos() {
        numContactos=0;
        for(int i=0;i<contactos.length-1;i++){
            if(contactos[i]!=null){
                numContactos++;
            }
        }
        return numContactos;
    }

    public Contacto [] getContactos() {
        return contactos.clone();
    }

}

