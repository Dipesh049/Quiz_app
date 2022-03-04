package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Question_page extends AppCompatActivity {
    TextView queno, question, optionA, optionB, optionC, optionD, ans,exit;
    CardView card1, card2, card3, card4;
    CountDownTimer countDownTimer;

    ProgressBar progressBar;
    public static ArrayList<Questionformate> queList;
    public static ArrayList<Questionformate> queList1;
    public static ArrayList<Questionformate> queList2;
    ArrayList<Questionformate> Allquelist;
    Questionformate questionformate;
    int index = 0;
    int progress = 10;
      int correctCount = 0;
      int  incorrectCount = 0;
      ImageView back;
      TextView level;
      String data;

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_page);

        progressBar = findViewById(R.id.progressBar);


        allids();  // all id's is found here.
         // basic question
        queList = new ArrayList<>();
        queList.add(new Questionformate("What is the correct syntax for java main method ?", "public void static main(String[] args)", "private void main(String [] args", "private static void main(String[] args)", "public static void main(String[] args)", "public static void main(String[] args)"));
        queList.add(new Questionformate("Which will legally declare, construct, and initialize an array?", "int [] myList = {\"1\", \"2\", \"3\"};", "\tint [] myList = (5, 8, 2);", "int myList [] [] = {4,9,7,0};", "int myList [] = {4, 3, 7};", "int myList [] = {4, 3, 7};"));
        queList.add(new Questionformate("Which is a reserved word in the Java programming language?", "method", "this", "subclasses", "reference", "this"));
        queList.add(new Questionformate("Which is a valid keyword in java?", "interface", "String", "Float", "unsigned", "interface"));
        queList.add(new Questionformate("Which one of the following will declare an array and initialize it with five numbers?", "Array a = new Array(5);", "int [] a = {23,22,21,20,19};", "int a [] = new int[5];", "int [5] array", "int [] a = {23,22,21,20,19};"));
        queList.add(new Questionformate("Which one is a valid declaration of a boolean?", "boolean b1 = 0;", "boolean b2 = 'false';", "boolean b3 = false;", "boolean b4 = Boolean.false();", "boolean b3 = false;"));
        queList.add(new Questionformate("Which is a valid declarations of a String?", "String s1 = null;", "String s2 = 'null';", "String s3 = (String) 'abc';", "String s4 = 'abc'", "String s1 = null;"));
        queList.add(new Questionformate("Which of the following would compile without error?", "int a = Math.abs(-5);", "int b = Math.abs(5.0);", "int c = Math.abs(5.5F);", "int d = Math.abs(5L);", "int a = Math.abs(-5);"));
        queList.add(new Questionformate("Who invented Java Programming?", "Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup", "James Gosling"));
        queList.add(new Questionformate("Which component is used to compile, debug and execute the java programs?", "JRE", "JIT", "JDK", "JVM", "JDK"));
        //medium question
        queList1 = new ArrayList<>();
        queList1.add(new Questionformate("Which of the following is not an OOPS concept in Java?", "Polymorphism", "Inheritance", "Compilation", "Encapsulation", "Compilation"));
        queList1.add(new Questionformate("What is not the use of “this” keyword in Java?", "Referring to the instance variable when a local variable has the same name", "Passing itself to the method of the same class", "Passing itself to another method", "Calling another constructor in constructor chaining", "Passing itself to the method of the same class"));
        queList1.add(new Questionformate("Which of the following is a type of polymorphism in Java Programming?", "Multiple polymorphism", "Compile time polymorphism", "Multilevel polymorphism", "Execution time polymorphism", "Compile time polymorphism"));
        queList1.add(new Questionformate("Which exception is thrown when java is out of memory?","MemoryError", "OutOfMemoryError", "MemoryOutOfBoundsException", "MemoryFullException","OutOfMemoryError"));
        queList1.add(new Questionformate("Which of these are selection statements in Java?", "break", "continue", "for()", "if()", "if()"));
        queList1.add(new Questionformate("Which of these keywords is used to define interfaces in Java?", "intf", "Intf", "interface", "Interface", "interface"));
        queList1.add(new Questionformate("Which of the following is a superclass of every class in Java?", "ArrayList", "Abstract class", "Object class", "String", "Abstract class"));
        queList1.add(new Questionformate("Which of the below is not a Java Profiler?", "JProfiler", "Eclipse Profiler", "JVM", "JConsole", "JVM"));
        queList1.add(new Questionformate("Which of these packages contains the exception Stack Overflow in Java?", "java.io", "java.system", "java.lang", "java.util","java.lang"));
        queList1.add(new Questionformate("Which of these keywords are used for the block to be examined for exceptions?", "check", "throw", "catch", "try", "try"));


        // hard question
        queList2 = new ArrayList<>();
        queList2.add(new Questionformate("Which class provides system independent server side implementation?", "Server", "ServerReader", "Socket", "ServerSocket", "ServerSocket"));
        queList2.add(new Questionformate("Which of these methods of httpd class is used to read data from the stream?", "getDta()", "GetResponse()", "getStream()", "getRawRequest()", "getRawRequest()"));
        queList2.add(new Questionformate("Which of these method of httpd class is used to get report on each hit to HTTP server?", "log()", "logEntry()", "logHttpd()", "logResponse()","logEntry()"));
        queList2.add(new Questionformate("Which of these methods are used to find a URL from the cache of httpd?", "findfromCache()", "findFromCache()", "serveFromCache()", "getFromCache()", "serveFromCache()"));
        queList2.add(new Questionformate("Which of these variables stores the number of hits that are successfully served out of cache?", "hits", "hitstocache", "hits_to_cache", "hits.to.cache", "hits.to.cache"));
        queList2.add(new Questionformate("Which of these method of httpd class is used to write UrlCacheEntry object into local disk?", "writeDiskCache()", "writetoDisk()", "writeCache()", "writeDiskEntry()", "writeDiskCache()"));
        queList2.add(new Questionformate("Which of these method is used to start a server thread?", "run()", "start()", "runThread()", "startThread()", "run()"));
        queList2.add(new Questionformate("Which of these method is called when http daemon is acting like a normal web server?", "Handle()", "HandleGet()", "handleGet()", "Handleget()", "handleGet()"));
        queList2.add(new Questionformate("Which of these are legacy classes?", "Stack", "Hashtable", "Vector", "All of the mentioned", "All of the mentioned"));
        queList2.add(new Questionformate("Which of these is the interface of legacy?", "Map", "Enumeration", "HashMap", "Hashtable", "Enumeration"));

        Intent i = getIntent();
        data = i.getStringExtra("tapp");

        level = findViewById(R.id.level);


        if(data.equals("a")){
            Allquelist = queList;
            Collections.shuffle(Allquelist);
            questionformate = Allquelist.get(index);
            level.setText("Easy Level");
        }else if(data.equals("b")){
            Allquelist = queList1;
            Collections.shuffle(Allquelist);
            questionformate = Allquelist.get(index);
            level.setText("Medium Level");
        }else{
            Allquelist = queList2;
            Collections.shuffle(Allquelist);
            questionformate = Allquelist.get(index);
            level.setText("Hard Level");
        }








        setAllData();

        back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Question_page.this,MainActivity.class);
                startActivity(i);
            }
        });




    }


    private void setAllData() {
        enableButton();
        progressBar.incrementProgressBy(10);
        resetColor();
        int q = index + 1;
        String qn = "Q." + q;
        queno.setText(qn);
        question.setText(questionformate.getQue());
        optionA.setText(questionformate.getOptionA());
        optionB.setText(questionformate.getOptionB());
        optionC.setText(questionformate.getOptionC());
        optionD.setText(questionformate.getOptionD());


    }

    private void allids() {
        queno = findViewById(R.id.qno);
        question = findViewById(R.id.question);
        optionA = findViewById(R.id.optionA);
        optionB = findViewById(R.id.optionB);
        optionC = findViewById(R.id.optionC);
        optionD = findViewById(R.id.optionD);

        card1 = findViewById(R.id.card1);
        card2 = findViewById(R.id.card2);
        card3 = findViewById(R.id.card3);
        card4 = findViewById(R.id.card4);
    }

    public void correct(CardView card) {

        card.setBackgroundColor(getResources().getColor(R.color.green));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                correctCount++;
                if (index < queList.size() - 1) {
                    index++;
                    questionformate = Allquelist.get(index);
                    setAllData();
                } else {
                    scoreboard();
                }
            }
        }, 1000);

    }

    public void wrong(CardView card) {
        card.setBackgroundColor(getResources().getColor(R.color.red));
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                incorrectCount++;
                if (index < queList.size() - 1) {
                    index++;
                    questionformate = Allquelist.get(index);
                    setAllData();
                } else {
                    scoreboard();
                }
            }
        }, 1000);

    }

    // it will called after the completion of the quiz
    private void scoreboard() {
        Intent i = new Intent(Question_page.this, scoreboard.class);
        i.putExtra("correct",correctCount);
        i.putExtra("incorrect",incorrectCount);
        startActivity(i);
    }

    //to enable all button after going on next question.
    public void enableButton() {
        card1.setClickable(true);
        card2.setClickable(true);
        card3.setClickable(true);
        card4.setClickable(true);
    }

    // to disable button after user selects the option.
    public void disableButton() {
        card1.setClickable(false);
        card2.setClickable(false);
        card3.setClickable(false);
        card4.setClickable(false);
    }

    //it will reset the background color of button on next question
    public void resetColor() {
        card1.setBackgroundColor(getResources().getColor(R.color.black));
        card2.setBackgroundColor(getResources().getColor(R.color.black));
        card3.setBackgroundColor(getResources().getColor(R.color.black));
        card4.setBackgroundColor(getResources().getColor(R.color.black));
    }


    public void optionA(View view) {
        disableButton();
        if (questionformate.getOptionA().equals(questionformate.getAns())) {
           correct(card1);
        } else {
            wrong(card1);
        }
    }

    public void optionB(View view) {
        disableButton();
        if (questionformate.getOptionB().equals(questionformate.getAns())) {
           correct(card2);
        } else {
            wrong(card2);
        }
    }
    public void optionC(View view) {
        disableButton();
        if (questionformate.getOptionC().equals(questionformate.getAns())) {
           correct(card3);
        } else {
            wrong(card3);
        }
    }
    public void optionD(View view) {
        disableButton();
        if (questionformate.getOptionD().equals(questionformate.getAns())) {
            correct(card4);
        } else {
            wrong(card4);
        }
    }


}