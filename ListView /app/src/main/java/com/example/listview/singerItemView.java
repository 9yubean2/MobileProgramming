package com.example.listview;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class singerItemView extends LinearLayout {
    TextView textView_name;
    TextView textView_num;

    public singerItemView(Context context) {
        super(context);
        init(context);
    }
    public singerItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.singer_item,this,true);
        textView_name = findViewById(R.id.textView_name);
        textView_num = findViewById(R.id.textView_num);
    }
    public void setName(String name) {
        textView_name.setText(name);
    }
    public void setNum(String mobile) {
        textView_num.setText(mobile);
    }
}
