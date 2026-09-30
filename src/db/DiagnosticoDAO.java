/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import DB.Conexion;
import entidades.Diagnostico;
import entidades.Paciente;
import entidades.Receta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class DiagnosticoDAO {
    
            public static ArrayList<Diagnostico> listar() {
        ArrayList<Diagnostico> lista = new ArrayList<>();
        String sql = "SELECT * FROM diagnostico";
        
        try(
                Connection con = Conexion.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
                ){
            
            while(rs.next()){
                lista.add(new Diagnostico(
                        rs.getInt("id"),
                        rs.getString("enfermedad"),
                        rs.getString("severidad"),                        
                        rs.getString("nombrepaciente"),
                        rs.getString("fechadiagnostico"),
                        rs.getString("hospital"),
                        rs.getString("tratamiento")
                ));
            }
            
        }catch(SQLException e){
            
             JOptionPane.showMessageDialog(
            null,
            e.getMessage(),
            "ERROR!",
            JOptionPane.ERROR_MESSAGE
            );            
        }
        
        return lista;
    }
        
    public static boolean insertar(Diagnostico diagnostico) {
        String sql = "INSERT INTO diagnostico (enfermedad, severidad, nombrepaciente, fechadiagnostico, hospital, tratamiento ) values (?,?,?,?,?,?)";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, diagnostico.getEnfermedad());
            ps.setString(2, diagnostico.getSeveridad());
            ps.setString(3, diagnostico.getNombrepaciente());
            ps.setString(4, diagnostico.getFechadiagnostico());
            ps.setString(5, diagnostico.getHospital());
            ps.setString(6, diagnostico.getTratamiento());
            
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            
            String mensaje;
            
            switch (e.getErrorCode()){
                case 1062:
                    mensaje = "La informacion ya se encuentra registrada";
                    break;
                default:
                    mensaje = e.getMessage();
                
            }
            
            JOptionPane.showMessageDialog(
            null,
            mensaje,
            "ERROR!",
            JOptionPane.ERROR_MESSAGE
            );            
            
            return false;
        }
    }
    
       public static Diagnostico buscarID(int id) {
        String sql = "SELECT * FROM diagnostico WHERE id = ?";
        
        try(
                Connection con = Conexion.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Diagnostico d = new Diagnostico();
            
            if(rs.next()){
               
               String enfermedad = rs.getString("enfermedad");
               String severidad = rs.getString("severidad");               
               String nombrepaciente = rs.getString("nombrepaciente");
               String fechadiagnostico = rs.getString("fechadiagnostico");
               String hospital = rs.getString("hospital");
               String tratamiento = rs.getString("tratamiento");
     
                    d.setEnfermedad(enfermedad);
                    d.setSeveridad(severidad);
                    d.setNombrepaciente(nombrepaciente);
                    d.setFechadiagnostico(fechadiagnostico);
                    d.setHospital(hospital);
                    d.setTratamiento(tratamiento);
                       
            }else{
                   throw new SQLException("El id no existe", "DIAGNOSTICO",1);
               } 
            
            
            
            return d;
        }catch(SQLException e){
            
            JOptionPane.showMessageDialog(
            null,
            e.getMessage(),
            "ERROR!",
            JOptionPane.ERROR_MESSAGE
            );            
                     
            return null;
        }

    }
       
       
          public static boolean actualizar(Diagnostico diagnostico, int id) {
        String sql = "UPDATE diagnostico SET enfermedad=?, severidad=?, nombrepaciente=?, fechadiagnostico =?, hospital =?, tratamiento=? WHERE id=?";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, diagnostico.getEnfermedad());
            ps.setString(2, diagnostico.getSeveridad());
            ps.setString(3, diagnostico.getNombrepaciente());
            ps.setString(4, diagnostico.getFechadiagnostico());
            ps.setString(5, diagnostico.getHospital());
            ps.setString(6, diagnostico.getTratamiento());
            ps.setInt(7, id);
            
            
            ps.executeUpdate();
            
            return true;
        } catch (SQLException e) {
            
            String mensaje;
            
            switch (e.getErrorCode()){
                case 1062:
                    mensaje = "La informacion ya se encuentra registrada";
                    break;
                default:
                    mensaje = e.getMessage();
                
            }
            
            JOptionPane.showMessageDialog(
            null,
            mensaje,
            "ERROR!",
            JOptionPane.ERROR_MESSAGE
            );            
            
            return false;
        }
    }
}
