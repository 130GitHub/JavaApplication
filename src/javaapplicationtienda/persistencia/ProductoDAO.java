/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtienda.persistencia;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import javaapplicationtienda.entidades.Producto;

/**
 *
 * @author Leo
 */
public final class ProductoDAO extends DAO {
    public void guardarProducto(Producto p) throws Exception {
        try {
            if(p == null){
                throw new Exception("Debe indicar un producto");
            }
            String sql="INSERT INTO producto (nombre, precio, codigo_fabricante)"
                    + "VALUES ('"+p.getNombre()+"', '"+p.getPrecio()+"', '"+p.getCodigoFabricante()+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }
 
    }
    public void modificarProducto(Producto p) throws Exception {
        
        try {
            System.out.println(p);
            if(p == null){
                throw new Exception("Debe indicar un producto");
            }
            String sql=
            "UPDATE producto SET nombre = '"+
            p.getNombre()
            +"', precio = '"+
            p.getPrecio()
            +"', codigo_fabricante = '"+
            p.getCodigoFabricante()+ 
            "'"
            + "WHERE"
            + " codigo = '"+
            p.getCodigo()
            +"'";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        }
 
    }
    public void eliminarProducto(Producto p) throws Exception {
        try {
            String sql=
            "DELETE * FROM producto"
            + "WHERE"
            + "  codigo = '"+
            p.getCodigo()
            +"'";
        } catch (Exception e) {
            throw e;
        }
    }
    public Producto buscarProducto (int codigoProducto) throws SQLException, Exception{
        try {
            String sql="SELECT * FROM producto WHERE codigo like '"+codigoProducto+"'";
            consultarBD(sql);
            Producto p=null;
            while(resultado.next()){
                p=new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBD();
            return p;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
    public Collection<Producto> mostrarProductoNombre() throws SQLException, Exception{
        try {
            String sql="SELECT nombre FROM producto";
            consultarBD(sql);
            Producto p=null;
            Collection<Producto> productos=new ArrayList();
            while(resultado.next()){
                p=new Producto();
                //p.setCodigo(resultado.getInt(1));
                //p.setNombre(resultado.getString(2));
                p.setNombre(resultado.getString(1));
                //p.setPrecio(resultado.getDouble(3));
                //p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarBD();
            return productos;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
    public Collection<Producto> mostrarProductoNombrePrecio() throws SQLException, Exception{
        try {
            String sql="SELECT nombre, precio FROM producto";
            consultarBD(sql);
            Producto p=null;
            Collection<Producto> productos=new ArrayList();
            while(resultado.next()){
                p=new Producto();
               // p.setCodigo(resultado.getInt(1));
                //p.setNombre(resultado.getString(1));
                p.setNombre(resultado.getString(1));
                //p.setPrecio(resultado.getDouble(3));
                p.setPrecio(resultado.getDouble(2));
                //p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarBD();
            return productos;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
    public Collection<Producto> mostrarProductoPrecioEntre120y202() throws SQLException, Exception{
        try {
            String sql="SELECT * FROM producto where precio between 120 and 202";
            consultarBD(sql);
            Producto p=null;
            Collection<Producto> productos=new ArrayList();
            while(resultado.next()){
                p=new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarBD();
            return productos;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
    public Collection<Producto> mostrarProductoNombrePortatil() throws SQLException, Exception{
        try {
            String sql="select * from tienda.producto where nombre like \"%Portatil%\"";
            consultarBD(sql);
            Producto p=null;
            Collection<Producto> productos=new ArrayList();
            while(resultado.next()){
                p=new Producto();
                p.setCodigo(resultado.getInt(1));
                p.setNombre(resultado.getString(2));
                p.setPrecio(resultado.getDouble(3));
                p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarBD();
            return productos;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
    public Collection<Producto> mostrarProductoMinPrecio() throws SQLException, Exception{
        try {
            String sql="select nombre, precio from tienda.producto where precio = (select min(precio) as minPrecio from tienda.producto)";
            consultarBD(sql);
            Producto p=null;
            Collection<Producto> productos=new ArrayList();
            while(resultado.next()){
                p=new Producto();
                //p.setCodigo(resultado.getInt(1));
                //p.setNombre(resultado.getString(2));
                p.setNombre(resultado.getString(1));
                //p.setPrecio(resultado.getDouble(3));
                p.setPrecio(resultado.getDouble(2));
                //p.setCodigoFabricante(resultado.getInt(4));
                productos.add(p);
            }
            desconectarBD();
            return productos;
        } catch (ClassNotFoundException | SQLException ex) {
            desconectarBD();
            throw ex;
        }
    }
}
