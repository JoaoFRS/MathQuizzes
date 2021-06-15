package com.example.mathquizzes.Database.Models;

public class MultOperationModel {
    int mult_lvl,mult_total,mult_right, mult_wrong, mult_right_in_a_row;

    public MultOperationModel() {
    }

    public MultOperationModel(int mult_lvl) {
        this.mult_lvl = mult_lvl;
        this.mult_total = 0;
        this.mult_right = 0;
        this.mult_wrong = 0;
        this.mult_right_in_a_row = 0;
    }

   /* public MultOperationModel(int mult_lvl, int mult_total, int mult_right, int mult_wrong, int mult_right_in_a_row) {
        this.mult_lvl = mult_lvl;
        this.mult_total = mult_total;
        this.mult_right = mult_right;
        this.mult_wrong = mult_wrong;
        this.mult_right_in_a_row = mult_right_in_a_row;
    }
     */

    public int getMult_lvl() {
        return mult_lvl;
    }

    public void setMult_lvl(int mult_lvl) {
        this.mult_lvl = mult_lvl;
    }

    public int getMult_total() {
        return mult_total;
    }

    public void setMult_total(int mult_total) {
        this.mult_total = mult_total;
    }

    public int getMult_right() {
        return mult_right;
    }

    public void setMult_right(int mult_right) {
        this.mult_right = mult_right;
    }

    public int getMult_wrong() {
        return mult_wrong;
    }

    public void setMult_wrong(int mult_wrong) {
        this.mult_wrong = mult_wrong;
    }

    public int getMult_right_in_a_row() {
        return mult_right_in_a_row;
    }

    public void setMult_right_in_a_row(int mult_right_in_a_row) {
        this.mult_right_in_a_row = mult_right_in_a_row;
    }

    @Override
    public String toString() {
        return "MultOperationModel{" +
                "mult_id=" + mult_lvl +
                ", mult_total=" + mult_total +
                ", mult_right=" + mult_right +
                ", mult_wrong=" + mult_wrong +
                ", mult_right_in_a_row=" + mult_right_in_a_row +
                '}';
    }
}
