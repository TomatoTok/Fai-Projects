/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lineales.dinamicas;

/**
 *
 * @author Walter
 */
public class Lista {

    private Nodo cabecera;

    public Lista() {
        this.cabecera=null;
    }

    public boolean insertar(Object nuevoElem, int pos) {
        boolean exito = true;
        if (pos < 1 || pos > this.longitud() + 1) {
            exito = false;
        } else {
            if (pos == 1) {
                //crea un nuevo nodo y se enlaza en la cabecera
                this.cabecera = new Nodo(nuevoElem, this.cabecera);
            } else {//avanza hasta el elemento en posicion pos-1
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos - 1) {
                    aux = aux.getEnlace();
                    i++;
                }

                //crea el nodo y lo enlaza
                Nodo nuevo = new Nodo(nuevoElem, aux.getEnlace());
                aux.setEnlace(nuevo);
            }
        }
        //Nunca hay error de lista llena, entonces devuelve true
        return exito;
    }

    public boolean eliminar(int pos) {
        boolean exito = true;
        //si la posicion no es correcta devuelve false
        if (pos < 1 || pos > longitud() ) {
            exito = false;
        } else {
            //si la posicion es 1 retorna la el enlace de la cabecera
            if (pos == 1) {
                this.cabecera = this.cabecera.getEnlace();
            } else {
                Nodo aux = this.cabecera;
                int i = 1;
                while (i < pos-1) {
                    aux = aux.getEnlace();
                    i++;
                }
                //enlaza el nodo de aux con el enlace de su proximo enlace
                aux.setEnlace(aux.getEnlace().getEnlace());
            }
        }
        return exito;
    }

    public boolean esVacia() {
        //verifica si esta vacia la lista
        boolean exito = false;
        if (this.cabecera == null) {
            exito = true;
        }
        return exito;
    }

    public int longitud() {
        //devuelve la longitud de la lista
        int tamanio = 0;
        Nodo aux = this.cabecera;
        while (aux != null) {
            tamanio = tamanio + 1;
            aux = aux.getEnlace();
        }
        return tamanio;
    }

    public Object recuperar(int pos) {
        Object elem;
        Nodo aux = this.cabecera;
        int i;
        if (pos < 1 || pos > longitud()) {
            //caso no valido retorna null
            elem = null;
        } else {
            //se mueve hasta posicion pos buscando el elemento
            i = 1;
            aux = this.cabecera;
            while (i < pos) {
                aux = aux.getEnlace();
                i++;
            }
            elem = aux.getElem();
        }
        return elem;
    }

    public int localizar(Object elem) {
        //localiza la posicion de un elemento dentro de la lista
        int pos = -1, i = 1;
        Nodo aux = this.cabecera;
        while (aux != null && pos == -1) {
            if (elem == aux.getElem()) {
                pos = i;
            }
            i++;
            aux = aux.getEnlace();
        }
        return pos;
    }

    public void vaciar() {
        //se vacia la lista gracias al garbageCollector de java
        this.cabecera = null;
    }

    public Lista clone() {
        //creo una lista nueva, le asigno un nuevo nodo con la cabecera
        Lista listaClon = new Lista();
//      Verifico que no este vacia la lista
        if(this.cabecera!=null){
            
        listaClon.cabecera = new Nodo(this.cabecera.getElem(), null);
        Nodo aux = this.cabecera.getEnlace(), aux2 = listaClon.cabecera;
        if(this.cabecera==null){}
        else{
//          copio cada uno de los enlaces
        while (aux != null) {
            aux2.setEnlace(new Nodo(aux.getElem(), null));
            aux = aux.getEnlace();
            aux2 = aux2.getEnlace();
        }}}
        return listaClon;
    }

    public String toString() {
        Nodo aux = this.cabecera;
        String cadena = "[";
        if (aux == null) {
            cadena = cadena + "Lista vacia]";
        } else {
            while (aux != null) {
                cadena = cadena + aux.getElem().toString() + ",";
                aux = aux.getEnlace();
            }
            cadena = cadena + "]";
        }
        return cadena;
    }
    
    //Ejercicio adicional 2.5 generarLista
    
    public Lista generarLista(Lista lis){
    Lista nueva= new Lista();
    Cola tramo= new Cola();
    int i = 1,longitud=lis.longitud();
//  La repetitiva while tiene como condicion longitud+2 para poder entrar al ultimo elemento de la lista
//  y poder guardarlo en "tramo"
    while(i<=longitud+2){
// recorro la lista del parametro hasta encontrar *
        if ( i==longitud+1 || lis.recuperar(i).equals('*')){
//      Genero la nueva lista con el tramo recuperado
            generarListaAux(nueva,tramo);
            tramo.vaciar();
        if (lis.longitud()>=i) {
//      esta sentencia me permite agregar los * menos en la ultima instancia
            nueva.insertar('*', nueva.longitud()+1);
        }
            i++;
        }
//      Sino a tramo le asigno lo que 
             tramo.poner(lis.recuperar(i));
             i++;
         }
    
    return nueva;    
    }
