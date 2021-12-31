package com.example.tp5.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MeteoController {
	
	
	/*@GetMapping("/meteo")
	public String showAddresses(Model model) {
		
		return "meteo";
	}*/
	
	@PostMapping(value = "/meteo")
	public String getAddress(Model model, @RequestParam(value="address") String address) throws Exception {
		
		JSONObject json = null;
		
		URL obj = new URL("https://api-adresse.data.gouv.fr/search/?q=" + URLEncoder.encode(address));
        HttpURLConnection httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        int responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(response.toString());
            json = new JSONObject(response.toString());
        } else {
            System.out.println("GET request not worked");
        }
		
		
		JSONArray coord = json.getJSONArray("features").getJSONObject(0).getJSONObject("geometry").getJSONArray("coordinates");
		System.out.println(coord.getDouble(0) + " : " + coord.getDouble(1));
		
		
		
		
		obj = new URL("https://api.meteo-concept.com/api/forecast/daily?token=9724de3b87085e93991dbe3e175143202da8166a543488fc1a24b3466cfca4c5&latlng=" + coord.getDouble(1) + "," + coord.getDouble(0));
        httpURLConnection = (HttpURLConnection) obj.openConnection();
        httpURLConnection.setRequestMethod("GET");
        httpURLConnection.setRequestProperty("Accept", "JSON");
        responseCode = httpURLConnection.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) { // success
            BufferedReader in = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in .readLine()) != null) {
                response.append(inputLine);
            } in .close();

            // print result
            System.out.println(response.toString());
            json = new JSONObject(response.toString());
        } else {
            System.out.println("GET request not worked");
            
        }
		
		
        model.addAttribute("json", json.toString());
        
        
		
		return "meteo";
	}
}
