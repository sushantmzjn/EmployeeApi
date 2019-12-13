package com.sushant.employeeapi.API;

import com.sushant.employeeapi.model.Employee;
import com.sushant.employeeapi.model.EmployeeCUD;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface EmployeeAPI {

    //Retrieving data
    @GET("employees")
    Call<List<Employee>> getAllEmployee();

    @GET("employee/{empID}")
    Call<Employee> getEmployeeByID(@Path("empID") int empID);

    @POST("create")
    Call<Void> registerEmployee(@Body EmployeeCUD emp);




}
