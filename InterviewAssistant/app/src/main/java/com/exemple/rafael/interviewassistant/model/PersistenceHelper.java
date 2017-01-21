package com.exemple.rafael.interviewassistant.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rafael on 19/01/2017.
 */
public class PersistenceHelper extends SQLiteOpenHelper {

    public static final String NOME_BANCO =  "InterviewAssistant";
    public static final int VERSAO =  4;

    private static PersistenceHelper instance;

    private PersistenceHelper(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(InterviewedPersonEntity.SCRIPT_CREATE_PERSON);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(InterviewedPersonEntity.SCRIPT_DELECAO_TABELA);
        onCreate(db);
    }

    public static PersistenceHelper getInstance(Context context) {
        if(instance == null)
            instance = new PersistenceHelper(context);

        return instance;
    }
}
