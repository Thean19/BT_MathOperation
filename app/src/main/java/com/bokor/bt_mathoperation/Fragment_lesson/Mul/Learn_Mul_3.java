package com.bokor.bt_mathoperation.Fragment_lesson.Mul;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bokor.bt_mathoperation.Activity.Home_Activity;
import com.bokor.bt_mathoperation.Fragment_lesson.Addition.Learn_2;
import com.bokor.bt_mathoperation.R;
import com.luolc.emojirain.EmojiRainLayout;
import com.thekhaeng.pushdownanim.PushDownAnim;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Learn_Mul_3 extends AppCompatActivity {
    TextView qt_top,qt_bottom,qt_result;
    TextView txt_level_current;
    int level_plus = 1;
    TextView current_lv1,current_lv2,current_lv3,current_lv4;
    Random random;

    ImageView img_back;
    Button btn1,btn2,btn3,btn4;
    AlertDialog.Builder dialogBuilder;
    AlertDialog alertDialog;
    GifImageView gifImageView;
    TextView num_result,answer;
    EmojiRainLayout container;

    Vibrator vibe;
    MediaPlayer mp1,game_over;
    TextView symbol;
    Bundle extras;
    String userName;
    //second dialog alert
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.learn);
        symbol=findViewById(R.id.symbol);
        symbol.setText("×");
        qt_top=findViewById(R.id.num_top);
        qt_bottom=findViewById(R.id.num_bottom);
        qt_result=findViewById(R.id.num_result);

        current_lv1=findViewById(R.id.current_level1);
        current_lv2=findViewById(R.id.current_level2);
        current_lv3=findViewById(R.id.current_level3);
        current_lv4=findViewById(R.id.current_level4);

        txt_level_current=findViewById(R.id.txt_level_current);


        img_back=findViewById(R.id.img_back);
        PushDownAnim.setPushDownAnimTo(img_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                onBackPressed();
            }
        });
        btn1=findViewById(R.id.btn_1);
        btn2=findViewById(R.id.btn_2);
        btn3=findViewById(R.id.btn_3);
        btn4=findViewById(R.id.btn_4);
        PushDownAnim.setPushDownAnimTo(btn1,btn2,btn3,btn4).setScale(PushDownAnim.MODE_SCALE,0.89f);
        ImageView img_hand = findViewById(R.id.img_hand);
        Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alpha_scale_animation);
        animation2.setInterpolator(new LinearInterpolator());
        img_hand.startAnimation(animation2);
        img_hand.setVisibility(View.VISIBLE);

        container=findViewById(R.id.container);

        //sound game
        mp1=MediaPlayer.create(this, R.raw.hand_clap);
        game_over=MediaPlayer.create(this,R.raw.game_over);


        vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

        answer=findViewById(R.id.answer);
        answer.setPaintFlags(answer.getPaintFlags() |   Paint.UNDERLINE_TEXT_FLAG);
        showNextQuiz();
    }
    private void showNextQuiz(){
        extras = getIntent().getExtras();
        if (extras != null) {
            userName = extras.getString("sample_mul");
            if (userName != null) {
                //text current level
                current_lv1.setText("9");
                current_lv2.setText("10");
                current_lv3.setText("11");
                current_lv4.setText("12");
                if (level_plus==1){
                    current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 9");
                }else if (level_plus==2){
                    current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 10");
                }else if (level_plus==3){
                    current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 11");
                }else if (level_plus==4){
                    current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
                    txt_level_current.setText("កម្រិត 12");
                }
            }
        }else {
            txt_level_current.setText("កម្រិត "+level_plus);
            current_lv1.setText("1");
            current_lv2.setText("2");
            current_lv3.setText("3");
            current_lv4.setText("4");
        }
        qt_result.setText("??");

        if (level_plus==1){
            current_lv1.setBackground(getDrawable(R.drawable.gradient_current_level));
            qt_top.setText("10");
            qt_bottom.setText("2");

            //btn
            btn1.setText("19");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("20");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("20");
                }
            });
            btn3.setText("21");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("22");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==2){
            current_lv2.setBackground(getDrawable(R.drawable.gradient_current_level));
            qt_top.setText("20");
            qt_bottom.setText("4");

            //btn
            btn1.setText("80");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("80");
                }
            });
            btn2.setText("81");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("82");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("83");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==3){
            current_lv3.setBackground(getDrawable(R.drawable.gradient_current_level));
            qt_top.setText("50");
            qt_bottom.setText("2");

            //btn
            btn1.setText("98");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("99");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("100");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showAlertDialogPositive();
                    qt_result.setText("100");
                }
            });
            btn4.setText("101");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
        }else if (level_plus==4){
            current_lv4.setBackground(getDrawable(R.drawable.gradient_current_level));
            qt_top.setText("80");
            qt_bottom.setText("3");

            //btn
            btn1.setText("237");
            btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn2.setText("238");
            btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn3.setText("239");
            btn3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    surprise_wrong();
                }
            });
            btn4.setText("240");
            btn4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    qt_result.setText("240");
                    qt_result.setTextSize(30f);
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_mul");
                        if (userName!=null){
                            showAlertDialogPositive();
                        }
                    }else {
                        showAlertDialogEnd();
                    }
                }
            });

        }

