package com.sushant.employeeapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sushant.employeeapi.API.EmployeeAPI;
import com.sushant.employeeapi.model.Employee;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SearchEmployee extends AppCompatActivity {
    private TextView textView;
    EditText id;
    Button btnSearch;
    private static final String base_url = "http://dummy.restapiexample.com/api/v1/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_employee);

        id = findViewById(R.id.editText4);
        textView = findViewById(R.id.searchShow);
        btnSearch = findViewById(R.id.btnSearch);




        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadData();

            }
        });

    }

    private void loadData(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        EmployeeAPI employeeAPI = retrofit.create(EmployeeAPI.class);
        Call<Employee> listCall = employeeAPI.getEmployeeByID(Integer.parseInt(id.getText().toString()));

        listCall.enqueue(new Callback<Employee>() {
            @Override
            public void onResponse(Call<Employee> call, Response<Employee> response) {

              //  Toast.makeText(SearchEmployee.this, response.body().toString() , Toast.LENGTH_SHORT).show();
                String content = "";
                content += "ID : " +response.body().getId() + "\n";
                content += "Name : " +response.body().getEmployee_name() + "\n";
                content += "Salary : " +response.body().getEmployee_salary() + "\n";
                content += "Age : " +response.body().getEmployee_age() + "\n";
                textView.setText(content);

            }

            @Override
            public void onFailure(Call<Employee> call, Throwable t) {
                Log.d("error", "onFailure: " +t.getLocalizedMessage());

            }
        });


    }
}
