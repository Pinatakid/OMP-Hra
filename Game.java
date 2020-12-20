package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Game extends AppCompatActivity {
    private static ImageView citizen, citizenright, golem;
    private static JoystickView joystickView;
    private static Button button_test;
    private static CardView cardView;
    private static TextView answerA, answerB, answerC, answerD, question;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        citizen = findViewById(R.id.citizen0);
        citizenright = findViewById(R.id.citizenright0);
        joystickView = findViewById(R.id.joystickView0);
        button_test = findViewById(R.id.test_button);
        cardView = findViewById(R.id.cardView0);
        answerA = findViewById(R.id.answerA0);
        answerB = findViewById(R.id.answerB0);
        answerC = findViewById(R.id.answerC0);
        answerD = findViewById(R.id.answerD0);
        question = findViewById(R.id.question0);
        golem = findViewById(R.id.golem);

        question.setText(MainMenu.questions.get(0));
        answerA.setText(MainMenu.answers0.get(0));
        answerB.setText(MainMenu.answers0.get(1));
        answerC.setText(MainMenu.answers0.get(2));
        answerD.setText(MainMenu.answers0.get(3));


        playerMoves(citizen, citizenright, joystickView, 1920);
        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quizTest(answerA, answerB, answerC, answerD, cardView, MainMenu.correct0, joystickView, golem);
            }
        });
    }

      public void playerMoves (View citizen, View citizenright, JoystickView joystickView, float transition) {
          joystickView.setOnMoveListener(new JoystickView.OnMoveListener() {

              @Override
              public void onMove(int angle, int strength) {
                  if (angle <= 45 && angle >= 0 && strength >= 50) {
                      citizen.setVisibility(View.INVISIBLE);
                      citizenright.setVisibility(View.VISIBLE);
                      citizenright.setX(citizenright.getX() + 2);
                      citizen.setX(citizenright.getX());
                      citizen.setY(citizenright.getY());
                      if (citizenright.getX() >= transition&& citizenright.getX()<1940) {
                          mapMove();
                      }
                  }
                  if (angle >= 315 && angle < 360 && strength >= 50) {
                      citizen.setVisibility(View.INVISIBLE);
                      citizenright.setVisibility(View.VISIBLE);
                      citizenright.setX(citizenright.getX() + 2);
                      citizen.setX(citizenright.getX());
                      citizen.setY(citizenright.getY());
                      if (citizenright.getX() >= transition && citizenright.getX()<1940) {
                          mapMove();
                      }
                  }
                  if (angle >= 135 && angle <= 225 && strength > 50) {
                      citizenright.setVisibility(View.INVISIBLE);
                      citizen.setVisibility(View.VISIBLE);
                      citizen.setX(citizen.getX() - 2);
                      citizenright.setX(citizen.getX());
                      citizenright.setY(citizen.getY());
                      if (citizenright.getX() >= transition&& citizenright.getX()<1940) {
                          mapMove();
                      }
                  }
                  if (angle > 45 && angle < 135 && strength == 100) {
                      CitizenAnimationYUp(citizen, -400f, 0f);
                      CitizenrightAnimationYUp(citizenright, -400f, 0f);
                      if (citizenright.getX() >= transition&& citizenright.getX()<1940) {
                          mapMove();
                      }
                  }
              }
          }, 2);
      }

    public void CitizenAnimationYUp(View citizen, float position, float position2) {
        SpringAnimation animationY = new SpringAnimation(citizen, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY.setSpring(springForce);

        SpringAnimation animationY2 = new SpringAnimation(citizen, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce2 = new SpringForce();
//        springForce2.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce2.setFinalPosition(position2);
        springForce2.setDampingRatio(SpringForce.DAMPING_RATIO_LOW_BOUNCY);
        animationY2.setSpring(springForce2);
        animationY.start();

        animationY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                animationY2.animateToFinalPosition(position2);
            }
        });
        animationY2.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
            @Override
            public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {

            }
        });

    }

    public void CitizenrightAnimationYUp(View citizenright, float position, float position2) {
        SpringAnimation animationY = new SpringAnimation(citizenright, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce = new SpringForce();
        springForce.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce.setFinalPosition(position);
        springForce.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY.setSpring(springForce);

        SpringAnimation animationY2 = new SpringAnimation(citizenright, DynamicAnimation.TRANSLATION_Y);
        SpringForce springForce2 = new SpringForce();
//        springForce2.setStiffness(SpringForce.STIFFNESS_VERY_LOW);
        springForce2.setFinalPosition(position2);
        springForce2.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY);
        animationY2.setSpring(springForce2);
            animationY.start();
            joystickView.setEnabled(false);
            animationY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                @Override
                public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                    animationY2.animateToFinalPosition(position2);

                }
            });
            animationY2.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                @Override
                public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                joystickView.setEnabled(true);
                }
            });
        }


        public void quizTest (TextView answer1, TextView answer2, TextView answer3,
                              TextView answer4, CardView cardView, String correct,
                              JoystickView joystickView, ImageView golem) {
                joystickView.resetButtonPosition();
                joystickView.setEnabled(false);
                cardView.setVisibility(View.VISIBLE);
                answer1.setBackgroundColor(Color.WHITE);
                answer2.setBackgroundColor(Color.WHITE);
                answer3.setBackgroundColor(Color.WHITE);
                answer4.setBackgroundColor(Color.WHITE);

                answer1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (answer1.getText().toString().equals(correct)) {
                            answer1.setBackgroundColor(Color.GREEN);
                            golem.setVisibility(View.GONE);

                        }else
                        answer1.setBackgroundColor(Color.RED);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (answer1.getText().toString().equals(correct)){
                                    cardView.setVisibility(View.GONE);
                                    golem.setY(0);
                                    golem.setX(0);
                                    joystickView.setEnabled(true);
                                }else
                                quizTest(answer1, answer2,answer3,
                                        answer4, cardView,  correct,
                                        joystickView,  golem);

                            }
                        }, 1500);


                    }
                });
                answer2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (answer2.getText().toString().equals(correct)) {
                            answer2.setBackgroundColor(Color.GREEN);
                            golem.setVisibility(View.GONE);

                        }else
                        answer2.setBackgroundColor(Color.RED);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (answer2.getText().toString().equals(correct)){
                                    cardView.setVisibility(View.GONE);
                                    joystickView.setEnabled(true);
                                    golem.setY(0);
                                    golem.setX(0);
                                }else
                                    quizTest(answer1, answer2,answer3,
                                            answer4, cardView,  correct,
                                            joystickView,  golem);

                            }
                        }, 1500);
                    }
                });
                answer3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (answer3.getText().toString().equals(correct)) {
                            answer3.setBackgroundColor(Color.GREEN);
                            golem.setVisibility(View.GONE);

                        }else
                        answer3.setBackgroundColor(Color.RED);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (answer3.getText().toString().equals(correct)){
                                    cardView.setVisibility(View.GONE);
                                    golem.setY(0);
                                    golem.setX(0);
                                    joystickView.setEnabled(true);
                                }else
                                    quizTest(answer1, answer2,answer3,
                                            answer4, cardView,  correct,
                                            joystickView,  golem);

                            }
                        }, 1500);
                    }
                });
                answer4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (answer4.getText().toString().equals(correct)) {
                            answer4.setBackgroundColor(Color.GREEN);
                            golem.setVisibility(View.GONE);

                        } else
                            answer4.setBackgroundColor(Color.RED);
                        final Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                if (answer4.getText().toString().equals(correct)){
                                    cardView.setVisibility(View.GONE);
                                    golem.setY(0);
                                    golem.setX(0);
                                    joystickView.setEnabled(true);
                                }else
                                    quizTest(answer1, answer2,answer3,
                                            answer4, cardView,  correct,
                                             joystickView,  golem);
                            }
                        }, 1500);

                    }
                });
        }
            public void mapMove () {
                joystickView.setFixedCenter(true);
                Intent myIntent = new Intent(Game.this, Arena1.class);//Optional parameters
                Game.this.startActivity(myIntent);
                finishActivity(R.layout.activity_game);
                joystickView.setFixedCenter(false);
            }
        }











