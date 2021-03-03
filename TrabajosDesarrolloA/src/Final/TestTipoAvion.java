/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Final;

/**
 *
 * @author Tomas Bascal
 */
public class TestTipoAvion {
    public static void main(String []arg){
        TipoAvion arr [] = new TipoAvion[9];
        cargarArr(arr);
        datos(arr,0);
        
    }
    public static void cargarArr(TipoAvion arr[]){
    //Carga un arreglo de 9 aviones
    arr[0]=new TipoAvion("Boing",747,350,24,100,true,4);
    arr[1]=new TipoAvion("Boing",737,300,34,70,false,6);
    arr[2]=new TipoAvion("Airbus",757,325,40,80,true,2);
    arr[3]=new TipoAvion("Boing",748,250,30,50,true,1);
    arr[4]=new TipoAvion("Airbus",647,70,10,38,false,14);
    arr[5]=new TipoAvion("Airbus",757,325,40,80,true,2);
    arr[6]=new TipoAvion("Boing",847,150,43,78,false,2);
    arr[7]=new TipoAvion("Airbus",742,100,24,90,true,2);
    arr[8]=new TipoAvion("Boing",747,350,24,100,true,4);
    }
    public static void datos(TipoAvion arr[],int pos){
        if (pos<arr.length) {
            //Si cumple con los requisitos pedidos entonces se imprime por pantalla
            if (cumpleCondicion(arr[pos])) {
                System.out.println(arr[pos].toString());
            }
        pos++;
        //Llamado recursivo
        datos(arr,pos);
        }
    }
    public static boolean cumpleCondicion(TipoAvion x){
    boolean valor=false;
    //Compara los requisitos con el "x" de TipoAvion, si los cumple entonces devuelve true
        if ((x.getMarca().equalsIgnoreCase("Boing")&& x.getAsiento()>=200)|| (x.getMarca().equalsIgnoreCase("Airbus") && x.getHrsAutonomia()>=10 && x.getLargo()<=70)) {
            valor=true;
        }
        return valor;
    }
}
