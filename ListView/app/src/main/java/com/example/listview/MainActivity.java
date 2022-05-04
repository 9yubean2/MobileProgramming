package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SingleAdapter adapter;
    EditText editText_name;
    EditText editText_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_name = (EditText)findViewById(R.id.editText_name);
        editText_num = (EditText)findViewById(R.id.editText_num);
        ListView listView = (ListView)findViewById(R.id.listView);
        //어댑터 안에 데이터 담기
        adapter = new SingleAdapter();
        adapter.addItem(new singerItem("이규빈","010-9040-3024"));
        //리스트뷰에 어댑터 설정
        listView.setAdapter(adapter);
        //이벤트 처리 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
                singerItem item = (singerItem) adapter.getItem(position);
                Toast.makeText(getApplicationContext(),"선택:"+item.getName(),Toast.LENGTH_LONG).show();
            }
        });
        Button btn_register = (Button) findViewById(R.id.btn_register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText_name.getText().toString();
                String mobile = editText_num.getText().toString();
                adapter.addItem(new singerItem(name, mobile));
                adapter.notifyDataSetChanged();
            }
        });
    }

    class SingleAdapter extends BaseAdapter {
        ArrayList<singerItem>items = new ArrayList<singerItem>();
        @Override
        public int getCount() {
            return items.size();
        }
        public void addItem(singerItem item) {
            items.add(item);
        }
        @Override
        public Object getItem(int position) {
            return items.get(position);
        }
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            singerItemView view = null;
            if (convertView == null) {
                view = new singerItemView(getApplicationContext());
            } else {
                view = (singerItemView) convertView;
            }
            singerItem item = items.get(position);
            view.setName(item.getName());
            view.setNum(item.getMobile());
            return view;
        }
    }
}