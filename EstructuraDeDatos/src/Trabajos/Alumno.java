/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trabajos;

/**
 *
 * @author Walter
 */
public class Alumno {
    //atributos
    private String legajo;
    private String nombre;
    private String apellido;
    private int dni;
    private String calle;
    private int numero;
    private String ciudad;
    private int telefono;
    private String usuario;
    private String clave;
    //Constructores
    public Alumno(String leg){
    legajo=leg;
    }
    public Alumno(String leg,String nom, String ape, int dni,String calle, int num, String ciudad, int tel, String usu,String clave ){
    legajo=leg;
    nombre=nom;
    apellido=ape;
    this.dni=dni;
    this.calle=calle;
    numero=num;
    this.ciudad=ciudad;
    telefono=tel;
    usuario=usu;
    this.clave=clave;}
    //Modificadores
    public void setNombre(String nom){
    nombre=nom;}
    public void setApellido(String ape){
    apellido=ape;}
    public void setDni(int dni){
    this.dni=dni;}
    public void setCalle(String calle){
    this.calle=calle;}
    public void setNumero(int num){
    numero=num;}
    public void setCiudad(String ciudad){
    this.ciudad=ciudad;}
    public void setTelefono(int tel){
    telefono=tel;}
    //Observadores
    public String getNombre(){
    return nombre;    }
    public String getApellido(){
    return apellido;}
    public int getDni(){
    return dni;}
    public String getCalle(){
    return calle;}
    public int getNumero(){
    return numero;}
    public String getCiudad(){
    return ciudad;}
    public int getTelefono(){
    return telefono;}
    
    
    
    
}
