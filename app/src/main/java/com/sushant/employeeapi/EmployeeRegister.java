package com.sushant.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sushant.employeeapi.API.EmployeeAPI;
import com.sushant.employeeapi.model.EmployeeCUD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class EmployeeRegister extends AppCompatActivity {

    EditText etname, etsalary, etage;
    Button btnpost;
    private static final String base_url = "http://dummy.restapiexample.com/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_register);

        etname = findViewById(R.id.etname);
        etsalary = findViewById(R.id.etsalary);
        etage = findViewById(R.id.etage);
        btnpost = findViewById(R.id.btnRegister);

        btnpost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Create();
            }
        });


    }

    private void Create(){

        String name = etname.getText().toString().trim();
        String salary = etsalary.getText().toString().trim();
        int age = Integer.parseInt(etage.getText().toString());

        EmployeeCUD employee = new EmployeeCUD(name,salary,age);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
       Call<Void> call = employeeAPI.registerEmployee(employee);


       call.enqueue(new Callback<Void>() {
           @Override
           public void onResponse(Call<Void> call, Response<Void> response) {
               Toast.makeText(EmployeeRegister.this, "Employee registered successfully", Toast.LENGTH_LONG).show();
           }

           @Override
           public void onFailure(Call<Void> call, Throwable t) {
               Log.d("msg", "onFailure: " + t.getLocalizedMessage());

           }
       });


    }
}
