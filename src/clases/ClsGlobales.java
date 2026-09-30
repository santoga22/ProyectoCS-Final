/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import entidades.Usuario;
import formularios.IFrmDiagnosticos;
import formularios.IFrmPacientes;
import formularios.IFrmRecetas;
import formularios.IFrmUsuarios;
import formularios.MDIPrincipal;

/**
 *
 * @author usuario
 */
public class ClsGlobales {
    public static Usuario usesion = new Usuario();
    public static IFrmUsuarios fusuarios = new IFrmUsuarios();
    public static IFrmPacientes fpacientes = new IFrmPacientes();
    public static IFrmRecetas frecetas = new IFrmRecetas();   
    public static IFrmDiagnosticos fdiagnosticos = new IFrmDiagnosticos();      
    public static MDIPrincipal fprincipal = new MDIPrincipal();
    
   
}
