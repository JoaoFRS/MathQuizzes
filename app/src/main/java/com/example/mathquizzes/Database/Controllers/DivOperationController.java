package com.example.mathquizzes.Database.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Database.Models.DivOperationModel;

public class DivOperationController {

    DatabaseHelper database;

    public DivOperationController(DatabaseHelper databse) {
        this.database = databse;
    }


    public void insertDivOperation(DivOperationModel divOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_DIV, divOperationModel.getDiv_lvl());
        values.put(DatabaseHelper.COLUNA_DIV_TOTAL_PLAYED,divOperationModel.getDiv_total());
        values.put(DatabaseHelper.COLUNA_DIV_RIGHT,divOperationModel.getDiv_right());
        values.put(DatabaseHelper.COLUNA_DIV_WRONG,divOperationModel.getDiv_wrong());
        values.put(DatabaseHelper.COLUNA_DIV_RIGHT_IN_A_ROW,divOperationModel.getDiv_right_in_a_row());


        db.insert(DatabaseHelper.TABELA_DIV, null, values);
        db.close();
    }

    public void updateDivOperation(DivOperationModel divOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_DIV, divOperationModel.getDiv_lvl());
        values.put(DatabaseHelper.COLUNA_DIV_TOTAL_PLAYED,divOperationModel.getDiv_total());
        values.put(DatabaseHelper.COLUNA_DIV_RIGHT,divOperationModel.getDiv_right());
        values.put(DatabaseHelper.COLUNA_DIV_WRONG,divOperationModel.getDiv_wrong());
        values.put(DatabaseHelper.COLUNA_DIV_RIGHT_IN_A_ROW,divOperationModel.getDiv_right_in_a_row());
        db.update(DatabaseHelper.TABELA_DIV, values, DatabaseHelper.COLUNA_KEY_DIV + "=?", new String[]{String.valueOf(divOperationModel.getDiv_lvl())});
    }

    public void deleteDivOperation(DivOperationModel divOperationModel) {

        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(DatabaseHelper.TABELA_DIV, DatabaseHelper.COLUNA_KEY_DIV + "=?", new String[]{String.valueOf(divOperationModel.getDiv_lvl())});

        db.close();
    }

    public DivOperationModel getDivOperation(int lvl){
        SQLiteDatabase db = database.getReadableDatabase();

        String selection = DatabaseHelper.COLUNA_KEY_DIV + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(lvl)};

        Cursor cursor = db.query(DatabaseHelper.TABELA_DIV, null, selection,  selectionArgs, null, null, null);

        if (cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
        }

        DivOperationModel divOperationModel=new DivOperationModel();
        divOperationModel.setDiv_lvl(cursor.getInt(0));
        divOperationModel.setDiv_total(cursor.getInt(1));
        divOperationModel.setDiv_right(cursor.getInt(2));
        divOperationModel.setDiv_wrong(cursor.getInt(3));
        divOperationModel.setDiv_right_in_a_row(cursor.getInt(4));
        db.close();
        cursor.close();
        return divOperationModel;
    }

    public String[] getAllDivPlayed(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_DIV_TOTAL_PLAYED + " from "+ DatabaseHelper.TABELA_DIV +" WHERE ID_DIV > 0", null);
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
    public String[] getAllDivRight(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_DIV_RIGHT + " from "+ DatabaseHelper.TABELA_DIV +" WHERE ID_DIV > 0", null);
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

    public String[] getAllDivWrong(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_DIV_WRONG + " from "+ DatabaseHelper.TABELA_DIV +" WHERE ID_DIV> 0", null);

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
