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

        TextView titleTextViewLeft;
        TextView descriptionTextViewLeft;
        ImageView recipeImageViewLeft;
        CheckBox checkBoxLeft;
        TextView titleTextViewRight;
        TextView descriptionTextViewRight;
        ImageView recipeImageViewRight;
        CheckBox checkBoxRight;

        RecipeViewHolder(View itemViews) {
            super(itemViews);
            titleTextViewLeft = (TextView) itemView.findViewById(R.id.recipe_title_left);
            descriptionTextViewLeft = (TextView) itemView.findViewById(R.id.recipe_description_left);
            recipeImageViewLeft = (ImageView) itemView.findViewById(R.id.recipe_img_left);
            checkBoxLeft = (CheckBox) itemView.findViewById(R.id.recipe_checkbox_left);

            titleTextViewRight = (TextView) itemView.findViewById(R.id.recipe_title_right);
            descriptionTextViewRight = (TextView) itemView.findViewById(R.id.recipe_description_right);
            recipeImageViewRight = (ImageView) itemView.findViewById(R.id.recipe_img_right);
            checkBoxRight = (CheckBox) itemView.findViewById(R.id.recipe_checkbox_right);
        }
        public void bind(int index) {
            if(index%2 == 0) {
                titleTextViewLeft.setText(String.valueOf(recipe_list.get(index).getTitle()));
                descriptionTextViewLeft.setText(String.valueOf(recipe_list.get(index).getDescription()));
                recipeImageViewLeft.setImageResource(recipe_list.get(index).getImgId());
                checkBoxLeft.setChecked(recipe_list.get(index).isChecked());
            } else {
                titleTextViewRight.setText(String.valueOf(recipe_list.get(index).getTitle()));
                descriptionTextViewRight.setText(String.valueOf(recipe_list.get(index).getDescription()));
                recipeImageViewRight.setImageResource(recipe_list.get(index).getImgId());
                checkBoxRight.setChecked(recipe_list.get(index).isChecked());
            }
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
        holder.checkBoxLeft.setOnClickListener(new View.OnClickListener() {
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
        holder.checkBoxRight.setOnClickListener(new View.OnClickListener() {
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
