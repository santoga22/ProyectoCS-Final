/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author usuario
 */
public class Receta {
    
    private int id;
    private String medicamento;
    private String cantidad;
    private String nombrepaciente;
    private String fechaentrega;
    private String farmacia;
    private String estado;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getFechaentrega() {
        return fechaentrega;
    }

    public void setFechaentrega(String fechaentrega) {
        this.fechaentrega = fechaentrega;
    }

    public String getFarmacia() {
        return farmacia;
    }

    public void setFarmacia(String farmacia) {
        this.farmacia = farmacia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Receta(String medicamento, String cantidad, String nombrepaciente, String fechaentrega, String farmacia, String estado) {
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.nombrepaciente = nombrepaciente;
        this.fechaentrega = fechaentrega;
        this.farmacia = farmacia;
        this.estado = estado;
    }

    public Receta(int id, String medicamento, String cantidad, String nombrepaciente, String fechaentrega, String farmacia, String estado) {
        this.id = id;
        this.medicamento = medicamento;
        this.cantidad = cantidad;
        this.nombrepaciente = nombrepaciente;
        this.fechaentrega = fechaentrega;
        this.farmacia = farmacia;
        this.estado = estado;
    }

    public Receta() {
    }

}
