package com.red.shinigami.interactivecookbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class adapter extends RecyclerView.Adapter<adapter.viewHolder> implements Filterable {
    private static List<Recipes> mRecipes;
    private static List<Recipes> mRecipesFiltered;

    private OnItemClickListener mListener;


    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    static class viewHolder extends RecyclerView.ViewHolder {


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
            //  Context mContext = itemView.getContext();


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


    adapter(Context context, List<Recipes> Recipes) {
        mRecipes = Recipes;
        mRecipesFiltered = new ArrayList<>(Recipes);
        Context mContext = context;


    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_contact, parent, false);
        return new viewHolder(v, mListener);
    }


    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Recipes currentRecipes = mRecipes.get(position);
        holder.mTextView.setText(currentRecipes.getmrecipeName());
        holder.mPrep.setText(currentRecipes.getmPrepTime());
        holder.mCook.setText(currentRecipes.getmCookTime());
        holder.mTotal.setText(currentRecipes.getmTotalTime());


        Glide.with(holder.itemView).load(currentRecipes.getmRecipeImages()).apply(new RequestOptions().centerCrop().placeholder(R.drawable.ic_burger).error(R.drawable.ic_error)).into(holder.mImageView);





       /* switch(position){
            case 0:

        }
        */

    }


    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            ArrayList<Recipes> Filtered = new ArrayList<>();
            if (constraint == null || constraint.length()== 0){
                Filtered.addAll(mRecipesFiltered);
            }else{
                String FilterPattern = constraint.toString().toLowerCase().trim();

                for (Recipes item : mRecipesFiltered){
                    if(item.getmrecipeName().toLowerCase().contains(FilterPattern)){
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
            mRecipes.clear();
            mRecipes.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };




    public void upToDate(List<Recipes> newList){
        mRecipesFiltered = new ArrayList<>(); // recipesList is your arrayList in your adapter that you give it from activity
        mRecipesFiltered.addAll(newList);
        notifyDataSetChanged();
    }
}
