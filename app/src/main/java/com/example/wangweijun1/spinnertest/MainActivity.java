package com.example.wangweijun1.spinnertest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import org.angmarch.views.NiceSpinner;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String[] name = {"刘备", "关羽", "张飞", "曹操", "小乔"};
    private TextView text;
    private Spinner spinner;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.textView);
        spinner = (Spinner) findViewById(R.id.spinner);

        //将可选内容与ArrayAdapter连接起来，simple_spinner_item是android系统自带样式
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, name);
        //设置下拉列表的风格,simple_spinner_dropdown_item是android系统自带的样式，等会自定义修改
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //将adapter 添加到spinner中
        spinner.setAdapter(adapter);
        //添加事件Spinner事件监听
        spinner.setOnItemSelectedListener(new SpinnerSelectedListener());


        NiceSpinner niceSpinner = (NiceSpinner) findViewById(R.id.nice_spinner);
        List<String> dataset = new LinkedList<>(Arrays.asList("One", "Two", "Three", "Four", "Five"));
//        niceSpinner.attachDataSource(dataset);
        niceSpinner.setAdapter(new CountryAdapter(getApplicationContext(),dataset));

    }

    //使用数组形式操作
    class SpinnerSelectedListener implements AdapterView.OnItemSelectedListener {

        public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
                                   long arg3) {
            text.setText("我的名字是：" + name[arg2]);
        }

        public void onNothingSelected(AdapterView<?> arg0) {
        }
    }


    public class CountryAdapter extends BaseAdapter {
        private Context context;
        private List<String> countrys;

        public CountryAdapter(Context context, List<String> countrys) {
            this.context = context;
            this.countrys = countrys;
        }


        @Override
        public int getCount() {
            return countrys.size();
        }

        @Override
        public Object getItem(int i) {
            return countrys.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(getApplicationContext());
            tv.setText("ddddddddddddddddd");
            return tv;
        }

        @Override
        public View getDropDownView(final int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(getApplicationContext());
            tv.setText("xxxxxxxxxxx");
            return tv;
        }

        public class ViewHolder {
            TextView tv_rank_country;
            RelativeLayout rl_global;
            View view_global;
        }
    }
}
