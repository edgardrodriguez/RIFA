/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.PersonaModelo;
import java.util.ArrayList;
import java.util.List;

public class PersonaDao extends Conexion{
    public void registrar(PersonaModelo per) throws Exception{
        try {
            String sql = "INSERT INTO PERSONA (NOMPER, APEPER, NUMPER, ESTPER) VALUES (?,?,?,?)";
            
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setString(1, per.getName());
            st.setString(2, per.getLname());
            st.setString(3, per.getNumber());
            st.setString(4, per.getState());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en PersonaDao-Registrar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public void modificar(PersonaModelo per) throws Exception{
        try {
            String sql = "UPDATE PERSONA SET NOMPER=?, APEPER=?, NUMPER=?, ESTPER=? WHERE IDPER=?";
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setString(1, per.getName());
            st.setString(2, per.getLname());
            st.setString(3, per.getNumber());
            st.setString(4, per.getState());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en PersonaDao-Modificar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public void eliminar(PersonaModelo per) throws Exception{
        try {
            String sql = "DELETE FROM PERSONA WHERE IDPER=?";
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setInt(1, per.getCod());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("error en PersonaDao-Eliminar: ");
        }finally{
            this.cerrarCnx();
        }
    }
    
    public List<PersonaModelo> listar() throws Exception{
        List<PersonaModelo> lista=null;
        PersonaModelo persona;
        try {
            
            System.out.println("Se está realizando la consulta");
            String sql = "SELECT * FROM PERSONA";
            Statement st = this.getCnx().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while(rs.next()){
                persona = new PersonaModelo();
                persona.setCod(rs.getInt("IDPER"));
                persona.setName(rs.getString("NOMPER"));
                persona.setLname(rs.getString("APEPER"));
                persona.setNumber(rs.getString("NUMPER"));
                persona.setState(rs.getString("ESTPER"));
                lista.add(persona);
                System.out.println("Enviando persona");
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            System.out.println("Error en PersonaDao-Listar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
        return lista;
    }
}