package org.iesalandalus.programacion.agenda;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {
    private static final String ERROR="Error, intentelo de nuevo";
    private static final String EXITO="Exito en la operación";
    private static Agenda agenda;

	public static void main(String[] args)throws OperationNotSupportedException {
		System.out.println("Programa para gestionar una agenda de contactos");
                int opcion;
                do{
                    mostrarMenu();
                    opcion=elegirOpcion();
                    ejecutarOpcion(opcion);
                }while (opcion!=0);
            System.out.println("Gracias por utilizar el programa");
        }
            //mostramos el menu
            private static void mostrarMenu(){
                System.out.println("Bienvenido al programa agenda");
                System.out.println("");
                System.out.println("");
                System.out.println("Selecciona una opción");
                System.out.println("");
                System.out.println("1. Anadir contacto");
                System.out.println("2. Buscar contacto");
                System.out.println("3. Borrar contacto");
                System.out.println("4. Listar agenda");
                System.out.println("0. SALIR DEL PROGRAMA");
            }
            
            //creamos el metodo elegirOpcion
            private static int elegirOpcion(){
                int opcion;
                do{
                    System.out.println("Introduce un numero del 0 al 4 (ambos inclusive)");
                    opcion=Entrada.entero();
                }while(opcion<0 || opcion>4);
                
                return opcion;
            }
            
            //creamos el metodo ejecutarOpcion
            private static void ejecutarOpcion (int opcion)throws OperationNotSupportedException{
                switch(opcion){
                    
                    case 1:
                        anadirContacto();
                        break;
                    case 2:
                        buscarContacto();
                        break;
                    case 3:
                        borrarContacto();
                        break;
                    case 4:
                        listarAgenda();
                        break;
                }
            }
            
            //creamos el metodo anadirContacto
            private static void anadirContacto()throws OperationNotSupportedException{
                String nombre;
                String correo;
                String telefono;
                agenda=new Agenda();
                
                System.out.println("introduce el nombre ");
                nombre=Entrada.cadena();
                System.out.println("introduce el correo electronico ");
                correo=Entrada.cadena();
                System.out.println("introduce el telefono ");
                telefono=Entrada.cadena();
                
                try{
                    Contacto contacto1=new Contacto(nombre,telefono,correo);
                    agenda.anadir(contacto1);
                    System.out.println(contacto1.toString());
                    System.out.println(EXITO);
                }catch(IllegalArgumentException e){
                    System.out.println("Operacion no soportada"+e.getMessage());
                }
                ejecutarOpcion(elegirOpcion());
            }
            
            //creamos el metodo buscarContacto
            private static void buscarContacto()throws OperationNotSupportedException{
                String nombre;
                System.out.println("Introduce el nombre del contacto a buscar");
                nombre=Entrada.cadena();
                try{
                    agenda.buscar(nombre);
                 
                }catch (IllegalArgumentException e){
                    System.out.println("Operacion no soportada"+e.getMessage());
                }
                ejecutarOpcion(elegirOpcion());
            }
            //creamos el metodo borrarContacto
            private static void borrarContacto()throws OperationNotSupportedException{
                String nombre;
                System.out.println("Introduce el contacto a borrar");
                nombre=Entrada.cadena();
                Contacto[]contactos=agenda.getContactos();
                boolean encontrado=false;
                try{
                    agenda.borrar(nombre);
                    
                }catch(OperationNotSupportedException e){
                    e.getMessage();
                }
                if(encontrado==true){
                    System.out.println(EXITO);
                }else{
                    System.out.println(ERROR);
                }
                ejecutarOpcion(elegirOpcion());
            }
            
            //creamos el metodo listarAgenda
            private static void listarAgenda()throws OperationNotSupportedException{
                Contacto[]contactos=agenda.getContactos();
                for(int i=0;i<agenda.getNumContactos();i++);{
                    System.out.println(agenda.getContactos());
                }
                ejecutarOpcion(elegirOpcion());
            }
        
}   
	

	

