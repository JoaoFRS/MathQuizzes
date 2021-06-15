package com.example.mathquizzes.Controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.example.mathquizzes.Models.*;
import com.example.mathquizzes.R;

public class QuizzActivity extends AppCompatActivity {

    Button btn1, btn2, btn3,btn4,btn_leave,btn_next;
    boolean btn1Pressed,btn2Pressed,btn3Pressed,btn4Pressed, have_countDownTimer=false, btnPressed, is_next_clickable=true, was_wrong=false;
    TextView txtV_topValueString,txtV_bottomValue, lvl_TxtView, sign;
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
    ImageView title;
    int lvl;
    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizz);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        s = getIntent().getStringExtra("OPERATION");
        lvl= getIntent().getIntExtra("LVL",1);
        findViews();
        lvl_TxtView.setText("Lvl:" + lvl);
        mContext=this;
        switch (s){
            case "add": title.setImageResource(R.drawable.titlepracticeadd);
                        sign.setText("+");
                        addOperationController=new AddOperationController(databaseHelper);
                        addOperationModel=addOperationController.getAddOperation(lvl);
                        break;
            case "sub": title.setImageResource(R.drawable.titlepracticesub);
                        sign.setText("-");
                        subOperationController=new SubOperationController(databaseHelper);
                        subOperationModel=subOperationController.getSubOperation(lvl);
                        break;
            case "mult": title.setImageResource(R.drawable.titlepracticemult);
                        sign.setText("×");
                        multOperationController=new MultOperationController(databaseHelper);
                        multOperationModel=multOperationController.getMultOperation(lvl);
                        break;
            case "div": title.setImageResource(R.drawable.titlepracticediv);
                        sign.setText("÷");
                        divOperationController=new DivOperationController(databaseHelper);
                        divOperationModel=divOperationController.getDivOperation(lvl);
                        break;
            default: break;
        }
        btn_next.setOnClickListener(view -> {
            if(is_next_clickable)
                startOperation();
        });
        btn_leave.setOnClickListener(view -> {
            Intent i=new Intent(mContext,MainActivity.class);
            startActivity(i);
        });
        startOperation();


    }

    private void findViews(){
        title = findViewById(R.id.title_imageView);
        sign=findViewById(R.id.operation_textView);
        txtV_topValueString=findViewById(R.id.top_value);
        txtV_bottomValue=findViewById(R.id.bottom_value);
        lvl_TxtView=findViewById(R.id.lvl_txt);
        btn1=findViewById(R.id.btn_choice1);
        btn2=findViewById(R.id.btn_choice2);
        btn3=findViewById(R.id.btn_choice3);
        btn4=findViewById(R.id.btn_choice4);
        btn_leave=findViewById(R.id.btn_leave);
        btn_next=findViewById(R.id.btn_next);
    }

    private void startOperation(){
        was_wrong=false;
        Operation operation=new Operation().getNewOperation(s,lvl);
        updateValues(operation);
        int correct=pickCorrectPosition(operation);
        setButtons(correct);
    }

    private void updateValues(Operation operation){
        btn1.setBackgroundResource(R.drawable.btn_options);
        btn2.setBackgroundResource(R.drawable.btn_options);
        btn3.setBackgroundResource(R.drawable.btn_options);
        btn4.setBackgroundResource(R.drawable.btn_options);
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

    private View.OnClickListener btnListener(Button btn,int correct,int btnID){
        return view -> {
            switch (btnID) {
                case 1: btnPressed=btn1Pressed;
                    btn1Pressed=true;
                    break;
                case 2: btnPressed=btn2Pressed;
                    btn2Pressed=true;
                    break;
                case 3: btnPressed=btn3Pressed;
                    btn3Pressed=true;
                    break;
                case 4: btnPressed=btn4Pressed;
                    btn4Pressed=true;
                    break;
                default: break;
            }
            if (!btnPressed) {
                boolean acertou;
                if (correct == btnID) {
                    acertou = true;
                    updateDatabase(acertou);
                    btn.setBackgroundResource(R.drawable.btn_options_correct);
                    btn1Pressed = btn2Pressed = btn3Pressed = btn4Pressed = true;
                    setTransitionTimer(acertou, btnID);
                }
                else{
                    acertou = false;
                    updateDatabase(acertou);
                    btn.setBackgroundResource(R.drawable.btn_options_wrong);
                }
            }
        };
    }

    private void setTransitionTimer(boolean acertou,int button_clicked){
        have_countDownTimer=true;
        is_next_clickable=false;
        setButtonsAwait(acertou,button_clicked);
        countDownTimer = new CountDownTimer(400, 1000) {
            public void onTick(long millisUntilFinished) {}
            public void onFinish() {
                have_countDownTimer=false;
                is_next_clickable=true;
                startOperation();
            }
        }.start();
    }

    private void setButtonsAwait(boolean was_right,int btn_clicked ) {
        if (was_right) {
            if (btn_clicked != 1)
                btn1.setBackgroundResource(R.drawable.btn_standbye_blue);
            if (btn_clicked != 2)
                btn2.setBackgroundResource(R.drawable.btn_standbye_blue);
            if (btn_clicked != 3)
                btn3.setBackgroundResource(R.drawable.btn_standbye_blue);
            if (btn_clicked != 4)
                btn4.setBackgroundResource(R.drawable.btn_standbye_blue);
        }
        btn1Pressed = btn2Pressed = btn3Pressed = btn4Pressed = true;
    }

    private void updateDatabase(boolean acertou){
        if(was_wrong)
            return;
        if(!acertou)
            was_wrong=true;
        switch (s){
            case "add": addOperationModel=addOperationController.getAddOperation(lvl);
                        addOperationModel.setAdd_total(addOperationModel.getAdd_total()+1);
                        addOperationModel.setAdd_right(addOperationModel.getAdd_right()+ (acertou ? 1 : 0));
                        addOperationModel.setAdd_wrong(addOperationModel.getAdd_wrong()+ (!acertou ? 1 : 0));
                        addOperationModel.setAdd_right_in_a_row((addOperationModel.getAdd_right_in_a_row()+1)* (acertou ? 1:0));
                        addOperationController.updateAddOperation(addOperationModel);
                        break;
            case "sub": subOperationModel=subOperationController.getSubOperation(lvl);
                        subOperationModel.setSub_total(subOperationModel.getSub_total()+1);
                        subOperationModel.setSub_right(subOperationModel.getSub_right()+ (acertou ? 1 : 0));
                        subOperationModel.setSub_wrong(subOperationModel.getSub_wrong()+ (!acertou ? 1 : 0));
                        subOperationModel.setSub_right_in_a_row((subOperationModel.getSub_right_in_a_row()+1)* (acertou ? 1:0));
                        subOperationController.updateSubOperation(subOperationModel);
                        break;
            case "mult": multOperationModel=multOperationController.getMultOperation(lvl);
                         multOperationModel.setMult_total(multOperationModel.getMult_total()+1);
                         multOperationModel.setMult_right(multOperationModel.getMult_right()+ (acertou ? 1 : 0));
                         multOperationModel.setMult_wrong(multOperationModel.getMult_wrong()+ (!acertou ? 1 : 0));
                         multOperationModel.setMult_right_in_a_row((multOperationModel.getMult_right_in_a_row()+1)* (acertou ? 1:0));
                         multOperationController.updateMultOperation(multOperationModel);
                         break;
            case "div": divOperationModel=divOperationController.getDivOperation(lvl);
                        divOperationModel.setDiv_total(divOperationModel.getDiv_total()+1);
                        divOperationModel.setDiv_right(divOperationModel.getDiv_right()+ (acertou ? 1 : 0));
                        divOperationModel.setDiv_wrong(divOperationModel.getDiv_wrong()+ (!acertou ? 1 : 0));
                        divOperationModel.setDiv_right_in_a_row((divOperationModel.getDiv_right_in_a_row()+1)* (acertou ? 1:0));
                        divOperationController.updateDivOperation(divOperationModel);
                        break;
            default: break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(have_countDownTimer)
            countDownTimer.cancel();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if(have_countDownTimer)
            countDownTimer.cancel();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startOperation();
    }
}