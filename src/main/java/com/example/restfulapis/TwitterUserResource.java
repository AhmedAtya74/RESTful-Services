package com.example.restfulapis;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.FileReader;
import java.io.IOException;


@Path("/users")
public class TwitterUserResource {

    final private String path = "C:\\Users\\dell\\IdeaProjects\\Web-Service\\src\\main\\java\\com\\example\\webservice\\twitter.json";

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllUsers")
    public JSONArray getAllUsers() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object allTweets = jsonParser.parse(reader);
        JSONArray tweets = (JSONArray) allTweets;
        JSONArray response = new JSONArray();
        for(Object tweet: tweets){
            JSONObject currentUser = (JSONObject) ((JSONObject) (((JSONObject) tweet).get("tweet"))).get("user");
            response.add(currentUser);
        }
        return response;
    }

    private JSONObject filter(JSONObject user){
        String name = String.valueOf(user.get("name"));
        String loc = String.valueOf(user.get("location"));
        String url = String.valueOf(user.get("url"));
        String description = String.valueOf(user.get("description"));

        JSONObject filtered = new JSONObject();
        filtered.put("name", name);
        filtered.put("location", loc);
        filtered.put("url", url);
        filtered.put("description", description);

        return filtered;
    }

    private JSONObject find(JSONArray allTweets, String key){
        JSONObject response = new JSONObject();
        for(Object tweet: allTweets){
            JSONObject currentTweet = (JSONObject) ((JSONObject) tweet).get("tweet");
            String id = String.valueOf(((JSONObject)currentTweet.get("user")).get("screen_name"));
            if(id.equals(key))
                response = (JSONObject) currentTweet.get("user");
        }
        return response;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getUserByScreenName/{screenName}")
    public JSONObject getUserByScreenName(@PathParam("screenName") String screenName) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object allTweets = jsonParser.parse(reader);
        JSONArray tweets = (JSONArray) allTweets;
        JSONObject response = new JSONObject();
        response = (JSONObject) find(tweets, screenName);
        response = filter((JSONObject) response);

        return response;
    }

}