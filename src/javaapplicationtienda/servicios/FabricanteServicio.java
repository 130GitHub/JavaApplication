/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplicationtienda.servicios;

import java.util.Scanner;
import javaapplicationtienda.entidades.Fabricante;
import javaapplicationtienda.persistencia.FabricanteDAO;

/**
 *
 * @author Leo
 */
public class FabricanteServicio {
    Scanner leer=new Scanner(System.in).useDelimiter("\n");
    
    private final FabricanteDAO pDAO;
    
    public FabricanteServicio(){
        this.pDAO = new FabricanteDAO();
    }
    public void crearFabricante(){
        try {
            Fabricante f=new Fabricante();
            System.out.println("Ingrese el nombre del fabricante");
            f.setNombre(leer.next());
            
            pDAO.guardarFabricante(f);
        } catch (Exception e) {
        }
    }
}
