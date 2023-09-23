/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concurrentetp1;

/**
 *
 * @author tomasbascal
 */
public class ConcurrenteTP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Tecnico tec1 = new Tecnico();
        Tecnico tec2 = new Tecnico();
        Tecnico tec3 = new Tecnico();
        Tecnico tec4 = new Tecnico();
        tec1.setAntiguedad(15);
        tec2.setAntiguedad(11);
        tec3.setAntiguedad(3);
        tec4.setAntiguedad(8);

        Empleado array[] = {tec1,tec2,tec3,tec4};
        Empleado aux[] = verificarAntiguedades(array);

        for (int i = 0; i < aux.length; i++) {
            System.out.println( aux[i].toString());
        }
    }
    
    //sin casteo
    
    public static Empleado[] verificarAntiguedades(Empleado array[]){
        Empleado aux[] = new Empleado[array.length];
        Empleado resultado[] = null;
        int cont = -1;
        for(int i = 0; i<array.length;i++){
            if(array[i].getAntiguedad() > 10){
                cont++;
                aux[cont] = array[i];
            }
        }
        if(cont != -1){
            resultado= new Empleado[cont+1];
            for (int i = 0; i < array.length; i++) {
                if(aux[i] != null){
                    resultado[i]=aux[i];
                }
            }
        }
        return resultado;
    }

    
    //Casteo
    /*
    public static Empleado[] getListado(Object array[]){
        Empleado aux[] = new Empleado[array.length];
        ((Empleado)array[0]).getAntiguedad();
        for(){
            if(((Empleado)elem).getAntiguedad()){
                
            }
        }
        return aux;
    }*/
    
}
