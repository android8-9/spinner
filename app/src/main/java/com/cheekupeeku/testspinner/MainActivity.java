package com.cheekupeeku.testspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.cheekupeeku.testspinner.databinding.HomeBinding;

public class MainActivity extends AppCompatActivity {
    String city[] = {"Select city","Indore","Pune","Chennai","Goa","Mumbai","Delhi","Heydrabad"};
    HomeBinding binding;
    ArrayAdapter<String>adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = HomeBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        adapter = new ArrayAdapter<>(this,R.layout.city_item_list,R.id.tvCityname,city);

        binding.spinner.setAdapter(adapter);

        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String selectedCity =  city[position];
                if(selectedCity.equals("Select city")){
                    onNothingSelected(parent);
                }
                else
                 Toast.makeText(MainActivity.this, selectedCity, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(MainActivity.this, "please select city", Toast.LENGTH_SHORT).show();
            }
        });
    }
}