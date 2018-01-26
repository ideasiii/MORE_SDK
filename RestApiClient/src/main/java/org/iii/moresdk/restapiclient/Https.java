package org.iii.moresdk.restapiclient;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Jugo on 2018/1/25
 */

public class Https
{
    public static int POST(final String httpsURL, final Config.HTTP_DATA_TYPE http_data_type,
            final HashMap<String, String> parameters, Response response)
    {
        System.out.println("[Https] POST : URL=" + httpsURL + " Data Type=" + http_data_type
                .toString());
        String strParameter = null;
        try
        {
            strParameter = getPostDataString(parameters);
            URL url = new URL(httpsURL);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setConnectTimeout(Config.TIME_OUT_CONNECT);
            con.setReadTimeout(Config.TIME_OUT_READ);
            con.setRequestProperty("Content-length", String.valueOf(strParameter.length()));
            con.setRequestProperty("Content-Type", http_data_type.toString());
            con.setRequestProperty("Cache-Control", "no-cache");
            con.setDoOutput(true);
            con.setDoInput(true);
            
            DataOutputStream output = new DataOutputStream(con.getOutputStream());
            output.writeBytes(strParameter);
            output.close();
            
            System.out.println("Resp Code:" + con.getResponseCode());
           // System.out.println("Resp Message:" + con.getResponseMessage());
            
            response.Code = con.getResponseCode();
            if (response.Code == HttpsURLConnection.HTTP_OK)
            {
                response.Data = "";
                String line;
                BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
                while ((line = br.readLine()) != null)
                {
                    response.Data += line;
                }
                System.out.println("Resp Data:" + response.Data);
            }
            else
            {
                System.out.println("[Https] ERROR HTTP Response Code:" + response.Code);
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
        
        
        return response.Code;
    }
    
    private static String getPostDataString(HashMap<String, String> params)
            throws UnsupportedEncodingException
    {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (HashMap.Entry<String, String> entry : params.entrySet())
        {
            if (first)
            {
                first = false;
            }
            else
            {
                result.append("&");
            }
            
            result.append(URLEncoder.encode(entry.getKey(), Config.ENCODING));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), Config.ENCODING));
        }
        
        return result.toString();
    }
}
