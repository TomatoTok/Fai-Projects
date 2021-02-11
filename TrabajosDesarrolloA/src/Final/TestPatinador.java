/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TestPatinador {
    public static void main (String []arr){
    Patinador arrPat [] = new Patinador [6];
    carga(arrPat);
    char opc=' ';
    while(opc != 'x'){
        System.out.println("Ingrese una opcion:");
        System.out.println("a) Mostrar los Patinadores");
        System.out.println("b) Mostrar los datos de los patinadores de una categoria");
        System.out.println("c) Aumentar la categoria de un patinador");
        System.out.println("x) Salir");
        opc=TecladoIn.readLineNonwhiteChar();
    switch(opc){
        case 'a' : mostrarPat(arrPat);break;
        case 'b' : mostrarCat(arrPat);break;
        case 'c' : cambiarCat(arrPat);break;
        default: System.out.println("Gracias por utilizar el programa");break;
    
    }}}
    public static void carga(Patinador arrPat[]){
    arrPat[0] = new Patinador("Bascal","Tomas","40927208",21,'i');
    arrPat[1] = new Patinador("Lopez","jose","4536400",23,'c');
    arrPat[2] = new Patinador("Marselo","hernan","4073234",14,'c');
    arrPat[3] = new Patinador("Eche","camila","4095540",13,'a');
    arrPat[4] = new Patinador("Ricker","agustina","4123000",16,'b');
    arrPat[5] = new Patinador("Flaflu","Joker","4224450",20,'i');
    }
    public static void mostrarPat(Patinador arrPat[]){
        for (int i = 0; i < arrPat.length; i++) {
            System.out.println(arrPat[i].toString());
        }
}
    public static void mostrarCat(Patinador arrPat[]){
    char aux;
        System.out.println("Ingrese la categoria a buscar");
        aux = TecladoIn.readChar();
        for (int i = 0; i < arrPat.length; i++) {
            if (aux == arrPat[i].getCat()) {
                System.out.println(arrPat[i].toString());
            }
        }
    }
    public static void cambiarCat(Patinador arrPat[]){
    String aux;
    int x=0;
    boolean band=false;
        System.out.println("Ingrese el documento a subir de categoria");
        aux= TecladoIn.readLine();
    while (!band && x<arrPat.length){
        if (arrPat[x].getDocumento().equalsIgnoreCase(aux)) {
            arrPat[x].asiende();
            band = true;
        }
        x=x+1;
    }}
    
}
