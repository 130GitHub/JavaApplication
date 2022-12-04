/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtienda.persistencia;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;

/**
 *
 * @author Leo
 */
public abstract class DAO {
    protected Connection conexion=null;
    protected ResultSet resultado=null;
    protected Statement sentencia=null;
    
    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    
    protected void conectarBD() throws ClassNotFoundException, SQLException {
        try{
            Class.forName(DRIVER);
            String urlBaseDeDatos = "jdbc:mysql://localhost:3306/"+DATABASE+"?useSSL=false";
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
            throw ex;
            
        }           
    }
    protected void desconectarBD() throws SQLException {
        try{
            if(resultado != null){
                resultado.close();
            }
            if(sentencia != null){
                
            }
            if(conexion != null){
                conexion.close();
            }
        }catch(SQLException e){
            throw e;
        }
    }
    protected void insertarModificarEliminar(String sql) throws ClassNotFoundException, SQLException {
        try{
            conectarBD();
            sentencia=conexion.createStatement();
            sentencia.executeUpdate(sql);
        }catch(ClassNotFoundException | SQLException ex){
            //conexion.rollback();
            /*
            Descomentar la linea anterior si desean tener en cuenta el rollback.
            
            Correr el siguiente script en Workbench
            
            SET autocommit=1;
            COMMIT;
            */
            throw ex;
        }finally{
            desconectarBD();
        }
    }
    protected void consultarBD(String sql) throws SQLException, ClassNotFoundException {
        try{
            conectarBD();
            sentencia=conexion.createStatement();
            resultado=sentencia.executeQuery(sql);
        }catch(ClassNotFoundException | SQLException e){
            throw e;
        }
    }    
}
