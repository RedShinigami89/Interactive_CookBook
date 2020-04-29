package com.red.shinigami.interactivecookbook;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> {
    private ArrayList<Recipes> mRecipes;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

     void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

     static class viewHolder extends RecyclerView.ViewHolder{


         ImageView mImageView;
         TextView mTextView;
         TextView mPrep;
         TextView mCook;
         TextView mTotal;








       viewHolder(@NonNull final View itemView, final OnItemClickListener listener) {
            super(itemView);

            mImageView = itemView.findViewById(R.id.sampleImage);
            mTextView = itemView.findViewById(R.id.recipeName);
            mPrep = itemView.findViewById(R.id.PrepTime);
            mCook = itemView.findViewById(R.id.CookTime);
            mTotal = itemView.findViewById(R.id.TotalTime);



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


    adapter(ArrayList<Recipes> Recipes){
        mRecipes = Recipes;

    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_contact, parent, false);
        viewHolder vh = new viewHolder(v, mListener);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Recipes currentRecipes = mRecipes.get(position);

        holder.mImageView.setImageResource(currentRecipes.getMsampleImage());
        holder.mTextView.setText(currentRecipes.getmrecipeName());
        holder.mPrep.setText(currentRecipes.getmPrepTime());
        holder.mCook.setText(currentRecipes.getmCookTime());
        holder.mTotal.setText(currentRecipes.getmTotalTime());





        }







    @Override
    public int getItemCount() {
        return mRecipes.size();
    }
}
