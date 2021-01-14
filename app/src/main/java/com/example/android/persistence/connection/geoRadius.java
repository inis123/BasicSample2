package com.example.android.persistence.connection;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.android.persistence.db.entity.AdressEntity;

import org.json.JSONObject;

public class geoRadius {

    private final String API_KEY = null;

    private AdressEntity adress1 = null;
    private AdressEntity adress2;

    private double lat1, lon1, lat2, lon2;
    boolean init = false;

    Context context;

    public geoRadius(Context context, AdressEntity local, AdressEntity remote) {

        this.context = context;
        adress1 = local;
        adress2 = remote;

        getCor(context, buildUrl(adress1));
    }

    public geoRadius(Context context, AdressEntity local) {

        this.context = context;
        adress1 = local;
        getCor(context, buildUrl(adress1));
    }

    public double getDistance() {

        getCor(context, buildUrl(adress2));
        return distance(lat1, lon1, lat2, lon2);
    }

    public double getNewDistance(AdressEntity ae) {

        adress2 = ae;
        getCor(context, buildUrl(adress2));
        return distance(lat1, lon1, lat2, lon2);

    }

    private String buildUrl(AdressEntity ae) {

        String url = "https://maps.googleapis.com/maps/api/geocode/json?address=";
        StringBuilder surl = new StringBuilder(url);

        if (ae.getStrasse() != null)
            surl.append(ae.getStrasse() + "-");

        if (ae.getHausnummer() != null)
            surl.append(ae.getHausnummer() + "-");

        if (ae.getOrt() != null)
            surl.append(ae.getOrt());

        if (ae.getLand() != null)
            surl.append("-" + ae.getLand());

        surl.append("&key=" + API_KEY);

        return surl.toString();
    }


    private void getCor(Context context, String url) {


        RequestQueue mQueue = Volley.newRequestQueue(context);

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        if (!init) {
                            double arr[] = decodeJson(response);
                            lat1 = arr[0];
                            lon1 = arr[1];
                            init = true;
                        } else {
                            double arr[] = decodeJson(response);
                            lat2 = arr[0];
                            lon2 = arr[1];

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {

        int radius = 6371;
        double lat = Math.toRadians(lat2 - lat1);
        double lon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(lat / 2) * Math.sin(lat / 2) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.sin(lon / 2) * Math.sin(lon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = radius * c;
        return Math.abs(d);
    }

    private double[] decodeJson(JSONObject json) {

        try {
            String lat = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getString("lat");
            String lng = json.getJSONArray("results").getJSONObject(0).getJSONObject("geometry").getString("lng");
            double co[] = {Double.parseDouble(lat), Double.parseDouble(lat)};
            return co;

        } catch (Exception ec) {
            return null;
        }

    }
}