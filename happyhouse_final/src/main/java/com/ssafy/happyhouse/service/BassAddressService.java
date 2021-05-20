package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

public interface BassAddressService {
	List<String> getCity();
	
	List<String> getGugun(Map<String, String> map);
	
	List<String> getDong(Map<String, String> map);
}
