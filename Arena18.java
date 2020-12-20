package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Arena18 extends AppCompatActivity {
    private static ImageView citizen, citizenright, golem;
    private static JoystickView joystickView;
    private static SpringAnimation animationY2, animationY4;
    private static TextView answerA, answerB, answerC, answerD, question;
    private static CardView cardView;
    Game game = new Game();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_arena18);

        citizen = findViewById(R.id.citizen18);
        citizenright = findViewById(R.id.citizenright18);
        joystickView = findViewById(R.id.joystickView18);
        cardView = findViewById(R.id.cardView18);
        answerA = findViewById(R.id.answerA18);
        answerB = findViewById(R.id.answerB18);
        answerC = findViewById(R.id.answerC18);
        answerD = findViewById(R.id.answerD18);
        question = findViewById(R.id.question18);
        golem = findViewById(R.id.golem18);

        question.setText(MainMenu.questions.get(18));
        answerA.setText(MainMenu.answers18.get(0));
        answerB.setText(MainMenu.answers18.get(1));
        answerC.setText(MainMenu.answers18.get(2));
        answerD.setText(MainMenu.answers18.get(3));

        playerMoves(citizen, citizenright, joystickView, 1920);
    }
    public void playerMoves (View citizen, View citizenright, JoystickView joystickView, float transition) {
        joystickView.setOnMoveListener(new JoystickView.OnMoveListener() {

            @Override
            public void onMove(int angle, int strength) {
                if (angle <= 60 && angle >= 0 && strength >= 50) {
                    citizen.setVisibility(View.INVISIBLE);
                    citizenright.setVisibility(View.VISIBLE);
                    citizenright.setX(citizenright.getX() + 2);
                    citizen.setX(citizenright.getX());
                    citizen.setY(citizenright.getY());
                    firstplatform();
                    actionQuiz();
                    if (citizenright.getX()>=transition) {
                        mapMove();
                    }
                }
                if (angle >= 315 && angle < 360 && strength >= 50) {
                    citizen.setVisibility(View.INVISIBLE);
                    citizenright.setVisibility(View.VISIBLE);
                    citizenright.setX(citizenright.getX() + 2);
                    citizen.setX(citizenright.getX());
                    citizen.setY(citizenright.getY());
                    firstplatform();
                    actionQuiz();
                    if (citizenright.getX()>=transition) {
                        mapMove();
                    }
                }
                if (angle >= 120 && angle <= 225 && strength > 50) {
                    citizenright.setVisibility(View.INVISIBLE);
                    citizen.setVisibility(View.VISIBLE);
                    citizen.setX(citizen.getX() - 2);
                    citizenright.setX(citizen.getX());
                    citizenright.setY(citizen.getY());
                    firstplatform();
                    actionQuiz();
                    if (citizenright.getX()>=transition) {
                        mapMove();
                    }
                }
                if (angle > 60 && angle < 120 && strength == 100) {
                    if( citizen.getY()==860f) {
                        CitizenAnimationYUp(citizen, -400f, 0f);
                        CitizenrightAnimationYUp(citizenright, -400f, 0f);
                        firstplatform();
                    }
//                    if (citizen.getY()==460f) {
//                        CitizenAnimationYUp(citizen, -800f, -400f);
//                        CitizenrightAnimationYUp(citizenright, -800f, -400f);
//                        firstplatform();
//                    }
                    actionQuiz();
                    if (citizenright.getX()>=transition) {
                        mapMove();
                    }
                }
            }
        }, 2);
        citizenright.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int[] location = new int[2];
                citizenright.getLocationOnScreen(location);
                Toast.makeText(Arena18.this, "X axis is " + location[0] + " and Y axis is " + location[1], Toast.LENGTH_LONG).show();
            }
        });
    }
    public static Point getLocationOnScreen(View view) {
        int[] location = new int[2];
        view.getLocationOnScreen(location);
        return new Point(location[0], location[1]);
    }
    public void CitizenAnimationYUp(View citizen, float position, float position2) {
        SpringAnimation animationY = new SpringAnimation(citizen, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY.setSpring(springForce);

        animationY2 = new SpringAnimation(citizen, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce2 = new SpringForce();
//        springForce2.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce2.setFinalPosition(position2);
        springForce2.setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        animationY2.setSpring(springForce2);
        animationY.start();
        animationY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
//                if (citizen.getX()<950 && citizen.getY()>50 && citizen.getX() > 350) {
//                    citizenright.setY(460f);
//                    citizen.setY(460f);
//                }
                animationY2.animateToFinalPosition(position2);
            }
        });

    }
    public void CitizenrightAnimationYUp(View citizenright, float position, float position2) {
        SpringAnimation animationY3 = new SpringAnimation(citizenright, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY3.setSpring(springForce);

        animationY4 = new SpringAnimation(citizenright, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce4 = new SpringForce();
//        springForce2.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce4.setFinalPosition(position2);
        springForce4.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY4.setSpring(springForce4);
        animationY3.start();
        animationY3.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
//                if (citizenright.getX()<950 && citizenright.getX() > 350) {
//                    citizen.setY(460f);
//                    citizenright.setY(460f);
//                }
                animationY4.animateToFinalPosition(position2);
            }
        });
    }
    public void firstplatform () {
        if (citizen.getX()>950 || citizen.getX()<350) {
            citizenright.setY(860);
            citizen.setY(860);
        }
        if (citizenright.getX()>950 || citizenright.getX()<350) {
            citizenright.setY(860);
            citizen.setY(860);
        }
    }

    public void mapMove() {
        joystickView.setFixedCenter(true);
        Intent myIntent = new Intent(Arena18.this, Arena19.class);//Optional parameters
        Arena18.this.startActivity(myIntent);
        finishActivity(R.layout.activity_arena18);
        joystickView.setFixedCenter(false);
    }
    public void actionQuiz() {
        if(citizenright.getX()==golem.getX() && citizenright.getX()==golem.getX() && citizenright.getY()>700f) {
            game.quizTest(answerC, answerD, answerA, answerB, cardView, MainMenu.correct18, joystickView, golem);
        }
    }

}