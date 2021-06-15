package com.example.mathquizzes.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.mathquizzes.Database.Controllers.AddOperationController;
import com.example.mathquizzes.Database.Controllers.DivOperationController;
import com.example.mathquizzes.Database.Controllers.MultOperationController;
import com.example.mathquizzes.Database.Controllers.SubOperationController;
import com.example.mathquizzes.Database.DatabaseHelper;
import com.example.mathquizzes.Models.PickLvlAdapter;
import com.example.mathquizzes.R;

public class PickLvlActivity extends AppCompatActivity {
    String s;
    RecyclerView recyclerView_PickLvl;
    int[] images={R.drawable.lvl1_image,R.drawable.lvl2_image,R.drawable.lvl3_image,R.drawable.lvl4_image
            ,R.drawable.lvl5_image,R.drawable.lvl6_image,R.drawable.lvl7_image,
            R.drawable.lvl8_image,R.drawable.lvl9_image};
    PickLvlAdapter pickLvlAdapter;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pick_lvl);
        recyclerView_PickLvl=findViewById(R.id.RecView_PickLvl);
        ImageView imageView=findViewById(R.id.Imageview_Pick_Lvl_Title);
        DatabaseHelper databaseHelper=new DatabaseHelper(this);
        s = getIntent().getStringExtra("OPERATION");
        switch (s){
            case "add": AddOperationController addOperationController=new AddOperationController(databaseHelper);
                        pickLvlAdapter=new PickLvlAdapter(this,images,
                                addOperationController.getAllAddPlayed(),addOperationController.getAllAddRight(),
                                  addOperationController.getAllAddWrong(),"add");
                        imageView.setImageResource(R.drawable.titlepickadd);
                        break;
            case "sub":SubOperationController subOperationController=new SubOperationController(databaseHelper);
                        pickLvlAdapter=new PickLvlAdapter(this,images,
                                subOperationController.getAllSubPlayed(),subOperationController.getAllSubRight(),
                                  subOperationController.getAllSubWrong(),"sub");
                        imageView.setImageResource(R.drawable.titlepicksub);
                        break;
            case "mult":MultOperationController multOperationController=new MultOperationController(databaseHelper);
                        pickLvlAdapter=new PickLvlAdapter(this,images,
                                multOperationController.getAllMultPlayed(),multOperationController.getAllMultRight(),
                                  multOperationController.getAllMultWrong(),"mult");
                        imageView.setImageResource(R.drawable.titlepickmult);
                        break;
            case "div": DivOperationController divOperationController=new DivOperationController(databaseHelper);
                        pickLvlAdapter=new PickLvlAdapter(this,images,
                            divOperationController.getAllDivPlayed(),divOperationController.getAllDivRight(),
                                divOperationController.getAllDivWrong(),"div");
                        imageView.setImageResource(R.drawable.titlepickdiv);
                        break;
            default: break;
        }
        recyclerView_PickLvl.setAdapter(pickLvlAdapter);
        recyclerView_PickLvl.setLayoutManager(new LinearLayoutManager(context));
    }
}