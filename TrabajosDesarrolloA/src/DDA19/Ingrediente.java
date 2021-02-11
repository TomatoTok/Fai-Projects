/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DDA19;

/**
 *
 * @author Walter
 */
public class Ingrediente {

    //Declaro la clase con sus atributos
   

        private String ingrediente, unidadDeMedida;
        private double cantidad;
        //Constructor

        public Ingrediente() {
            ingrediente = null;
            cantidad = 0;
            unidadDeMedida = null;

        }
        //Metodo obvservador

        public String getIngrediente() {
            return this.ingrediente;
        }

        public double getCantidad() {
            return this.cantidad;
        }

        public String getUnidadDeMedida() {
            return this.unidadDeMedida;
        }
        //Metodos Modificadores

        public void setIngrediente(String ing) {
            this.ingrediente = ing;

        }

        public void setCantidad(double cant) {
            this.cantidad = cant;
        }

        public void setUnidadDeMedida(String umd) {
            this.unidadDeMedida = umd;
        }

        public void MuestraIngredientes() {

            System.out.println("Ingrediente:" + this.ingrediente);
            System.out.println("Cantidad: " + this.cantidad);
            System.out.println("Unidad de Medida: " + this.unidadDeMedida);

        }

    
    public boolean equals(Ingrediente al) {
        return unidadDeMedida.equals(ingrediente);
    }
     
    }


