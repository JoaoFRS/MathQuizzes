package com.example.mathquizzes.Models;


public class Operation {
    int value1,
    value2,
    result,
    wrongResult1,
    wrongResult2,
    wrongResult3;
    private int max,min;

    public Operation(){
        this.value1 = 0;
        this.value2 = 0;
        this.result = 0;
        this.wrongResult1 = 0;
        this.wrongResult2 = 0;
        this.wrongResult3 = 0;
    }

    public Operation(int value1, int value2, int result, int wrongResult1, int wrongResult2, int wrongResult3) {
        this.value1 = value1;
        this.value2 = value2;
        this.result = result;
        this.wrongResult1 = wrongResult1;
        this.wrongResult2 = wrongResult2;
        this.wrongResult3 = wrongResult3;
    }

    public Operation getNewOperation(String type,int difficulty ){
        //difficulty:1->9
       switch (type){
           case "add":  getNewAddValues(difficulty);
                        break;
           case "sub":  getNewSubValues(difficulty);
                        break;
           case "mult": getNewMultValues(difficulty);
                        break;
           case "div":  getNewDivValues(difficulty);
                        break;
           default: break;
       }
       generateWrong(Math.min(result,10));
        return new Operation(value1,value2,result,wrongResult1,wrongResult2,wrongResult3);


    }

    public int getValue1() {
        return value1;
    }

    public int getValue2() {
        return value2;
    }

    public int getResult() {
        return result;
    }

    public int getWrongResult1() {
        return wrongResult1;
    }

    public int getWrongResult2() {
        return wrongResult2;
    }

    public int getWrongResult3() {
        return wrongResult3;
    }

    private void getNewAddValues(int difficulty){
        generateMaxMinAddSub(difficulty);
        value1 = (int) (Math.random() * (max - min)) + min;
        value2=(int) (Math.random() * (max - min)) + min;
        result=value1+value2;
    }

    private void getNewSubValues(int difficulty){
        generateMaxMinAddSub(difficulty);
        value2 = (int) (Math.random() * (max - min)) + min;
        value1= value2 + ((int) ((Math.random() * (max - min)) + min));
        result=value1-value2;
    }

    private void getNewMultValues(int difficulty) {
        generateMaxMinMultDiv(true,difficulty,false);
        value1 = (int) (Math.random() * (max - min)) + min;
        generateMaxMinMultDiv(false,difficulty, false);
        value2=(int) (Math.random() * (max - min)) + min;
        result=value1*value2;
    }

    private void getNewDivValues(int difficulty) {

        min=1+(difficulty-1)*2;
        max=6+(difficulty-1)*2;
        value2=(int) (Math.random() * (max - min)) + min;
        generateMaxMinMultDiv(true,difficulty,true);
        value1=value2 * ((int) ((Math.random() * (max - min)) + min));
        result=value1/value2;
    }

    private void generateMaxMinAddSub(int difficulty){
        switch (difficulty) {
            case 1:
                min = 1;
                max = 10;
                break;
            case 2:
                min = 10;
                max = 25;
                break;
            case 3:
                min = 25;
                max = 50;
                break;
            case 4:
                min = 50;
                max = 100;
                break;
            case 5:
                min = 100;
                max = 250;
                break;
            case 6:
                min = 250;
                max = 400;
                break;
            case 7:
                min = 400;
                max = 800;
                break;
            case 8:
                min = 800;
                max = 1250;
                break;
            case 9:
                min = 1250;
                max = 2000;
                break;
            default:
                break;
        }
    }

    private void generateMaxMinMultDiv(boolean isFirstValue, int difficulty,boolean isDivision){
        switch (difficulty) {
            case 1:
                min = 1 + (isDivision ? 1:0);
                max = 6 - (isFirstValue ? 0:2) - (isDivision ? 1:0);
                break;
            case 2:
                min = 2 + (isDivision ? 1:0);
                max = 7 - (isDivision ? 1:0);
                break;
            case 3:
                min = 5 - (isFirstValue ? 0:1) - (isDivision ? 1:0);
                max = 10 - (isFirstValue ? 0:2) - (isDivision ? 2:0);
                break;
            case 4:
                min = 7 - (isFirstValue ? 0:1) - (isDivision ? 1:0);
                max = 11 - (isFirstValue ? 0:1) - (isDivision ? 1:0);
                break;
            case 5:
                min = 10 - (isDivision ? 1:0);
                max = 16 - (isFirstValue ? 0:2) - (isDivision ? 3:0);
                break;
            case 6:
                min = 13 - (isDivision ? 2:0);
                max = 18 - (isDivision ? 2:0);
                break;
            case 7:
                min = 17- (isDivision ? 2:0);
                max = 25- (isFirstValue ? 0:4) - (isDivision ? 2:0);
                break;
            case 8:
                min = 20 - (isDivision ? 2:0);
                max = 26 - (isDivision ? 1:0);
                break;
            case 9:
                min = 26 - (isDivision ? 3:0);
                max = 75 - (isDivision ? 25:0);
                break;
            default:
                break;
        }
    }

    private void generateWrong(int max) {
        if (result >= 11){
            if (((int) (Math.random() * (10 - 1)) + 1) < 5)
                wrongResult3 = result + 10;
            else
                wrongResult3 = result - 10;
            int aux = ((int) (Math.random() * (max - 1)) + 1);
            wrongResult2 = result + aux;
            aux = ((int) (Math.random() * (max - 1)) + 1);
            wrongResult1 = result - aux;
        }
        else{
            wrongResult1=result-1;
            wrongResult2=result+1;
            if(result == 1){
                wrongResult3=result+2;
            }
            else{
                if (((int) (Math.random() * (10 - 1)) + 1) < 5)
                    wrongResult3 = result + 2;
                else
                    wrongResult3 = result - 2;
            }
        }
    }

}
