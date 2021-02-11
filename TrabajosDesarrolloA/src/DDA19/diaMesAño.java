/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

/**
 *
 * @author Walter
 */
public class diaMesAño {
    //ATRIBUTOS
    private int dia,mes,año;
    //CONSTRUCTOR
    public diaMesAño (int d,int m,int a){
    
    dia = d;
    mes = m;
    año = a;
    
    }
    //OBSERVADOR
    public int getDia(){
    return dia;
    }
    public int getMes(){
    return mes;
}
    public int getAño(){
    return año;}
    //MODIFICADOR
    public void setDia(int d){
    dia=d;
    }
    public void setMes(int m){
    mes=m;
    }
    public void setAño(int a ){
    año = a;
    }
    //PROPIAS DEL TIPO
    public int diasTranscurridos(int dtrans){
    int total;
    total= 365 - dtrans;
        return total;
    }
    public boolean esFechaAnterior(diaMesAño fecha1){
        boolean aux;
        aux=false;
      if (dia < fecha1.dia)   {
            if (mes < fecha1.mes) {
                if (año < fecha1.año) {
                    aux = true;
                }
            }
        }
      else{
      aux = false;}
    return aux;
    }
}
