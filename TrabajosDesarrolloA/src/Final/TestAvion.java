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
public class TestAvion {
    public static void main (String []arg){
    
    Avion arrA [] = new Avion [10];
    int cont=3;
    char opc=' ';
    carga(arrA);
    while(opc != 'x'){
        System.out.println("Elija una opcion:");
        System.out.println("a) Cargar un avion");
        System.out.println("b) Verificar que avion tiene mayor velocidad promedio");
        System.out.println("c) La cantidad de asintos promedio");
        System.out.println("d) Ver todos los aviones");
        System.out.println("x) Salir");
        opc=TecladoIn.readLineNonwhiteChar();
    switch(opc){
        case 'a' : cargarAvion(arrA,cont);cont++;break;
        case 'b' : mayorVel(arrA,cont);break;
        case 'c' : asientoProm(arrA,cont);break;
        case 'd' : mostrar(arrA,cont);break;
        default : System.out.println("Gracias por usar esto chabon me haces tan feliz!!");break;}
    }
    
    }
    
    public static void carga(Avion arrA[]){
    arrA[0] = new Avion("Av-k12",3500,250,400);
    arrA[1] = new Avion("Av-k53",5000,150,450);
    arrA[2] = new Avion("Av-k32",20000,500,350);
    }
    
    public static void cargarAvion(Avion arrA[],int cont){
    
        String mod;
        int km, asiento,velP;
        
        System.out.println("Ingrese el Modelo del avion");
        mod = TecladoIn.readLine();
        System.out.println("Ingrese los kilometros recorridos");
        km= TecladoIn.readInt();
        System.out.println("Ingrese la cantidad de asientos");
        asiento = TecladoIn.readInt();
        System.out.println("Ingrese la velocidad promedio");
        velP=TecladoIn.readInt();
        
        arrA[cont] = new Avion(mod,km,asiento,velP);
        
    }
    public static void mayorVel(Avion arrA[],int cont){
    Avion aux;
    aux = new Avion("null",0,0,0);
        for (int i = 0; i < cont; i++) {
            if (aux.getVelProm() < arrA[i].getVelProm()) {
                aux=arrA[i];
            }
        }
        System.out.println(aux.toString());
    }
    public static void asientoProm(Avion arrA[],int cont){
    int aux=0;
        for (int i = 0; i < cont; i++) {
            aux=aux+arrA[i].getcantA();
        }
        
        System.out.println("El promedio de la cantidad de asientos es de: "+(aux)/cont);
    }
    public static void mostrar(Avion arrA[],int cont){
        for (int i = 0; i < cont; i++) {
            System.out.println(arrA[i].toString());
        }
    }
}
