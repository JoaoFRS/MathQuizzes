package com.example.mathquizzes.Database.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Database.Models.MultOperationModel;

public class MultOperationController {
    DatabaseHelper database;


    public MultOperationController(DatabaseHelper databse) {
        this.database = databse;
    }

    public void insertMultOperation(MultOperationModel multOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_MULT, multOperationModel.getMult_lvl());
        values.put(DatabaseHelper.COLUNA_MULT_TOTAL_PLAYED,multOperationModel.getMult_total());
        values.put(DatabaseHelper.COLUNA_MULT_RIGHT,multOperationModel.getMult_right());
        values.put(DatabaseHelper.COLUNA_MULT_WRONG,multOperationModel.getMult_wrong());
        values.put(DatabaseHelper.COLUNA_MULT_RIGHT_IN_A_ROW,multOperationModel.getMult_right_in_a_row());


        db.insert(DatabaseHelper.TABELA_MULT, null, values);
        db.close();
    }

    public void updateMultOperation(MultOperationModel multOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_MULT, multOperationModel.getMult_lvl());
        values.put(DatabaseHelper.COLUNA_MULT_TOTAL_PLAYED,multOperationModel.getMult_total());
        values.put(DatabaseHelper.COLUNA_MULT_RIGHT,multOperationModel.getMult_right());
        values.put(DatabaseHelper.COLUNA_MULT_WRONG,multOperationModel.getMult_wrong());
        values.put(DatabaseHelper.COLUNA_MULT_RIGHT_IN_A_ROW,multOperationModel.getMult_right_in_a_row());
        db.update(DatabaseHelper.TABELA_MULT, values, DatabaseHelper.COLUNA_KEY_MULT + "=?", new String[]{String.valueOf(multOperationModel.getMult_lvl())});
    }

    public void deleteMultOperation(MultOperationModel multOperationModel) {

        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(DatabaseHelper.TABELA_MULT, DatabaseHelper.COLUNA_KEY_MULT + "=?", new String[]{String.valueOf(multOperationModel.getMult_lvl())});

        db.close();
    }

    public MultOperationModel getMultOperation(int lvl){
        SQLiteDatabase db = database.getReadableDatabase();

        String selection = DatabaseHelper.COLUNA_KEY_MULT + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(lvl)};

        Cursor cursor = db.query(DatabaseHelper.TABELA_MULT, null, selection,  selectionArgs, null, null, null);

        if (cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
        }

        MultOperationModel multOperationModel=new MultOperationModel();
        multOperationModel.setMult_lvl(cursor.getInt(0));
        multOperationModel.setMult_total(cursor.getInt(1));
        multOperationModel.setMult_right(cursor.getInt(2));
        multOperationModel.setMult_wrong(cursor.getInt(3));
        multOperationModel.setMult_right_in_a_row(cursor.getInt(4));
        db.close();
        cursor.close();
        return multOperationModel;
    }
    public String[] getAllMultPlayed(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_MULT_TOTAL_PLAYED + " from "+ DatabaseHelper.TABELA_MULT +" WHERE ID_MULT > 0", null);
        String[] s=new String[cursor.getCount()];
        int index=0;
        if (cursor.moveToFirst()) {
            do {
                s[index]=String.valueOf(cursor.getInt(0));
                index++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return s;
    }
    public String[] getAllMultRight(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_MULT_RIGHT + " from "+ DatabaseHelper.TABELA_MULT +" WHERE ID_MULT > 0", null);
        String[] s=new String[cursor.getCount()];
        int index=0;
        if (cursor.moveToFirst()) {
            do {
                s[index]=String.valueOf(cursor.getInt(0));
                index++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return s;
    }

    public String[] getAllMultWrong(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_MULT_WRONG + " from "+ DatabaseHelper.TABELA_MULT +" WHERE ID_MULT > 0", null);

        String[] s=new String[cursor.getCount()];
        int index=0;
        if (cursor.moveToFirst()) {
            do {
                s[index]=String.valueOf(cursor.getInt(0));
                index++;
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return s;
    }
}
