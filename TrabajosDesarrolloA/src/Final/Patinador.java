/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Walter
 */
public class Patinador{
    
    private String apellido;
    private String nombre;
    private String documento;
    private int edad;
    private char categoria;
    
    public Patinador(){
         apellido="vacio";
        nombre="vacio";
        documento="vacio";
        edad=0;
        categoria= 'x';
    }
    public Patinador(String ape, String nom, String doc, int ed, char cat){
        apellido=ape;
        nombre=nom;
        documento=doc;
        edad=ed;
        categoria= cat;
    }
    
    public String getNombre(){
        return nombre;
    }
        public String getDocumento(){
        return documento;
    }
    public char getCat(){
    return categoria;}
    
    public void setNombre(String nom){
        nombre=nom;
    }
    public String toString(){
    String aux;
    aux= "nombre: "+ nombre +" Apellido: " + apellido+ " documento: "+ documento+ " edad: "+edad + " categoria: "+categoria;
    return aux;}
    public boolean equals(Patinador f){
        boolean aux=true;
        if (this.documento != f.getDocumento()) {
            aux=false;
        }
        return aux;
    }
    public void asiende(){
        if (categoria == 'p') {
            categoria='i';
        }else{if (categoria == 'i') {
            categoria='c';
        }
        else{if (categoria == 'c') {
            categoria='b';
        }
        else{ if (categoria == 'b') {
            categoria='a';
        }}}}
        
        
       
    }
}
