package com.example.vibrance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyviewHolder> {
    Context context;
    ArrayList<User> userArrayList;

    public MyAdapter(Context context, ArrayList<User> userArrayList) {
        this.context = context;
        this.userArrayList = userArrayList;
    }

    @NonNull
    @Override
    public MyAdapter.MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item,parent,false);
        return new MyviewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyviewHolder holder, int position) {
        User user = userArrayList.get(position);
        holder.message.setText(user.message);
        holder.date.setText(user.date);

    }

    @Override
    public int getItemCount() {
        return userArrayList.size();
    }
    public static class MyviewHolder extends RecyclerView.ViewHolder{
           TextView message,date;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            message = itemView.findViewById(R.id.focus_report);
            date = itemView.findViewById(R.id.current_date);
        }
    }
}
