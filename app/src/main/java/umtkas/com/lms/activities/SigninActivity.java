package umtkas.com.lms.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import umtkas.com.lms.R;
import umtkas.com.lms.service.ApiClient;
import umtkas.com.lms.service.ApiService;
import umtkas.com.lms.service.Server;

public class SigninActivity extends AppCompatActivity {

    @BindView(R.id.txtUsername)
    EditText txtUsername;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    @BindView(R.id.btnSignin)
    Button btnSignIn;

    @BindView(R.id.txlUsername)
    TextInputLayout txlUsername;


    @BindView(R.id.txlPassword)
    TextInputLayout txlPassword;


    private ApiClient apiService;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.getSupportActionBar().hide();
        ButterKnife.bind(this);
        sharedPreferences = this.getPreferences(Context.MODE_PRIVATE);
        apiService = ApiService.getClient();

        editor = this.sharedPreferences.edit();


        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                if (username.isEmpty()){
                    txlUsername.setError("Username cannot be empty");
                }
                else if (password.isEmpty()){
                    txlPassword.setError("Password cannot be empty");
                }
                else{

                    signIn(username, password);
                }

            }
        });


        String username = sharedPreferences.getString("username", "");
        String password = sharedPreferences.getString("password", "");

        if (!username.isEmpty() && !password.isEmpty()){
            signIn(username, password);
        }


    }




    private void signIn(final String username, final String password){

        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.setCancelable(false); // disable dismiss by tapping outside of the dialog
        final ProgressDialog p = progress;
        p.show();

        Call<JsonObject> call = apiService.authorize(Server.getCredentials(), Server.GRANT_TYPE, username, password);
        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                JsonObject resp = response.body();
                if (response.code() == 200) {
                    String accessToken = resp.get("access_token").getAsString();
                    if (!accessToken.isEmpty()) {

                        editor.putString("username", username);
                        editor.putString("password", password);
                        editor.putString("access_token", accessToken);
                        editor.commit();
                        Toast.makeText(getApplicationContext(), "Signed In", Snackbar.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), CoursesActivity.class);
                        p.dismiss();
                        startActivity(intent);

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Username or Password is not correct", Snackbar.LENGTH_LONG).show();
                        p.dismiss();

                    }

                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                p.dismiss();

            }
        });

    }
}
