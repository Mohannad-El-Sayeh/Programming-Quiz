package com.msayeh.programmersquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioButton firstAnswer, secondAnswer;
    CheckBox javaAnswer, swiftAnswer, kotlinAnswer, rubyAnswer;
    EditText writtenAnswer;
    Button submit;

    final String ACTUAL_WRITTEN_ANSWER = "var x: String";
    final int NUMBER_OF_QUESTIONS = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstAnswer = findViewById(R.id.radio1_answer_3);
        secondAnswer = findViewById(R.id.radio2_answer_2);
        javaAnswer = findViewById(R.id.checkbox1);
        swiftAnswer = findViewById(R.id.checkbox2);
        kotlinAnswer = findViewById(R.id.checkbox3);
        rubyAnswer = findViewById(R.id.checkbox4);
        writtenAnswer = findViewById(R.id.written);
        submit = findViewById(R.id.btn_sumbit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int score = 0;
                if(firstAnswer.isChecked()){
                    score++;
                }
                if(secondAnswer.isChecked()){
                    score++;
                }
                if(javaAnswer.isChecked() && kotlinAnswer.isChecked() && !swiftAnswer.isChecked() && !rubyAnswer.isChecked()){
                    score++;
                }
                if(writtenAnswer.getText().toString().equals(ACTUAL_WRITTEN_ANSWER)){
                    score++;
                }
                if(score == NUMBER_OF_QUESTIONS){
                    Toast.makeText(getApplicationContext(), "Congratulations, You've gotten the full mark.", Toast.LENGTH_LONG).show();
                }else if(score == 0){
                    Toast.makeText(getApplicationContext(), "Sorry, All answers are wrong.", Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(getApplicationContext(), String.format("You've answered %d questions correctly out of %d.", score, NUMBER_OF_QUESTIONS), Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}