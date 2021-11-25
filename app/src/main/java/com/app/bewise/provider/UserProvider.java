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
import com.android.volley.toolbox.Volley;
import com.app.bewise.model.UserBuilder;
import com.app.bewise.utils.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

class UserProvider {
    String url = Util.BASE_API+"/users";
    public List<UserBuilder> getUsers(Context context) {
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

    private void setUser(UserBuilder user) {

    }
}
