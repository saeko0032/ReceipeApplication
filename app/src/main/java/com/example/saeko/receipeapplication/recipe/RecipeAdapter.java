package com.example.saeko.receipeapplication.recipe;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.saeko.receipeapplication.R;

import java.util.List;

/**
 * Created by fukuisaeko on 2017-07-24.
 */

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    private List<Recipe> recipe_list;
    private int numberOfRows;
    private Context context;

    public RecipeAdapter(List<Recipe> recipeList, Context context) {
        this.recipe_list = recipeList;
        this.context = context;
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
            recipeImageView = (ImageView) itemView.findViewById(R.id.recipe_img);
            checkBox = (CheckBox) itemView.findViewById(R.id.recipe_checkbox);
        }
        public void bind(int index) {
          //  if(index%2 == 0) {
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
        View view = inflater.inflate(R.layout.recipe_list_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, final int position) {
        holder.bind(position);
        holder.recipeImageView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, RecipeDetailActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Recipe tempRecipe = recipe_list.get(position);
                i.putExtra("myObj",tempRecipe);
                context.startActivity(i);
            }
        });
        holder.recipeImageView.setOnLongClickListener(new View.OnLongClickListener(){

            @Override
            public boolean onLongClick(View view) {
                recipe_list.add(position + 1,recipe_list.get(position));
                notifyDataSetChanged();
                return true;
            }
        });
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
