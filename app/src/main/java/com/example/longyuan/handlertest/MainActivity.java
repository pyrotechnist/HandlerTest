package com.example.longyuan.handlertest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends Activity {


    TextView textView ;

    String textString;

    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView =  (TextView) findViewById(R.id.text);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        // Solution 1
        // Handler + looper + sendMessage(Message)

      /*  final Handler uiHandler = new Handler(){

            @Override
            public void handleMessage(Message msg) {

                textView.setText(textString);

            }
        };

        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    textString =  Double.toString(Math.random());
                    uiHandler.sendEmptyMessage(0);
                }
            }
        };

        Thread newThread = new Thread(runnable);
        newThread.start();*/

        // solution 1 done



        // solution 2
        // Handler + looper + Handler.post
        /*final Handler uiHandler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(1000);
                        textString = Double.toString(Math.random());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    uiHandler.post(new Runnable() {

                        @Override
                        public void run() {


                            textView.setText(textString);

                        }
                    });
                }
            }
        };

        Thread newThread = new Thread(runnable);
        newThread.start();*/

        // solution 2 done


        // solution 3 ; view.post
        // Handler + looper + view.post

        final Handler uiHandler = new Handler();

        progressBar.setMax(10);

        Runnable runnable = new Runnable() {
            @Override
            public void run() {


                for (int i = 0; i <= 10; i++) {
                    final int value = i;
                    try {
                        Thread.sleep(1000);
                        textString = Integer.toString(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    textView.post(new Runnable() {

                        @Override
                        public void run() {


                            textView.setText(textString);

                            progressBar.setProgress(value);;

                        }
                    });
                }
            }
        };

        Thread newThread = new Thread(runnable);
        newThread.start();

        // solution 3 done



    }
}
