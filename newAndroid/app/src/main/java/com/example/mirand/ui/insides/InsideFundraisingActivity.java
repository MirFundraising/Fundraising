package com.example.mirand.ui.insides;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.mirand.R;

import org.w3c.dom.Text;

public class InsideFundraisingActivity extends AppCompatActivity {
    private EditText fundName;
    private EditText fundRole;
    private TextView currentSumm;
    private TextView yourFund;
    private TextView currentCardNumber;
    private Spinner cardSpinner;
    private EditText transactionSummary;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_fundraising);
        fundName=(EditText)findViewById(R.id.inside_fundraising_name);
        fundRole=(EditText)findViewById(R.id.inside_fundraising_role);
        currentSumm=(TextView)findViewById(R.id.inside_fundraising_current_summ_text);
        yourFund=(TextView)findViewById(R.id.inside_fundraising_your_current_fundraising);
        currentCardNumber=(TextView)findViewById(R.id.current_card_number);
        cardSpinner=(Spinner) findViewById(R.id.card_spinner);
        transactionSummary=(EditText) findViewById(R.id.choose_transaction_summ_text);
    }
    public void transfer(View view){

    }
}