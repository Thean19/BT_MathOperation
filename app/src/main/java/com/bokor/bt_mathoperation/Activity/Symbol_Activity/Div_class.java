package com.bokor.bt_mathoperation.Activity.Symbol_Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ViewFlipper;

import com.bokor.bt_mathoperation.Activity.Go_to.Select_Lesson.Select_div_lesson;
import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Div.Learn_Div_1;
import com.bokor.bt_mathoperation.Fragment_lesson.Mul.Learn_Mul_1;
import com.bokor.bt_mathoperation.R;
import com.thekhaeng.pushdownanim.PushDownAnim;

public class Div_class extends AppCompatActivity {

    ImageView back_div,alert;
    LinearLayout rl_play,rl_practice;
    Bundle extras;
    String put_extra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_div_class);
        alert=findViewById(R.id.alert);
        ViewFlipper simpleViewFlipper = findViewById(R.id.flipper);
        Animation in = AnimationUtils.loadAnimation(this, R.anim.bounce);
        simpleViewFlipper.setInAnimation(in);
        simpleViewFlipper.setAutoStart(true);

        rl_play = findViewById(R.id.relativelayout_lesson);
        PushDownAnim.setPushDownAnimTo(rl_play).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Select_div_lesson.class));
            }
        });
        rl_practice=findViewById(R.id.relativelayout_game);
        PushDownAnim.setPushDownAnimTo(rl_practice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Learn_Div_1.class);
                intent.putExtra("sample_div", "div");
                startActivity(intent);
            }
        });
        back_div = findViewById(R.id.back_div);
        PushDownAnim.setPushDownAnimTo(back_div).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        extras = getIntent().getExtras();
        if (extras != null) {
            put_extra = extras.getString("add_to");
            if (put_extra != null) {
                Intent intent = new Intent(getApplicationContext(), Home_Activity.class);
                intent.putExtra("add_to","class");
                startActivity(intent);
                finish();
            }
        }else {
            finish();
        }
    }
}
