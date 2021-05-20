package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

public interface BaseAddressMapper {
	List<String> getcity();
	
	List<String> getgugun(Map<String, String> map);
	
	List<String> getdong(Map<String, String> map);
}
