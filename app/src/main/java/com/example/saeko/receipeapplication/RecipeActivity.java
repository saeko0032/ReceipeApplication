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
//        // 1
//        Movie movie = new Movie("Mad Max: Fury Road", "Action & Adventure", "2015", R.drawable.movie1);
//        movieList.add(movie);
//        // 2
//        movie = new Movie("Inside Out", "Animation, Kids & Family", "2015", R.drawable.movie2);
//        movieList.add(movie);
//        // 3
//        movie = new Movie("The Shawshank Redemption ", "Drama", "1994", R.drawable.movie3);
//        movieList.add(movie);
//        // 4
//        movie = new Movie("The Godfather ", "Drama", "1972", R.drawable.movie4);
//        movieList.add(movie);
//        // 5
//        movie = new Movie("The Dark Knight", "Action & Drama", "2008", R.drawable.movie5);
//        movieList.add(movie);
//        // 6
//        movie = new Movie("12 Angry Men ", "Cinema & Drama", "1957", R.drawable.movie6);
//        movieList.add(movie);
//        // 7
//        movie = new Movie("Schindler's List", "Biography & History", "1993", R.drawable.movie7);
//        movieList.add(movie);
//        // 8
//        movie = new Movie("Pulp Fiction", "Animation, Kids & Family", "1994", R.drawable.movie8);
//        movieList.add(movie);
//        // 9
//        movie = new Movie("Fight Club", "Drama", "1999", R.drawable.movie9);
//        movieList.add(movie);
//        // 10
//        movie = new Movie(" The Lord of the Ring", "Adventure & Fantasy", "2003", R.drawable.movie10);
//        movieList.add(movie);
//        // 11
//        movie = new Movie("Forest Gump", "Comedy & Romance", "1994", R.drawable.movie11);
//        movieList.add(movie);
    }
}
