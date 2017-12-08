package com.anka.fcm;

public class FCMPushNotification {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			PushNotification.pushFCMNotification();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
