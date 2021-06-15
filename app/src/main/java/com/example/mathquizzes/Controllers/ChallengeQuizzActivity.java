package com.example.mathquizzes.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mathquizzes.Database.Controllers.AddOperationController;
import com.example.mathquizzes.Database.Controllers.DivOperationController;
import com.example.mathquizzes.Database.Controllers.MultOperationController;
import com.example.mathquizzes.Database.Controllers.SubOperationController;
import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Database.Models.AddOperationModel;
import com.example.mathquizzes.Database.Models.DivOperationModel;
import com.example.mathquizzes.Database.Models.MultOperationModel;
import com.example.mathquizzes.Database.Models.SubOperationModel;
import com.example.mathquizzes.Models.Operation;
import com.example.mathquizzes.R;

public class ChallengeQuizzActivity extends AppCompatActivity {

    Button btn1, btn2, btn3,btn4;
    boolean btnPressed,btn1Pressed,btn2Pressed,btn3Pressed,btn4Pressed;
    TextView txtV_topValueString,txtV_bottomValue, timerTxtView, sign;
    ImageView title;
    LinearLayout life_LinearLayout;
    String s;
    CountDownTimer countDownTimer;
    AddOperationController addOperationController;
    AddOperationModel addOperationModel;
    SubOperationController subOperationController;
    SubOperationModel subOperationModel;
    MultOperationController multOperationController;
    MultOperationModel multOperationModel;
    DivOperationController divOperationController;
    DivOperationModel divOperationModel;
    int lvl, operation_count, life, max_certas, dificuldadeNove;
    private Context mContext=this;
    boolean next_step=true;
    TextView lvl_txt,operation_count_txt, max_certas_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_quizz);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        s = getIntent().getStringExtra("OPERATION");
        lvl=1;
        operation_count=0;
        dificuldadeNove=0;
        life=3;
        findViews();
        lvl_txt.setText(getResources().getString(R.string.Level) + lvl);
        operation_count_txt.setText(getResources().getString(R.string.Right_answers) + operation_count);
        switch (s){
            case "add": title.setImageResource(R.drawable.titlechallengeadd);
                sign.setText("+");
                addOperationController=new AddOperationController(databaseHelper);
                addOperationModel=addOperationController.getAddOperation(0);
                max_certas=addOperationModel.getAdd_right_in_a_row();
                max_certas_txt.setText(getResources().getString(R.string.Right_answers_to_record) + max_certas);
                break;
            case "sub": title.setImageResource(R.drawable.titlechallengesub);
                sign.setText("-");
                subOperationController=new SubOperationController(databaseHelper);
                subOperationModel=subOperationController.getSubOperation(0);
                max_certas=subOperationModel.getSub_right_in_a_row();
                max_certas_txt.setText(getResources().getString(R.string.Right_answers_to_record) + max_certas);
                break;
            case "mult": title.setImageResource(R.drawable.titlechallengemult);
                sign.setText("×");
                multOperationController=new MultOperationController(databaseHelper);
                multOperationModel=multOperationController.getMultOperation(0);
                max_certas=multOperationModel.getMult_right_in_a_row();
                max_certas_txt.setText(getResources().getString(R.string.Right_answers_to_record) + max_certas);
                break;
            case "div": title.setImageResource(R.drawable.titlechallengediv);
                sign.setText("÷");
                divOperationController=new DivOperationController(databaseHelper);
                divOperationModel=divOperationController.getDivOperation(0);
                max_certas=divOperationModel.getDiv_right_in_a_row();
                max_certas_txt.setText(getResources().getString(R.string.Right_answers_to_record) + max_certas);
                break;
            default: break;
        }
        startOperation();
    }

    private void findViews(){
        title = findViewById(R.id.chllenge_title_imageView);
        sign=findViewById(R.id.challenge_operation_textView);
        txtV_topValueString=findViewById(R.id.challenge_top_value);
        txtV_bottomValue=findViewById(R.id.challenge_bottom_value);
        timerTxtView = findViewById(R.id.timmerChallenge);
        btn1=findViewById(R.id.challenge_btn_choice1);
        btn2=findViewById(R.id.challenge_btn_choice2);
        btn3=findViewById(R.id.challenge_btn_choice3);
        btn4=findViewById(R.id.challenge_btn_choice4);
        lvl_txt=findViewById(R.id.nextLvl_txtView);
        operation_count_txt=findViewById(R.id.right_ans_txtView);
        max_certas_txt=findViewById(R.id.record_txtView);
        life_LinearLayout=findViewById(R.id.life_LinearLayout);
    }

    private void startOperation(){
        if(next_step) {
            Operation operation = new Operation().getNewOperation(s, lvl);
            updateValues(operation);
            int correct = pickCorrectPosition(operation);
            setButtons(correct);
            setTimer();
        }
    }

    private void updateValues(Operation operation){
        btn1.setBackgroundResource(R.drawable.challenge_btn_options);
        btn2.setBackgroundResource(R.drawable.challenge_btn_options);
        btn3.setBackgroundResource(R.drawable.challenge_btn_options);
        btn4.setBackgroundResource(R.drawable.challenge_btn_options);
        txtV_topValueString.setText(String.valueOf(operation.getValue1()));
        txtV_bottomValue.setText(String.valueOf(operation.getValue2()));
    }

    private int pickCorrectPosition(Operation atual){
        int min=1, max=4,
                correct=((int) (Math.random() * (max - min)) + min);
        switch (correct){
            case 1: btn1.setText(String.valueOf(atual.getResult()));
                btn2.setText(String.valueOf(atual.getWrongResult1()));
                btn3.setText(String.valueOf(atual.getWrongResult2()));
                btn4.setText(String.valueOf(atual.getWrongResult3()));
                break;
            case 2: btn1.setText(String.valueOf(atual.getWrongResult2()));
                btn2.setText(String.valueOf(atual.getResult()));
                btn3.setText(String.valueOf(atual.getWrongResult1()));
                btn4.setText(String.valueOf(atual.getWrongResult3()));
                break;
            case 3: btn1.setText(String.valueOf(atual.getWrongResult3()));
                btn2.setText(String.valueOf(atual.getWrongResult2()));
                btn3.setText(String.valueOf(atual.getResult()));
                btn4.setText(String.valueOf(atual.getWrongResult1()));
                break;
            case 4: btn1.setText(String.valueOf(atual.getWrongResult3()));
                btn2.setText(String.valueOf(atual.getWrongResult1()));
                btn3.setText(String.valueOf(atual.getWrongResult2()));
                btn4.setText(String.valueOf(atual.getResult()));
                break;
            default: break;
        }
        return correct;
    }

    private void setButtons(int correct) {
        btn1Pressed = false;
        btn2Pressed = false;
        btn3Pressed = false;
        btn4Pressed = false;
        btn1.setOnClickListener(btnListener(btn1, correct,1));
        btn2.setOnClickListener(btnListener(btn2, correct,2));
        btn3.setOnClickListener(btnListener(btn3, correct,3));
        btn4.setOnClickListener(btnListener(btn4, correct,4));
    }

    private void setButtonsAwait(boolean was_right,int btn_clicked ){
        if(was_right){
            if(btn_clicked!=1)
                btn1.setBackgroundResource(R.drawable.btn_standbye);
            if(btn_clicked!=2)
                 btn2.setBackgroundResource(R.drawable.btn_standbye);
            if(btn_clicked!=3)
                btn3.setBackgroundResource(R.drawable.btn_standbye);
            if(btn_clicked!=4)
                 btn4.setBackgroundResource(R.drawable.btn_standbye);
        }
        else{
            btn1.setBackgroundResource(R.drawable.btn_options_wrong);
            btn2.setBackgroundResource(R.drawable.btn_options_wrong);
            btn3.setBackgroundResource(R.drawable.btn_options_wrong);
            btn4.setBackgroundResource(R.drawable.btn_options_wrong);
        }
    }

    private View.OnClickListener btnListener(Button btn, int correct, int btnID){
        return view -> {
            switch (btnID) {
                case 1: btnPressed=btn1Pressed;
                    break;
                case 2: btnPressed=btn2Pressed;
                    break;
                case 3: btnPressed=btn3Pressed;
                    break;
                case 4: btnPressed=btn4Pressed;
                    break;
                default: break;
            }
            if (!btnPressed) {
                boolean acertou;
                if (correct == btnID) {
                    acertou = true;
                    btn.setBackgroundResource(R.drawable.btn_options_correct);
                }
                else{
                    acertou = false;
                    btn.setBackgroundResource(R.drawable.btn_options_wrong);
                }
                    btn1Pressed = btn2Pressed = btn3Pressed = btn4Pressed = true;
                    updateLvl(acertou);
                    countDownTimer.cancel();
                    setTransitionTimer(acertou,btnID);
            }
        };
    }

    private void setTransitionTimer(boolean acertou,int button_clicked){
        if(next_step) {
            setButtonsAwait(acertou,button_clicked);
            countDownTimer = new CountDownTimer(400, 1000) {
                public void onTick(long millisUntilFinished) {
                }

                public void onFinish() {
                    startOperation();
                }
            }.start();
        timerTxtView.setText("");
        }
    }

    private void setTimer(){
        timerTxtView=findViewById(R.id.timmerChallenge);
        countDownTimer=new CountDownTimer(4000+lvl*1000-dificuldadeNove*1000, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTxtView.setText("00:00:" + (millisUntilFinished+1000) / 1000);
            }
            public void onFinish() {
                timerTxtView.setText("00:00:00");
                btn1Pressed = btn2Pressed = btn3Pressed = btn4Pressed = true;
                updateLvl(false);
                setTransitionTimer(false,0);
            }
        }.start();
    }

    private void updateLvl(boolean acertou){
        if(acertou){
            operation_count++;
            if(operation_count<90)
                lvl=(operation_count/10)+1;
            else
                lvl=9;
            lvl_txt.setText(getResources().getString(R.string.Level) + lvl);
            operation_count_txt.setText(getResources().getString(R.string.Right_answers) + operation_count);
            if(operation_count>100 && operation_count<200){
                dificuldadeNove=((operation_count%100)/10)+1;
            }
            return;
        }
        life-=1;
        life_LinearLayout.removeViewAt(0);
        if(life>0){
            lvl_txt.setText(getResources().getString(R.string.Level) + lvl);
            return;
        }
        else {
            next_step = false;
            setButtonsAwait(false,0);
        }
        lvl_txt.setText(getResources().getString(R.string.Level) + lvl);
        operation_count_txt.setText(getResources().getString(R.string.Right_answers) + operation_count);
        boolean new_record=false;
        String last_operation_name="";
        switch (s){
            case "add": if(operation_count>max_certas){
                            addOperationModel.setAdd_right_in_a_row(operation_count);
                            addOperationController.updateAddOperation(addOperationModel);
                            new_record=true;
                            last_operation_name="Addition:";
                        }
                        break;
            case "sub": if(operation_count>max_certas){
                              subOperationModel.setSub_right_in_a_row(operation_count);
                              subOperationController.updateSubOperation(subOperationModel);
                              new_record=true;
                              last_operation_name="Subtraction:";
                        }
                        break;
            case "mult": if(operation_count>max_certas){
                             multOperationModel.setMult_right_in_a_row(operation_count);
                             multOperationController.updateMultOperation(multOperationModel);
                             new_record=true;
                             last_operation_name="Multiplication:";
                         }
                         break;
            case "div": if(operation_count>max_certas){
                            divOperationModel.setDiv_right_in_a_row(operation_count);
                            divOperationController.updateDivOperation(divOperationModel);
                            new_record=true;
                            last_operation_name="Division:";
                        }
                        break;
            default: break;
        }
        Intent i=new Intent(mContext,MainActivity.class);
        i.putExtra("Last_Activity", "Challenge");
        i.putExtra("is_New_Record", new_record);
        i.putExtra("Last_Operation", last_operation_name);
        i.putExtra("New_value", operation_count);
        startActivity(i);
    }

    @Override
    protected void onPause() {
        super.onPause();
        countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startOperation();
    }
}