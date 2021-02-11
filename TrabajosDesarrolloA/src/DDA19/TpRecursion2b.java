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
public class TpRecursion2b {
    public static void main(String [] arg){
    int viejoNum,nuevoNum=0;
        System.out.println("ingrese el numero a invertir");
        viejoNum = TecladoIn.readLineInt();
        System.out.println(invertirNum(viejoNum,nuevoNum));
    
    }
    public static int invertirNum(int viejoNum,int nuevoNum){
    int inv=nuevoNum;
    
        if (viejoNum > 0) {
            inv = invertirNum(viejoNum/10, nuevoNum*10 + viejoNum%10);
        }
        return inv;
    
    }
}
