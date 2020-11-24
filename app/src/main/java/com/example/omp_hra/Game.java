package com.example.omp_hra;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import io.github.controlwear.virtual.joystick.android.JoystickView;

public class Game extends AppCompatActivity {
    private static JoystickView joystickView;
    private static ImageView citizen;
    static final int[] upto2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private static RelativeLayout parent;
    static float Xposition;
    static float Yposition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        citizen = findViewById(R.id.citizen);
        joystickView = findViewById(R.id.joystick);
        parent = findViewById(R.id.parent);

        TranslateAnimation animation = new TranslateAnimation(0, 50, 0, 0);
        animation.setDuration(1000);
        animation.setFillAfter(false);
        animation.setAnimationListener(new Animationlistener() {

        });

        joystickView.setOnMoveListener(new JoystickView.OnMoveListener() {
            @Override
            public void onMove(int angle, int strength) {
                            switch (angle) {
                                case 5:
                                    citizen.startAnimation(animation);
                                    break;
                                case 6:
                                    citizen.startAnimation(animation);
                                    break;
                                default:
                                    break;


                            }
                        }
                });
        }

    private class Animationlistener implements Animation.AnimationListener {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            citizen.clearAnimation();
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(citizen.getWidth(), citizen.getHeight());
            lp.setMargins(50, 0, 0, 0);
            citizen.setLayoutParams(lp);
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            citizen.clearAnimation();
            ActionBar.LayoutParams lp = new ActionBar.LayoutParams(citizen.getWidth(), citizen.getHeight());
            lp.setMargins(50, 0, 0, 0);
            citizen.setLayoutParams(lp);
        }
    }
}
