package bean;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import modelo.PersonaModelo;
import dao.PersonaDao;

@Named(value = "personaC")
@SessionScoped
public class PersonaC implements Serializable{
    
    private PersonaDao dao;
    private PersonaModelo modelo;
    private List<PersonaModelo> listaPersona;
    
    public PersonaC(){
        modelo = new PersonaModelo();
        dao = new PersonaDao();
        listaPersona = new ArrayList();
    }
    
    public void listar(){
        try {
            listaPersona = dao.listar();
        } catch (Exception e) {
            System.out.println("Error en PersonaControlador-Listar: "+ e.getMessage());
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
            System.out.println("Error en PersonaControlador-Registrar: "+ e.getMessage());
        }
    }
    
    public void eliminar(PersonaModelo per){
        try {
            dao.eliminar(per);
            listar();
            limpiar();
        } catch (Exception e) {
            System.out.println("Error en PersonaControlador-Eliminar: "+ e.getMessage());
        }
    }
    public void datos(PersonaModelo per){
        this.modelo = per;
    }
    
    public void limpiar(){
        modelo = new PersonaModelo();
    }
    
    public PersonaDao getDao(){
        return dao;
    }
    
    public void setdao(PersonaDao dao){
        this.dao = dao;
    }
    
    public PersonaModelo getModelo(){
        return modelo;
    }
    
    public void setModelo(PersonaModelo modelo){
        this.modelo = modelo;
    }
    
    public List<PersonaModelo> getlistaPersona(){
        return listaPersona;
    }
    
    public void setListaPersona(List<PersonaModelo> listaPersona){
        this.listaPersona = listaPersona;
    }
}