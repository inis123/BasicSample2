package com.example.android.persistence.connection;


import android.content.Context;
import android.graphics.Bitmap;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.persistence.db.entity.AdressEntity;
import com.example.android.persistence.db.entity.InteressentEntity;
import com.example.android.persistence.db.entity.PersonEntity;
import com.example.android.persistence.ui.kontakt_erstellen;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.OutputStream;

import java.net.URL;
import java.net.URLConnection;
import java.nio.ByteBuffer;


public class vcard {
    private kontakt_erstellen ke;

    public vcard(kontakt_erstellen ke, Bitmap imgBitmap) {
        this.ke = ke;
        performPostCall(imgBitmap);
        getRequest(ke.getApplicationContext());
    }


    public void getRequest(Context context) {


        RequestQueue mQueue = Volley.newRequestQueue(context);
        String url = "https://{endpoint}/formrecognizer/v2.1-preview.2/prebuilt/businessCard/analyzeResults/{resultId}";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONObject json = response.getJSONObject("status");
                            if (json.toString().contains("failed"))
                                return;
                            if (json.toString().contains("succeeded")) {
                                setData(response);
                                return;
                            }
                            if (json.toString().contains("running") || json.toString().contains("notStarted"))
                                getRequest(context);                                                        // Wiederholverzögerung oder als eigener Task
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


    public void performPostCall(Bitmap img) {
        int width = img.getWidth();
        int height = img.getHeight();

        int size = img.getRowBytes() * img.getHeight();
        ByteBuffer byteBuffer = ByteBuffer.allocate(size);
        img.copyPixelsToBuffer(byteBuffer);
        byte[] byteArray = byteBuffer.array();
        try {

            // Defined URL  where to send data
            URL url = new URL("https://northeurope.api.cognitive.microsoft.com/formrecognizer/v2.1-preview.2/prebuilt/businessCard/analyze");

            // Send POST data request

            URLConnection conn = url.openConnection();
            conn.setRequestProperty("Content-Type", "image/jpeg");
            conn.setDoOutput(true);
            OutputStream os = conn.getOutputStream();
            os.write(byteArray);
            os.flush();
            os.close();
            conn.connect();


        } catch (Exception ex) {

        }

    }

    public void setData(JSONObject response) {
        PersonEntity pe = new PersonEntity();
        AdressEntity ae = new AdressEntity();
        InteressentEntity ie = new InteressentEntity();

        try {
            JSONArray jarr = response.getJSONObject("analyzeResult").getJSONArray("documentResults");
            JSONObject tmp = jarr.getJSONObject(0).getJSONObject("fields").getJSONObject("ContactNames").getJSONObject("valueObject");
            JSONObject fields = jarr.getJSONObject(0).getJSONObject("fields");


            pe.setName(tmp.getJSONObject("FirstName").getString("text"));
            pe.setNachname(tmp.getJSONObject("LastName").getString("text"));
            ie.setStellung(fields.getJSONObject("JobTitles").getJSONArray("valueArray").getJSONObject(0).getString("text"));

            ae.setmTelNr(fields.getJSONObject("OtherPhones").getJSONArray("valueArray").getJSONObject(0).getString("text"));
            ae.setTelNr(fields.getJSONObject("MobilPhones").getJSONArray("valueArray").getJSONObject(0).getString("text"));
            ae.setOrt(fields.getJSONObject("Adresses").getJSONArray("valueArray").getJSONObject(0).getString("text"));


        } catch (Exception a) {

        }
        ke.setData(pe, ie, ae);

    }

}
