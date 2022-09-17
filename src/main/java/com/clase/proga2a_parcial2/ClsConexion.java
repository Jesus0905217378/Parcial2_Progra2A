/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.clase.proga2a_parcial2;

import java.sql.*;
import static javax.swing.UIManager.getInt;

/**
 *
 * @author Jesus Alberto
 */
public class ClsConexion {

    static ResultSet result=null;
   
    public static void Vendedores(){
            //paso 1 creamos la conexion a la base de datos
            String url = "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try{
            //paso 2 creamos el objeto conexion
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            //paso 3 creamos el objeto statement
            Statement sentencia = conexion.createStatement();
            //paso 4 creamos la instruccion
            String sql = "SELECT * FROM db_comisiones.tb_comisiones";
            // paso 5 ejecutamos el query
            ResultSet resultado = sentencia.executeQuery(sql);
            result = resultado;
            // paso 6. procesar el resultado
            // explicar como se maneja al siguiente registro
            ImprimirTabla(resultado);
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }

    }
    
    public static void ConsultaNiv(int NIV){
        try {
            String url = "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            String consulta = " select * from tb_comisiones  where niv ="+NIV;
            ResultSet resultado = sentencia.executeQuery(consulta);
            ImprimirTabla(resultado);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void Eliminar(int NIV){
            String url = "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";

        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            String sql = "delete from tb_comisiones  where niv ="+NIV;
            sentencia.executeUpdate(sql);
            Vendedores();
         } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
        
    }
    
    public static void Actualizar(int NIV, String Nombre){
        String url = "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";

        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            String sql = "update tb_comisiones set vendedor ='"+Nombre+"'where niv ="+NIV;
            sentencia.executeUpdate(sql);
         } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    public static void Crear(String Vendedor,int enero, int febrero, int marzo,int abril,int mayo, int junio){
                String url = "jdbc:mysql://localhost:3306/db_comisiones?zeroDateTimeBehavior=convertToNull&useSSL=false&useTimezone=true&serverTimezone=UTC";
        try {
            Connection conexion = DriverManager.getConnection(url,"root","bb010901bb");
            Statement sentencia = conexion.createStatement();
            
            String sql = "insert into tb_comisiones (vendedor,enero,febrero,marzo,abril,mayo,junio)"
                    + "values('"+Vendedor+"',"+enero+","+febrero+","+marzo+","+abril+","+mayo+","+junio+");";
            sentencia.executeUpdate(sql);
         } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    
    public static void ImprimirTabla(ResultSet result){
        int ToEne = 0,ToFeb=0,ToMar =0,ToAbr=0,ToMay=0,ToJun=0, ToSuma =0;
        try {
            
                System.out.println("Niv\t"+"Nombre\t"+"Enero\t"+"Febrero\t"+"Marzo\t"+"Abril\t"+"Mayo\t"+"Junio\t"+"Total");
            while(result.next()){
                int ene = 0,feb=0,mar =0,abr=0,may=0,jun=0,suma =0;
                System.out.print(result.getInt(1)+"\t");    //niv
                System.out.print(result.getString(2)+"\t"); //nombre
                System.out.print(result.getInt(3)+"\t");    //enero
                System.out.print(result.getInt(4)+"\t");  //febrero
                System.out.print(result.getInt(5)+"\t");  //marzo
                System.out.print(result.getInt(6)+"\t");  //abril
                System.out.print(result.getInt(7)+"\t");  //mayo
                System.out.print(result.getInt(8)+"\t");  //junio
                ene = result.getInt(3);
                feb = ene + result.getInt(4);
                mar = feb + result.getInt(5);
                abr = mar + result.getInt(6);
                may = abr + result.getInt(7);
                jun = may + result.getInt(8);
                suma = jun;
                System.out.println(suma);  //total
                
                ToEne = ToEne + result.getInt(3);
                ToFeb = ToFeb + result.getInt(4);
                ToMar = ToMar + result.getInt(5);
                ToAbr = ToAbr + result.getInt(6);
                ToMay = ToMay + result.getInt(7);
                ToJun = ToJun + result.getInt(8);
        }
            System.out.println("\n***** SUMA DE VENTAS POR MES *****");
            System.out.println("Total Enero   = "+ToEne);
            System.out.println("Total Febrero = "+ToFeb);
            System.out.println("Total Marzo   = "+ToMar);
            System.out.println("Total Abril   = "+ToAbr);
            System.out.println("Total Mayo    = "+ToMay);
            System.out.println("Total Junio   = "+ToJun+"\n");
            
            System.out.println("***** VENTAS TOTALES *****");
            ToSuma = ToEne+ToFeb+ToMar+ToAbr+ToMay+ToJun;
            System.out.println(ToSuma);
        }catch (SQLException ex) {
          ex.printStackTrace(System.out);

        }
    }

}
