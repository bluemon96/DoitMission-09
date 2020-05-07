package com.tutorial.doitmission_09;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText name,birthday,phone;
    Button insert;
    TextView c;
    int count;
    CustomAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new CustomAdapter();
        final ListView listView = findViewById(R.id.listview);

        listView.setAdapter(adapter);


        name = findViewById(R.id.et_name);
        birthday = findViewById(R.id.et_day);
        phone = findViewById(R.id.et_phone);
        insert = findViewById(R.id.btn_inset);

        c = findViewById(R.id.count);
        count= 0;

        for (int i = 1;i<11;i++){
            adapter.addItem("홍길동"+i,"1996년 01월 11일","010-1234-5678: "+count++);
        }
        c.setText(count+" 명");
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert(name,birthday,phone);
                c.setText(count+" 명");
            }
        });




    }

    public void insert(EditText name,EditText birth,EditText phone){

        if (name.getText().toString().isEmpty()||birth.getText().toString().isEmpty()||phone.getText().toString().isEmpty()){
            Toast.makeText(getApplicationContext(),"입력란을 모두 입력해주세요",Toast.LENGTH_LONG).show();
        }else {
            adapter.addItem(name.getText().toString(),birth.getText().toString(),phone.getText().toString());
            adapter.notifyDataSetChanged();
            name.setText("");
            birth.setText("");
            phone.setText("");
        }
    }
    public String totext(TextView view){

        return view.getText().toString();
    }
}

class CustomAdapter extends BaseAdapter {
    ArrayList<User> Users = new ArrayList<User>();

    @Override
    public int getCount() {
        return Users.size();
    }

    @Override
    public Object getItem(int position) {
        return Users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = parent.getContext();

        if (convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.activity_custom_list_view, parent, false);
        }

        TextView name = convertView.findViewById(R.id.list_name);
        TextView birthday =  convertView.findViewById(R.id.list_birthday);
        TextView phonenum =  convertView.findViewById(R.id.list_phonenum);

        User user = Users.get(position);

        name.setText(user.getName());
        birthday.setText(user.getBirthday());
        phonenum.setText(user.getPhonnum());

        return convertView;
    }

    public void addItem(String name, String date,String phonenum){
        User user = new User();

        user.setName(name);
        user.setBirthday(date);
        user.setPhonnum(phonenum);

        Users.add(user);
    }
}
