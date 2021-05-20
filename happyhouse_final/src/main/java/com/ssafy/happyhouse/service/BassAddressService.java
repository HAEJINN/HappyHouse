package com.ssafy.happyhouse.service;

import java.util.List;
import java.util.Map;

public interface BassAddressService {
	List<String> getcity();
	
	List<String> getgugun(Map<String, String> map);
	
	List<String> getdong(Map<String, String> map);
}
