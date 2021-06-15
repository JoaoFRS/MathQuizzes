package com.example.mathquizzes.Database.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Database.Models.SubOperationModel;

public class SubOperationController {
    DatabaseHelper database;

    public SubOperationController(DatabaseHelper databse) {
        this.database = databse;
    }

    public void insertSubOperation(SubOperationModel subOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_SUB, subOperationModel.getSub_lvl());
        values.put(DatabaseHelper.COLUNA_SUB_TOTAL_PLAYED,subOperationModel.getSub_total());
        values.put(DatabaseHelper.COLUNA_SUB_RIGHT,subOperationModel.getSub_right());
        values.put(DatabaseHelper.COLUNA_SUB_WRONG,subOperationModel.getSub_wrong());
        values.put(DatabaseHelper.COLUNA_SUB_RIGHT_IN_A_ROW,subOperationModel.getSub_right_in_a_row());


        db.insert(DatabaseHelper.TABELA_SUB, null, values);
        db.close();
    }

    public void updateSubOperation(SubOperationModel subOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_SUB, subOperationModel.getSub_lvl());
        values.put(DatabaseHelper.COLUNA_SUB_TOTAL_PLAYED,subOperationModel.getSub_total());
        values.put(DatabaseHelper.COLUNA_SUB_RIGHT,subOperationModel.getSub_right());
        values.put(DatabaseHelper.COLUNA_SUB_WRONG,subOperationModel.getSub_wrong());
        values.put(DatabaseHelper.COLUNA_SUB_RIGHT_IN_A_ROW,subOperationModel.getSub_right_in_a_row());
        db.update(DatabaseHelper.TABELA_SUB, values, DatabaseHelper.COLUNA_KEY_SUB + "=?", new String[]{String.valueOf(subOperationModel.getSub_lvl())});
    }

    public void deleteSubOperation(SubOperationModel subOperationModel) {

        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(DatabaseHelper.TABELA_SUB, DatabaseHelper.COLUNA_KEY_SUB + "=?", new String[]{String.valueOf(subOperationModel.getSub_lvl())});

        db.close();
    }

    public SubOperationModel getSubOperation(int lvl){
        SQLiteDatabase db = database.getReadableDatabase();

        String selection = DatabaseHelper.COLUNA_KEY_SUB + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(lvl)};

        Cursor cursor = db.query(DatabaseHelper.TABELA_SUB, null, selection,  selectionArgs, null, null, null);

        if (cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
        }

        SubOperationModel subOperationModel=new SubOperationModel();
        subOperationModel.setSub_lvl(cursor.getInt(0));
        subOperationModel.setSub_total(cursor.getInt(1));
        subOperationModel.setSub_right(cursor.getInt(2));
        subOperationModel.setSub_wrong(cursor.getInt(3));
        subOperationModel.setSub_right_in_a_row(cursor.getInt(4));
        db.close();
        cursor.close();
        return subOperationModel;
    }
    public String[] getAllSubPlayed(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_SUB_TOTAL_PLAYED + " from "+ DatabaseHelper.TABELA_SUB +" WHERE ID_SUB > 0", null);
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
    public String[] getAllSubRight(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor= db.rawQuery( "select " + DatabaseHelper.COLUNA_SUB_RIGHT + " from "+ DatabaseHelper.TABELA_SUB +" WHERE ID_SUB > 0", null);
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

    public String[] getAllSubWrong(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_SUB_WRONG + " from "+ DatabaseHelper.TABELA_SUB +" WHERE ID_SUB > 0", null);

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
