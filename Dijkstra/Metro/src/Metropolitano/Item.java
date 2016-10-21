/*
 * Item.java
 *
 * Created on 20 de abril de 2007, 12:16
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package Metropolitano;

/**
 *
 * @author Alberto
 */
public class Item implements Comparable{
    public int origen;
    public int destino;
    public int peso;
    /** Creates a new instance of Item */
    public Item() {
        origen = 0;
        destino = 0;
        peso = 0;
    }
    public Item(int o, int d, int p) {
        origen = o;
        destino = d;
        peso = p;
    }
    public int getPeso(){
        return peso;
    }

    public int compareTo(Object otroItem) {
        int otroItemPeso = ((Item) otroItem).getPeso();
        return this.peso - otroItemPeso;
    }
}
