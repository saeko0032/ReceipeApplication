package com.example.saeko.receipeapplication;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
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
        GridLayoutManager recycleLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
      //  LinearLayoutManager linearMng = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recycleLayoutManager);
        adapter = new RecipeAdapter(recipeList, this.getApplicationContext());
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
        Recipe recipe = new Recipe("Baked Vegi", "vegi + coco oil",R.drawable.recipe1);
        recipeList.add(recipe);
        recipe = new Recipe("Ice noodle", "eggs + noodle",R.drawable.recipe2);
        recipeList.add(recipe);
        recipe = new Recipe("Seafood salad", "seafood + vegi",R.drawable.recipe3);
        recipeList.add(recipe);
        recipe = new Recipe("Chirashi don", "seafood + rice",R.drawable.recipe4);
        recipeList.add(recipe);
        recipe = new Recipe("Boiled egg", "eggs",R.drawable.recipe5);
        recipeList.add(recipe);
        recipe = new Recipe("Niku Udon", "meat + noodle",R.drawable.recipe6);
        recipeList.add(recipe);
        recipe = new Recipe("Oyako don", "chicken +  eggs",R.drawable.recipe7);
        recipeList.add(recipe);
        recipe = new Recipe("Carbonara", "eggs + pasta + cheese",R.drawable.recipe8);
        recipeList.add(recipe);
        recipe = new Recipe("Chawan mushi", "eggs",R.drawable.recipe9);
        recipeList.add(recipe);
        recipe = new Recipe("Pizza", "go buy princess",R.drawable.recipe10);
        recipeList.add(recipe);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //outState.putAll(outState);
        //outState.putString("STRING",textView.getText().toString() );
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        //textView.setText(savedInstanceState.getString("STRING"));

    }
}
