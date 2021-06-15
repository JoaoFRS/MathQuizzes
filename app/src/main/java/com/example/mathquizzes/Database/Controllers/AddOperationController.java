package com.example.mathquizzes.Database.Controllers;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Database.Models.AddOperationModel;

public class AddOperationController {
    DatabaseHelper database;

    public AddOperationController(DatabaseHelper databse) {
        this.database = databse;
    }

    public void insertAddOperation(AddOperationModel addOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_ADD, addOperationModel.getAdd_lvl());
        values.put(DatabaseHelper.COLUNA_ADD_TOTAL_PLAYED,addOperationModel.getAdd_total());
        values.put(DatabaseHelper.COLUNA_ADD_RIGHT,addOperationModel.getAdd_right());
        values.put(DatabaseHelper.COLUNA_ADD_WRONG,addOperationModel.getAdd_wrong());
        values.put(DatabaseHelper.COLUNA_ADD_RIGHT_IN_A_ROW,addOperationModel.getAdd_right_in_a_row());


        db.insert(DatabaseHelper.TABELA_ADD, null, values);
        db.close();
    }

    public void updateAddOperation(AddOperationModel addOperationModel){

        SQLiteDatabase db = database.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(DatabaseHelper.COLUNA_KEY_ADD, addOperationModel.getAdd_lvl());
        values.put(DatabaseHelper.COLUNA_ADD_TOTAL_PLAYED,addOperationModel.getAdd_total());
        values.put(DatabaseHelper.COLUNA_ADD_RIGHT,addOperationModel.getAdd_right());
        values.put(DatabaseHelper.COLUNA_ADD_WRONG,addOperationModel.getAdd_wrong());
        values.put(DatabaseHelper.COLUNA_ADD_RIGHT_IN_A_ROW,addOperationModel.getAdd_right_in_a_row());

        db.update(DatabaseHelper.TABELA_ADD, values, DatabaseHelper.COLUNA_KEY_ADD + "=?", new String[]{String.valueOf(addOperationModel.getAdd_lvl())});
    }

    public void deleteAddOperation(AddOperationModel addOperationModel) {

        SQLiteDatabase db = database.getWritableDatabase();
        db.delete(DatabaseHelper.TABELA_ADD, DatabaseHelper.COLUNA_KEY_ADD + "=?", new String[]{String.valueOf(addOperationModel.getAdd_lvl())});

        db.close();
    }

    public AddOperationModel getAddOperation(int lvl){
        SQLiteDatabase db = database.getReadableDatabase();

        String selection = DatabaseHelper.COLUNA_KEY_ADD + " = ?";
        String[] selectionArgs = new String[]{String.valueOf(lvl)};

        Cursor cursor = db.query(DatabaseHelper.TABELA_ADD, null, selection,  selectionArgs, null, null, null);

        if (cursor != null && cursor.getCount()>0) {
            cursor.moveToFirst();
        }

        AddOperationModel addOperationModel=new AddOperationModel();
        addOperationModel.setAdd_lvl(cursor.getInt(0));
        addOperationModel.setAdd_total(cursor.getInt(1));
        addOperationModel.setAdd_right(cursor.getInt(2));
        addOperationModel.setAdd_wrong(cursor.getInt(3));
        addOperationModel.setAdd_right_in_a_row(cursor.getInt(4));
        db.close();
        cursor.close();
        return addOperationModel;
    }

    public String[] getAllAddPlayed(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_ADD_TOTAL_PLAYED + " from "+ DatabaseHelper.TABELA_ADD +" WHERE ID_ADD > 0", null);
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
    public String[] getAllAddRight(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_ADD_RIGHT + " from "+ DatabaseHelper.TABELA_ADD +" WHERE ID_ADD > 0", null);
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

    public String[] getAllAddWrong(){
        SQLiteDatabase db = database.getReadableDatabase();
        Cursor cursor=db.rawQuery( "select " + DatabaseHelper.COLUNA_ADD_WRONG + " from "+ DatabaseHelper.TABELA_ADD +" WHERE ID_ADD > 0", null);
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
