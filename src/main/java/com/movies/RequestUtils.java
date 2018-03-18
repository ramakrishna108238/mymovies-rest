package com.movies;

import java.util.Map;
import java.util.Set;

import org.springframework.util.MultiValueMap;

public class RequestUtils {
	
	public static RequestDto getRequest(MultiValueMap<String, String> requestParams) {
		RequestDto requestDto = new RequestDto();
		StringBuffer searchIndicator = new StringBuffer();
		Map<String, String> searchParams = requestParams.toSingleValueMap();
		//transform params to Request
		Set<String> keySet = searchParams.keySet();
		//iterate KeySet
		for(String key : keySet) {
			searchIndicator.append(key);
		}
		requestDto.setRequestParamMap(searchParams);
		requestDto.setSearchIndicator(searchIndicator.toString());
		return requestDto;
	}

}
