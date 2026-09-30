/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import DB.Conexion;
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
public class RecetaDAO {
    
            public static ArrayList<Receta> listar() {
        ArrayList<Receta> lista = new ArrayList<>();
        String sql = "SELECT * FROM receta";
        
        try(
                Connection con = Conexion.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
                ){
            
            while(rs.next()){
                lista.add(new Receta(
                        rs.getInt("id"),
                        rs.getString("medicamento"),
                        rs.getString("cantidad"),                        
                        rs.getString("nombrepaciente"),
                        rs.getString("fechaentrega"),
                        rs.getString("farmacia"),
                        rs.getString("estado")
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
        
    public static boolean insertar(Receta receta) {
        String sql = "INSERT INTO receta (medicamento, cantidad, nombrepaciente, fechaentrega, farmacia, estado ) values (?,?,?,?,?,?)";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, receta.getMedicamento());
            ps.setString(2, receta.getCantidad());
            ps.setString(3, receta.getNombrepaciente());
            ps.setString(4, receta.getFechaentrega());
            ps.setString(5, receta.getFarmacia());
            ps.setString(6, receta.getEstado());
            
            
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
    
       public static Receta buscarID(int id) {
        String sql = "SELECT * FROM receta WHERE id = ?";
        
        try(
                Connection con = Conexion.getConnection(); 
                PreparedStatement ps = con.prepareStatement(sql)
                ){
            
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            Receta r = new Receta();
            
            if(rs.next()){
               
               String medicamento = rs.getString("medicamento");
               String cantidad = rs.getString("cantidad");               
               String nombrepaciente = rs.getString("nombrepaciente");
               String fechaentrega = rs.getString("fechaentrega");
               String farmacia = rs.getString("farmacia");
               String estado = rs.getString("estado");
     
                    r.setMedicamento(medicamento);
                    r.setCantidad(cantidad);
                    r.setNombrepaciente(nombrepaciente);
                    r.setFechaentrega(fechaentrega);
                    r.setFarmacia(farmacia);
                    r.setEstado(estado);
                       
            }else{
                   throw new SQLException("El id no existe", "RECETA",1);
               } 
            
            
            
            return r;
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
       
       
          public static boolean actualizar(Receta receta, int id) {
        String sql = "UPDATE receta SET medicamento=?, cantidad=?, nombrepaciente=?, fechaentrega =?, farmacia =?, estado=? WHERE id=?";

        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
            ){
            
            ps.setString(1, receta.getMedicamento());
            ps.setString(2, receta.getCantidad());
            ps.setString(3, receta.getNombrepaciente());
            ps.setString(4, receta.getFechaentrega());
            ps.setString(5, receta.getFarmacia());
            ps.setString(6, receta.getEstado());
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
