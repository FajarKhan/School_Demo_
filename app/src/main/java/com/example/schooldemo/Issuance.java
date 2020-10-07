package com.example.schooldemo;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatTextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Issuance extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.edit_student_id)
    TextInputEditText editStudentId;
    @BindView(R.id.input_student_id)
    TextInputLayout inputStudentId;
    @BindView(R.id.materialButton_submit)
    AppCompatButton materialButtonSubmit;
    @BindView(R.id.text_student_id)
    AppCompatTextView textStudentId;
    @BindView(R.id.text_student_free_text)
    AppCompatTextView textStudentFreeText;
    @BindView(R.id.materialButton_read_card_id)
    AppCompatButton materialButtonReadCardId;
    @BindView(R.id.text_card_id)
    AppCompatTextView textCardId;
    @BindView(R.id.materialButton_issue_card)
    AppCompatButton materialButtonIssueCard;
    @BindView(R.id.text_student)
    AppCompatTextView textStudent;

    private List<String> studentID = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuance);
        ButterKnife.bind(this);

        getSupportActionBar().hide();
        insertData();
        materialButtonSubmit.setOnClickListener(this);
        materialButtonReadCardId.setOnClickListener(this);
        materialButtonIssueCard.setOnClickListener(this);

    }

    private void insertData() {
        studentID.add("1");
        studentID.add("2");
        studentID.add("3");
        studentID.add("4");
        studentID.add("5");
        studentID.add("6");
        studentID.add("7");
        studentID.add("8");
        studentID.add("9");
        studentID.add("10");

        data.add("Your added fee is 11");
        data.add("Your added fee is 22");
        data.add("Your added fee is 33");
        data.add("Your added fee is 44");
        data.add("Your added fee is 55");
        data.add("Your added fee is 66");
        data.add("Your added fee is 77");
        data.add("Your added fee is 88");
        data.add("Your added fee is 99");
        data.add("Your added fee is 00");
    }

    private String fechData(String studentID_) {
        String data_ = "no data found";
        for (int i = 0; i < studentID.size(); i++) {
            if (studentID_.equals(studentID.get(i))) {
                data_ = data.get(i);
            }
        }
        return data_;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.materialButton_submit:

                textStudentId.setText("Student ID : " + editStudentId.getText().toString());
                textStudentFreeText.setText(fechData(editStudentId.getText().toString()));

                ProgressDialog progress = new ProgressDialog(this);
                progress.setTitle("Loading");
                progress.setMessage("Please wait while we fetch data for you..");
                progress.setCancelable(false);
                progress.show();

                final Handler handler = new Handler(Looper.getMainLooper());
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        editStudentId.setVisibility(View.GONE);
                        inputStudentId.setVisibility(View.GONE);
                        materialButtonSubmit.setVisibility(View.GONE);
                        textStudent.setVisibility(View.VISIBLE);
                        textStudentId.setVisibility(View.VISIBLE);
                        textStudentFreeText.setVisibility(View.VISIBLE);
                        materialButtonReadCardId.setVisibility(View.VISIBLE);
                        progress.dismiss();
                    }
                }, 4000);


                break;
            case R.id.materialButton_read_card_id:

                ProgressDialog progress1 = new ProgressDialog(this);
                progress1.setTitle("Loading");
                progress1.setMessage("Please wait while we read your card..");
                progress1.setCancelable(false);
                progress1.show();

                final Handler handler1 = new Handler(Looper.getMainLooper());
                handler1.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        materialButtonReadCardId.setVisibility(View.GONE);
                        textCardId.setVisibility(View.VISIBLE);
                        materialButtonIssueCard.setVisibility(View.VISIBLE);
                        progress1.dismiss();
                    }
                }, 4000);


                break;

            case R.id.materialButton_issue_card:

                ProgressDialog progress2 = new ProgressDialog(this);
                progress2.setTitle("Loading");
                progress2.setMessage("Please wait while issuing card for you..");
                progress2.setCancelable(false);
                progress2.show();

                final Handler handler2 = new Handler(Looper.getMainLooper());
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Issuance.this, DoneActivity.class);
                        startActivity(intent);
                    }
                }, 4000);


                break;


        }
    }
}