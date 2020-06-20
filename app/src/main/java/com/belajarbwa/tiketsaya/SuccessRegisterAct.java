package com.belajarbwa.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessRegisterAct extends AppCompatActivity {
    Animation app_splash, btt, ttb;
    Button btn_explore;
    ImageView icon_success;
    TextView app_tittle, app_subtittle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_register);

        icon_success = findViewById(R.id.icon_success);
        app_tittle = findViewById(R.id.app_tittle);
        app_subtittle = findViewById(R.id.app_subtittle);
        btn_explore = findViewById(R.id.btn_explore);


        //load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt =  AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb =  AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run animation
        btn_explore.startAnimation(btt);
        icon_success.startAnimation(app_splash);
        app_tittle.startAnimation(ttb);
        app_subtittle.startAnimation(ttb);



        btn_explore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotohome = new Intent(SuccessRegisterAct.this, HomeAct.class);
                startActivity(gotohome);
            }
        });
    }
}
