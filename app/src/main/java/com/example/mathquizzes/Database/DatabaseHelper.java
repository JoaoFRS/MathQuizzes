package com.example.mathquizzes.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "UserDatabase";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public static final String TABELA_ADD = "TABELA_ADD";
    public static final String COLUNA_KEY_ADD= "ID_ADD";
    public static final String COLUNA_ADD_TOTAL_PLAYED = "ADD_TOTAL_PLAYED";
    public static final String COLUNA_ADD_RIGHT  = "ADD_RIGHT";
    public static final String COLUNA_ADD_WRONG = "ADD_WRONG";
    public static final String COLUNA_ADD_RIGHT_IN_A_ROW = "ADD_RIGHT_IN_A_ROW";

    public static final String TABELA_SUB = "TABELA_SUB";
    public static final String COLUNA_KEY_SUB= "ID_SUB";
    public static final String COLUNA_SUB_TOTAL_PLAYED = "SUB_TOTAL_PLAYED";
    public static final String COLUNA_SUB_RIGHT  = "SUB_RIGHT";
    public static final String COLUNA_SUB_WRONG = "SUB_WRONG";
    public static final String COLUNA_SUB_RIGHT_IN_A_ROW = "SUB_RIGHT_IN_A_ROW";

    public static final String TABELA_MULT = "TABELA_MULT";
    public static final String COLUNA_KEY_MULT= "ID_MULT";
    public static final String COLUNA_MULT_TOTAL_PLAYED = "MULT_TOTAL_PLAYED";
    public static final String COLUNA_MULT_RIGHT  = "MULT_RIGHT";
    public static final String COLUNA_MULT_WRONG = "MULT_WRONG";
    public static final String COLUNA_MULT_RIGHT_IN_A_ROW = "MULT_RIGHT_IN_A_ROW";

    public static final String TABELA_DIV = "TABELA_DIV";
    public static final String COLUNA_KEY_DIV= "ID_DIV";
    public static final String COLUNA_DIV_TOTAL_PLAYED = "DIV_TOTAL_PLAYED";
    public static final String COLUNA_DIV_RIGHT  = "DIV_RIGHT";
    public static final String COLUNA_DIV_WRONG = "DIV_WRONG";
    public static final String COLUNA_DIV_RIGHT_IN_A_ROW = "DIV_RIGHT_IN_A_ROW";

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABELA_ADD= "Create Table " + TABELA_ADD + "(" +COLUNA_KEY_ADD + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUNA_ADD_TOTAL_PLAYED + " INTEGER,"+ COLUNA_ADD_RIGHT + " INTEGER,"+
                COLUNA_ADD_WRONG + " INTEGER,"+ COLUNA_ADD_RIGHT_IN_A_ROW + " INTEGER)";

        String CREATE_TABELA_SUB= "Create Table " + TABELA_SUB + "(" +COLUNA_KEY_SUB + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUNA_SUB_TOTAL_PLAYED + " INTEGER,"+ COLUNA_SUB_RIGHT + " INTEGER," +
                COLUNA_SUB_WRONG + " INTEGER," + COLUNA_SUB_RIGHT_IN_A_ROW + " INTEGER)";

        String CREATE_TABELA_MULT= "Create Table " + TABELA_MULT + "(" +COLUNA_KEY_MULT + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUNA_MULT_TOTAL_PLAYED + " INTEGER," + COLUNA_MULT_RIGHT + " INTEGER," +
                COLUNA_MULT_WRONG + " INTEGER," + COLUNA_MULT_RIGHT_IN_A_ROW + " INTEGER)";

        String CREATE_TABELA_DIV= "Create Table " + TABELA_DIV + "("+ COLUNA_KEY_DIV + " INTEGER PRIMARY KEY AUTOINCREMENT,"+
                COLUNA_DIV_TOTAL_PLAYED + " INTEGER," + COLUNA_DIV_RIGHT + " INTEGER," +
                COLUNA_DIV_WRONG + " INTEGER," + COLUNA_DIV_RIGHT_IN_A_ROW + " INTEGER)";

        db.execSQL(CREATE_TABELA_ADD);
        db.execSQL(CREATE_TABELA_SUB);
        db.execSQL(CREATE_TABELA_MULT);
        db.execSQL(CREATE_TABELA_DIV);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS " + TABELA_ADD);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_SUB);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_MULT);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_DIV);
        onCreate(db);
    }
}
