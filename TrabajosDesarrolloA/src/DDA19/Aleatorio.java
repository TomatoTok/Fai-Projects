/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;
import java.util.Random;
/**
 *
 * @author Walter
 */
public class Aleatorio {

    private int numAle;
    private boolean gemelos;
    private boolean fibonacci;

    public Aleatorio() {
        int n1=0,n2=1;
        boolean corte=false;
        numAle = numRandom();
        gemelos = sonGemelos(numAle);
        fibonacci = serieFib(numAle,n1,n2,corte);
    }

    public int getNum() {
        return numAle;
    }

    public void setNum(int num) {
        numAle = num;
    }

    public void setGem(boolean val) {
        gemelos = val;
    }

    public void setFib(boolean val) {
        fibonacci = val;
    }

    public boolean equals(Aleatorio o) {
        boolean aux = false;
        if (gemelos == o.gemelos && fibonacci == o.fibonacci && numAle == o.numAle) {
            aux = true;
        }
        return aux;
    }

    public String toStringAle() {
       String aux;
       aux = "Numero: " + numAle;
        
        if (gemelos) {
            aux= aux +" Digitos gemelos: Si ";
        } else {
            aux=aux+(" Digitos gemelos: No ");
        }
        if (fibonacci) {
            aux = aux + (" Serie Fibonacci: Si ");
        } else {
            
                aux=aux+(" Serie Fibonacci: no ");
            
        }
        return aux;
    }

    public int compararCon(Aleatorio o) {
        String aux, aux2;
        int aux3;
        aux = String.valueOf(this.numAle);
        aux2 = String.valueOf(o.numAle);
        aux3 = aux.compareTo(aux2);
        return aux3;
    }

    public boolean sonGemelos(int num) {
        int aux = (num % 100 - num % 10)/10;
        boolean corte = false;
        if (num > 9) {
            if (!corte && aux == num % 10) {
                corte = true;
                return corte;
            } else {
                sonGemelos(num / 10);
            }
        }
        return corte;
    }

    public Aleatorio clonar(Aleatorio obj) {
        Aleatorio nuevoObj = new Aleatorio(); //ESTA BIEN ASI? COMO CONSTRUCTOR?
        obj.numAle=this.numAle;        
        obj.gemelos = this.gemelos;
        obj.fibonacci=this.fibonacci;
        return nuevoObj;
    }

    public boolean serieFib(int num,int n1, int n2,boolean corte) {
        int aux;
        
        if (!corte && n1<=num) {
            if (num == n1 || num == n2) {
            corte=true;
            return corte;
        }
        else{   aux=n1;
                n1=n2;
                n2=aux+n1;
                corte = serieFib(num,n1,n2,corte);
        }
        }
               
        return corte;
    }
    
    public int numRandom(){
    int aux;
    Random Aleatorio = new Random();
    aux = Aleatorio.nextInt(100) ;
    return aux;
    }
}
