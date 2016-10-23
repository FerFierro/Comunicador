package com.escom.tt2016.comunicador;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

    //Este es mi base de datos sqlite
public class DBHelper  extends SQLiteOpenHelper{

    //Nombre de la base de datos
    public static final  String NAME_DATABASE="pictogramas.sqlite";
    private static final int DB_SHEME_VERSION=1;//Version de la DB por si hay una nueva version y haya que actualizar la BD


    //Context context Es una referencia a la Activity
    public DBHelper(Context context) {
        super(context, NAME_DATABASE, null,DB_SHEME_VERSION);
    }
    //este metodo se encarga de inicializar la base de datos, se ejecuta siempre cuando se crea la clase
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(DataBaseManagerCurso.CREATE_TABLE_PICTOGRAMA);

    }

    //metodo usado en el caso de que haga falta actualizar la version de la base de datos
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        //se elimina la veersion anterior de la tabla
        db.execSQL("DROP TABLE IF EXIST "+DataBaseManagerCurso.TABLE_PICTOGRAMA);
        //se crea la nueva version de la tabla
        onCreate(db);
    }

//Para cerrar la conexión de la base de datos
    public void close(){
      this.close();
    }



}
