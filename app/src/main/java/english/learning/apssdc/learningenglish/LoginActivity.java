package english.learning.apssdc.learningenglish;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class LoginActivity extends AppCompatActivity {

    Button loginB, register;
    EditText username, password;
    Login login;
    ConnectivityManager connectivityManager;
    NetworkInfo activeInfo;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_login);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginB = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        activeInfo = connectivityManager.getActiveNetworkInfo();
        login = new Login();
        loginB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (username.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Fill Username", Toast.LENGTH_LONG).show();
                } else if (password.getText().toString().equalsIgnoreCase("")) {
                    Toast.makeText(getApplicationContext(), "Fill Password", Toast.LENGTH_LONG).show();
                } else {
                    login.setUserName(username.getText().toString());
                    login.setPassword(password.getText().toString());
                    login.setDeviceId(Build.SERIAL);
                    if (activeInfo != null && activeInfo.isConnected()) {

                        LoginTask task = new LoginTask();
                        task.execute();
                    } else {
                        Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(getApplicationContext(), RegistrationActivity.class);
                startActivity(i);

            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Login Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://202.65.133.69:8181"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    public void offlineAppAccess(View view) {

        Intent intent = new Intent(getApplicationContext(),FirstScreen.class);
        startActivity(intent);
    }

    class LoginTask extends AsyncTask<Void, Void, Response> {

        ProgressDialog loading;
        boolean successful;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(LoginActivity.this, "Please wait...", null, true, true);
            loading.setCanceledOnTouchOutside(false);
        }

        @Override
        protected Response doInBackground(Void... voids) {
            final String URL = "http://202.65.133.69:8181/learningEnglish/auth/login";
            RestTemplate restTemplate = new RestTemplate();
            Log.d("LOGIN MODEL", "" + login);
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Response response = restTemplate.postForObject(URL, login, Response.class);
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            loading.dismiss();
            Log.d("RESPONSE", "" + response);
            try {
                JSONObject jsonObject = new JSONObject(response.toString());
                successful = jsonObject.getBoolean("successful");
                if (successful) {
                    Intent intent = new Intent(getApplicationContext(), FirstScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
