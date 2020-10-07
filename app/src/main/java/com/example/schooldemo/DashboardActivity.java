package com.example.schooldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.card_issuance)
    CardView cardIssuance;
    @BindView(R.id.card_validation)
    CardView cardValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getSupportActionBar().hide();
        cardIssuance.setOnClickListener(this);
        cardValidation.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.card_issuance:
                Intent intent = new Intent(this, Issuance.class);
                startActivity(intent);
                break;
            case R.id.card_validation:
                Intent intent2 = new Intent(this, TapActivity.class);
                startActivity(intent2);
                break;

        }
    }
}