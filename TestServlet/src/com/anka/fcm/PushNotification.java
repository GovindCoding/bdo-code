package com.anka.fcm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
//import org.json.simple.JSONObject;

/*import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONString;*/

/**
 * Servlet implementation class PushNotification
 */
@WebServlet("/PushNotification")
public class PushNotification implements Servlet {

    /**
     * Default constructor. 
     */
    public PushNotification() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("inside init");
		/*try {
			pushFCMNotification("c6uDlbybVg0:APA91bEjyWNfj0NtDbcGA0toa1jCb6uuFTGxEBDlTf_g30iQXpvc9amgSkB9qL49xGbh3pMCeGmBBxktqvpEf00hPrb4ZgVfLHQuybo_wDE3uejrKLkMMuugvkz6uU-fMBWpHw9Ei4pJ");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("inside destroy");
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see Servlet#getServletInfo()
	 */
	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null; 
	}

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside service");
	}
	
	// Method to send Notifications from server to client end.

	//public final static String AUTH_KEY_FCM = "AIzaSyBR4pU4aiJZ2kc8mkvg2s4vnhvJglOegfo";//myFirebase govind
	public final static String AUTH_KEY_FCM = "AIzaSyAUP533KeY5OBiHGg8kPoczCDlzA5ZK6Ws";//demologin vikrant
	//public final static String AUTH_KEY_FCM = "AIzaSyCkeiINQhk_OTbWL-Kf_8AmzHe7umpLvko";//MNBDemo fcmnotification
	public final static String API_URL_FCM = "https://fcm.googleapis.com/fcm/send";
	
	// userDeviceIdKey is the device id you will query from your database

	public static void pushFCMNotification() throws Exception{
	 	//String userDeviceIdKey = "cZvOMq0MAdQ:APA91bHTajasvXjcygcy1be9sL9892tVWEFzP6CuUyHif-R5rH-9x9UC0hOgKe1QrmJDOAkvoxmPDKcu2pRp13Ck5sDOKUqmawyLK6cRgg6pdf72gTd-eHx4MRfe3O_LnErAJv55cMDQ";
	 	//String userDeviceIdKey = "efHw34LAoLU:APA91bF1ozYI65FOBCc7PLrC_gPn4jhExPWMbX9Zszo3PB1ACBAV2sdk_aZn5o9QGY2io4GJjbOkBarq1rTywgKl6X4rloO_93-AG2Qhw8gTA0jzHrLR0QDgTAyngTNFqPzflb4w8nh3";   
	    String authKey = AUTH_KEY_FCM; // You FCM AUTH key
	    String FMCurl = API_URL_FCM; 
	    System.out.println("in pushNotification 123");
	    URL url = new URL(FMCurl);
	    HttpURLConnection conn = (HttpURLConnection) url.openConnection();

	    conn.setUseCaches(false);
	    conn.setDoInput(true);
	    conn.setDoOutput(true);

	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Authorization","key="+authKey);
	    conn.setRequestProperty("Content-Type","application/json");
	    
	    System.out.println("in pushNotification 456");
		  
	    //JSONObject json = new JSONObject();
	    //json.put("to",userDeviceIdKey.trim());
	    //json.put("to","/topics/anka"); //govind topic
	    //String json = "{\"to\": \"/topics/Anka\",\"data\": {\"title\": \"Drive for DBA Developer\", \"body\": \"This is a Recruitment drive data Cloud Messaging Topic Message\", \"board\": \"Anka\", }}";
	    
	    String json = "{\"to\": \"/topics/Anka\",\"data\": {"
	    		+ "\"title\": \"Annual Day Invitation\","
	    		+ "\"body\": \"This is a Recruitment drive data Cloud Messaging Topic Message. \","
	    		+ "\"board\": \"Anka\","
	    		+ "\"sender\": \"HR Co-Ordinator\","
	    		+ "\"event\": \"1\","
	    		+ "}}";
	    
	    //json.put("to","/topics/Accenture");//vikrant topic
	    
	    //JSONObject info = new JSONObject();
	    //info.put("title", "Dot Net Requirment Drive"); // Notification title
	    //info.put("body", "We have opening for Experience for sr. Java developer. "); // Notification body
	    //json.put("notification", info);

	    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
	    //wr.write(json.toString());
	    wr.write(json);
	    wr.flush();
	    conn.getInputStream();
	   
	    wr.close();
	   
	    int responseCode = conn.getResponseCode();
        System.out.println("Response Code : " + responseCode);
       
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        System.out.println("Resonse: " + response);
        //return Action.SUCCESS;      
	}
}
