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
public class ContextoRugbyCantidades {
    public static void main(String [] arg){
    int [][] rugby = new int[5][5];
    //Carga del arreglo principal
     for (int i = 0; i < rugby.length; i++) {
            System.out.println("Ingrese los alumnos de la escuela: "+escuela(i)+" Para la categoria: ");
            for (int j = 0; j < rugby[0].length; j++) {
                System.out.println(categoria(j));
                rugby[i][j] = TecladoIn.readInt();              
            }
        }
     menu(rugby);
    }
    
    //--------------MODULOS---------------
    
    public static void menu (int rugby [][]){
    char opcion;
        System.out.println("Elija la opcion deseada"
                + "a) Cantidad de grupos de más de 7 niños. ¿Qué porcentaje representa del total de grupos?\n" +
"b) Cantidad de alumnos por escuela. ¿Qué porcentaje representa del total?\n" +
"c) ¿Qué categorías y de qué escuela no llegan a armar un grupo de 7 para jugar un partido?\n" +
"d) Promedio de alumnos por categoría.\n" +
"e) El grupo más grande, indicando además la categoría y la escuela.\n" +
"f) El grupo más pequeño, indicando además la categoría y la escuela.");
        opcion = TecladoIn.readLineNonwhiteChar();
        switch (opcion){
            case 'a':sieteAlum(rugby);break;
            case'b': totalEsc(rugby);break;
            case'c':menorSieteAlum(rugby);break;
            case'd':promedioCategoria(rugby);break;
            case'e':masGrande(rugby);break;
            case'f':masChico(rugby);break;
            default : System.out.println("ERROR");
    
    }
    }
    //dice la cantidad de grupos con 7 o mas alumnos
    public static void sieteAlum(int rugby [][]){
        int siete = 0;
        for (int i = 0; i < rugby.length; i++) {
            for (int j = 0; j < rugby[0].length; j++) {
                if (rugby[i][j] >= 7) {
                    siete = siete+1;                    
                }
            }
        }
        System.out.println("La cantidad de grupos con mas o 7 alumnos son: "+siete);
        System.out.println("El porcentaje que representa es "+(siete*100)/(rugby.length*rugby[0].length) + "%");
      
    }
    //Cargo los nombres de las escuelas
    public static String escuela (int i){
    String [] escuela = new String [5];
        escuela [0]= "Los patos (Centenario)";
        escuela [1]="Marabunta (Cipolletti)";
        escuela [2]="RRC (Roca)";
        escuela [3]="NRC (Neuquen)";
        escuela [4]="ARC (Allen)";
      return escuela[i];
            
    }
    //Cargo los nombres de las categorias
    public static String categoria(int j){
    String [] categoria = new String [5];
    
    categoria[0] = "M4";
    categoria[1] = "M6";
    categoria[2] = "M7";
    categoria[3] = "M8";
    categoria[4] = "M10";
return categoria[j];
        
    
    
    }
    //Dice la cantidad de alumnos por escuela y calcula el porcentaje del total
    public static void totalEsc(int rugby [][]){
    int total = 0;
    int cadaEsc [] = new int [5];
    
    
        for (int i = 0; i < rugby.length; i++) {
            for (int j = 0; j < rugby[0].length; j++) {
                cadaEsc [i]= rugby[i][j] + cadaEsc[i];
            }
        total = total + cadaEsc[i];
        }
        for (int i = 0; i < cadaEsc.length; i++) {
            System.out.println("La escuela: "+escuela(i)+" tiene un total de: "+ cadaEsc[i]+"alumnos");
            System.out.println("El porcentaje que representa del total es: "+ (cadaEsc[i]*100)/total + "%");
        }    }
    //Dice cuales son las escuelas con menos de 7 alumnos
    public static void menorSieteAlum (int rugby[][]){
    
        for (int i = 0; i < rugby.length; i++) {
            for (int j = 0; j < rugby[0].length; j++) {
                if (rugby[i][j] < 7) {
                    System.out.println("La escuela: "+ escuela(i)+" de la categoria: "+categoria(j)+ " no alcanza la cantidad de jugadores necesarios");
                    
                }
            }
        }
    
    }
    //Dice el promedio de jugadores por cada categoria
    public static void promedioCategoria (int rugby [][]){
    int totalCat = 0;
        for (int j = 0; j < rugby.length; j++) {
            for (int i = 0; i < rugby[0].length; i++) {
                totalCat= rugby[i][j] + totalCat;
            }
            System.out.println("El promedio de alumnos de la categoria "+categoria(j)+" es de: "+totalCat/rugby[0].length );
            totalCat = 0;
        }
    
    }
    //Dice que escuela tiene el grupo de mayor tamaño y a que categoria pertenece
    public static void masGrande(int rugby[][]){
    int mayor = 0,guardarCat = 0,guardarEsc = 0;
        for (int i = 0; i < rugby.length; i++) {
            for (int j = 0; j < rugby[0].length; j++) {
                if (rugby[i][j]> mayor) {
                    mayor = rugby[i][j];
                    guardarEsc = i;
                    guardarCat = j;
                }
            }
        }
        System.out.println("El grupo mas grande posee: "+ mayor+" alumnos");
        System.out.println("Este grupo pertenece a la escuela: "+escuela(guardarEsc)+" y a la categoria: "+categoria(guardarCat));
    }
    //Dice que escuela tiene el grupo de menor tamaño y a que categoria pertenece
    public static void masChico(int rugby[][]){
    int menor = rugby[0][0],guardarCat = 0,guardarEsc = 0;
        for (int i = 0; i < rugby.length; i++) {
            for (int j = 0; j < rugby[0].length; j++) {
                if (rugby[i][j]< menor) {
                    menor = rugby[i][j];
                    guardarEsc = i;
                    guardarCat = j;
                }
            }
        }
        System.out.println("El grupo mas chico posee: "+ menor+" alumnos");
        System.out.println("Este grupo pertenece a la escuela: "+escuela(guardarEsc)+" y a la categoria: "+categoria(guardarCat));
    }
    //
}

