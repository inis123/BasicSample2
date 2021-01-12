package com.example.android.persistence.connection;


import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.persistence.ui.kontakt_erstellen;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import javax.net.ssl.HttpsURLConnection;

import cz.msebera.android.httpclient.entity.mime.Header;

public class vcard {
    private kontakt_erstellen ke;

    public vcard(kontakt_erstellen ke, Bitmap imgBitmap) {
        this.ke = ke;
        performPostCall(imgBitmap);
        getRequest(ke.getApplicationContext());
    }


    public void getRequest(Context context){
        boolean faild =false;

       RequestQueue mQueue= Volley.newRequestQueue(context);
       String url="";
        JsonObjectRequest request =new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject json=response.getJSONObject("status");
                            if(json.toString().contains("failed"))
                                return;
                            if(json.toString().contains("succeeded"))
                                setData(response);
                                return;


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }




    public void  performPostCall(Bitmap img){
        int width = img.getWidth();
        int height = img.getHeight();

        int size = img.getRowBytes() * img.getHeight();
        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        img.copyPixelsToBuffer(byteBuffer);
        byte[] byteArray = byteBuffer.array();
        try
        {

            // Defined URL  where to send data
            URL url = new URL("https://northeurope.api.cognitive.microsoft.com/formrecognizer/v2.1-preview.2/prebuilt/businessCard/analyze");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type","image/jpeg");
            conn.setDoOutput(true);
            OutputStream os=conn.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
            conn.connect();


        }
        catch(Exception ex)
        {

        }

    }
    public void setData(JSONObject response){

    }

}
