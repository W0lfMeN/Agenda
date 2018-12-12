/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iesalandalus.programacion.agenda;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Carlos
 */
// 3. Crea la clase Contacto con sus atributos correspondientes

public class Contacto {
    private static final String ER_TELEFONO="[69][0-9]{8}"; //definimos el patron del telefono
    private static final String ER_CORREO="([a-zA-Z0-9]{1,}@)+[a-zA-Z]{1,}+.+[a-z]{2,3}"; //definimos el patron del correo
    private String nombre;
    private String telefono;
    private String correo;
    private String iniciales;
    
    //Crea el constructor con los parámetros adecuados y que haga el mismo control que en el caso anterior

    /**
     *
     * @param nombre
     * @param telefono
     * @param correo
     */
    public Contacto(String nombre, String telefono, String correo) { //Para este caso basta con llamar al metodo set de cada variable
        setNombre(nombre);
        setCorreo(correo);
        setTelefono(telefono);
    }
    
    
    /*Crea los métodos get y set. 
    Ten en cuenta que el nombre no puede estar vacío
    y que además no podemos modificar el nombre de un contacto ya creado,
    el teléfono debe empezar por 6 o 9 y tener 9 dígitos en total y que el correo debe ser un correo válido.
    Si no se cumple el método set correspondiente deberá lanzar una excepción
    del tipo IllegalArgumentException con el mensaje adecuado.
    Utiliza dos atributos de clase que no se puedan modificar para guardar las expresiones regulares a validar.*/
    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        if(this.nombre !=null){
            throw new IllegalArgumentException(" No se puede cambiar el nombre de un contacto que ya existe");
        }else{
        if (this.nombre ==null || nombre.equals("")){
            throw new IllegalArgumentException("El nombre de un contacto no puede ser nulo o vacío.");
        }
        else{
            this.nombre = nombre;
        }
       }
    }

    private String getIniciales() {
        String []nombreCorto;
        nombreCorto = nombre.split(" ");
        for (int i=0;i<nombreCorto.length;i++){
            String iniciales="";
            iniciales=iniciales+nombreCorto[i].charAt(0);
        }
        return iniciales;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
       if(telefono ==null || telefono.equals("")){
          throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
        
        }else{
           if(Pattern.matches(ER_TELEFONO, telefono)){
               this.telefono=telefono;
           }else{
               throw new IllegalArgumentException("El teléfono de un contacto no puede ser nulo o vacío.");
            }
        }
    }


    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo ==null || correo.equals("")){
           throw new IllegalArgumentException(" El correo de un contacto no puede ser nulo o vacío.");
            }else{
                if(Pattern.matches(ER_CORREO, correo)){
                this.correo = correo;
            }
            else{
                throw new IllegalArgumentException(" El correo no tiene un formato válido.");  
            }
        }
    }
    /*Crea los demás métodos que se muestran en el diagrama de clases,
    teniendo en cuenta que el método toString nos devolverá una cadena
    con las iniciales del nombre y encerrado entre corchetes el teléfono y el correo separados por comas.
    También debes tener en cuenta que un contacto será igual que otro si sus nombres,
    ignorando mayúsculas y minúsculas, son iguales*/

    @Override
    public String toString() {
        return "Contacto{" + "nombre=" + nombre + ", telefono=" + telefono + ", correo=" + correo + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.correo);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        return true;
    }
}
