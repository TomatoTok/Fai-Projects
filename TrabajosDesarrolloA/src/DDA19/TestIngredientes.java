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
public class TestIngredientes {

    public static void main(String[] arg) {
        Ingrediente i1 = new Ingrediente();
        String ing, umd;
        double cant;

        System.out.println("Ingrese el ingrediente");
        ing = TecladoIn.readLine();
        i1.setIngrediente(ing);
        System.out.println("Ingrese la cantidad: ");
        cant = TecladoIn.readDouble();
        i1.setCantidad(cant);
        System.out.println("Ingrese la medida");
        umd = TecladoIn.readLine();
        i1.setUnidadDeMedida(umd);

        i1.MuestraIngredientes();
        //System.out.println(i1.equals(i1));
              
        
    }

}
