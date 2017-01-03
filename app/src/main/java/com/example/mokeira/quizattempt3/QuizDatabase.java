package com.example.mokeira.quizattempt3;
import java.util.ArrayList;
import java.util.List;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mokeira on 1/2/17.
 * This is the database for question
 */

public class QuizDatabase extends SQLiteOpenHelper
{
    private static final int DATABASE_VERSION = 2;
    // Database Name
    private static final String DATABASE_NAME = "capitalQuiz";
    // tasks table name
    private static final String TABLE_QUEST = "quest";
    // tasks Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_QUES = "question";
    private static final String KEY_ANSWER = "answer"; //correct option
    private static final String KEY_OPTIONA = "optiona"; //option a
    private static final String KEY_OPTIONB = "optionb"; //option b
    private static final String KEY_OPTIONC = "optionc"; //option c
    private static final String KEY_OPTIOND = "optiond"; //option d
    private SQLiteDatabase dbase;

    public QuizDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        dbase=db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER+ " TEXT, "+KEY_OPTIONA +" TEXT, "
                +KEY_OPTIONB +" TEXT, "+KEY_OPTIONC+" TEXT, "+KEY_OPTIOND+" TEXT)";
        db.execSQL(sql);
        addQuestions();
    //db.close();
    }

    private void addQuestions()
    {
        Questions q1=new Questions("What country is Nairobi in?",
                "Croatia", "Kenya", "Gambia", "Venezuela", "B");
        this.addQuestion(q1);
        Questions q2=new Questions("Which of the following is NOT " +
                "a city?", "Mexico", "Djibouti", "Monaco", "Illinois", "D");
        this.addQuestion(q2);
        Questions q3=new Questions("Which of the following is the fastest" +
                " writable memory?","RAM", "FLASH","Register", "SOMETHING", "C");
        this.addQuestion(q3);
        Questions q4=new Questions("Which of the following device" +
                " regulates internet traffic?",    "Router", "Bridge", "Hub", "YA", "A");
        this.addQuestion(q4);
        Questions q5=new Questions("Which of the following is NOT an" +
                " interpreted language?","Ruby","Python","BASIC", "JAVA", "C");
        this.addQuestion(q5);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV)
    {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }
    // Adding new question
    public void addQuestion(Questions quest)
    {
//SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTIONA, quest.getOPTIONA());
        values.put(KEY_OPTIONB, quest.getOPTIONB());
        values.put(KEY_OPTIONC, quest.getOPTIONC());
        values.put(KEY_OPTIOND, quest.getOPTIOND());
// Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }
    public List<Questions> getAllQuestions()
    {
        List<Questions> quesList = new ArrayList<Questions>();
// Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase=this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
// looping through all rows and adding to list
        if (cursor.moveToFirst())
        {
            do
            {
                Questions quest = new Questions();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTIONA(cursor.getString(3));
                quest.setOPTIONB(cursor.getString(4));
                quest.setOPTIONC(cursor.getString(5));
                quest.setOPTIOND(cursor.getString(6));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
// return quest list
        return quesList;
    }

    public int rowcount()
    {
        int row = 0;
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        row = cursor.getCount();
        return row;
    }
}

