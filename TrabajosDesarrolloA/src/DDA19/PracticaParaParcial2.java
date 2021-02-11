/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

import utiles.TecladoIn;

/**
 *
 * @author Walter
 */
public class PracticaParaParcial2 {
    public static void main (String[]arg){
    String pal;
        System.out.println("Ingrese la palabra a invertir");
        pal=TecladoIn.readLine();
        System.out.println(invertir(pal));
        
    }
    public static String invertir(String pal){
    String aux;
    
        if (pal.length()== 1) {
            return pal;
        }
        else{
        return invertir(pal.substring(1))+ pal.charAt(0);
                }
       
    }
}
