package com.example.eosinchen.volleyexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String TAG = "MainActivity";

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View v) {

        // getDataByVolley();
        getData();
    }

    private void getData() {

        String urlParkingArea = "http://data.taipei/opendata/datalist/apiAccess?scope=resourceAquire&rid=a880adf3-d574-430a-8e29-3192a41897a5";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(urlParkingArea,

                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, "response = " + response.toString());

                        // TextView txtView = (TextView) findViewById(R.id.textView);
                        // txtView.setText(response.toString());

                        // parserJson(response);
                    }
                },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e(TAG, "error : " + error.toString());
                    }
                }
        );

        Volley.newRequestQueue(this).add(jsonObjectRequest);
    }

    private void parserJson(JSONObject jsonObject) {

    }

}
