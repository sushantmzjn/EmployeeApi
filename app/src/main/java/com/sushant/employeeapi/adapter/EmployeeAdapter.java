package com.sushant.employeeapi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sushant.employeeapi.R;
import com.sushant.employeeapi.model.Employee;

import java.util.List;


public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder> {

    Context context;
    List<Employee> employeeList;

    public EmployeeAdapter(Context context, List<Employee> employeeList) {
        this.context = context;
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.employeelayout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {

        Employee employee = employeeList.get(position);
        holder.id.append(String.valueOf(employee.getId()));
        holder.name.append(employee.getEmployee_name());
        holder.salary.append(employee.getEmployee_salary());
        holder.age.append(String.valueOf(employee.getEmployee_age()));


    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder {
        private TextView id, name, salary, age;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.idEmployee);
            name = itemView.findViewById(R.id.EmployeeName);
            salary = itemView.findViewById(R.id.EmployeeSalary);
            age = itemView.findViewById(R.id.Age);
        }
    }
}
