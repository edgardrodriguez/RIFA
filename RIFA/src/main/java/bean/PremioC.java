/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import modelo.PremioModelo;
import dao.PremioDao;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;

/**
 *
 * @author Pablo Canales
 */
@Named(value="premioC")
@SessionScoped
public class PremioC {
    private PremioDao dao;
    private PremioModelo modelo;
    private List<PremioModelo> listaPremio;
    
    public PremioC(){
        modelo = new PremioModelo();
        dao = new PremioDao();
        listaPremio = new ArrayList();
    }
    
    public void listar(){
        try {
            listaPremio = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en PremioControlador-Listar: "+ e.getMessage());
        }
    }
    
    @PostConstruct
    public void construir(){
        listar();
    }
    
    public void registrar(){
        try {
            dao.registrar(modelo);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error En Premiocontrolador-registrar: "+ e.getMessage());
        }
    }
    
    public void eliminar(PremioModelo pre){
        try {
            dao.eliminar(pre);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en PersonaControlador-Eliminar: "+ e.getMessage());
        }
    }
    
    public void datos(PremioModelo pre){
        this.modelo = pre;
    }
    
    public void limpiar(){
        modelo = new PremioModelo();
    }

    public PremioDao getDao() {
        return dao;
    }

    public void setDao(PremioDao dao) {
        this.dao = dao;
    }

    public PremioModelo getModelo() {
        return modelo;
    }

    public void setModelo(PremioModelo modelo) {
        this.modelo = modelo;
    }

    public List<PremioModelo> getListaPremio() {
        return listaPremio;
    }

    public void setListaPremio(List<PremioModelo> listaPremio) {
        this.listaPremio = listaPremio;
    }
}
