package com.rabbitshat.aptowiz.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.rabbitshat.aptowiz.R;

public class UserInfoActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etFlatNo;
    private EditText etFloorNo;
    private EditText etHouseNo;
    private EditText etPrimary;
    private EditText etEmergencyOne;
    private EditText etEmergencyTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        initializeView();
        findViewById(R.id.btn_user_info_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNotEmpty(etName) && isNotEmpty(etFlatNo) && isNotEmpty(etFloorNo)
                        && isNotEmpty(etHouseNo) && isNotEmpty(etPrimary) &&
                        isNotEmpty(etEmergencyOne) && isNotEmpty(etEmergencyTwo)) {
                    apiRequest();
                } else {
                    Toast.makeText(UserInfoActivity.this, R.string.fill_all_info,
                            Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private void initializeView() {
        etName = (EditText) findViewById(R.id.et_user_info_name);
        etFlatNo = (EditText) findViewById(R.id.et_user_info_flat_no);
        etFloorNo = (EditText) findViewById(R.id.et_user_info_floor_no);
        etHouseNo = (EditText) findViewById(R.id.et_user_info_house_no);
        etPrimary = (EditText) findViewById(R.id.et_user_info_primary_no);
        etEmergencyOne = (EditText) findViewById(R.id.et_user_info_emergency_one);
        etEmergencyTwo = (EditText) findViewById(R.id.et_user_info_emergency_two);
    }

    private void apiRequest() {

        // is successful
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
        finish();


    }

    private boolean isNotEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }
}
