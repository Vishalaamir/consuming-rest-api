package exceptionhandler;

import java.io.IOException;
import java.util.Properties;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

@Component
public class AppExceptionHandler implements ResponseErrorHandler {

	@Override
	public boolean hasError(ClientHttpResponse response) throws IOException {
		
		if(response.getStatusCode()!=HttpStatus.OK) {
			
			System.out.println("Inside hasError()");
			System.out.println("response.getStatusText()"+response.getStatusText());
			System.out.println("response.getStatusText()"+response.getRawStatusCode());
			return true;
		
		}
		
		return false;
	}

	@Override
	public void handleError(ClientHttpResponse response) throws IOException {
		System.out.println("Inside handleError()");
//		Properties properties= new Properties();
//		properties.put("body", response.getBody().toString());
//		System.out.println("response.getBody().toString():"+response.getBody().toString());
//		properties.put("header", response.getHeaders());
//		System.out.println(response.getHeaders());
//		properties.put("Status Code", response.getStatusCode());
//		System.out.println(response.getStatusCode());
//		
//		CustomException customException=new CustomException();
//		customException.setProperties(properties);
//		System.out.println("customexception:"+customException);
//		throw customException;
//		
		
		
	}

}
