package com.mochammadfaris.cityguide.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.mochammadfaris.cityguide.R;
import com.mochammadfaris.cityguide.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    //mengatur waktu splashscreen
    private static int SPLASH_TIMER = 10000;

    // membuat variable
    ImageView backgroundImage;
    TextView poweredByLine, title;

    // Animation
    Animation topAnim, sideAnim, buttonAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);

        //Mengkaitkan variabel dengan element
        title = findViewById(R.id.titleApp);
        poweredByLine = findViewById(R.id.poweredBy);
        backgroundImage = findViewById(R.id.icon_image);

        //mengkaitkan animasi dengan variable yang sudah dibuat
        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_anim);
        sideAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);
        buttonAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_anim);

        //Menggunakan Animasi ke element
        backgroundImage.setAnimation(sideAnim);
        poweredByLine.setAnimation(buttonAnim);
        title.setAnimation(topAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, UserDashboard.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIMER);
    }
}
