/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;
import utiles.TecladoIn;
/**
 *
 * @author tbascal
 */
public class TpArreglosContexto1 {
    public static void main (String[]arg){    
        char opcion;
        String cod;
        System.out.println("ingrese su codigo");
        cod = TecladoIn.readLine();
        String [] arrCod = new String [cod.length()];
        String [] nuevoArr = new String [cod.length()*2];
        System.out.println("Ingrese la opcion desada:"
                + "a) Los dígitos calculados del CN");
        opcion = TecladoIn.readLineNonwhiteChar();        
        switch (opcion){        
            case 'a' : ejercicioA(cod,nuevoArr);               
        }               
    }
    public static void ejercicioA (String cod,String nuevoArr[]){
    int aux,aux2;
    aux =0;
    aux2=0;
        for (int i = 0; i < nuevoArr.length; i=i+2) {
         nuevoArr[i] =  (cod.charAt(aux)+"");
                 aux=aux+1;         
        }
        for (int i = 1; i < nuevoArr.length; i=i+2) {
            nuevoArr[i]= ((cod.charAt(aux2)+5)*3)+"" ;
                aux2=aux2+1;    ;
        }
        for (int i = 0; i < nuevoArr.length; i++) {
            System.out.print(nuevoArr[i]);
            System.out.print(" ");
        }
    }
}
