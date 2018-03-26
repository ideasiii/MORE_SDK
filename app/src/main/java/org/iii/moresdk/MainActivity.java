package org.iii.moresdk;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.EditText;

import org.iii.moresdk.restapiclient.RestApiClient;
import org.iii.moresdk.widget.IndicatorView;
import org.iii.moresdk.widget.ProgressView;
import org.iii.moresdk.widget.SwitchButton;

public class MainActivity extends Activity
{
    private EditText et_msg = null;
    private RestApiClient restApiClient = null;
    private SwitchButton switchButton = null;
    
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        
        /* SwitchButton test*/
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams
                .MATCH_PARENT, 80);
        switchButton = new SwitchButton(this);
        switchButton.setLayoutParams(layoutParams);
        
        IndicatorView indicatorView = new IndicatorView(this);
        indicatorView.setLayoutParams(layoutParams);
        indicatorView.setPosition(100);
        
        ProgressView progressView = new ProgressView(this);
        progressView.setLayoutParams(layoutParams);
        progressView.setPosition(30);
        
        setContentView(progressView);
        
        /* // https api test
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
        });*/
    }
}
