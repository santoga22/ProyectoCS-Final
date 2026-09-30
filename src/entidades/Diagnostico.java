/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author usuario
 */
public class Diagnostico {
    private int id;
    private String enfermedad;
    private String severidad;
    private String nombrepaciente;
    private String fechadiagnostico;
    private String hospital;
    private String tratamiento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String getSeveridad() {
        return severidad;
    }

    public void setSeveridad(String severidad) {
        this.severidad = severidad;
    }

    public String getNombrepaciente() {
        return nombrepaciente;
    }

    public void setNombrepaciente(String nombrepaciente) {
        this.nombrepaciente = nombrepaciente;
    }

    public String getFechadiagnostico() {
        return fechadiagnostico;
    }

    public void setFechadiagnostico(String fechadiagnostico) {
        this.fechadiagnostico = fechadiagnostico;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }

    public Diagnostico(String enfermedad, String severidad, String nombrepaciente, String fechadiagnostico, String hospital, String tratamiento) {
        this.enfermedad = enfermedad;
        this.severidad = severidad;
        this.nombrepaciente = nombrepaciente;
        this.fechadiagnostico = fechadiagnostico;
        this.hospital = hospital;
        this.tratamiento = tratamiento;
    }

    public Diagnostico(int id, String enfermedad, String severidad, String nombrepaciente, String fechadiagnostico, String hospital, String tratamiento) {
        this.id = id;
        this.enfermedad = enfermedad;
        this.severidad = severidad;
        this.nombrepaciente = nombrepaciente;
        this.fechadiagnostico = fechadiagnostico;
        this.hospital = hospital;
        this.tratamiento = tratamiento;
    }

    public Diagnostico() {
    }
}
