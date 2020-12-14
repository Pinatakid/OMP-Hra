package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;
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
import android.widget.Toast;
import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Game extends AppCompatActivity {
    private static ImageView citizen, citizenright;
    private static JoystickView joystickView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        citizen = findViewById(R.id.citizen);
        citizenright = findViewById(R.id.citizenright);
        joystickView = findViewById(R.id.joystickView);
        playerMooves(citizen, citizenright, joystickView);
      }

      public void playerMooves (  View citizen,   View citizenright, JoystickView joystickView) {
          joystickView.setOnMoveListener(new JoystickView.OnMoveListener() {

              @Override
              public void onMove(int angle, int strength) {
                  if (angle <= 45 && angle >= 0 && strength >= 50) {
                      citizen.setVisibility(View.INVISIBLE);
                      citizenright.setVisibility(View.VISIBLE);
                      citizenright.setX(citizenright.getX() + 2);
                      citizen.setX(citizenright.getX());
                      citizen.setY(citizenright.getY());
                      if (citizenright.getX()>=1905f) {
                          Intent myIntent = new Intent(Game.this, Arena1.class);//Optional parameters
                          Game.this.startActivity(myIntent);
                          finishActivity(R.layout.activity_game);
                      }
                  }
                  if (angle >= 315 && angle < 360 && strength >= 50) {
                      citizen.setVisibility(View.INVISIBLE);
                      citizenright.setVisibility(View.VISIBLE);
                      citizenright.setX(citizenright.getX() + 2);
                      citizen.setX(citizenright.getX());
                      citizen.setY(citizenright.getY());
                      if (citizenright.getX()>=1905f) {
                          Intent myIntent = new Intent(Game.this, Arena1.class);//Optional parameters
                          Game.this.startActivity(myIntent);
                          finishActivity(R.layout.activity_game);
                      }
                  }
                  if (angle >= 135 && angle <= 225 && strength > 50) {
                      citizenright.setVisibility(View.INVISIBLE);
                      citizen.setVisibility(View.VISIBLE);
                      citizen.setX(citizen.getX() - 2);
                      citizenright.setX(citizen.getX());
                      citizenright.setY(citizen.getY());
                      if (citizenright.getX()>=1905f) {
                          Intent myIntent = new Intent(Game.this, Arena1.class);//Optional parameters
                          Game.this.startActivity(myIntent);
                          finishActivity(R.layout.activity_game);
                      }
                  }
                  if (angle > 45 && angle < 135 && strength == 100) {
                      CitizenAnimationYUp(citizen, -400f, 0f);
                      CitizenrightAnimationYUp(citizenright, -400f, 0f);
                      if (citizenright.getX()>=1905f) {
                          Intent myIntent = new Intent(Game.this, Arena1.class);//Optional parameters
                          Game.this.startActivity(myIntent);
                          finishActivity(R.layout.activity_game);
                      }
                  }
              }
          }, 2);
          citizenright.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  int[] location = new int[2];
                  citizenright.getLocationOnScreen(location);
                  Toast.makeText(Game.this, "X axis is " + location[0] + " and Y axis is " + location[1], Toast.LENGTH_LONG).show();
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
            animationY.addEndListener(new DynamicAnimation.OnAnimationEndListener() {
                @Override
                public void onAnimationEnd(DynamicAnimation animation, boolean canceled, float value, float velocity) {
                    animationY2.animateToFinalPosition(position2);

                }
            });
        }

    }







