package com.example.asd.answersactivity;

import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String bullet="false";
    ImageButton button;
    TextView textView;
    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.ans_edit);
        //bullet=findViewById(R.id.bullet);
        button=findViewById(R.id.image_button);
        textView=findViewById(R.id.text);
        if(bullet.equals("True")){
            String temp="";
            temp=editText.getText().toString();
            if(temp.charAt(temp.length()-1)=='\n'){
                temp=temp + "\u2022";
            }
            editText.setText(temp);
        }
        //button=findViewById(R.id.button);
        //textView=findViewById(R.id.text);
        //image=findViewById(R.id.image);
        button.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {
                //editText.setCompoundDrawables(null, null, getResources().getDrawable(R.drawable.hospital2), null);
                //editText.setCompoundDrawablesWithIntrinsicBounds(null,null,null,getResources().getDrawable(R.drawable.alwar));
                //textView.setText(editText.getText().toString());
                //SpannableString ss2= new SpannableString(editText.getText().toString());
                editText.setText(editText.getText()+"\n");
                CharSequence charSeq=editText.getText()+" ";
                SpannableString ss2 = new SpannableString(charSeq);
                Drawable d2 = getResources().getDrawable(R.drawable.alwar);
                d2.setBounds(0, 0, d2.getIntrinsicWidth(), d2.getIntrinsicHeight());

                ImageSpan span2 = new ImageSpan(d2, ImageSpan.ALIGN_BOTTOM);
                ss2.setSpan(span2,charSeq.length()-1, charSeq.length(),

                        Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                //ss2.getSpanEnd(span2);
                editText.setText(ss2, TextView.BufferType.SPANNABLE);
                editText.setSelection(ss2.getSpanEnd(span2));
                editText.append("\n");
                editText.setTypeface(Typeface.DEFAULT_BOLD);
                textView.setText(editText.getText());

                //image.setImageResource(R.drawable.hospital2);
            }
        });
    }
   /* void bulletfun(View view){
        if(bullet.equals("True"))
        bullet="false";
        else
            bullet="True";
    }*/
}
