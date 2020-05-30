package com.red.shinigami.interactivecookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class drinkAdapter extends RecyclerView.Adapter<drinkAdapter.viewHolder> {
    private ArrayList<drinks> mDrinks;
    private adapter.OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    void setOnItemClickListener(adapter.OnItemClickListener listener){
        mListener = listener;
    }

    static class viewHolder extends RecyclerView.ViewHolder{
        ImageView mImageDrinks;
        TextView mDrinkTitle;
        TextView mDrinkDescription;

        viewHolder(@NonNull final View itemView, final adapter.OnItemClickListener listener) {
            super(itemView);
            mImageDrinks = itemView.findViewById(R.id.DrinkImages);
            mDrinkTitle = itemView.findViewById(R.id.DrinksTitle);
            mDrinkDescription = itemView.findViewById(R.id.drinksDescription);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }



            });
        }
    }

    drinkAdapter(Context context, ArrayList<drinks> drinks){
        mDrinks = drinks;
        Context mContext = context;

    }

    @NonNull
    @Override
    public drinkAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_card, parent, false);
        return new drinkAdapter.viewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull drinkAdapter.viewHolder holder, int position) {
        drinks currentDrinks = mDrinks.get(position);
        holder.mDrinkTitle.setText(currentDrinks.getmDrinksTitle());
        holder.mDrinkDescription.setText(currentDrinks.getmDrinksDescription());
        Glide.with(holder.itemView).load(currentDrinks.getmDrinksImage()).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(holder.mImageDrinks);



    }

    @Override
    public int getItemCount() {
        return mDrinks.size();
    }
}
