package com.camunda.avg.KundenAuftrag;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;
import org.json.JSONException;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GetKundeninformationenDelegate implements JavaDelegate {

	private String urlHeader = "http://localhost:3000/customers";
	
	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		String prename = (String) execution.getVariable("prename");
		String surname = (String) execution.getVariable("surname");
		// String birthdate = (String) execution.getVariable("birthDate");
		
		abfrage(execution, prename, surname); //, birthdate);
	}

	private void abfrage(DelegateExecution execution, String prename, String surname)
	throws Exception {
		
		//System.out.print("Hello World \n\n");
		String output;
		
		try {
			URL url = new URL(urlHeader + "?prename=" + prename + "&surname=" + surname); // + "&birthDate=" + birthdate);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json");

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			StringBuffer sb = new StringBuffer();
			while ((output = br.readLine()) != null) {
				sb.append(output + "\n");
			}
			con.disconnect();
			
			JSONArray jarr = new JSONArray(sb.toString());
			if(jarr.length() == 0)
				execution.setVariable("vorhanden", false);
			else {
				execution.setVariable("vorhanden", true);
				
				JSONObject jobj = jarr.getJSONObject(0);
				
				execution.setVariable("creditRating", jobj.get("creditRating"));
				
				execution.setVariable("purchaseVolume", jobj.get("purchaseVolume"));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			throw new BpmnError("Error_Connection_Failed");
		}
	}

}
