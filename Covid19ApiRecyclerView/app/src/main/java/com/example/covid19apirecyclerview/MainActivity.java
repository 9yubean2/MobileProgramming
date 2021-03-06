package com.example.covid19apirecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import java.net.URLEncoder;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class MainActivity extends AppCompatActivity {


    String servicekey = "";
    String requestUrl;
    String strDate;

    private Button btnSearch;
    private RecyclerView mRecyclerView;
    EditText editText_date;

    private ArrayList<Dictionary> mArrayList;
    private CustomAdapter mAdapter;

    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSearch = findViewById(R.id.btn_search);
        editText_date = findViewById(R.id.editText_date);
        mRecyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);
        mArrayList = new ArrayList<>();
        mAdapter = new CustomAdapter(mArrayList);
        mRecyclerView.setAdapter(mAdapter);



        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strDate = editText_date.getText().toString();
                requestUrl = "http://openapi.data.go.kr/openapi/service/rest/Covid19/getCovid19SidoInfStateJson?serviceKey="+servicekey+"&startCreateDt=" + strDate + "&endCreateDt=" + strDate;

                System.out.println(requestUrl);
                makeRequest();


            }
        });
        //RequestQueue ?????? ??????
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

    }

    public void makeRequest() {

        StringRequest request = new StringRequest(Request.Method.GET, requestUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //System.out.println("??????-> " + response);
                XMLtoJSONData(response);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("??????-> " + error.getMessage());
                    }

                }) {
            @Override
            //response??? UTF8??? ??????
            protected Response<String> parseNetworkResponse(NetworkResponse response) {
                try {
                    String utf8String = new String(response.data, "UTF-8");
                    return Response.success(utf8String, HttpHeaderParser.parseCacheHeaders(response));
                } catch (UnsupportedEncodingException e) {
                    // log error
                    return Response.error(new ParseError(e));
                } catch (Exception e) {
                    // log error
                    return Response.error(new ParseError(e));
                }
            }
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                return params;
            }
        };
        request.setShouldCache(false);
        requestQueue.add(request);
        System.out.println("?????? ??????");
    }

    private void XMLtoJSONData(String xml) {

        // ??????
        try {
            // ????????? static ???????????? ????????? ????????? ?????? : ????????? ??????
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            // ?????? ???????????? ????????? ?????????, ????????? ???????????? ????????? ??????.
            DocumentBuilder documentbuilder = factory.newDocumentBuilder(); //// ????????? ????????? ??????  ???????????? ?????????
            // ???????????? InputStream?????? ??????


            InputStream is = new ByteArrayInputStream(xml.getBytes());
            Document doc = documentbuilder.parse(is);

            // ????????? tag
            NodeList nList = doc.getElementsByTagName("item");

            System.out.println(nList.getLength());


            // ???????????? ??????????????? ???????????? data??? ??????
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                
                Element eElement = (Element) nNode;

                String createDate = getTagValue("createDt", eElement);
                String location = getTagValue("gubun", eElement);
                String count = getTagValue("defCnt", eElement);
                System.out.println("?????????????????? : " + getTagValue("createDt", eElement));
                System.out.println("?????????(??????) : " + getTagValue("gubun", eElement));
                System.out.println("????????? ??? : " + getTagValue("defCnt", eElement));

                Dictionary data = new Dictionary(createDate, location, count);
                //mArrayList.add(0, dict); //RecyclerView??? ??? ?????? ??????
                mArrayList.add(data); // RecyclerView??? ????????? ?????? ??????
                mAdapter.notifyDataSetChanged();

                Statement stmt = null;
                if (stmt != null) {
                    stmt.close();
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    // tag?????? ????????? ???????????? ??????
    public static String getTagValue(String tag, Element eElement) {
        Node nValue=null;

        NodeList x= eElement.getElementsByTagName(tag);
        Node test=x.item(0);
        NodeList t=null;
        if(test!=null) {
            t= test.getChildNodes();
            if((Node)t.item(0)!=null) {nValue=(Node)t.item(0);}
        }
        if(nValue==null) return null;
        return nValue.getNodeValue();
    }
}