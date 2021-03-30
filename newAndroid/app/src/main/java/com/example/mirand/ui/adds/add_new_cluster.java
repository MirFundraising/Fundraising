package com.example.mirand.ui.adds;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import com.example.mirand.ui.home.HomeFragment;
import com.example.mirand.MainActivity;
import com.example.mirand.R;
import com.example.mirand.ui.home.HomeFragment;
import com.example.mirand.ui.insides.inside_cluster_activity;
import com.example.mirand.util.Cluster;
import com.example.mirand.util.User;

import java.util.ArrayList;
import java.util.Calendar;

public class add_new_cluster extends AppCompatActivity {
    private EditText name;
    private Cluster cluster;
    private EditText cardNumber;
    private TextView currentDateTime;
    private Calendar dateAndTime=Calendar.getInstance();
    private Spinner inviteIntoCluster;

    private String mName;
    private String mCardNumber;
    private ArrayList<User> clusterMembers;
    private HomeFragment hf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_cluster);
        name=(EditText)findViewById(R.id.new_cluster_name);
        cardNumber=(EditText) findViewById(R.id.new_cluster_user_card_number_text);
        currentDateTime=(TextView)findViewById(R.id.end_of_date_new_cluster);
        inviteIntoCluster=(Spinner)findViewById(R.id.users_spinnerlist);
        setInitialDateTime();
        hf=new HomeFragment();
    }

    // отображаем диалоговое окно для выбора даты
    public void setDate(View v) {
        new DatePickerDialog(add_new_cluster.this, d,
                dateAndTime.get(Calendar.YEAR),
                dateAndTime.get(Calendar.MONTH),
                dateAndTime.get(Calendar.DAY_OF_MONTH))
                .show();
    }

    // отображаем диалоговое окно для выбора времени
    public void setTime(View v) {
        new TimePickerDialog(add_new_cluster.this, t,
                dateAndTime.get(Calendar.HOUR_OF_DAY),
                dateAndTime.get(Calendar.MINUTE), true)
                .show();
    }
    // установка начальных даты и времени
    private void setInitialDateTime() {

        currentDateTime.setText(DateUtils.formatDateTime(this,
                dateAndTime.getTimeInMillis(),
                DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_YEAR
                        | DateUtils.FORMAT_SHOW_TIME));
    }

    // установка обработчика выбора времени
    TimePickerDialog.OnTimeSetListener t=new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            dateAndTime.set(Calendar.HOUR_OF_DAY, hourOfDay);
            dateAndTime.set(Calendar.MINUTE, minute);
            setInitialDateTime();
        }
    };

    // установка обработчика выбора даты
    DatePickerDialog.OnDateSetListener d=new DatePickerDialog.OnDateSetListener() {
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateAndTime.set(Calendar.YEAR, year);
            dateAndTime.set(Calendar.MONTH, monthOfYear);
            dateAndTime.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            setInitialDateTime();
        }
    };
    public void createNewCluster(View view){
        mName=name.getText().toString();
        mCardNumber=cardNumber.getText().toString();
        if (!mName.isEmpty()&&!mCardNumber.isEmpty()){
            cluster=new Cluster(mName,clusterMembers.size(),clusterMembers);
            hf.user.addClusters(cluster);
            startActivity(new Intent(add_new_cluster.this, inside_cluster_activity.class));
            finish();
        }
    }
}