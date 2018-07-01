package com.xsheists.android.quizapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "myActivity" ;
    private RadioGroup Question_one, Question_two, Question_three, Question_four, Question_five;
    private RadioButton ansTo1, ansTo2, ansTo3, ansTo4, ansTo5;
    private CheckBox Ans6a, Ans6b, Ans6c, Ans7a, Ans7b, Ans7c, Ans8a, Ans8b, Ans8c;
    private EditText Ans_nine, Ans_ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        }
    public void onSubmit(View view) {
        int Score = 0;
        Question_one = findViewById(R.id.RG1);
        Question_two = findViewById(R.id.RG2);
        Question_three = findViewById(R.id.RG3);
        Question_four = findViewById(R.id.RG4);
        Question_five = findViewById(R.id.RG5);

        ansTo1 = findViewById(R.id.RBtn1_2);
        ansTo2 = findViewById(R.id.RBtn2_1);
        ansTo3 = findViewById(R.id.RBtn3_3);
        ansTo4 = findViewById(R.id.RBtn4_3);
        ansTo5 = findViewById(R.id.RBtn5_2);

        int Checked_Id1 = Question_one.getCheckedRadioButtonId();
        int Checked_Id2 = Question_two.getCheckedRadioButtonId();
        int Checked_Id3 = Question_three.getCheckedRadioButtonId();
        int Checked_Id4 = Question_four.getCheckedRadioButtonId();
        int Checked_Id5 = Question_five.getCheckedRadioButtonId();

        int[] RadioBtn = {Checked_Id1, Checked_Id2, Checked_Id3, Checked_Id4, Checked_Id5};
        for (int aRadioBtn : RadioBtn) {
            if (aRadioBtn == ansTo1.getId() || aRadioBtn == ansTo2.getId() || aRadioBtn == ansTo3.getId() || aRadioBtn == ansTo4.getId() || aRadioBtn == ansTo5.getId()) {
                Score++;
                }

            }
        Ans6a = findViewById(R.id.chkBox6a);
        Ans6b = findViewById(R.id.chkBox6b);
        Ans6c = findViewById(R.id.chkBox6c);
        Ans7a = findViewById(R.id.chkBox7a);
        Ans7b = findViewById(R.id.chkBox7b);
        Ans7c = findViewById(R.id.chkBox7c);
        Ans8a = findViewById(R.id.chkBox8a);
        Ans8b = findViewById(R.id.chkBox8b);
        Ans8c = findViewById(R.id.chkBox8c);

            if (Ans6a.isChecked() && Ans6c.isChecked() && !Ans6b.isChecked()){
                Score++ ;
                }

            if (Ans7a.isChecked() && Ans7c.isChecked() && !Ans7b.isChecked()) {
                Score++;
                Log.i(TAG, "Q7 is right");
                }
            if (Ans8a.isChecked() && Ans8b.isChecked() && !Ans8c.isChecked()) {
                Score++;
                }

            Ans_nine = findViewById(R.id.Q9Ans);
            Ans_ten = findViewById(R.id.Q10Ans);

            String userInput9 = Ans_nine.getText().toString();
            String userInput10 = Ans_ten.getText().toString();

            if(userInput9.equals("void")){
                Score++ ;
                }
            if (userInput10.equals("Yes") || userInput10.equals("There can") || userInput10.equals("Yes there can") || userInput10.equals("yes") || userInput10.equals("true") || userInput10.equals("True")){
                Score++ ;
                }
           int ScorePercent = Score * 10 ;

            CharSequence text;
            int duration = Toast.LENGTH_LONG;

            if (ScorePercent == 100) {
                text = "Excellent, you got a perfect score, you scored " + ScorePercent + "%";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                }
            else if (ScorePercent >= 80) {
                text = "Splendid you scored " + ScorePercent + "%";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                }
            else if (ScorePercent >= 60) {
                text = "You did fair, you scored " + ScorePercent;
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                }
            else if (ScorePercent > 0) {
                text = "You really can do better, you scored " + ScorePercent + "%";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                }
            else {
                text = "I don't know bud, you might want to brush up on your Java, you scored " + ScorePercent + "%";
                Toast toast = Toast.makeText(this, text, duration);
                toast.show();
                }
    }
}

