package com.app.bewise.provider;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.airbnb.lottie.utils.Utils;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.app.bewise.model.UserBuilder;
import com.app.bewise.utils.Util;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class UserProvider  {
    String url = Util.BASE_API+"/users";
    Context context;

    public UserProvider(Context context) {
        this.context = context;
    }

    public interface VolleyResponseListener {
        void onError(String message);

        void onResponse(Object response);
    }


    public List<UserBuilder> getUsers() {
        List<UserBuilder> usersList = new ArrayList<>();
        RequestQueue queue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                UserBuilder userBuilder = new UserBuilder();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        // we are getting each json object.
                        JSONObject responseObj = response.getJSONObject(i);
                        userBuilder.setId(responseObj.getString("id"));
                        userBuilder.setEmail(responseObj.getString("email"));
                        userBuilder.setName(responseObj.getString("name"));
                        userBuilder.setPhone(responseObj.getString("phone"));
                        userBuilder.setLocation(responseObj.getString("location"));
                        userBuilder.setSchool_levels(responseObj.getString("school_levels"));
                        userBuilder.setCreatedAt(responseObj.getString("createdAt"));
                        userBuilder.setStatus(responseObj.getString("status"));
                        userBuilder.setOthers(responseObj.getString("others"));
                        usersList.add(userBuilder);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, "Fail to get the data..", Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonArrayRequest);
        return usersList;
    }

    public void setUser(UserBuilder user, VolleyResponseListener volleyResponseListener) {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JSONObject postData = new JSONObject();
        Gson gson = new Gson();

        try{
            //postData.getJSONObject(gson.toJson(user));
            postData.put("phone", "84365we5568");
            postData.put("name", "Agostiewwenho");
            postData.put("id", "122");
            postData.put("location", "Maputo");
            postData.put("email","ag@gmail.com");
        } catch (JSONException e) {
            e.printStackTrace();

            volleyResponseListener.onResponse(e.getMessage());
        }

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, postData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.e("RUser", response.toString());
                volleyResponseListener.onResponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("EUser", error.toString());
                volleyResponseListener.onError(error.toString());
            }
        });

        requestQueue.add(jsonObjectRequest);
    }
}
