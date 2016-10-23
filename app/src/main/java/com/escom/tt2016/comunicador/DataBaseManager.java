package com.escom.tt2016.comunicador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Angel on 21/10/2016.
 */

public abstract class DataBaseManager {
    private DBHelper helper;
    private SQLiteDatabase db;

    //Metodo de Inicializacion
    public DataBaseManager(Context context){
        helper=new DBHelper(context);
        db=helper.getWritableDatabase();
    }

    //getters y setters
    public DBHelper getHelper() {
        return helper;
    }

    public void setHelper(DBHelper helper) {
        this.helper = helper;
    }

    public SQLiteDatabase getDb() {
        return db;
    }

    public void setDb(SQLiteDatabase db) {
        this.db = db;
    }





    abstract void insertar_parametros(String id, String nombre, String categoria, int idDrawable);
    abstract void actualizar_parametros(String id, String nombre, String categoria, int idDrawable);


    abstract public void eliminar(String id);
    abstract public void eliminarTodo();
    abstract public Cursor cargarCursor();
    abstract Boolean compruebaRegistro(String id);

    public void cerrar(){
        db.close();
    }



}
