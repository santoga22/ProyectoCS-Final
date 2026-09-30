/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import Clases.ClsEncriptar;
import DB.Conexion;
import clases.ClsGlobales;
import entidades.Usuario;
import java.sql.Connection;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author usuario
 */
public class UsuarioDAO {

    public static boolean insertar(Usuario usuario) {
        String sql = "INSERT INTO usuario (correo, clave, salt, nombre, idFuncionario) values (?,?,?,?,?)";
try (
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
    ) {
        ps.setString(1, usuario.getCorreo());
        ps.setString(2, usuario.getClave());
        ps.setString(3, usuario.getSalt());
        ps.setString(4, usuario.getNombre());
        ps.setInt(5, usuario.getIdFuncionario());

        ps.executeUpdate();

        JOptionPane.showMessageDialog(
        null,
        "Usuario creado con exito",
        "Exito",
        JOptionPane.INFORMATION_MESSAGE
        );
  
        return true;

    } catch (SQLException e) {
            
            String mensaje;
            
            switch (e.getErrorCode()){
                case 1062:
                    mensaje = "El correo electrónico ya se encuentra registrada";
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
     public static Usuario validarAcceso(String correo, String clave) {
        String sql = "SELECT * FROM usuario WHERE correo = ?";    
        
        try (
                Connection con = Conexion.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
               
             ){
            
            ps.setString(1, correo);
            ResultSet rs = ps.executeQuery();
            
            Usuario usesion = new Usuario();
            if(rs.next()){
               //System.out.println(rs.getString("salt"));
               
               String salt = rs.getString("salt");
               String claveEncriptada = ClsEncriptar.encriptaSHA256(clave, salt);
               
               if (!claveEncriptada.equals(rs.getString("clave"))){
                   throw new SQLException ("La clave es incorrecta","LOGIN_PASS",2);
                   
               }
               if(!rs.getBoolean("activo")){
                   throw new SQLException ("Su usuario esta inactivo","LOGIN_ACT",3);
               }
                       
                       
            }else{
                   throw new SQLException("El correo no existe", "LOGIN_EMAIL",1);
               } 
           
            usesion.setCorreo(correo);
            return usesion;
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
     
public static boolean existeCorreo(String correo) {
    boolean existe = false;
    try {
        Connection con = Conexion.getConnection();
        String sql = "SELECT COUNT(*) FROM usuario WHERE correo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, correo);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            existe = rs.getInt(1) > 0;
        }
        rs.close();
        ps.close();
        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return existe;
}

public static boolean actualizarClave(String correo, String nuevaClave, String nuevoSalt) {
    boolean actualizado = false;
    try {
        Connection con = Conexion.getConnection();
        String sql = "UPDATE usuario SET clave = ?, salt = ? WHERE correo = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, nuevaClave);
        ps.setString(2, nuevoSalt);
        ps.setString(3, correo);
        actualizado = ps.executeUpdate() > 0;
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return actualizado;
    }

    public static ArrayList<Usuario> listar() {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT id, correo, activo FROM usuario";
        
        try(
                Connection con = Conexion.getConnection();
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(sql)
                ){
            
            while(rs.next()){
                lista.add(new Usuario(
                        rs.getInt("id"),
                        rs.getString("correo"),
                        rs.getBoolean("activo")   
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

}
