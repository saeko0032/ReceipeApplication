package com.example.saeko.receipeapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by fukuisaeko on 2017-07-24.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipe_list;
    private int numberOfRows;

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipe_list = recipeList;
    }

    class RecipeViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView descriptionTextView;
        ImageView recipeImageView;
        CheckBox checkBox;

        RecipeViewHolder(View itemViews) {
            super(itemViews);
            titleTextView = (TextView) itemView.findViewById(R.id.recipe_title);
            descriptionTextView = (TextView) itemView.findViewById(R.id.recipe_description);
            recipeImageView = (ImageView) itemView.findViewById(R.id.recipe_image);
            checkBox = (CheckBox) itemView.findViewById(R.id.recipe_checkbox);
        }
        public void bind(int index) {
            titleTextView.setText(String.valueOf(recipe_list.get(index).getTitle()));
            descriptionTextView.setText(String.valueOf(recipe_list.get(index).getDescription()));
            recipeImageView.setImageResource(recipe_list.get(index).getImgId());
            checkBox.setChecked(recipe_list.get(index).isChecked());
        }
    }

    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recipe_list_row, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        holder.bind(position);
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean checked = ((CheckBox) view).isChecked();
                if (checked) {
                    recipe_list.get(position).setChecked(true);
                } else {
                    recipe_list.get(position).setChecked(false);
                }

            }

        });
    }

    @Override
    public int getItemCount() {
        return recipe_list.size();
    }

}