//        random = new Random();
//        int num = 10,max=9;
////        int ran = random.nextInt(num);
////        if (ran==0){
////            ran= ran+1;
////        }
//        //
//        max = random.nextInt(max);
//        if (max==0){
//            max=max+1;
//        }
//        String num_ran = "0";
//
//        String str = String.valueOf(random.nextInt((99 - 10) + 1) + 10);
//        char letterChar = str.charAt(0);
//        if (letterChar=='0'){
//            str = str.replace(str.substring(str.length()-1),String.valueOf(max));
//        }
//        if (str.charAt(str.length()-1)!='0'){
//            str = str.replace(str.substring(str.length()-1), num_ran);
//        }
//
////        str = str.replace(str.substring(str.length()-1), num_ran);
//        int full_in = Integer.parseInt(str);
//
//        //last_digit
//        int num_int = Integer.parseInt(num_ran);
//
//        //mul_below
//        int min = random.nextInt(max)+1 ;
//
//        //result
//        final int result = full_in * min;
//
//        //Question
//        qt_top.setText(String.valueOf(full_in));
//        qt_bottom.setText(String.valueOf(min));
//        qt_result.setText(String.valueOf(result));
//        //
//
//        System.out.println("-------- "+result);
////       int num = random.nextInt((result+5) - (result-5) + 1) + (result-5);
//        System.out.println("======"+str+"==="+num_int);
//        System.out.println("=====::::="+min);
//        ArrayList<Integer> nelist = new ArrayList<>();
//        while (nelist.size()<4){
//            int num_button = random.nextInt((result+2) - (result-2)) + (result-2);
//            if (!nelist.contains(num_button)){
//                nelist.add(num_button);
//            }
//        }
//        ArrayList<Integer> btnList = new ArrayList<>();
//        nelist.add(result);
//        ArrayList<Button> tv_list = new ArrayList<Button>();
//        tv_list.add(btn1);
//        tv_list.add(btn2);
//        tv_list.add(btn3);
//        tv_list.add(btn4);
//        while (btnList.size()<4){
//            for (int i = 0;i<nelist.size();i++){
//                if (!btnList.contains(nelist.get(i))){
//                    btnList.add(nelist.get(i));
//                    tv_list.get(i).setText(String.valueOf(btnList.get(i)));
//                    System.out.println("======"+btnList.get(i));
//                }
//            }
//            Collections.sort(btnList);
//        }
//        String value = btn1.getText().toString();
//        final int num1 = Integer.parseInt(value);
//        String value2 = btn2.getText().toString();
//        final int num2 = Integer.parseInt(value2);
//        String value3 = btn3.getText().toString();
//        final int num3 = Integer.parseInt(value3);
//        String value4 = btn4.getText().toString();
//        final int num4 = Integer.parseInt(value4);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num1 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        showAlertDialogEnd();
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num2 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                            showAlertDialogEnd();
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num3 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        showAlertDialogEnd();
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
//        btn4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(num4 == result){
//                    qt_result.setVisibility(View.VISIBLE);
//                    if (level_plus==4){
//                        showAlertDialogEnd();
//                    }else {
//                        showAlertDialogPositive();
//                    }
//                }else{
//                    surprise_wrong();
//                }
//            }
//        });
    }

    private void surprise_wrong(){
        container.stopDropping();
        showAlertDialogNegative();
        vibe.vibrate(200);
        game_over.start();
//        game_over.setLooping(true);
    }

    private void surprise_true(){
        mp1.start();
//        mp1.setLooping(true);

        //transition rain dialog win
        AutoTransition autoTransition = new AutoTransition();
        autoTransition.setDuration(2000);
        TransitionManager.beginDelayedTransition(container,autoTransition);

        //star drop
//        container.addEmoji(R.drawable.star1);
//        container.addEmoji(R.drawable.star2);
//        container.addEmoji(R.drawable.star3);
//        container.addEmoji(R.drawable.star4);
//        container.addEmoji(R.drawable.star5);
//        container.startDropping();
//        //container.stopDropping();
//        container.setPer(10);
//        container.setDuration(7200);
//        container.setDropDuration(2400);
//        container.setDropFrequency(500);
        //end
    }

    @Override
    public void onBackPressed() {
        final Dialog dialogBuilder = new Dialog(Learn_Mul_3.this,R.style.CustomDialog);
        dialogBuilder.setContentView(R.layout.layout_dialog_alert);
        Button no = dialogBuilder.findViewById(R.id.no);
        Button yes = dialogBuilder.findViewById(R.id.yes);
        PushDownAnim.setPushDownAnimTo(no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialogBuilder.cancel();
            }
        });
        dialogBuilder.show();
    }

    private void showAlertDialogNegative() {
        dialogBuilder = new AlertDialog.Builder(Learn_Mul_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new_fail, null);
        ImageView dialogButtonNegative = layoutView.findViewById(R.id.btnDialogNegative);
        ImageView home = layoutView.findViewById(R.id.home);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
//        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowFalse;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();
        PushDownAnim.setPushDownAnimTo(dialogButtonNegative).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Mul_3.this, Home_Activity.class));
                finish();
            }
        });
    }
    private void showAlertDialogPositive() {
        surprise_true();
        dialogBuilder = new AlertDialog.Builder(Learn_Mul_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_new, null);
        ImageView dialogButtonPositive = layoutView.findViewById(R.id.btnDialogPositive);
        ImageView home = layoutView.findViewById(R.id.home);
        ImageView again = layoutView.findViewById(R.id.again);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
//        dialogBuilder.setCancelable(false);
        dialogBuilder.setView(layoutView);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(dialogButtonPositive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (level_plus!=4) {
                    level_plus++;
                    showNextQuiz();
                    bk_normal();
                }else {
                    extras = getIntent().getExtras();
                    if (extras != null) {
                        userName = extras.getString("sample_mul");
                        if (userName != null) {
                            Intent intent = new Intent(getApplicationContext(), Learn_Mul_4.class);
                            intent.putExtra("sample_mul", "learn_mul3");
                            startActivity(intent);
                            finish();
                        }
                    }
                }
                alertDialog.cancel();
            }
        });
        PushDownAnim.setPushDownAnimTo(home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Mul_3.this, Home_Activity.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(again).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bk_normal();
                showNextQuiz();
                alertDialog.cancel();
            }
        });
    }

    private void showAlertDialogEnd() {
        surprise_true();

        dialogBuilder = new AlertDialog.Builder(Learn_Mul_3.this);
        View layoutView = getLayoutInflater().inflate(R.layout.dialog_next_level, null);
        TextView txt_exit_lv = layoutView.findViewById(R.id.txt_level_exit);
        txt_exit_lv.setText("អ្នកបានបញ្ចប់ហ្គេមមេរៀន");
        TextView lesson_exit_lv = layoutView.findViewById(R.id.lesson_level_exit);
        lesson_exit_lv.setText("វិធីគុណលេខមួយខ្ទង់នឹងចំនួនសូន្យខាងចុង");
        TextView con = layoutView.findViewById(R.id.con);
        TextView back = layoutView.findViewById(R.id.back);
        gifImageView = layoutView.findViewById(R.id.gifImageView);
        dialogBuilder.setView(layoutView);
//        dialogBuilder.setCancelable(false);
        alertDialog = dialogBuilder.create();
        alertDialog.getWindow().getAttributes().windowAnimations = R.style.WindowTrue;
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        alertDialog.show();

        PushDownAnim.setPushDownAnimTo(con).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Mul_3.this, Learn_Mul_4.class));
                finish();
            }
        });
        PushDownAnim.setPushDownAnimTo(back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Learn_Mul_3.this, Home_Activity.class));
                finish();
            }
        });
    }

    private void bk_normal(){
        container.stopDropping();
//        qt_result.setVisibility(View.VISIBLE);
    }

}