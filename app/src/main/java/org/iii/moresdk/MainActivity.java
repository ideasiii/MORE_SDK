package org.iii.moresdk;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.iii.moresdk.agent.Agent;

public class MainActivity extends AppCompatActivity
{
    
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Agent agent = new Agent();
        Log.d("SDK Debug", agent.toString());
    }
}
