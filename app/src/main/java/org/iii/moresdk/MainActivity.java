package org.iii.moresdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.iii.moresdk.agent.Agent;
import org.iii.moresdk.restapiclient.Config;
import org.iii.moresdk.restapiclient.Response;
import org.iii.moresdk.restapiclient.RestApiClient;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity
{
    private EditText et_msg = null;
    private RestApiClient restApiClient = null;
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        restApiClient = new RestApiClient();
        Agent agent = new Agent();
        Log.d("SDK Debug", agent.toString());
        
        Button btn_https_post = findViewById(R.id.button_https_post);
        et_msg = findViewById(R.id.editText_msg);
        et_msg.append(agent.toString());
        
        btn_https_post.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("1", "a");
                Response response = new Response();
                int nResponse_id = restApiClient.HttpsPost("https://ryejuice.sytes.net/api/test"
                        + ".jsp", Config.HTTP_DATA_TYPE.X_WWW_FORM, param, response);
                System.out.println("[MainActivity] onClick https response id: " + nResponse_id);
            }
        });
        
        restApiClient.setResponseListener(new RestApiClient.ResponseListener()
        {
            @Override
            public void onResponse(JSONObject jsonObject)
            {
                System.out.println("[MainActivity] onResponse : " + jsonObject.toString());
            }
        });
    }
}
