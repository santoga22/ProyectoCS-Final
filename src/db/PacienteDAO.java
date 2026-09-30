/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import DB.Conexion;
import entidades.Paciente;
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
public class PacienteDAO {
    
            public static ArrayList<Paciente> listar() {
        ArrayList<Paciente> lista = new ArrayList<>();
        String sql = "SELECT * FROM paciente";
        
        try(
                Connection con = Conexion.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
                ){
            
            while(rs.next()){
                lista.add(new Paciente(
                        rs.getInt("id"),
                        rs.getString("cedula"),
                        rs.getString("genero"),                        
                        rs.getString("nombre"),
                        rs.getString("apellidos"),
                        rs.getString("correo"),
                        rs.getString("telefono")
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
        
    public static boolean insertar(Paciente paciente) {
        String sql = "INSERT INTO paciente (cedula, genero, nombre, apellidos, correo, telefono ) values (?,?,?,?,?,?)";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, paciente.getCedula());
            ps.setString(2, paciente.getGenero());
            ps.setString(3, paciente.getNombre());
            ps.setString(4, paciente.getApellidos());
            ps.setString(5, paciente.getCorreo());
            ps.setString(6, paciente.getTelefono());
            
            
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
    
       public static Paciente buscarID(int id) {
        String sql = "SELECT * FROM paciente WHERE id = ?";
        
        try(
                Connection con = Conexion.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Paciente p = new Paciente();
            
            if(rs.next()){
               
               String cedula = rs.getString("cedula");
               String genero = rs.getString("genero");               
               String nombre = rs.getString("nombre");
               String apellidos = rs.getString("apellidos");
               String correo = rs.getString("correo");
               String telefono = rs.getString("telefono");
     
                    p.setCedula(cedula);
                    p.setGenero(genero);
                    p.setNombre(nombre);
                    p.setApellidos(apellidos);
                    p.setCorreo(correo);
                    p.setTelefono(telefono);
                       
            }else{
                   throw new SQLException("El id no existe", "PACIENTE",1);
               } 
            
            
            
            return p;
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
       
       
          public static boolean actualizar(Paciente paciente, int id) {
        String sql = "UPDATE paciente SET cedula=?, genero=?, nombre=?, apellidos =?, correo =?, telefono=? WHERE id=?";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, paciente.getCedula());
            ps.setString(2, paciente.getGenero());
            ps.setString(3, paciente.getNombre());
            ps.setString(4, paciente.getApellidos());
            ps.setString(5, paciente.getCorreo());
            ps.setString(6, paciente.getTelefono());
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
