/**
 * @(#)NamexTweet.java
 *
 *
 * @author 
 * @version 1.00 2019/6/18
 */

//unduh twitter4j di http://twitter4j.org/en/index.html
//masukkan ke project     
//twitter4j-async-a.b.c.jar
//    twitter4j-core-a.b.c.jar
//    twitter4j-media-support-a.b.c.jar
//    twitter4j-stream-a.b.c.jar
//ubah consumer key, consumer key secret, access token, access token secret sesuai akun twitter anda


import java.io.IOException;

import twitter4j.ResponseList;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class NamexTweet {
    private final static String CONSUMER_KEY = "VytF15LiJ0GoYkru3WbcwrdL3";
    private final static String CONSUMER_KEY_SECRET = "VVORU0UE0NPi7hgFo6H9GETn0T3sFe3JPNfA1d2S5Jfuq7SXmX";

    public void start() throws TwitterException, IOException {

	Twitter twitter = new TwitterFactory().getInstance();
	twitter.setOAuthConsumer(CONSUMER_KEY, CONSUMER_KEY_SECRET);

	// here's the difference
	String accessToken = getSavedAccessToken();
	String accessTokenSecret = getSavedAccessTokenSecret();
	AccessToken oathAccessToken = new AccessToken(accessToken,
		accessTokenSecret);

	twitter.setOAuthAccessToken(oathAccessToken);
	// end of difference

	twitter.updateStatus("Hallo, my name is Danu");

	System.out.println("\nMy Timeline:");

	// I'm reading your timeline
	ResponseList<Status> list = twitter.getHomeTimeline();
	for (Status each : list) {

	    System.out.println("Sent by: @" + each.getUser().getScreenName()
		    + " - " + each.getUser().getName() + "\n" + each.getText()
		    + "\n");
	}

    }

    private String getSavedAccessTokenSecret() {
	// consider this is method to get your previously saved Access Token
	// Secret
	return "xAgBtfgWsfMeGITFowSCDwNHvgGh1ASPKwqzdSzT2cJBg";
    }

    private String getSavedAccessToken() {
	// consider this is method to get your previously saved Access Token
	return "552480481-81Vop9idCRANbvx8p8Yq5zuk0LKaJcfAlVvxlUUr";
    }

    public static void main(String[] args) throws Exception {
	new NamexTweet().start();
    }
}