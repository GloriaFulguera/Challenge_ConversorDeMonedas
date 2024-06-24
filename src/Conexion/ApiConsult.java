package Conexion;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConsult {
	public HttpRequest request;
	public HttpClient client = HttpClient.newHttpClient();
	
	/*Request API*/
	public ApiConsult(String moneda) {
				
		String url="https://v6.exchangerate-api.com/v6/bfee6f84749feea874cfedfc/latest/"+moneda;
		
		request = HttpRequest.newBuilder().uri(URI.create(url)).build();
	}
	
	/*Response API*/
	public String ApiResponse() {
		try {
			HttpResponse<String> response=client.send(request, HttpResponse.BodyHandlers.ofString());
			String json=response.body();
			return json;
		}
		catch(Exception e) {
			return null;
		}
	}
}
