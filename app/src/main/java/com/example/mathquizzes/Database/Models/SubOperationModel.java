package com.example.mathquizzes.Database.Models;

public class SubOperationModel {
    int sub_lvl,sub_total,sub_right, sub_wrong, sub_right_in_a_row;

    public SubOperationModel() {
    }

    public SubOperationModel(int sub_lvl) {
        this.sub_lvl = sub_lvl;
        this.sub_total = 0;
        this.sub_right = 0;
        this.sub_wrong = 0;
        this.sub_right_in_a_row = 0;
    }

   /*public SubOperationModel(int sub_lvl, int sub_total, int sub_right, int sub_wrong, int sub_right_in_a_row) {
        this.sub_lvl = sub_lvl;
        this.sub_total = sub_total;
        this.sub_right = sub_right;
        this.sub_wrong = sub_wrong;
        this.sub_right_in_a_row = sub_right_in_a_row;
    }
    */

    public int getSub_lvl() {
        return sub_lvl;
    }

    public void setSub_lvl(int sub_lvl) {
        this.sub_lvl = sub_lvl;
    }

    public int getSub_total() {
        return sub_total;
    }

    public void setSub_total(int sub_total) {
        this.sub_total = sub_total;
    }

    public int getSub_right() {
        return sub_right;
    }

    public void setSub_right(int sub_right) {
        this.sub_right = sub_right;
    }

    public int getSub_wrong() {
        return sub_wrong;
    }

    public void setSub_wrong(int sub_wrong) {
        this.sub_wrong = sub_wrong;
    }

    public int getSub_right_in_a_row() {
        return sub_right_in_a_row;
    }

    public void setSub_right_in_a_row(int sub_right_in_a_row) {
        this.sub_right_in_a_row = sub_right_in_a_row;
    }

    @Override
    public String toString() {
        return "SubOperationModel{" +
                "sub_id=" + sub_lvl +
                ", sub_total=" + sub_total +
                ", sub_right=" + sub_right +
                ", sub_wrong=" + sub_wrong +
                ", sub_right_in_a_row=" + sub_right_in_a_row +
                '}';
    }
}
