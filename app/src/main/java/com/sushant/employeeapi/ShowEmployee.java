package com.sushant.employeeapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sushant.employeeapi.API.EmployeeAPI;
import com.sushant.employeeapi.adapter.EmployeeAdapter;
import com.sushant.employeeapi.model.Employee;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ShowEmployee extends AppCompatActivity {
    private RecyclerView recyclerView;

    private static final String base_url = ("http://dummy.restapiexample.com/api/v1/");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_employee);

        recyclerView = findViewById(R.id.etOutput);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //interface instance
        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        Call<List<Employee>> listCall = employeeAPI.getAllEmployee();
        //Asynchronous call
        listCall.enqueue(new Callback<List<Employee>>() {
            @Override
            public void onResponse(Call<List<Employee>> call, Response<List<Employee>> response) {

                if (!response.isSuccessful()) {
                    Toast.makeText(ShowEmployee.this, "Error" + response.code(), Toast.LENGTH_SHORT).show();
                    return;
                }

                List<Employee> lstEmployee = response.body();

                EmployeeAdapter employeeAdapter = new EmployeeAdapter(ShowEmployee.this,lstEmployee);
                recyclerView.setAdapter(employeeAdapter);



//                for (Employee employee : lstEmployee) {
//                    String emp = "";
//                    emp += "Employee id : " + employee.getId() + "\n";
//                    emp += "Employee name : " + employee.getEmployee_name() + "\n";
//                    emp += "Employee age : " + employee.getEmployee_age() + "\n";
//                    emp += "Employee salary : " + employee.getEmployee_salary() + "\n";
//                    emp += "-----------------" + "\n";
//                    recyclerView.append(emp);
//                }

            }

            @Override
            public void onFailure(Call<List<Employee>> call, Throwable t) {
                Toast.makeText(ShowEmployee.this, "Error" + t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.d("error msg", "onFailure:" + t.getLocalizedMessage());

            }
        });
    }

}
