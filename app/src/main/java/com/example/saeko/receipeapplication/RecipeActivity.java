package com.example.saeko.receipeapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {
    List<Recipe> recipeList;
    private RecipeAdapter adapter;
    private RecyclerView recyclerView;
    private Button clearBtn;
    private Button selectBtn;
    private  Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_recycle);

        recipeList = new ArrayList<>();
        prepareRecipeData();

        recyclerView = (RecyclerView) findViewById(R.id.recipe_recycler);
        clearBtn = (Button) findViewById(R.id.recipe_clear);
        selectBtn = (Button) findViewById(R.id.recipe_select);
        deleteBtn = (Button) findViewById(R.id.recipe_delete);

        // change checkbox's status
        clearBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                for(Recipe recipe: recipeList) {
                    recipe.setChecked(false);
                }
                // we need to tell it to adapter
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        // change checkbox's status
        selectBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                for(Recipe recipe: recipeList) {
                    recipe.setChecked(true);
                }

                // we need to tell it to adapter
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        // check movi_list_ischecked status -> if checked delete and refresh it
        deleteBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                for( int i = recipeList.size() - 1; i >= 0; i--) {
                    if(recipeList.get(i).isChecked()) {
                        recipeList.remove(i);
                    }
                }
                adapter.notifyDataSetChanged();
                setFadeAnimation(view);
            }
        });

        LinearLayoutManager linearMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearMng);
        adapter = new RecipeAdapter(recipeList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the orientation of the screen
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            adapter.notifyDataSetChanged();
        } else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
            adapter.notifyDataSetChanged();
        }
    }

    private void setFadeAnimation(View view) {
        AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
        anim.setDuration(1000);
        view.startAnimation(anim);
    }

    public void prepareRecipeData() {
        Recipe recipe = new Recipe("Title 1", "rice with eggs",R.drawable.recipe1);
        recipeList.add(recipe);
        recipe = new Recipe("Title 2", "rice with eggs",R.drawable.recipe2);
        recipeList.add(recipe);
        recipe = new Recipe("Title 3", "rice with eggs",R.drawable.recipe3);
        recipeList.add(recipe);
        recipe = new Recipe("Title 4", "rice with eggs",R.drawable.recipe4);
        recipeList.add(recipe);
        recipe = new Recipe("Title 5", "rice with eggs",R.drawable.recipe5);
        recipeList.add(recipe);
        recipe = new Recipe("Title 6", "rice with eggs",R.drawable.recipe6);
        recipeList.add(recipe);
        recipe = new Recipe("Title 7", "rice with eggs",R.drawable.recipe7);
        recipeList.add(recipe);
        recipe = new Recipe("Title 8", "rice with eggs",R.drawable.recipe8);
        recipeList.add(recipe);
        recipe = new Recipe("Title 9", "rice with eggs",R.drawable.recipe9);
        recipeList.add(recipe);
        recipe = new Recipe("Title 10", "rice with eggs",R.drawable.recipe10);
        recipeList.add(recipe);
    }
}
