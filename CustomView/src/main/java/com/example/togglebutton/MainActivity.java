package com.example.togglebutton;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void toggleButton(View view) {
        startActivity(new Intent(this,ToggleButtonActvity.class));
    }

    public void recView(View view) {
        startActivity(new Intent(this,RecViewActivity.class));
    }

    public void customViewGroup(View view) {
        startActivity(new Intent(this, CoustomVGAct.class));
    }

    public void CakeView(View view) {
        startActivity(new Intent(this,CakeViewAct.class));
    }

    public void swipeMenu(View view) {
        startActivity(new Intent(this,SwipeMenuAct.class));
    }
}
