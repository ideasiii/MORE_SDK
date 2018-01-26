package org.iii.moresdk.restapiclient;

import java.util.HashMap;

public class RestApiClient
{
    public RestApiClient()
    {
    }
    
    public String toString()
    {
        return "RestApiClient";
    }
    
    public void HttpsPost(final String httpsURL, final Config.HTTP_DATA_TYPE http_data_type,
            final HashMap<String, String> parameters, Response response)
    {
        Thread thread = new Thread(new HttpsPostRunnable(httpsURL, http_data_type, parameters,
                response));
        thread.start();
    }
    
    private class HttpsPostRunnable implements Runnable
    {
        private String mstrHttpsURL;
        private Config.HTTP_DATA_TYPE mHttp_data_type;
        private HashMap<String, String> mParameters;
        private Response mResponse;
        
        public HttpsPostRunnable(final String httpsURL, final Config.HTTP_DATA_TYPE
                http_data_type, final HashMap<String, String> parameters, Response response)
        {
            mstrHttpsURL = httpsURL;
            mHttp_data_type = http_data_type;
            mParameters = parameters;
            mResponse = response;
        }
        
        @Override
        public void run()
        {
            Https.POST(mstrHttpsURL, mHttp_data_type, mParameters, mResponse);
        }
    }
    
}
