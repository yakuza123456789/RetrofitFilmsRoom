package com.example.Android_3_home.data.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Android_3_home.R;
import com.example.Android_3_home.data.Interface.OnClickListeners;
import com.example.Android_3_home.data.models.FilmsGhibli;

import java.util.ArrayList;

public class LocalAdapter extends RecyclerView.Adapter<LocalAdapter.LocalHolder> {

    OnClickListeners onClickListenersLocal;

    public void setOnClickListenersLocal(OnClickListeners onClickListenersLocal) {
        this.onClickListenersLocal = onClickListenersLocal;
    }

    private ArrayList<FilmsGhibli> localfilms = new ArrayList<>();

    public void setLocalfilms(ArrayList<FilmsGhibli> localfilms) {
        this.localfilms = localfilms;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LocalHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_film, parent, false);
        return new LocalHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocalHolder holder, int position) {
        holder.tv_title.setText(localfilms.get(position).getTitle());
        holder.tv_producer.setText(localfilms.get(position).getProducer());
    }

    @Override
    public int getItemCount() {
        return localfilms.size();
    }

    public class LocalHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        TextView tv_producer;

       public LocalHolder(@NonNull View itemView) {
           super(itemView);
           tv_title = itemView.findViewById(R.id.tv_Title);
           tv_producer = itemView.findViewById(R.id.tv_producer);
           itemView.setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View v) {
                    onClickListenersLocal.onItemClick(getAdapterPosition());
               }
           });
       }
   }
}
