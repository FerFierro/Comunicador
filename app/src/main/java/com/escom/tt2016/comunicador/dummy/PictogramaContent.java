package com.escom.tt2016.comunicador.dummy;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.escom.tt2016.comunicador.Pictograma;
import com.escom.tt2016.comunicador.R;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class PictogramaContent extends Pictograma{

    /**
     * An array of sample (dummy) items.
     */
    public static final List<Pictograma> ITEMS = new ArrayList<Pictograma>();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, Pictograma> ITEM_MAP = new HashMap<String,Pictograma>();



    static {
        // Add some sample items.

        agregarItem(new Pictograma("1","gato","objetos",R.drawable.ic_pictograma_vaca));
        agregarItem(new Pictograma("2","carro","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("3","pez","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("4","zapato","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("5","juan","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("6","Andrea","objetos",R.drawable.ic_pictograma_vaca));

        agregarItem(new Pictograma("1","gato","objetos",R.drawable.ic_pictograma_vaca));
        agregarItem(new Pictograma("2","carro","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("3","pez","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("4","zapato","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("5","juan","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("6","Andrea","objetos",R.drawable.ic_pictograma_vaca));

        agregarItem(new Pictograma("1","gato","objetos",R.drawable.ic_pictograma_vaca));
        agregarItem(new Pictograma("2","carro","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("3","pez","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("4","zapato","objetos",R.drawable.ic_pictograma_buho));
        agregarItem(new Pictograma("5","juan","objetos",R.drawable.ic_pictograma_conejo));
        agregarItem(new Pictograma("6","Andrea","objetos",R.drawable.ic_pictograma_vaca));
    }

    public PictogramaContent(String id, String nombre, String categoria, int idDrawable) {
        super(id, nombre, categoria, idDrawable);
    }


    private static void agregarItem(Pictograma item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    /**
     * A dummy item representing a piece of content.

    public static class Pictograma {
        public String id;
        public String nombre;
        public String categoria;
        public int idDrawable;


        public Pictograma(String id, String nombre, String categoria, int idDrawable) {
            this.id = id;
            this.nombre = nombre;//titulo
            this.categoria = categoria;
            this.idDrawable = idDrawable;
        }

        @Override
        public String toString() {
            return nombre;
        }
    }*/
}
