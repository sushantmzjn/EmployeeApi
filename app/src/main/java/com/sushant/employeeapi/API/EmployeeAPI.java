package com.sushant.employeeapi.API;

import com.sushant.employeeapi.model.Employee;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EmployeeAPI {

    //Retrieving data
    @GET("employees")
    Call<List<Employee>> getAllEmployee();

}
