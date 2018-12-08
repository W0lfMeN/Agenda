/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos
 */
// 3. Crea la clase Contacto con sus atributos correspondientes
public class Contacto {
    private static final String PATRON_TELEFONO="[69][0-9]{8}"; //definimos el patron del telefono
    private static final String PATRON_CORREO="^[a-zA-Z0-9]*+@+[a-zA-Z]*+.+[a-z]";
    private String nombre;
    private String telefono;
    private String correo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (this.nombre== null){
            throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío");
        }
        else{
            this.nombre = nombre;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
       if(telefono !=null){
           if(Pattern.matches(PATRON_TELEFONO, telefono)){
               this.telefono=telefono;
           }else{
               throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
           }
       }else{
           throw new IllegalArgumentException("El teléfono no tiene un formato válido.");
       }
 
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo !=null){
            if(Pattern.matches(PATRON_CORREO, correo)){
                this.correo = correo;
            }else{
                throw new IllegalArgumentException("El correo no tiene un formato válido.");
            }
        }else{
          throw new IllegalArgumentException("El correo no tiene un formato válido.");  
        }
    }
}
