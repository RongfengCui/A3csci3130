package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, primaryBusinessField, addressField, provinceField;
    Contact receivedPersonInfo;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        appState = ((MyApplicationData) getApplicationContext());
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }


    public void updateContact(View v){
        //TODO: Update contact funcionality

        //get the value from one of specific business from current viewlist
        receivedPersonInfo.setAddress(addressField.getText().toString());
        receivedPersonInfo.setName(nameField.getText().toString());
        receivedPersonInfo.setPrimaryBusiness(primaryBusinessField.getText().toString());
        receivedPersonInfo.setNumber(numberField.getText().toString());
        receivedPersonInfo.setProvince(provinceField.getText().toString());

        //update the value only if the value satisfies the rules
        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(receivedPersonInfo);
        Toast.makeText(DetailViewActivity.this, "update!", Toast.LENGTH_SHORT).show();
        finish();
    }


    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        //remove all the value about the specific uid
        appState.firebaseReference.child( receivedPersonInfo.uid).removeValue();
        Toast.makeText(DetailViewActivity.this, "Delete!", Toast.LENGTH_SHORT).show();
        finish();
    }
}
