package com.example.schooldemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoneActivity extends AppCompatActivity  implements View.OnClickListener {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.materialButton_ok)
    AppCompatButton materialButtonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done);
        ButterKnife.bind(this);

        getSupportActionBar().hide();
        materialButtonOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.materialButton_ok:
                Intent intent = new Intent(this, DashboardActivity.class);
                startActivity(intent);
                break;

        }
    }
}