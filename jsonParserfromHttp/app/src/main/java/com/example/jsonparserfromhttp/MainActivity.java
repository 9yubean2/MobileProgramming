package com.example.jsonparserfromhttp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


public class MainActivity extends AppCompatActivity {

    //Properties
    EditText editTextArea, editTextDate;
    Button btnSearch;
    TextView textViewResult;

    String strDate, strArea;
    String url = "http://sc1.swu.ac.kr/~dlrbqls3024/covid19list.jsp";
    static RequestQueue requestQueue;

    //LifeCycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextArea = findViewById(R.id.editTextArea);
        editTextDate = findViewById(R.id.editTextDate);
        textViewResult = findViewById(R.id.textViewResult);

        //RequestQueue 객체 생성
        if (requestQueue == null){
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
    }
    public void onButtonClickSearch(View view)throws JSONException, UnsupportedEncodingException {
        strArea = editTextArea.getText().toString();
        strDate = editTextDate.getText().toString();

        //json object 객체 생성
        JSONObject searchInfo = new JSONObject();
        searchInfo.put("area",strArea);
        searchInfo.put("date",strDate);
        makeRequest(searchInfo);


    }

    public void makeRequest(JSONObject jobj) throws UnsupportedEncodingException {
        // { "area"="서울", "date"="20220505" }
        // ?searchparas={ "area":"서울", "date":"20220505" };

        String strUrl = url + "?searchparas=" + URLEncoder.encode(jobj.toString(),"UTF-8");
        System.out.println(strUrl);
        StringRequest request = new StringRequest(Request.Method.GET, strUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("RESPONSE-> " + response);
                    }
                },
                new Response.ErrorListener() {
                @Override
            public void onErrorResponse(VolleyError error) {
                println("ERROR: " + error.getMessage());
            }
        }) {
            @Override
            protected Map<String,String> getParams() throws AuthFailureError {

                    Map<String,String> params = new HashMap<String, String>();
                    return params;
                }
            };
            request.setShouldCache(false);
            requestQueue.add(request);
            println("SEND REQUEST: ");
        }
        public void println (String data) {
            textViewResult.append(data+"\n");
        }
}