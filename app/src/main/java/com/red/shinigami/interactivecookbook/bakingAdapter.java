package com.red.shinigami.interactivecookbook;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class bakingAdapter extends RecyclerView.Adapter<bakingAdapter.viewHolder> implements Filterable {
    private static ArrayList<Baking_Model> mBakingRecipes;
    private static ArrayList<Baking_Model> mBakingRecipesFiltered;
    private adapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    bakingAdapter(Context context, ArrayList<Baking_Model> Recipes) {
        mBakingRecipes = Recipes;
        mBakingRecipesFiltered = new ArrayList<>(Recipes);
    }

    void setOnItemClickListener(adapter.OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_baked__card, parent, false);
        return new bakingAdapter.viewHolder(v, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Baking_Model currentRecipes = mBakingRecipes.get(position);
        holder.mName.setText(currentRecipes.getmName());
        holder.mPrep.setText(currentRecipes.getmPrep());
        holder.mCook.setText(currentRecipes.getmCook());
        holder.mTotal.setText(currentRecipes.getmTotal());

        Glide.with(holder.itemView).load(currentRecipes.getmImage()).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(holder.mImage);



    }

    @Override
    public int getItemCount() {
        return mBakingRecipes.size();
    }

    static class viewHolder extends RecyclerView.ViewHolder {

        TextView mName;
        ImageView mImage;
        TextView mPrep;
        TextView mCook;
        TextView mTotal;


        public viewHolder(@NonNull View itemView, final adapter.OnItemClickListener listener) {
            super(itemView);
            mName = itemView.findViewById(R.id.recipeNameBaked);
            mImage = itemView.findViewById(R.id.IMG_Baked);
            mPrep = itemView.findViewById(R.id.BakedPrepTime);
            mCook = itemView.findViewById(R.id.BakedCookTime);
            mTotal = itemView.findViewById(R.id.BakedTotalTime);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);


                        }


                    }

                }


            });
        }
    }


    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Baking_Model> Filtered = new ArrayList<>();
            if (constraint == null || constraint.length()== 0){
                Filtered.addAll(mBakingRecipesFiltered);
            }else{
                String FilterPattern = constraint.toString().toLowerCase().trim();

                for (Baking_Model item : mBakingRecipesFiltered){
                    if(item.getmName().toLowerCase().contains(FilterPattern)){
                        Filtered.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = Filtered;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults results) {
            mBakingRecipes.clear();
            mBakingRecipes.addAll((List)results.values);
            notifyDataSetChanged();

        }
    };

}

