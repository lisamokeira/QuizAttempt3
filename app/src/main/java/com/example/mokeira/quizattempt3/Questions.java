package com.example.mokeira.quizattempt3;

/**
 * Created by Mokeira on 1/1/17.
 * Create a class for questions in order to ease the process. It's easier than referring
 * to many strings for questions and answers.
 */

public class Questions
{
    private int ID;
    private String QUESTION;
    private String OPTIONA;
    private String OPTIONB;
    private String OPTIONC;
    private String OPTIOND;
    private String ANSWER;
    public Questions()
    {
        ID = 0;
        QUESTION = "";
        OPTIONA = "";
        OPTIONB = "";
        OPTIONC = "";
        OPTIOND = "";
        ANSWER = "";
    }

    public Questions(String question, String optionA, String optionB, String optionC, String optionD, String answer)
    {
        QUESTION = question;
        OPTIONA = optionA;
        OPTIONB = optionB;
        OPTIONC = optionC;
        OPTIOND = optionD;
        ANSWER = answer;
    }

    public int getID()
    {
        return ID;
    }

    public String getQUESTION()
    {
        return QUESTION;
    }

    public String getOPTIONA()
    {
        return OPTIONA;
    }

    public String getOPTIONB()
    {
        return OPTIONB;
    }

    public String getOPTIONC()
    {
        return OPTIONC;
    }

    public String getOPTIOND()
    {
        return OPTIOND;
    }

    public String getANSWER()
    {
        return ANSWER;
    }

    public void setID(int id)
    {
        ID = id;
    }

    public void setQUESTION(String question)
    {
        QUESTION = question;
    }

    public void setOPTIONA(String optionA)
    {
        OPTIONA = optionA;
    }

    public void setOPTIONB(String optionB)
    {
        OPTIONB = optionB;
    }

    public void setOPTIONC(String optionC)
    {
        OPTIONC = optionC;
    }

    public void setOPTIOND(String optionD)
    {
        OPTIOND = optionD;
    }

    public void setANSWER(String answer)
    {
        ANSWER = answer;
    }
}
