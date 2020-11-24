package com.example.baraa.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class Real_timeFragment extends Fragment {
    View view;
    TextView textView;
    private static final String HI ="https://uniqueandrocode.000webhostapp.com/hiren/androidtute.php" ;
Button Get;
@Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    getMovieData();
    view=inflater.inflate(R.layout.fragment_real, container, false);

     textView = view.findViewById(R.id.htext);

    return view;
    }
   /* @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button) view.findViewById(R.id.but);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"click button",Toast.LENGTH_LONG).show();
                Intent myIntent = new Intent();
             //   myIntent.setClassName("com.example", "com.example.Main2Activity");

                myIntent = new Intent(getActivity(), Main2Activity.class);
                // for ex: your package name can be "com.example"
                // your activity name will be "com.example.Contact_Developer"
                startActivity(myIntent);}
        });
}*/
    private void getMovieData() {

        StringRequest stringRequest=new StringRequest(Request.Method.GET, HI, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    JSONObject jsonObject=new JSONObject(response);
                    JSONArray array=jsonObject.getJSONArray("data");
                    for (int i=0; i<array.length(); i++ ){
                        JSONObject ob=array.getJSONObject(i);
                        List_Data listData=new List_Data(ob.getString("name")
                                ,ob.getString("movie"));
                        Toast.makeText(getActivity(),""+ob.getString("name"),Toast.LENGTH_LONG).show();
                      //
                         reads(ob);
                    }
                   // rv.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue= Volley.newRequestQueue(getActivity());
        requestQueue.add(stringRequest);
    }
public void reads( final JSONObject ob){
    /*try {
        Toast.makeText(getActivity(),""+ob.getInt("id"),Toast.LENGTH_LONG).show();
    } catch (JSONException e) {
        e.printStackTrace();
    }*/

    Get =  view.findViewById(R.id.get);
    Get.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            try{
                Toast.makeText(getActivity(),""+ob.getInt("id"),Toast.LENGTH_LONG).show();

                //  Toast.makeText(getContext(),"click button",Toast.LENGTH_LONG).show();
            //Intent myIntent = new Intent();
            //   myIntent.setClassName("com.example", "com.example.Main2Activity");
            // myIntent = new Intent(getActivity(), Main2Activity.class);
            // for ex: your package name can be "com.example"
            // your activity name will be "com.example.Contact_Developer"
            // startActivity(myIntent);
          textView.setText(""+ob.getInt("id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }}
    });
}

}