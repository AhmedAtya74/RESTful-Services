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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Path("/tweets")
public class TweetResource {

    private String path = "C:\\Users\\dell\\IdeaProjects\\Web-Service\\src\\main\\java\\com\\example\\webservice\\twitter.json";

    private JSONObject extract(JSONObject tweet){
        String content = String.valueOf(tweet.get("text"));
        String time = String.valueOf(tweet.get("created_at"));
        String id = String.valueOf(((JSONObject)tweet.get("user")).get("id"));
        JSONObject extractedTweet = new JSONObject();
        extractedTweet.put("text", content);
        extractedTweet.put("created_at", time);
        extractedTweet.put("id", id);
        return extractedTweet;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllTweets")
    public JSONArray getAllTweets() throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object allTweets = jsonParser.parse(reader);
        JSONArray tweets = (JSONArray) allTweets;
        JSONArray response = new JSONArray();
        for(Object tweet: tweets){
            JSONObject currentTweet = (JSONObject) ((JSONObject) tweet).get("tweet");
            response.add( (JSONObject)extract(currentTweet));
        }
        return response;
    }

    private JSONObject find(JSONArray allTweets, String key){
        JSONObject response = new JSONObject();
        for(Object tweet: allTweets){
            JSONObject currentTweet = (JSONObject) ((JSONObject) tweet).get("tweet");
            String id = String.valueOf(((JSONObject)currentTweet.get("user")).get("id"));
            if(id.equals(key))
                response = currentTweet;
        }
        return response;
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getTweetById/{id}")
    public JSONObject getTweetById(@PathParam("id") String tweetId) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = new FileReader(path);
        Object content = jsonParser.parse(reader);
        JSONArray tweets = (JSONArray) content;
        JSONObject response = (JSONObject) find(tweets, tweetId);
        return response;
    }
}
