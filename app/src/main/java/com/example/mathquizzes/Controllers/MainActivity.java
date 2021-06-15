package com.example.mathquizzes.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.mathquizzes.Database.DatabaseBuilder;
import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.R;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ToggleButton toggleButton;
    ImageView imageView_title;
    ConstraintLayout constraintLayout;
    Toast toast;
    private final Context mContext=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        boolean doesDatabaseExist = DatabaseExist(this);
        if(!doesDatabaseExist) {
            DatabaseHelper db = new DatabaseHelper(mContext);
            DatabaseBuilder databaseBuilder=new DatabaseBuilder(db);
            databaseBuilder.buildUser();
        }
        setContentView(R.layout.activity_main);
        constraintLayout=findViewById(R.id.backgroundMainActivity);
        constraintLayout.setBackgroundColor(getResources().getColor(R.color.background_practice_mode));
        toggleButton=findViewById(R.id.switchModes);
        ImageButton addition= findViewById(R.id.addButton);
        ImageButton subtraction= findViewById(R.id.minusButton);
        ImageButton multiplication= findViewById(R.id.multButton);
        ImageButton division= findViewById(R.id.divButton);
        imageView_title=findViewById(R.id.imageView_title);
        addition.setOnClickListener(setListenerPractice("add"));
        subtraction.setOnClickListener(setListenerPractice("sub"));
        multiplication.setOnClickListener(setListenerPractice("mult"));
        division.setOnClickListener(setListenerPractice("div"));
        toggleButton.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                //challenge mode
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.background_challenge_mode));
                imageView_title.setImageResource(R.drawable.titlechallenge);
                addition.setImageResource(R.drawable.challenge_plus_button_src);
                addition.setOnClickListener(setListenerChallenge("add"));
                subtraction.setImageResource(R.drawable.challenge_minus_button_src);
                subtraction.setOnClickListener(setListenerChallenge("sub"));
                multiplication.setImageResource(R.drawable.challenge_multiplication_button_src);
                multiplication.setOnClickListener(setListenerChallenge("mult"));
                division.setImageResource(R.drawable.challenge_division_button_src);
                division.setOnClickListener(setListenerChallenge("div"));
            } else {
                //practice mode
                constraintLayout.setBackgroundColor(getResources().getColor(R.color.background_practice_mode));
                imageView_title.setImageResource(R.drawable.titlepractice);
                addition.setImageResource(R.drawable.practice_plus_button_src);
                addition.setOnClickListener(setListenerPractice("add"));
                subtraction.setImageResource(R.drawable.practice_minus_button_src);
                subtraction.setOnClickListener(setListenerPractice("sub"));
                multiplication.setImageResource(R.drawable.practice_multiplication_button_src);
                multiplication.setOnClickListener(setListenerPractice("mult"));
                division.setImageResource(R.drawable.practice_division_button_src);
                division.setOnClickListener(setListenerPractice("div"));
            }
        });
        String aux=getIntent().getStringExtra("Last_Activity");
        if(aux!=null && aux.equals("Challenge"))
            toggleButton.setChecked(true);
        Boolean new_record=getIntent().getBooleanExtra("is_New_Record",false);
        if(new_record){
            toast = Toast.makeText(mContext,"New Record in " + getIntent().getStringExtra("Last_Operation") + getIntent().getIntExtra("New_value",0),Toast.LENGTH_SHORT);
            View toastView = toast.getView(); // This'll return the default View of the Toast.

            TextView toastMessage = (TextView) toastView.findViewById(android.R.id.message);
            toastMessage.setTextSize(18);
            toastMessage.setTextColor(Color.BLACK);
            toastMessage.setGravity(Gravity.CENTER);
            toastMessage.setCompoundDrawablePadding(20);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                toastView.setBackground(getDrawable(android.R.drawable.toast_frame));
            }
            toast.show();
        }
    }

    private View.OnClickListener setListenerPractice(String operation){
        return view -> {
            if(toast!=null)
                toast.cancel();
            Intent i=new Intent(mContext,PickLvlActivity.class);
            i.putExtra("OPERATION", operation);
            startActivity(i);
        };
    }

    private View.OnClickListener setListenerChallenge(String operation){
        return view -> {
            if(toast!=null)
                toast.cancel();
            Intent i=new Intent(mContext,ChallengeQuizzActivity.class);
            i.putExtra("OPERATION", operation);
            startActivity(i);
        };
    }
    private static boolean DatabaseExist(Context context) {
        File dbFile = context.getDatabasePath("UserDatabase");
        return dbFile.exists();
    }
}