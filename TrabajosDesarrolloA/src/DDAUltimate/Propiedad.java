package DDAUltimate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Walter
 */
public class Propiedad {
    private int codigo;
    private char tipo;
    private int cantAmbientes;
    private char operacion;
    private int superficie;
    private boolean disponibilidad;
    private int precio;
    private String direccion;
    
    public Propiedad(int codigo){
    this.codigo = codigo;
    }
    public Propiedad(int cod, char tipo, String direccion, int cAmb, char op, int sup, boolean disp, int pr){
    codigo= cod;
    this.tipo = tipo;
    this.direccion=direccion;
    cantAmbientes=cAmb;
    operacion=op;
    superficie=sup;
    disponibilidad=disp;
    precio=pr;
    
    }
    public void setTipo(char tipo){
    this.tipo=tipo;
    }
    public void setDireccion(String dir){
    direccion=dir;
    }
    public void setCantAmbientes(int cAmb){
    cantAmbientes=cAmb;}
    
    public void setOperaciones(char op){
    operacion=op;}
    public void setSuperficie(int sup){
    superficie=sup;}
    public void setDisponibilidad(boolean disp){
    disponibilidad=disp;
    }
    public void setPrecio(int pre){
    precio=pre;}

public int getCodigo(){
return codigo;
}
public char getTipo(){
return tipo;}
public String getDireccion(){
return direccion;}
public int getCantAmbiente(){
return cantAmbientes;}
public char getOperacion(){
return operacion;}
public int getSuperficie(){
return superficie;}
public boolean getDisponibilidad(){
return disponibilidad;}
public int getPrecio(){
return precio;}
public boolean equals(Propiedad p){
boolean aux=false;
    if (p.codigo==this.codigo) {
        aux=true;
        return aux;
    }
    else{return aux;}
}
public String toString(){
    String texto,aux;
    if (disponibilidad) {aux="Si";}
    else {aux="No";}
    texto="Codigo:"+codigo+
            " Tipo:"+tipo+
            " Direccion:"+direccion+
            " Cantidad de Ambientes:"+cantAmbientes+
            " Operacion:"+operacion+
            " Superficie:"+superficie+"m^2"+
            " Disponibilidad:"
            +aux+
            " Precio:"+precio;
    return texto;
    
}
}
