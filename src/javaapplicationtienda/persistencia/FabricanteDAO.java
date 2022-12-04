/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtienda.persistencia;

import javaapplicationtienda.entidades.Fabricante;

/**
 *
 * @author Leo
 */
public class FabricanteDAO extends DAO {
    
    public void guardarFabricante(Fabricante f) throws Exception {
        try {
            if(f == null){
                throw new Exception("Debe indicar un fabricante");
            }
            String sql="INSERT INTO fabricante (nombre)"
                    + "VALUES ('"+f.getNombre()+"');";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
        }
 
    }
}
