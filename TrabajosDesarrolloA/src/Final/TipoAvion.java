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
public class TipoAvion {
    //Atributos
    private String marca;
    private int modelo;
    private int asiento;
    private int hrsAutonomia;
    private int largo;
    private boolean trasatlantico;
    private int cantidadEjemplares;
    
    //Constructores
    public TipoAvion(){}
    public TipoAvion(String marc, int mod, int as, int hrs, int largo, boolean trasatl, int cantEj){
    marca=marc;
    modelo=mod;
    asiento=as;
    hrsAutonomia=hrs;
    this.largo=largo;
    trasatlantico=trasatl;
    cantidadEjemplares=cantEj;
        }
    
    //Metodos Observadores

    public String getMarca() {
        return marca;
    }

    public int getModelo() {
        return modelo;
    }

    public int getAsiento() {
        return asiento;
    }

    public int getHrsAutonomia() {
        return hrsAutonomia;
    }

    public int getLargo() {
        return largo;
    }

    public boolean isTrasatlantico() {
        return trasatlantico;
    }
    //Metodos Modificadores

    public void setAsiento(int asiento) {
        this.asiento = asiento;
    }

    public void setHrsAutonomia(int hrsAutonomia) {
        this.hrsAutonomia = hrsAutonomia;
    }

    public void setTrasatlantico(boolean trasatlantico) {
        this.trasatlantico = trasatlantico;
    }

    public void setCantidadEjemplares(int cantidadEjemplares) {
        this.cantidadEjemplares = cantidadEjemplares;
    }
    //Propias del tipo
    public boolean equals(TipoAvion x){
        boolean valor=false;
        //Comparo la marca y el modelo, si es verdadero entonces son iguales
        if (marca.equalsIgnoreCase(x.getMarca()) && modelo == x.getModelo()) {
            valor=true;
        }
        return valor;
    }
    public String toString(){
        //En caso de que se haya creado un avion pero aun no se le ha asignado valores devuelve un cartel
        String aux="Aun no hay asignado un avion";
        if (!(marca==null)) {
            //Si el avion existe entonces llama al metodo que describe la informacion en un String
           aux=toStringAux();
        }
        return aux;
    }
    private String toStringAux(){
        //Es un metodo privado por que el usuario no debe utilizar este metodo y queda reservado para la operacion interna
    String aux;
        aux="Marca: "+marca+"\n Modelo: "+modelo+"\n Cantidad de asientos: "+asiento+"\n Horas de autonomia: "
                + ""+hrsAutonomia+"\n Largo: "+largo+"\n Transatlantico: ";
        //Considera si el avion es trasatlantico
        if (trasatlantico) {
            aux=aux+"Si";
        }else{aux=aux+"No";}
        aux=aux+"\n Cantidad de Ejemplares: "+cantidadEjemplares;
    return aux;
    }
}
