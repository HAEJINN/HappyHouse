package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

public interface BaseAddressMapper {
	List<String> getCity();
	
	List<String> getGugun(Map<String, String> map);
	
	List<String> getDong(Map<String, String> map);
}
