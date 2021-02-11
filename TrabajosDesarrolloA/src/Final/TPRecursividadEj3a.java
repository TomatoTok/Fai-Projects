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
public class TPRecursividadEj3a {
    public static void main (String []arg){
        char opc = ' ',x;
        int i=0;
        int arrN [] = new int [5];
        char arrC[] = new char [5];
        String arrP[]=new String [5];
        carga(arrN,arrC,arrP);
        System.out.println("Ingrese la opcion");
        System.out.println("a) Encuentra el mayor");
        System.out.println("b) Busca un caracter");
        System.out.println("c) Muestra la primera letra y longitud de la palabra");
        System.out.println("x) Para salir");
        opc=TecladoIn.readLineNonwhiteChar();
        switch(opc){
            case 'a':   System.out.println("El mayor numero es: "+mayor(arrN,i));break;
            case 'b':   System.out.println("Ingrese el caracter");x=TecladoIn.readLineNonwhiteChar();                       
                        if (pertenece(arrC,i,x)) {System.out.println("El caracter se encuentra en el arreglo");
                        }else{System.out.println("El caracter no se encuentra en el arreglo");}break;
            case 'c':   palabras(arrP,i);break;
            default :   System.out.println("Gracias por utilizar el programa bomboon!!");System.out.println(" (shh que no se enteren los otros ;v)");break;
                        
        }
    }
    public static void carga(int arrN [],char arrC [],String arrP[]){
    arrN[0]=3;arrN[1]=5;arrN[2]=2;arrN[3]=4;arrN[4]=0;
    arrC[0]='x';arrC[1]='g';arrC[2]='v';arrC[3]='r';arrC[4]='h';
    arrP[0]="buenas";arrP[1]="tardes";arrP[2]="como";arrP[3]="le";arrP[4]="va";
    }
    public static int mayor(int arrN[],int i){
    int n=0;
       if(i== arrN.length-1){n=arrN[i];}
       else{
           n=mayor(arrN,i+1);
           if (n<arrN[i]) {
               n=arrN[i];
           }
       
       }        
        return n;
    }
    public static boolean pertenece(char arrC[],int i,char x){
    boolean band=false;
        if (i==arrC.length-1) {
            if (arrC[i]==x) {
                band=true;
            }
        }
        else{if (arrC[i]==x) {
                band= true;
            }else{if (i<arrC.length) {
               band= pertenece(arrC,i+1,x);  
            }
           
        }
}
   return band;
    }
    public static void palabras(String arrP[],int i){
        if (i==arrP.length-1) {
            System.out.println("Primer letra:"+arrP[i].charAt(0)+" Longitud:"+arrP[i].length());    

        }
        else{
            palabras(arrP,i+1);
            System.out.println("Primer letra:"+arrP[i].charAt(0)+" Longitud:"+arrP[i].length());    
        }
    }
}
