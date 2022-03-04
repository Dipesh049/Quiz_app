package com.example.quizapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
   Button btn;
   BottomSheetDialog BottomSheetDialog;
    String tap = "a";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
//        ImageView img = findViewById(R.id.img);
//        img.setImageResource(R.drawable.one);
//        int[] images = new int[]{R.drawable.one,R.drawable.two,R.drawable.four,R.drawable.three,R.drawable.five};
//        viewFlipper = findViewById(R.id.flipper);
//        for(int i =0;i<images.length;i++){
//            flipper(images[i]);
//        }
        btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Bottomsheetfragment bottomsheetfragment = new Bottomsheetfragment();
//                bottomsheetfragment.show(getSupportFragmentManager(), bottomsheetfragment.getTag());
                BottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.AppBottomSheetDialogTheme);
                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.bottomsheetlayout,null);

                sheetView.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tap = "a";
                        Intent i = new Intent(MainActivity.this,Question_page.class);
                        i.putExtra("tapp",tap);
                        startActivity(i);
                    }
                });
                sheetView.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tap = "b";
                        Intent i = new Intent(MainActivity.this,Question_page.class);

                        i.putExtra("tapp",tap);
                        startActivity(i);
                    }
                });
                sheetView.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tap = "c";
                        Intent i = new Intent(MainActivity.this,Question_page.class);

                        i.putExtra("tapp",tap);
                        startActivity(i);
                    }
                });
                BottomSheetDialog.setContentView(sheetView);
                BottomSheetDialog.show();



            }


        });







     }



//
//     public void flipper (int images){
//        ImageView imageView = new ImageView(this);
//        imageView.setBackgroundResource(images);
//        viewFlipper.addView(imageView);
//        viewFlipper.setFlipInterval(2000);
//        viewFlipper.setAutoStart(true);
//        viewFlipper.setInAnimation(this,R.anim.fade_in);
//        viewFlipper.setOutAnimation(this,R.anim.fade_out);




//            imageflipper();



       }
//       public  void imageflipper(){
//        Handler handler = new Handler();
//        ImageView img = findViewById(R.id.img);
//        Animation ani = AnimationUtils.loadAnimation(this,android.R.anim.fade_out);
//
//
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    img.startAnimation(ani);
//                    img.setImageResource(R.drawable.two);
//                }
//            }, 2000);
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    img.startAnimation(ani);
//                    img.setImageResource(R.drawable.three);
//                }
//            }, 4000);
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    img.startAnimation(ani);
//                    img.setImageResource(R.drawable.four);
//                }
//            }, 6000);
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    img.startAnimation(ani);
//                    img.setImageResource(R.drawable.five);
//                }
//            }, 8000);








//       }
//
//}