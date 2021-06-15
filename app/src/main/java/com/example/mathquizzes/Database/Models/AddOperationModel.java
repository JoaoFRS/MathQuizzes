package com.example.mathquizzes.Database.Models;

public class AddOperationModel {
    int add_lvl, add_total, add_right, add_wrong, add_right_in_a_row;

    public AddOperationModel() {
    }

    public AddOperationModel(int add_lvl) {
        this.add_lvl = add_lvl;
        this.add_total = 0;
        this.add_right = 0;
        this.add_wrong = 0;
        this.add_right_in_a_row = 0;
    }

    /*public AddOperationModel(int add_lvl, int add_total, int add_right, int add_wrong, int add_right_in_a_row) {
        this.add_lvl = add_lvl;
        this.add_total = add_total;
        this.add_right = add_right;
        this.add_wrong = add_wrong;
        this.add_right_in_a_row = add_right_in_a_row;
    }
    */

    public int getAdd_lvl() {
        return add_lvl;
    }

    public void setAdd_lvl(int add_lvl) {
        this.add_lvl = add_lvl;
    }

    public int getAdd_total() {
        return add_total;
    }

    public void setAdd_total(int add_total) {
        this.add_total = add_total;
    }

    public int getAdd_right() {
        return add_right;
    }

    public void setAdd_right(int add_right) {
        this.add_right = add_right;
    }

    public int getAdd_wrong() {
        return add_wrong;
    }

    public void setAdd_wrong(int add_wrong) {
        this.add_wrong = add_wrong;
    }

    public int getAdd_right_in_a_row() {
        return add_right_in_a_row;
    }

    public void setAdd_right_in_a_row(int add_right_in_a_row) {
        this.add_right_in_a_row = add_right_in_a_row;
    }

    @Override
    public String toString() {
        return "AddOperationModel{" +
                "add_id=" + add_lvl +
                ", add_total=" + add_total +
                ", add_right=" + add_right +
                ", add_wrong=" + add_wrong +
                ", add_right_in_a_row=" + add_right_in_a_row +
                '}';
    }
}
