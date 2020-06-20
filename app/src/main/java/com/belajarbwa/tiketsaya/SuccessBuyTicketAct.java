package com.belajarbwa.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuccessBuyTicketAct extends AppCompatActivity {
    Animation app_splash, btt, ttb;
    Button btn_view_ticket, btn_my_dashboard;
    TextView app_title, app_subtitle;
    ImageView emblem_success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_buy_ticket);

        emblem_success = findViewById(R.id.emblem_success);
        app_title = findViewById(R.id.app_title);
        app_subtitle = findViewById(R.id.app_subtitle);
        btn_view_ticket = findViewById(R.id.btn_view_ticket);
        btn_my_dashboard = findViewById(R.id.btn_my_dashboard);

//load animation
        app_splash = AnimationUtils.loadAnimation(this, R.anim.app_splash);
        btt =  AnimationUtils.loadAnimation(this, R.anim.btt);
        ttb =  AnimationUtils.loadAnimation(this, R.anim.ttb);

        //run animation
        emblem_success.startAnimation(app_splash);
        app_title.startAnimation(ttb);
        app_subtitle.startAnimation(ttb);
        btn_my_dashboard.startAnimation(btt);
        btn_view_ticket.startAnimation(btt);
    }
}