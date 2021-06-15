package com.example.mathquizzes.Database.Models;

public class DivOperationModel {
    int div_lvl,div_total,div_right, div_wrong, div_right_in_a_row;

    public DivOperationModel() {
    }

    public DivOperationModel(int div_lvl) {
        this.div_lvl = div_lvl;
        this.div_total = 0;
        this.div_right = 0;
        this.div_wrong = 0;
        this.div_right_in_a_row = 0;
    }

    /*public DivOperationModel(int div_lvl, int div_total, int div_right, int div_wrong, int div_right_in_a_row) {
        this.div_lvl = div_lvl;
        this.div_total = div_total;
        this.div_right = div_right;
        this.div_wrong = div_wrong;
        this.div_right_in_a_row = div_right_in_a_row;
    }
     */

    public int getDiv_lvl() {
        return div_lvl;
    }

    public void setDiv_lvl(int div_lvl) {
        this.div_lvl = div_lvl;
    }

    public int getDiv_total() {
        return div_total;
    }

    public void setDiv_total(int div_total) {
        this.div_total = div_total;
    }

    public int getDiv_right() {
        return div_right;
    }

    public void setDiv_right(int div_right) {
        this.div_right = div_right;
    }

    public int getDiv_wrong() {
        return div_wrong;
    }

    public void setDiv_wrong(int div_wrong) {
        this.div_wrong = div_wrong;
    }

    public int getDiv_right_in_a_row() {
        return div_right_in_a_row;
    }

    public void setDiv_right_in_a_row(int div_right_in_a_row) {
        this.div_right_in_a_row = div_right_in_a_row;
    }

    @Override
    public String toString() {
        return "DivOperationModel{" +
                "div_id=" + div_lvl +
                ", div_total=" + div_total +
                ", div_right=" + div_right +
                ", div_wrong=" + div_wrong +
                ", div_right_in_a_row=" + div_right_in_a_row +
                '}';
    }
}
