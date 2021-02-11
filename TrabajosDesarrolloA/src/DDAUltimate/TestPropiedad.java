/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDAUltimate;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class TestPropiedad {
    public static void main(String []arg){
    
    Propiedad prop;
    prop=cargarDatos();
    char opcion=' ';
    int cont=0;
    while(opcion != 'x'){
        menu();
        opcion=TecladoIn.readLineNonwhiteChar();
    switch(opcion){
        case 'a' :listar(prop);break;
        case 'b' :verificarCasa(prop);break;
        case 'c' :verificarDepto(prop);break;
        case 'x': System.out.println("Adios");break;
    default : System.out.println("Error");break;
    }}
    
    }
    public static void menu(){
        System.out.println("-----------------------------------");
        System.out.println("ELIJA UNA OPCION (x para salir)");
        System.out.println("a)Lista de Datos");
        System.out.println("b)Verificar la casa");
        System.out.println("c)Verificar departamento");
    }
public static Propiedad cargarDatos(){
int cod,cantAmb,sup,prec;
char tip=' ',oper=' ',aux,aux2;
String dir;
boolean dis;
    System.out.println("Ingrese el codigo");
    cod=TecladoIn.readInt();
    while(tip!='c' && tip != 'd' && tip!='x'){
    System.out.println("Ingrese el tipo (c-casa, d-departamento o x-duplex)");
tip=TecladoIn.readLineNonwhiteChar();
        if (tip!='c' && tip != 'd' && tip!='x') {
            System.out.println("Error, ingrese de nuevo el tipo");
        }
}
    System.out.println("Ingrese la direccion");
dir=TecladoIn.readLine();
    System.out.println("Ingrese la cantidad de ambientes");
cantAmb=TecladoIn.readInt();
while(oper!='v' && oper != 'a' && oper!='t'){
    System.out.println("Ingrese la operacion(v-venta, a-alquiler o t-alquiler temporario)");
 oper=TecladoIn.readLineNonwhiteChar();}
 if (oper!='v' && oper != 'a' && oper!='t') {
        System.out.println("No es valida la opcion");
    }
    System.out.println("Ingrese la superficie");
sup=TecladoIn.readInt();
    System.out.println("Ingrese la disponibilidad (s/n)");
    aux=TecladoIn.readLineNonwhiteChar();
    if (aux=='s') {
        dis=true;
    }else{dis=false;}
    System.out.println("Ingrese el precio");
prec=TecladoIn.readLineInt();
Propiedad a =new Propiedad(cod,tip,dir,cantAmb,oper,sup,dis,prec);
return a;
}
public static void listar(Propiedad a){
    System.out.println(a.toString());}
public static void verificarCasa(Propiedad a){
    if (a.getTipo()=='c' && a.getSuperficie() >= 100&& a.getDisponibilidad()==true && a.getOperacion()=='v') {
        System.out.println("La casa es mayor a 100m^2, esta disponible y está a la venta. ");
    }
    else{System.out.println("Esta casa no cumple con las condiciones");}
}
public static void verificarDepto(Propiedad a){
    if (a.getTipo()=='d' && a.getCantAmbiente()==1 && a.getPrecio()< 20000) {
        System.out.println("Este departamento cumple con las condiciones requeridas");
    }
    else{System.out.println("Este departamento no cumple con las condiciones requeridas");}
}
}
        

