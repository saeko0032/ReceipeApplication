package com.example.saeko.receipeapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by saeko on 7/27/2017.
 */

public class RecipeDetailActivity extends AppCompatActivity {
    ImageView detailImage;
    TextView detailTitle;
    TextView detailDescription;
    TextView detailRule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recipe_detail_view);

        Intent intent = getIntent();
        Recipe recipe = (Recipe)intent.getSerializableExtra("myObj");

        detailImage = (ImageView) findViewById(R.id.recipe_detail_image);
        detailTitle = (TextView) findViewById(R.id.recipe_detail_title);
        detailDescription = (TextView) findViewById(R.id.recipe_detail_description);
        detailRule = (TextView) findViewById(R.id.recipe_detail_guide);

        detailImage.setImageResource(recipe.getImgId());
        detailTitle.setText(recipe.getTitle());
        detailDescription.setText(recipe.getDescription());
        detailRule.setText(recipe.getProcess());

    }
}
