/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dao.personaImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.persona;

/**
 *
 * @author ZERO
 */
@Named(value = "personaC")
@SessionScoped
public class personaC implements Serializable {

    private persona per;
    private personaImpl dao;
    private List<persona> listadoPer;

    public personaC() {
        per = new persona();
        dao = new personaImpl();
    }
    public void registrar() throws Exception {
        try {

            dao.registrar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en registrarC " + e.getMessage());
        }
    }

    public void modificar() throws Exception {
        try {
            dao.modificar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "OK", "Modificado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en modificarC " + e.getMessage());
        }
    }

    public void eliminar() throws Exception {
        try {
            dao.eliminar(per);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "OK", "Eliminado con éxito"));
            limpiar();
            listar();
        } catch (Exception e) {
            System.out.println("Error en eliminarC " + e.getMessage());
        }
    }

    public void limpiar() {
        per = new persona();
    }

    public void listar() {
        try {
            listadoPer = dao.listarTodos();
        } catch (Exception e) {
            System.out.println("Error en listarC " + e.getMessage());
        }
    }
//Metodos generados
    public persona getPer() {
        return per;
    }

    public void setPer(persona per) {
        this.per = per;
    }

    public personaImpl getDao() {
        return dao;
    }

    public void setDao(personaImpl dao) {
        this.dao = dao;
    }

    public List<persona> getListadoPer() {
        return listadoPer;
    }

    public void setListadoPer(List<persona> listadoPer) {
        this.listadoPer = listadoPer;
    }

}
