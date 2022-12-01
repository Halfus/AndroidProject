package com.example.planland;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.planland.entities.Box;

import java.util.ArrayList;

public class BoxAdapter extends RecyclerView.Adapter<BoxAdapter.ViewHolder> {

    private ArrayList<Box> boxes;
    private OnClickListener onClickListener;

    BoxAdapter(ArrayList<Box> boxes) {
        this.boxes = boxes;
    }

    public void setOnClickListener(OnClickListener listener) {
        this.onClickListener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.box_list_item, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        viewHolder.name.setText(boxes.get(position).getName());
        //viewHolder.icon.setImageResource(boxes.get(position).getDescription());
    }

    public int getItemCount() {
        return boxes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ImageView icon;

        ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.box_name);
            //icon = itemView.findViewById(R.id.box_icon);
            itemView.setOnClickListener(v -> {
                onClickListener.onClick(boxes.get(getBindingAdapterPosition()));
            });
        }
    }

    public interface OnClickListener {
        void onClick(Box box);
    }
}