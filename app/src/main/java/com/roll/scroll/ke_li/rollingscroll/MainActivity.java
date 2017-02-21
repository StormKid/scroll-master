package com.roll.scroll.ke_li.rollingscroll;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import com.roll.scroll.ke_li.rollingscroll.view.ScalePageTransformer;
import com.roll.scroll.ke_li.rollingscroll.view.ScrollLayout;
import com.roll.scroll.ke_li.rollingscroll.view.TubatuAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.list_contain)
    ScrollLayout listContain;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Context context;
    private TubatuAdapter tubatuAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        this.context = this;
        listContain.setSpeedScroller(300);
        listContain.setPageTransformer(true,new ScalePageTransformer());
        final List<String> list = Arrays.asList("sddfdf","dddsf","oijvoo","ihisuhihsdf98","sdaf08u082u40","f-00i-9i2-0i90u9");
        activityMain.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return listContain.dispatchTouchEvent(event);
            }
        });

        tubatuAdapter = new TubatuAdapter(this, list);
        listContain.setAdapter(tubatuAdapter);
        List<Integer> integerList = new ArrayList<>();
        integerList.add(R.mipmap.ic_launcher);
        integerList.add(R.mipmap.ic_launcher);
        integerList.add(R.mipmap.ic_launcher);
        integerList.add(R.mipmap.ic_launcher);
        integerList.add(R.mipmap.ic_launcher);
        listContain.setOffscreenPageLimit(integerList.size());
        tubatuAdapter.addAll(integerList);
    }


}
