package com.escom.tt2016.comunicador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Angel on 22/10/2016.
 */

public class DataBaseManagerCurso extends DataBaseManager{

    //Nombre de la tabla pictograma
    public static final  String TABLE_PICTOGRAMA="pictograma";


    //SNombre de los campos de la tabla usuarios
    public static final  String ID="idPictograma";
    public static final  String NOMBRE="nombre";
    public static final  String CATEGORIA="categoria";
    public static final  String ID_DRAWABLE="idDrawable";



    //sentencia para crear la tabla pictograma

    public static final String CREATE_TABLE_PICTOGRAMA="CREATE TABLE "+ TABLE_PICTOGRAMA+" ("
            + ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + NOMBRE +" TEXT NOT NULL,"
            + CATEGORIA +" TEXT NOT NULL,"
            + ID_DRAWABLE +" INTEGER );";



    public DataBaseManagerCurso(Context context) {
        super(context);
    }

    public void cerrar(){
        super.getDb().close();
    }

    private ContentValues generarContentValues(String id, String nombre, String categoria, int idDrawable) {
        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, nombre);
        valores.put(CATEGORIA, categoria);
        valores.put(ID_DRAWABLE, idDrawable);


        return valores;
    }

    @Override
    void insertar_parametros(String id, String nombre, String categoria, int idDrawable) {
        Log.d("curso_insertar",super.getDb().insert(TABLE_PICTOGRAMA,null,generarContentValues(id,nombre,categoria,idDrawable))+ "");

    }


    @Override
    void actualizar_parametros(String id, String nombre, String categoria, int idDrawable) {
        ContentValues valores = new ContentValues();
        valores.put(ID, id);
        valores.put(NOMBRE, nombre);
        valores.put(CATEGORIA, categoria);
        valores.put(ID_DRAWABLE, idDrawable);

        String [] args= new String[]{id};


        Log.d("cursos_actualizar", super.getDb().update(TABLE_PICTOGRAMA, valores, "_id=?", args)+"");


    }

    @Override
    public void eliminar(String id) {
        super.getDb().delete(TABLE_PICTOGRAMA, ID + "=?", new String[]{id});

    }

    @Override
    public void eliminarTodo() {
        super.getDb().execSQL("DELETE FROM "+ TABLE_PICTOGRAMA+";");
        Log.d("cursos_eliminar", "Datos borrados");

    }

    @Override
    public Cursor cargarCursor() {
        String [] columnas= new String[]{ID, NOMBRE, CATEGORIA, ID_DRAWABLE};


        return super.getDb().query(TABLE_PICTOGRAMA,columnas,null,null,null,null,null );
    }

    @Override
    Boolean compruebaRegistro(String id) {
        boolean esta=true;

        Cursor resultSet= super.getDb().rawQuery("Select * from " + TABLE_PICTOGRAMA + " WHERE " + ID + "=" + id, null);

        if(resultSet.getCount()<=0)
            esta=false;
        else
            esta=true;

        return esta;
    }

    public List<Pictograma> getCursosList(){
        List<Pictograma> list= new ArrayList<>();

        Cursor c= cargarCursor();


        while (c.moveToNext()){
            Pictograma mi_pictograma = new Pictograma();

            mi_pictograma.setId(c.getString(0));
            mi_pictograma.setNombre(c.getString(1));
            mi_pictograma.setCategoria(c.getString(2));
            mi_pictograma.setIdDrawable(c.getInt(3));

            list.add(mi_pictograma);
        }

        return list;

    }

   /* public void addPictograma(String nombre,String categoria,int idDrawable){
        try {
            if (db !=null){
                ContentValues values =new ContentValues();//creamos un objeto de esta clase
                values.put(NOMBRE,nombre);//especificamos que el siguiente dato que venga lo agregue a la columna NOMBRE
                values.put(CATEGORIA,categoria);
                values.put(ID_DRAWABLE,idDrawable);
            }db.close();
        }catch (SQLiteException e){
            Log.e("error BD",e.toString());
        }
    }

    public ArrayList getAllPictogramas(){

        ArrayList<Pictograma> pictogramas=new ArrayList<Pictograma>();
        Pictograma pic=new Pictograma();
        if (db !=null){
            Cursor c=db.rawQuery("SELECT * FROM "+TABLE_PICTOGRAMA,null);
            if (c.moveToFirst()){
                //recorremos el cursor hasta que no haya mas registros
                do{
                    pic.setNombre(c.getString(1));
                    pic.setCategoria(c.getString(2));
                    pic.setIdDrawable(c.getInt(3));
                    pictogramas.add(pic);
                }while(c.moveToNext());
            }
        }
        db.close();
        return pictogramas;
    }*/

}

