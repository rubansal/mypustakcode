package com.mypushtak.app.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mypushtak.app.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;

public class Donationform extends AppCompatActivity {

    Button submit_button;

    ImageView home_back;

    EditText name;
    EditText email_id;
    EditText contact_no;
    EditText pincode;
    EditText address;
    EditText landmark;
    EditText city;
    EditText state;
    EditText approx_no_of_books;
    EditText no_of_cartoons;
    EditText preffered_pick_update;
    EditText attachment_of_books_image;
    EditText from_where_you_got_to_know_about_mypustak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donationform);

        submit_button = findViewById(R.id.submit_button);
        home_back = findViewById(R.id.home_back);

        name = findViewById(R.id.name);
        email_id = findViewById(R.id.email_id);
        contact_no = findViewById(R.id.contact_no);
        pincode = findViewById(R.id.pincode);
        address = findViewById(R.id.address);
        landmark = findViewById(R.id.landmark);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        approx_no_of_books = findViewById(R.id.approx_no_of_books);
        no_of_cartoons = findViewById(R.id.no_of_cartoons);
        preffered_pick_update = findViewById(R.id.preferred_pickup_date);
        attachment_of_books_image = findViewById(R.id.attachment_of_books_image);
        from_where_you_got_to_know_about_mypustak = findViewById(R.id.from_where_you_got_to_know_about_mypustak);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                RequestQueue queue = Volley.newRequestQueue(Donationform.this);

                String url = "http://192.168.43.243:8080/getUsers/"+email_id.getText().toString();
                StringRequest postRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (!response.equals("null")&&!response.equals("")) {
                            try {
                                JSONObject jsonBody = new JSONObject(response);
                                int id=jsonBody.getInt("id");
                                //Log.d("onResponseId","id: "+id);
                                donationpostapi(id);
                                Toast.makeText(Donationform.this, "submitted successfully", Toast.LENGTH_LONG).show();
                            } catch (JSONException e) {
                                       e.printStackTrace();
                            }
                        }
                        else {
                            createNewUserApi();
                            int id=getUserId();
                            donationpostapi(id);
                            Toast.makeText(Donationform.this, "user successful", Toast.LENGTH_LONG).show();

                        }

                        Log.d("onResponse","response: "+response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
                queue.add(postRequest);


//                        Intent i = new Intent(Donationform.this, donationlastpart.class);
//                startActivity(i);
            }
        });

        home_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Donationform.this, Donation.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void donationpostapi(int id){
        RequestQueue donationqueue = Volley.newRequestQueue(Donationform.this);
        String donor_url="http://192.168.43.243:8080/donationpost/"+id;
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("volunteer_id", "2222");
            jsonBody.put("track_url", "null");
            jsonBody.put("declaration_form", "null");
            jsonBody.put("awb_attachment", "null");
            jsonBody.put("status", "5");
            jsonBody.put("address", "13,Rabi Rashmi Abasan");
            jsonBody.put("country", "101");
            jsonBody.put("state", "24");
            jsonBody.put("city", "1475");
            jsonBody.put("zipcode", "700156");
            jsonBody.put("no_of_book", "90");
            jsonBody.put("no_of_cartons", "0");
            jsonBody.put("app_books_weight", "25");
            jsonBody.put("donated_book_category", "");
            jsonBody.put("pickup_date_time", "1459222380");
            jsonBody.put("donation_image", "0528475001459164128.jpg");
            jsonBody.put("how_do_u_know_abt_us", "Dheeraj");
            jsonBody.put("wastage", "90");
            jsonBody.put("document_mail_sent", "N");
            jsonBody.put("is_blocked", "N");
            jsonBody.put("i_date", "1459164134");
            jsonBody.put("u_date", "1459164134");
            jsonBody.put("tracking_no", "");
            jsonBody.put("is_paid_donation", "N");
            jsonBody.put("paymrnt_url", "null");
            jsonBody.put("payment_id", "null");
            jsonBody.put("mobile", "");
            jsonBody.put("landmark", "");

            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, donor_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                        Log.d("onResponseString","response: "+responseString);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            donationqueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void createNewUserApi(){
        final int[] id = new int[1];
        RequestQueue donationqueue = Volley.newRequestQueue(Donationform.this);
        String donor_url="http://192.168.43.243:8080/userpost/"+email_id.getText().toString();
        JSONObject jsonBody = new JSONObject();
        try {
            jsonBody.put("first_name", "MyPustak");
            jsonBody.put("last_name", ".com");
            jsonBody.put("alternative_email", "smallboy7311@gmail.com");
            jsonBody.put("password", "12345678");
            jsonBody.put("user_role_id", "1");
            jsonBody.put("avatar", "12345678.jpg");
            jsonBody.put("birth_date", "04/13/2012");
            jsonBody.put("communication_address", "test");
            jsonBody.put("mobile", "12345678");
            jsonBody.put("contact_no", "null");
            jsonBody.put("profession", "null");
            jsonBody.put("contribution", "null");
            jsonBody.put("profile_percentage", "100");
            jsonBody.put("is_volunteer", "N");
            jsonBody.put("is_donor", "N");
            jsonBody.put("is_customer", "N");
            jsonBody.put("is_verified", "Y");
            jsonBody.put("is_deleted", "N");
            jsonBody.put("is_active", "Y");
            jsonBody.put("i_date", "12345678");
            jsonBody.put("i_by", "1");
            jsonBody.put("u_date", "1459164134");
            jsonBody.put("u_by", "1");
            jsonBody.put("registered_date", "2015-10-09");
            jsonBody.put("wallet_amount", "0");

            final String requestBody = jsonBody.toString();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, donor_url, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    Log.i("VOLLEY", response);
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("VOLLEY", error.toString());
                }
            }) {
                @Override
                public String getBodyContentType() {
                    return "application/json; charset=utf-8";
                }

                @Override
                public byte[] getBody() throws AuthFailureError {
                    try {
                        return requestBody == null ? null : requestBody.getBytes("utf-8");
                    } catch (UnsupportedEncodingException uee) {
                        VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", requestBody, "utf-8");
                        return null;
                    }
                }

                @Override
                protected Response<String> parseNetworkResponse(NetworkResponse response) {
                    String responseString = "";
                    if (response != null) {
                        responseString = String.valueOf(response.statusCode);
                        // can get more details such as response.headers
                        Log.d("onResponseString","response: "+responseString);
                    }
                    return Response.success(responseString, HttpHeaderParser.parseCacheHeaders(response));
                }
            };

            donationqueue.add(stringRequest);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public int getUserId(){
        final int[] id = new int[1];
        RequestQueue getUserqueue = Volley.newRequestQueue(Donationform.this);
        String getUser_url="http://192.168.43.243:8080/getUsers/"+email_id.getText().toString();
        StringRequest postRequest = new StringRequest(Request.Method.GET, getUser_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                    try {
                        JSONObject jsonBody = new JSONObject(response);
                        id[0] =jsonBody.getInt("id");

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                Log.d("onResponse","response: "+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        getUserqueue.add(postRequest);
        return id[0];
    }
}
