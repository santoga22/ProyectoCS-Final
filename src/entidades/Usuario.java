/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author usuario
 */
public class Usuario {  
    private int id;
    private String correo;
    private String clave;
    private String salt;
    private String nombre;
    private int idFuncionario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCorreo() {
        return correo;
    }

    public Usuario(int id, String correo, boolean activo) {
        this.id = id;
        this.correo = correo;
        this.activo = activo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Usuario(int id, String correo, String clave, String salt, String nombre, int idFuncionario, boolean activo) {
        this.id = id;
        this.correo = correo;
        this.clave = clave;
        this.salt = salt;
        this.nombre = nombre;
        this.idFuncionario = idFuncionario;
        this.activo = activo;
    }
    private boolean activo;

    public Usuario() {
    }
    
    public Usuario(String correo, String clave, String salt, String nombre, int idFuncionario) {
    this.correo = correo;
    this.clave = clave;
    this.salt = salt;
    this.nombre = nombre;
    this.idFuncionario = idFuncionario;
    this.activo = true;
}

    
}
