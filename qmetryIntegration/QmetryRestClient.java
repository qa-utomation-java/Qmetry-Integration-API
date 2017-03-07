package framework.qmetryIntegration;

import com.google.gson.*;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import framework.AnalyticsRequestPayload;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

/**
 * Created by Shahin Mannan
 */
public class QmetryRestClient {

    private Client client;
    private WebResource webResource;
    private ClientResponse response;
    private static Gson gson = new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create();
    public QmetryRestClient(String resource) {
        client = Client.create();
        webResource = client.resource(resource);
    }

    public String getUserToken(QmetryUser user){

        MultivaluedMap formData = new MultivaluedMapImpl();
        formData.add("username", user.getUsername());
        formData.add("password", user.getPassword());

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_FORM_URLENCODED)
                .post(ClientResponse.class, formData);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);

        //extract the access token from json string
        JsonElement element = new JsonParser().parse(output);
        JsonObject jsonObject = element.getAsJsonObject();
        String userToken = jsonObject.get("usertoken").getAsString();
        return userToken;
    }


    
    public int getTCrunId(int tsrID, String usertoken){
        QmetryTestCaseRunIdPayload tcRunIdPayload = new QmetryTestCaseRunIdPayload(tsrID);
        System.out.println(gson.toJson(tcRunIdPayload));

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_JSON)
                .header("usertoken", usertoken)
                .post(ClientResponse.class, gson.toJson(tcRunIdPayload));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JsonElement element = new JsonParser().parse(output);
        JsonObject responseObject = element.getAsJsonObject();
        JsonArray dataArray = responseObject.get("data").getAsJsonArray();
        JsonObject firstDataObject = dataArray.get(0).getAsJsonObject();
        int tcRunId = firstDataObject.get("tcRunID").getAsInt();
        return tcRunId;

    }

    public int getTCrunIdByEntityKey(String usertoken, int tsrID, String key){
        QmetryTestCaseRunIdPayload tcRunIdPayload = new QmetryTestCaseRunIdPayload(tsrID);
        System.out.println(gson.toJson(tcRunIdPayload));

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_JSON)
                .header("usertoken", usertoken)
                .post(ClientResponse.class, gson.toJson(tcRunIdPayload));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JsonElement element = new JsonParser().parse(output);
        JsonObject responseObject = element.getAsJsonObject();
        JsonArray dataArray = responseObject.get("data").getAsJsonArray();

        int tcRunId = 0;
        for(JsonElement dataObject : dataArray){
            JsonObject individualDataObject = dataObject.getAsJsonObject();

            if(individualDataObject.get("entityKey").getAsString().toLowerCase().equals(key.toLowerCase())){

                tcRunId = individualDataObject.get("tcRunID").getAsInt();
            }

        }

        return tcRunId;

    }

    public int getUserIdByLoginId(String usertoken, String loginId){
        EmptyPayload emptyPayload = new EmptyPayload();

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_JSON)
                .header("usertoken", usertoken)
                .header("scope", "default")
                .post(ClientResponse.class, gson.toJson(emptyPayload));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

        String output = response.getEntity(String.class);
        JsonElement element = new JsonParser().parse(output);
        JsonObject responseObject = element.getAsJsonObject();
        JsonArray dataArray = responseObject.get("data").getAsJsonArray();

        int userID = 0;
        for(JsonElement dataObject : dataArray){
            JsonObject individualDataObject = dataObject.getAsJsonObject();

            if(individualDataObject.get("loginId").getAsString().toLowerCase().equals(loginId.toLowerCase())){

                userID = individualDataObject.get("userID").getAsInt();
            }

        }

        return userID;
    }

    public void executeTCbyTCrunID (String usertoken, int qmTsRunId, String entityIDs, int runStatusID ){
        QmetryTestCaseExecutionPayload executionPayload = new QmetryTestCaseExecutionPayload(qmTsRunId, entityIDs, runStatusID);
        System.out.println(gson.toJson(executionPayload));

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_JSON)
                .header("usertoken", usertoken)
                //must pass in scope, else authentication fails
                .header("scope", "default")
                .put(ClientResponse.class, gson.toJson(executionPayload));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }
        System.out.println("Result updated for TSRID: "+qmTsRunId +"\n"+"TCRID: "+entityIDs);

    }


    public void logOutCurrentUser(String usertoken, int userID){

        QmetryForceLogoutPayload payload = new QmetryForceLogoutPayload(userID);

        ClientResponse response = webResource
                .type(MediaType.APPLICATION_JSON)
                .header("usertoken", usertoken)
                //must pass in scope, else authentication fails
                .header("scope", "default")
                .post(ClientResponse.class, gson.toJson(payload));

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + response.getStatus());
        }

    }



//
//    public static void main(String[] args){
//        EmptyPayload emptyPayload = new EmptyPayload();
//        System.out.println(gson.toJson(emptyPayload));
//    }

}
