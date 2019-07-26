package com.rabbitshat.aptowiz.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.rabbitshat.aptowiz.R;
import com.rabbitshat.aptowiz.util.AppUtil;
import com.rabbitshat.aptowiz.util.onLoginResponse;

public class ActivationActivity extends AppCompatActivity implements onLoginResponse {
    EditText etUserName;
    EditText etActivationKey;
    onLoginResponse loginInterface = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activation);

        initializeView();

        findViewById(R.id.btn_submit_activation).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(isNotEmpty(etUserName) && isNotEmpty(etActivationKey)){

                    // Api request
                    loginRequest(etUserName.getText().toString(),
                            etActivationKey.getText().toString());
                }
                else {
                    Toast.makeText(ActivationActivity.this, "Please Fill all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void initializeView() {

        etUserName = (EditText) findViewById(R.id.et_activation_user_name);
        etActivationKey = (EditText) findViewById(R.id.et_activation_key);
    }
    private boolean isNotEmpty(EditText editText) {
        if (editText.getText().toString().trim().length() > 0)
            return true;

        return false;
    }

    public void loginRequest(String userName,  String password) {

        String url = "http://rabbitshat.com/apto/api/UserAuthorizationsAPI?aid=" + userName + "&" + "code=" + password;
        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("An error has occurred.")){
                            loginInterface.onFailure(response);
                        }
                        else {
                            loginInterface.onSuccess(response);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                loginInterface.onFailure(error.toString());
            }
        });

        RequestQueue rq = Volley.newRequestQueue(ActivationActivity.this);
        rq.add(sr);

    }

    @Override
    public void onSuccess(String response) {

        Toast.makeText(ActivationActivity.this, "Successfully login as " + response, Toast.LENGTH_SHORT).show();

        // save login state
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(AppUtil.FIRST_TIME, "No");
        editor.commit();

        startActivity(new Intent(getApplicationContext(), UserInfoActivity.class));
        finish();
    }

    @Override
    public void onFailure(String response) {
        Toast.makeText(ActivationActivity.this, response, Toast.LENGTH_SHORT).show();

    }
}