private static void generarListaAux(Lista nueva, Cola tramo){
    //Hace los llamados para generar la lista nueva
    agregarTramo(nueva,tramo);
    agregarTramoInvertido(nueva,tramo);
    agregarTramo(nueva,tramo);
}
private static void agregarTramo(Lista nueva,Cola tramo){
    //Inserta en la lista nueva el tramo original
    Cola aux = tramo.clone() ;
    while(!aux.esVacia()){
        nueva.insertar(aux.obtenerFrente(), nueva.longitud()+1);
        aux.sacar();
}
}
private static void agregarTramoInvertido(Lista nueva, Cola tramo){
    //Inserta en la lista nueva el tramo invertido
    Pila invertido= new Pila();
    Cola aux=tramo.clone();
//  primero apilo para generar el tramo invertido
    while(!aux.esVacia()){
        invertido.apilar(aux.obtenerFrente());
        aux.sacar();}
//      Luego se lo asigno a la lista nueva
    while(!invertido.esVacia()){
        nueva.insertar(invertido.obtenerTope(), nueva.longitud()+1);
        invertido.desapilar();
}    
}

public Lista obtenerMultiplo(int num){
return obtenerMultiploAux(num);
}
private Lista obtenerMultiploAux(int num){
Lista multiplo = new Lista();
int aux=1,pos=1;
Nodo posicion = this.cabecera;
    if (num > 0) {
      while(posicion!=null){
          if ((aux%num) == 0) {
              multiplo.insertar(posicion.getElem(),pos);
              pos++;
          }
          posicion=posicion.getEnlace();
          aux = aux+1;
      }  
    }
    return multiplo;
}
public void eliminarApariciones(Object elem){
eliminarAparicionesAux(elem);
}
private void eliminarAparicionesAux(Object elem){
while(this.cabecera.getElem() == elem){
    this.cabecera = this.cabecera.getEnlace();
}
Nodo aux=this.cabecera;
while(aux.getEnlace()!=null){
    if (aux.getEnlace().getElem() == elem) {
        aux.setEnlace(aux.getEnlace().getEnlace());
    }
    aux=aux.getEnlace();
}
}
public void agregarElem(Object nuevo, int x){
    agregarElemAux(nuevo,x);
}
private void agregarElemAux(Object nuevo,int x){
    Lista aux = new Lista();
    Nodo elem = new Nodo(x,null),lista=new Nodo (this.cabecera.getElem(),this.cabecera);
    int cont=1;
    aux.cabecera=elem;
    aux.cabecera.setEnlace(this.cabecera);
    Nodo otro = new Nodo(nuevo,null);
    while(lista!=null){
        if ((cont % x) ==0) {
            otro.setEnlace(lista.getEnlace());
            lista.setEnlace(otro);
            
        }
        lista=lista.getEnlace();
        cont++;
    }
    this.cabecera=aux.cabecera;
}
}
