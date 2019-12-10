package com.sushant.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button showemployee, reg, search, delupd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showemployee = findViewById(R.id.btnShow);
        reg = findViewById(R.id.btnReg);
        search = findViewById(R.id.btnSearch);
        delupd = findViewById(R.id.btnupdel);

        showemployee.setOnClickListener(this);
        reg.setOnClickListener(this);
        search.setOnClickListener(this);
        delupd.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {

            case R.id.btnShow:
                intent = new Intent(MainActivity.this, ShowEmployee.class);
                break;
            case R.id.btnReg:
                intent = new Intent(MainActivity.this, EmployeeRegister.class);
                break;
            case R.id.btnSearch:
                intent = new Intent(MainActivity.this, SearchEmployee.class);
                break;
            case R.id.btnupdel:
                intent = new Intent(MainActivity.this, UpdateandDelete.class);
                break;
        }
        startActivity(intent);
    }
}
