package com.ssafy.happyhouse.util;

import com.ssafy.happyhouse.model.PosDto;

public class util {
	public static double distanceInKilometerByHaversine(PosDto pos1, PosDto pos2) {
	    double lat1 = pos1.getLat();
	    double lng1 = pos1.getLng();
	    double lat2 = pos2.getLat();
	    double lng2 = pos2.getLng();
		
		double distance;
	    double radius = 6371;
	    double toRadian = Math.PI / 180;

	    double deltaLatitude = Math.abs(lat1 - lat2) * toRadian;
	    double deltaLongitude = Math.abs(lng1 - lng2) * toRadian;

	    double sinDeltaLat = Math.sin(deltaLatitude / 2);
	    double sinDeltaLng = Math.sin(deltaLongitude / 2);
	    double squareRoot = Math.sqrt(
	        sinDeltaLat * sinDeltaLat +
	        Math.cos(lat1 * toRadian) * 
	        Math.cos(lat2 * toRadian) * 
	        sinDeltaLng * sinDeltaLng);

	    distance = 2 * radius * Math.asin(squareRoot);

	    return distance;
	}
}
