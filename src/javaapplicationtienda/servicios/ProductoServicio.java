/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtienda.servicios;

import java.util.Scanner;
import javaapplicationtienda.entidades.Producto;
import javaapplicationtienda.persistencia.ProductoDAO;

/**
 *
 * @author Leo
 */
public class ProductoServicio {
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    private final ProductoDAO pDAO;
    
    public ProductoServicio(){
        this.pDAO = new ProductoDAO();
    }
    
    public void interfazMenu() throws Exception{
        String opcion;
        try {
            do{
                System.out.println("*********MENU***********");                
                System.out.println("1 - el nombre de todos los productos");
                System.out.println("2 - los nombres y los precios de todos los productos de la tabla producto");
                System.out.println("3 - aquellos productos que su precio esté entre 120 y 202");
                System.out.println("4 - todos los Portátiles de la tabla producto");
                System.out.println("5 - el nombre y el precio del producto más barato");
                System.out.println("6 - Ingresar un producto a la base de datos");
                System.out.println("7 - Ingresar un fabricante a la base de datos");
                System.out.println("0 - salir");
                System.out.println("************************");

                opcion=analizaOpcionMenu(leer.next());
            }while(!opcion.equals("0"));
        } catch (Exception e) {
            throw e;
        }
        
    }
    public String analizaOpcionMenu(String opcion) throws Exception{
        String opcionRetorno;
        try {
            switch(opcion){
                case "1":
                    mostrarProductosNombre();
                    break;
                case "2":
                    mostrarProductosNombrePrecio();
                    break;
                case "3":
                    mostrarProductosNombrePrecioEntre120y202();
                    break;
                case "4":
                    mostrarProductosNombrePortatil();
                    break;
                case "5":
                    mostrarProductoMinPrecio();
                    break;
                case "6":
                    crearProducto();
                    break;
                case "8":
                    editarProducto();
                    break;
                default:
                    opcionRetorno="0";
            }
            return opcion;
        } catch (Exception e) {
            throw e;
        }
        
    }
    public void mostrarProductosNombre() throws Exception {
        //ProductoDAO pDAO=new ProductoDAO();
        try {
            //pDAO.mostrarProducto();
            for(Producto p:pDAO.mostrarProductoNombre()){
                p.mostrarNombre();
            }
        }catch (Exception e) {
            throw e;
        }
        
    }
    public void mostrarProductosNombrePrecio() throws Exception {
        //ProductoDAO pDAO=new ProductoDAO();
        try {
            //pDAO.mostrarProducto();
            for(Producto p:pDAO.mostrarProductoNombrePrecio()){
                System.out.println(p);
            }
        }catch (Exception e) {
            throw e;
        }
        
    }
    public void mostrarProductosNombrePrecioEntre120y202() throws Exception {
        //ProductoDAO pDAO=new ProductoDAO();
        try {
            //pDAO.mostrarProducto();
            for(Producto p:pDAO.mostrarProductoPrecioEntre120y202()){
                System.out.println(p);
            }
        }catch (Exception e) {
            throw e;
        }
        
    }
    public void mostrarProductosNombrePortatil() throws Exception {
        //ProductoDAO pDAO=new ProductoDAO();
        try {
            //pDAO.mostrarProducto();
            for(Producto p:pDAO.mostrarProductoNombrePortatil()){
                System.out.println(p);
            }
        }catch (Exception e) {
            throw e;
        }
        
    }
    public void mostrarProductoMinPrecio() throws Exception {
        //ProductoDAO pDAO=new ProductoDAO();
        try {
            //pDAO.mostrarProducto();
            for(Producto p:pDAO.mostrarProductoMinPrecio()){
                //System.out.println(p);
                p.mostrarNombrePrecio();
            }
        }catch (Exception e) {
            throw e;
        }
        
    }
    public void crearProducto(){
        try {
            Producto p=new Producto();
            System.out.println("Ingrese el nombre del producto");
            p.setNombre(leer.next());
            leer.next();
            System.out.println("Ingrese el precio del producto");
            p.setPrecio(leer.nextDouble());
            System.out.println("Ingrese el codigo del fabricante");
            p.setCodigoFabricante(leer.nextInt());
            
            pDAO.guardarProducto(p);
        } catch (Exception e) {
        }
    }
    public void editarProducto() throws Exception{
        try {
            System.out.println("Ingrese el codigo del producto a editar");
            int codigo=leer.nextInt();
            
            Producto p=pDAO.buscarProducto(codigo);
            
            p.setCodigo(codigo);
            System.out.println(p.getNombre());
            p.setNombre(leer.next());
            
            System.out.println(p.getPrecio());            
            p.setPrecio(leer.nextDouble());
            
            System.out.println(p.getCodigoFabricante());
            p.setCodigoFabricante(leer.nextInt());
           
            pDAO.modificarProducto(p);
        } catch (Exception e) {
            throw e;
        }
    }
}
