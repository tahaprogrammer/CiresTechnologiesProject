package com.thmobile.cirestechnologiesproject.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataRequestServer {

    private Context context;
    private RequestQueue requestQueue;

    public DataRequestServer(Context context) {
        this.context = context;
        requestQueue = Volley.newRequestQueue(context);
    }

    public void getAllOnlineData(String BASE_URL, OnDownloadFinished onDownloadFinished) {
        ArrayList<DataModel> dataModels = new ArrayList<>();
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, BASE_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray(Utils.Array_Data);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                dataModels.add(new DataModel(
                                        jsonObject.getString(Utils.author),
                                        jsonObject.getString(Utils.content),
                                        jsonObject.getString(Utils.date),
                                        jsonObject.getString(Utils.imageUrl),
                                        jsonObject.getString(Utils.readMoreUrl),
                                        jsonObject.getString(Utils.time),
                                        jsonObject.getString(Utils.title),
                                        jsonObject.getString(Utils.url)
                                ));
                            }

                            onDownloadFinished.onFinished(dataModels);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        showDialogNoInternet();
                    }
                });
        requestQueue.add(jsonObjectRequest);
    }

    private void showDialogNoInternet() {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle("Warning")
                .setMessage("There no Internet, Please try Again")
                .setNeutralButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        Dialog dialog = builder.create();
        dialog.show();
    }
}