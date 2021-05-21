/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelo.persona;

/**
 *
 * @author ZERO
 */
public class personaImpl extends Conexion implements ICRUDpersona<persona>{

    @Override
    public void registrar(persona per) throws Exception {
        String sql="insert into PERSONA (NOMPER,APEPER,NUMPER) values (?,?,?)";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setInt(3, per.getNumero());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("error al registrar persona dao "+ e.getMessage());
        }
    }

    @Override
    public void modificar(persona per) throws Exception {
        String sql="update PERSONA set NOMPER=?,APEPER=?,NUMPER=? where IDPER=?";
        try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            ps.setString(1, per.getNombre());
            ps.setString(2, per.getApellido());
            ps.setInt(3, per.getNumero());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error al modificar Persona Dao " + e.getMessage());
        }
    }

    @Override
    public void eliminar(persona per) throws Exception {
         String sql = "delete from PERSONA where IDPER=?";
         try {
            PreparedStatement ps = this.getCn().prepareStatement(sql);             
            ps.setInt(1, per.getIDper());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error en eliminarD" + e.getMessage());
        }finally {
            this.Cerrar();
        }
    }

    @Override
    public List<persona> listarTodos() throws Exception {
        List<persona> listado = null;
        persona per;
         String sql = "SELECT* FROM PERSONA";
        ResultSet rs;
        try {
            this.conectar();
            listado = new ArrayList();
            PreparedStatement ps = this.getCn().prepareStatement(sql);
            rs = ps.executeQuery(); 
             while (rs.next()) {
                 per = new persona();
                 per.setIDper(rs.getInt("IDPER"));
                 per.setNombre(rs.getString("NOMPER"));
                 per.setApellido(rs.getString("APEPER"));
                 per.setNumero(rs.getInt("NUMPER"));
                 listado.add(per);
             }
             rs.close();
             ps.close();
        } catch (Exception e) {
            System.out.println("Error en listarTodos Dao" + e.getMessage());
        }
        return listado;
    }
    
}
