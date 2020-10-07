package com.example.schooldemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TapActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.imageView3)
    ImageView imageView3;
    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.text_student)
    AppCompatTextView textStudent;
    @BindView(R.id.text_student_id)
    AppCompatTextView textStudentId;
    @BindView(R.id.text_student_free_text)
    AppCompatTextView textStudentFreeText;
    @BindView(R.id.materialButton_ok)
    AppCompatButton materialButtonOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap);
        ButterKnife.bind(this);


        getSupportActionBar().hide();
        tapCard();
        materialButtonOk.setOnClickListener(this);


    }

    private void tapCard(){
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                ProgressDialog progress = new ProgressDialog(TapActivity.this);
                progress.setTitle("Loading");
                progress.setMessage("Please wait while we fetch data for you..");
                progress.setCancelable(false);
                progress.show();

                final Handler handler2 = new Handler(Looper.getMainLooper());
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progress.dismiss();
                        textView.setVisibility(View.GONE);
                        textStudent.setVisibility(View.VISIBLE);
                        textStudentId.setVisibility(View.VISIBLE);
                        textStudentFreeText.setVisibility(View.VISIBLE);
                        materialButtonOk.setVisibility(View.VISIBLE);
                    }
                }, 4000);

            }
        }, 4000);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.materialButton_ok:

                ProgressDialog progress = new ProgressDialog(this);
                progress.setTitle("Loading");
                progress.setMessage("Please wait while we validate data for you..");
                progress.setCancelable(false);
                progress.show();

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(TapActivity.this, DoneActivity.class);
                        startActivity(intent);
                        progress.dismiss();
                    }
                }, 4000);


                break;
        }
    }
}