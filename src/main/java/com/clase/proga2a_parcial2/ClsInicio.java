/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clase.proga2a_parcial2;

import java.util.Scanner;

/**
 *
 * @author Jesus Alberto
 */
public class ClsInicio {
    private static int opcion = -1;
    private static final Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {
        
        ClsConexion comis = new ClsConexion();
        
        while (opcion != 0) {
            try {
                 System.out.println("\nElige opcion:\n"
                        + "1.- Consultar por NIV\n"
                        + "2.- Mostrar Vendedores y sumatorias\n"
                        + "3.- Eliminar Vendedor\n"
                        + "4.- Actualizar Vendedor\n"
                        + "5.- Crear Vendedor\n" 
                        + "0.- Salir");

                opcion = Integer.parseInt(scanner.nextLine());
                switch (opcion) {
                    case 1:
                        System.out.println("Ingresa el NIV del vendedor");
                        String Niv = scanner.nextLine();
                        comis.ConsultaNiv(Integer.parseInt(Niv));
                        break;
                     
                    case 2:
                        comis.Vendedores();
                        break;
                    
                    case 3:
                        System.out.println("Ingresa el NIV del vendedor a ELIMINAR");
                        String Elimin = scanner.nextLine();
                        System.out.println("**** ¿Está seguro que quiere eliminar el vendedor? ****");
                        System.out.println("Presione 1 para confirmar o cualquier tecla para cancelar");
                        String confirmar = scanner.nextLine();
                        if(Integer.parseInt(confirmar) == 1){
                           comis.Eliminar(Integer.parseInt(Elimin));
                            System.out.println("**** Vendedor Eliminado ****");
                           break;
                        }
                        else{
                            System.out.println("Cancelado");
                        }
                        break;
                        
                    case 4:
                        System.out.println("Ingresa el NIV del vendedor a ACTUALIZAR");
                        String Ni = scanner.nextLine();
                        comis.ConsultaNiv(Integer.parseInt(Ni));
                        System.out.println("Ingrese El nuevo nombre");
                        String Name = scanner.nextLine();
                        comis.Actualizar(Integer.parseInt(Ni),Name);
                        System.out.println("Vendedor Actualizado");
                        comis.ConsultaNiv(Integer.parseInt(Ni));
                        break;
                        
                   case 5:
                       System.out.println("Ingrese datos para crear un nuevo vendedor");
                       System.out.println("Nombre: ");
                       String Nom = scanner.nextLine();
                       System.out.println("Enero: ");
                       String Enero = scanner.nextLine();
                       System.out.println("Febrero: ");
                       String Febrero = scanner.nextLine();
                       System.out.println("Marzo: ");
                       String Marzo = scanner.nextLine();
                       System.out.println("Abril: ");
                       String Abril = scanner.nextLine();
                       System.out.println("Mayo: ");
                       String Mayo = scanner.nextLine();
                       System.out.println("Junio: ");
                       String Junio = scanner.nextLine();

                       comis.Crear(Nom,Integer.parseInt(Enero),Integer.parseInt(Febrero),Integer.parseInt(Marzo),
                                    Integer.parseInt(Abril),Integer.parseInt(Mayo),Integer.parseInt(Junio));
                       System.out.println("***** Vendedor Creado *****");
                       comis.Vendedores();
                       break;
                }

                
            } catch (Exception e) {
                System.out.println("Error!");
            }
        }
        
    }
}
