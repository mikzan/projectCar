package com.betacom.fecarjpa.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

public class WebUtils {

	public static Object convertInObject(Object input, Class<?> tipo) {
		Object result = new Object();
		ObjectMapper mapper = new ObjectMapper();
		
		result = mapper.convertValue(input, tipo);
		
		return result;
	}
}
