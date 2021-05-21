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
import modelo.PremioModelo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Canales
 */
public class PremioDao extends Conexion{
    public void registrar(PremioModelo pre) throws Exception{
        try {
            String sql = "INSERT INTO PREMIO(NOMPRE, DESPRE, IDTK) VALUES (?,?,?)";
            
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setString(1, pre.getName());
            st.setString(2, pre.getDesc());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en PremioDao-Registrar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public void modificar(PremioModelo pre) throws Exception{
        try {
            String sql = "UPDATE PREMIO SET NOMPRE=?, DESPRE=? WHERE IDPRE=?";
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setString(1, pre.getName());
            st.setString(2, pre.getDesc());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en PremioDao-Modificar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public void eliminar(PremioModelo pre) throws Exception{
        try {
            String sql = "DELETE FROM PREMIO WHERE IDEPRE=?";
            PreparedStatement st = this.getCnx().prepareStatement(sql);
            st.setInt(1, pre.getCod());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en PremioDao-Eliminar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
    }
    
    public List<PremioModelo> listar() throws Exception{
        List<PremioModelo> lista = null;
        PremioModelo premio;
        
        try {
            System.out.println("Se está realizando la consulta en Premio Dao");
            String sql = "SELECT * FROM PREMIO";
            Statement st = this.getCnx().createStatement();
            ResultSet rs = st.executeQuery(sql);
            lista = new ArrayList();
            while(rs.next()){
                premio = new PremioModelo();
                premio.setCod(rs.getInt("IDPRE"));
                premio.setName(rs.getString("NOMPRE"));
                premio.setDesc(rs.getString("DESPRE"));
                lista.add(premio);
                System.out.println("Enviando premio");
            }
            
            rs.close();
            st.close();
        } catch (Exception e) {
            System.out.println("Error en Premiodao-Listar: "+ e.getMessage());
        }finally{
            this.cerrarCnx();
        }
        return lista;
    }
}
