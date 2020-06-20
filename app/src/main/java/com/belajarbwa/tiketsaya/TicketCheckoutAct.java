package com.belajarbwa.tiketsaya;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class TicketCheckoutAct extends AppCompatActivity {

    Button btn_buy_ticket, btnmines, btnplus;
    LinearLayout btn_back;
    TextView textjumlahtiket, texttotalharga, textmybalance;
    ImageView notice_uang;
    Integer valueJumlahTiket = 1;
    Integer mybalance = 200;
    Integer valuetotalharga = 0;
    Integer valuehargatiket = 76;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_checkout);

        //panggil
        btn_buy_ticket = findViewById(R.id.btn_buy_ticket);
        textmybalance = findViewById(R.id.textmybalance);
        texttotalharga = findViewById(R.id.texttotalharga);
        btnmines = findViewById(R.id.btnmines);
        btnplus = findViewById(R.id.btnplus);
        btn_back = findViewById(R.id.btn_back);
        textjumlahtiket = findViewById(R.id.textjumlahtiket);
        notice_uang = findViewById(R.id.notice_uang);

        // setting value baru untuk beberapa komponen
        valuetotalharga = valuehargatiket * valueJumlahTiket;
        texttotalharga.setText("US$" + valuetotalharga+"");
        textjumlahtiket.setText(valueJumlahTiket.toString());
       textmybalance.setText("US$" + mybalance+"");

        //secara default, kita hide btnmines
        btnmines.animate().alpha(0).setDuration(300).start();
        btnmines.setEnabled(false);
            notice_uang.setVisibility(View.GONE);

        btn_buy_ticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gosuccess = new Intent(TicketCheckoutAct.this, SuccessBuyTicketAct.class);
                startActivity(gosuccess);
            }
        });

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTiket+=1;
                textjumlahtiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket > 1) {
                    btnmines.animate().alpha(1).setDuration(300).start();
                    btnmines.setEnabled(true);
                }
                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$" + valuetotalharga+"");
                if(valuetotalharga > mybalance) {
                    btn_buy_ticket.animate().translationY(250).alpha(0).setDuration(350).start();
                    btn_buy_ticket.setEnabled(false);
                    textmybalance.setTextColor(Color.parseColor("#D1206B"));
                    notice_uang.setVisibility(View.VISIBLE);
                }


            }
        });

        btnmines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valueJumlahTiket-=1;
                textjumlahtiket.setText(valueJumlahTiket.toString());
                if (valueJumlahTiket < 2) {
                    btnmines.animate().alpha(0).setDuration(300).start();
                    btnmines.setEnabled(false);
                }
                valuetotalharga = valuehargatiket * valueJumlahTiket;
                texttotalharga.setText("US$" + valuetotalharga+"");
                if(valuetotalharga < mybalance) {
                    btn_buy_ticket.animate().translationY(0).alpha(1).setDuration(350).start();
                    btn_buy_ticket.setEnabled(true);
                    textmybalance.setTextColor(Color.parseColor("#203DD1"));
                    notice_uang.setVisibility(View.GONE );
                }
            }
        });



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goback = new Intent(TicketCheckoutAct.this, TicketDetailAct.class);
                startActivity(goback);
            }
        });
    }
}
