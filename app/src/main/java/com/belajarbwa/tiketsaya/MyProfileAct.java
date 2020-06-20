package com.belajarbwa.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyProfileAct extends AppCompatActivity {

    LinearLayout btn_ticket_detail;
    Button btn_edit_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        btn_ticket_detail = findViewById(R.id.btn_ticket_detail);
        btn_edit_profile = findViewById(R.id.btn_edit_profile);
        btn_ticket_detail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goticketdetail = new Intent(MyProfileAct.this, MyTicketDetailAct.class);
                startActivity(goticketdetail);
            }
        });
        btn_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goeditprof = new Intent(MyProfileAct.this, EditProfileAct.class);
                startActivity(goeditprof);
            }
        });
    }
}