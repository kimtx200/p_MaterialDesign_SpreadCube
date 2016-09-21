package com.taewonkim.android.materialdesignpropertyanimationspreadcube;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.icu.text.RelativeDateTimeFormatter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    Button btnSpr;
    RelativeLayout ground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button)findViewById(R.id.button);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        btn5 = (Button)findViewById(R.id.button5);
        btn6 = (Button)findViewById(R.id.button6);
        btn7 = (Button)findViewById(R.id.button7);
        btn8 = (Button)findViewById(R.id.button8);
        btn9 = (Button)findViewById(R.id.button9);

        btnSpr = (Button)findViewById(R.id.btnSpr);
        ground = (RelativeLayout)findViewById(R.id.ground);

    }

    Boolean flag=false;
    public void spread(View v){
        if(flag==false) {
            rotate(ground);
            move(btn1, -btn1.getWidth(), btn1.getHeight());
            move(btn2, 0, btn2.getHeight());
            move(btn3, btn3.getWidth(), btn3.getHeight());
            move(btn4, -btn4.getWidth(), 0);
            move(btn5, 0, 0);
            move(btn6, btn6.getWidth(), 0);
            move(btn7, -btn7.getWidth(), -btn7.getHeight());
            move(btn8, 0, -btn8.getHeight());
            move(btn9, btn9.getWidth(), -btn9.getHeight());

            flag = true;
            btnSpr.setText("Combine");
        }
        else{
            rotate(ground);
            move(btn1, 0, 0);
            move(btn2, 0, 0);
            move(btn3, 0, 0);
            move(btn4, 0, 0);
            move(btn5, 0, 0);
            move(btn6, 0, 0);
            move(btn7, 0, 0);
            move(btn8, 0, 0);
            move(btn9, 0, 0);
            btnSpr.setText("Spread");
        }

    }

    public void move(View btn, int distance_x, int distance_y){
        ObjectAnimator ani1 = ObjectAnimator.ofFloat(btn, "translationX", distance_x);
        ObjectAnimator ani2 = ObjectAnimator.ofFloat(btn, "translationY", distance_y);

        AnimatorSet aniSet = new AnimatorSet();
        aniSet.playTogether(ani1, ani2);
        aniSet.setDuration(3000);
        aniSet.start();
    }

    int angle=0;
    public void rotate(View v){
        angle = angle + 270;
        ObjectAnimator ani = ObjectAnimator.ofFloat(ground, "rotation",angle);
        ani.setDuration(3000);
        ani.start();
    }
}
