package org.iii.moresdk.agent;

import org.iii.moresdk.common.Logs;
import org.iii.moresdk.restapiclient.Config;
import org.iii.moresdk.restapiclient.Response;
import org.iii.moresdk.restapiclient.RestApiClient;

import java.util.HashMap;

/**
 * The type Agent.
 *
 * @author Jugo
 * @version V0.1
 */
public abstract class Agent
{
    private static RestApiClient restApiClient = new RestApiClient();
    private static SdkData sdkData = new SdkData();
    
    public static synchronized void syncData()
    {
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("1", "a");
        Response response = new Response();
        int nResponse_id = restApiClient.HttpsPost("https://ryejuice.sytes.net/api/test" + "" +
                ".jsp", Config.HTTP_DATA_TYPE.X_WWW_FORM, param, response);
        Logs.showTrace("[MainActivity] onClick https response id: " + nResponse_id);
    }
}
