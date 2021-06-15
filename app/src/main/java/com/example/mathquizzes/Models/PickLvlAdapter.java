package com.example.mathquizzes.Models;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mathquizzes.Controllers.QuizzActivity;
import com.example.mathquizzes.R;

import org.jetbrains.annotations.NotNull;

public class PickLvlAdapter extends RecyclerView.Adapter<PickLvlAdapter.MyViewHolder>{

    String[] played, right, wrong;
    int[] images;
    Context context;
    String operation;
    public PickLvlAdapter(Context context,int[] images,String[] played, String[] right, String[] wrong,String type){
        this.context=context;
        this.images=images;
        this.played=played;
        this.right=right;
        this.wrong=wrong;
        this.operation=type;
    }

    @NotNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.lvl_picker_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PickLvlAdapter.MyViewHolder holder, int position) {
        holder.textView_played.setText(played[position]);
        holder.textView_right.setText(right[position]);
        holder.textView_wrong.setText(wrong[position]);
        holder.imageView_lvl.setImageResource(images[position]);
        holder.row.setOnClickListener(view -> {
            Intent i= new Intent(context, QuizzActivity.class);
            i.putExtra("OPERATION", operation);
            i.putExtra("LVL", position+1);
            context.startActivity(i);

        });
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView_played, textView_right, textView_wrong;
        ImageView imageView_lvl;
        ConstraintLayout row;
        public MyViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);
            textView_played=itemView.findViewById(R.id.txtPlayed);
            textView_right=itemView.findViewById(R.id.txtRight);
            textView_wrong=itemView.findViewById(R.id.txtWrong);
            imageView_lvl=itemView.findViewById(R.id.imageView_lvl);
            row=itemView.findViewById(R.id.row);
        }
    }
}
