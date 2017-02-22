package english.learning.apssdc.learningenglish;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {

    EditText studentName,rollNo,aadhaar,schoolName,village,mandal,district,state,pincode,userName,password;
    Button submit;
    Registration registration;
    ConnectivityManager connectivityManager;
    NetworkInfo activeInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Learning English");
        setContentView(R.layout.activity_registration);
        overridePendingTransition(R.anim.slide_in_left,R.anim.side_out_right);
        studentName=(EditText)findViewById(R.id.studentName);
        rollNo=(EditText)findViewById(R.id.rollno);
        aadhaar=(EditText)findViewById(R.id.aadhaar);
        schoolName=(EditText)findViewById(R.id.SchoolName);
        village=(EditText)findViewById(R.id.Village);
        mandal=(EditText)findViewById(R.id.mandal);
        district=(EditText)findViewById(R.id.district);
        state=(EditText)findViewById(R.id.state);
        pincode=(EditText)findViewById(R.id.pincode);
        userName=(EditText)findViewById(R.id.userName);
        password=(EditText)findViewById(R.id.passwordR);
        submit=(Button)findViewById(R.id.registerButton);
        registration = new Registration();
        connectivityManager=(ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        activeInfo = connectivityManager.getActiveNetworkInfo();
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* boolean isAadhaar;
                isAadhaar = validateAadharNumber(aadhaar.getText().toString());*/

                if(studentName.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill Student Name", Toast.LENGTH_SHORT).show();
                }
               else if(rollNo.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill Roll no", Toast.LENGTH_SHORT).show();
                }
               /* else if(aadhaar.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill This", Toast.LENGTH_SHORT).show();
                }
                else if(!isAadhaar)
                {
                    Toast.makeText(getApplicationContext(), "Invalid Aadhaar", Toast.LENGTH_SHORT).show();
                }
                else if(aadhaar.getText().toString().length()<12 || aadhaar.getText().toString().length()>12)
                {
                    Toast.makeText(getApplicationContext(), "Invalid Aadhaar", Toast.LENGTH_SHORT).show();
                }*/
                else if(schoolName.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill school name", Toast.LENGTH_SHORT).show();
                }
                else if(village.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill village", Toast.LENGTH_SHORT).show();
                }
                else if(mandal.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill mandal", Toast.LENGTH_SHORT).show();
                }
                else if(district.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill district", Toast.LENGTH_SHORT).show();
                }
                else if(state.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill state", Toast.LENGTH_SHORT).show();
                }
                else if(pincode.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill pincode", Toast.LENGTH_SHORT).show();
                }
                else if(pincode.getText().toString().length()<6 || pincode.getText().toString().length()>6 )
                {
                    Toast.makeText(getApplicationContext(), "Invalid Pincode", Toast.LENGTH_SHORT).show();
                }
                else if(userName.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill user name", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().equalsIgnoreCase(""))
                {
                    Toast.makeText(getApplicationContext(), "Fill password", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().length()<8 || password.getText().toString().length()>8)
                {
                    Toast.makeText(getApplicationContext(), "Password Should have  8 characters", Toast.LENGTH_SHORT).show();
                }

                else {

                    registration.setStudentName(studentName.getText().toString());
                    registration.setRollno(rollNo.getText().toString());
                    registration.setAadhaar(aadhaar.getText().toString());
                    registration.setSchoolName(schoolName.getText().toString());
                    registration.setVillage(village.getText().toString());
                    registration.setMandal(mandal.getText().toString());
                    registration.setDistrict(district.getText().toString());
                    registration.setState(state.getText().toString());
                    registration.setPincode(Long.parseLong(pincode.getText().toString()));
                    registration.setUserName(userName.getText().toString());
                    registration.setPassword(password.getText().toString());
                    registration.setDeviceId(Build.SERIAL);
                    if (activeInfo != null && activeInfo.isConnected()) {

                        RegistrationTask task=new RegistrationTask();
                        task.execute();
                    }else
                    {
                        Toast.makeText(getApplicationContext(), "Check your Internet Connection", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

    }

    class RegistrationTask extends AsyncTask<Void,Void,Response>
    {

        ProgressDialog loading;
        boolean successful;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            loading = ProgressDialog.show(RegistrationActivity.this, "Please wait...", null, true, true);
            loading.setCanceledOnTouchOutside(false);
        }
        @Override
        protected Response doInBackground(Void... voids) {
            final String URL = "http://202.65.133.69:8181/learningEnglish/add/addStudent";
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            Response response = restTemplate.postForObject(URL,registration,Response.class);
            return response;
        }

        @Override
        protected void onPostExecute(Response response) {
            super.onPostExecute(response);
            loading.dismiss();
            Log.d("RESPONSE",""+response);
            try {
                JSONObject jsonObject = new JSONObject(response.toString());
                successful = jsonObject.getBoolean("successful");
                if (successful) {
                    Toast.makeText(getApplicationContext(),"Registered Successfully", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"user name already exists", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



    public static boolean validateAadharNumber(String aadharNumber) {
        Pattern aadharPattern = Pattern.compile("\\d{12}");
        boolean isValidAadhar = aadharPattern.matcher(aadharNumber).matches();
        if (isValidAadhar) {
            isValidAadhar = VerhoeffAlgorithm.validateVerhoeff(aadharNumber);
        }
        return isValidAadhar;
    }
}
