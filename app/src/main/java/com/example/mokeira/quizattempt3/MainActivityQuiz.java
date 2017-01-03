package com.example.mokeira.quizattempt3;

import android.support.v7.app.AppCompatActivity;
import java.util.List;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivityQuiz extends AppCompatActivity
{
    List<Questions> quesList;
    int score=0;
    int qid=0;
    Questions currentQ;
    TextView txtQuestion;
    RadioButton rda, rdb, rdc, rdd;
    Button butNext;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);
        QuizDatabase db=new QuizDatabase(this);
        quesList=db.getAllQuestions();
        currentQ=quesList.get(qid);
        txtQuestion=(TextView)findViewById(R.id.textView1);
        rda=(RadioButton)findViewById(R.id.radio0);
        rdb=(RadioButton)findViewById(R.id.radio1);
        rdc=(RadioButton)findViewById(R.id.radio2);
        rdd=(RadioButton)findViewById(R.id.radio3);
        butNext=(Button)findViewById(R.id.button1);
        setQuestionView();
        butNext.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                RadioGroup grp=(RadioGroup)findViewById(R.id.radioGroup1);
                RadioButton answer=(RadioButton)findViewById(grp.getCheckedRadioButtonId());
                Log.d("yourans", currentQ.getANSWER()+" "+answer.getText());
                if(currentQ.getANSWER().equals(answer.getText()))
                {
                    score++;
                    Log.d("score", "Your score"+ score);
                }
                if(qid<5)
                {
                    currentQ=quesList.get(qid);
                    setQuestionView();
                }
                else
                {
                    Intent intent= new Intent(MainActivityQuiz.this, CurrentGameScore.class);
                    Bundle b= new Bundle();
                    b.putInt("score", score);//Your acore
                    intent.putExtras(b);
                    startActivity(intent);
                    finish();
                }
            }
        });

    }

   // @Override
    //public boolean onCreateOptionsMenu(Menu menu)
   // {
// Inflate the menu; this adds items to the action bar if it is present.
       // getMenuInflater().inflate(R.menu.activity_main_quiz, menu);
      //  return true;
    //}
    private void setQuestionView()
    {
        txtQuestion.setText(currentQ.getQUESTION());
        rda.setText(currentQ.getOPTIONA());
        rdb.setText(currentQ.getOPTIONB());
        rdc.setText(currentQ.getOPTIONC());
        rdd.setText(currentQ.getOPTIOND());
        qid++;
    }


}
