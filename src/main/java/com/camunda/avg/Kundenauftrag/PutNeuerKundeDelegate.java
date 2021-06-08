package com.camunda.avg.KundenAuftrag;

import org.json.JSONArray;
import org.json.JSONObject;

import connectjar.org.apache.http.HttpResponse;

import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import connectjar.org.apache.http.client.methods.HttpPost;
import connectjar.org.apache.http.entity.StringEntity;
import connectjar.org.apache.http.impl.client.HttpClientBuilder;
import connectjar.org.apache.http.client.HttpClient;

public class PutNeuerKundeDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		// TODO Auto-generated method stub
		putKunde(execution);
	}
	
	public void putKunde(DelegateExecution execution) {
		try {
			JSONObject postObj = new JSONObject();
			
			postObj.put("id", execution.getVariable("id"));
			postObj.put("prename", execution.getVariable("prename"));
			postObj.put("surname", execution.getVariable("surname"));
			postObj.put("birthDate", execution.getVariable("birthDate"));
			postObj.put("creditRating", -1);
			postObj.put("purchaseVolume", 0);
					
			HttpClient httpClient = HttpClientBuilder.create().build();
			HttpPost req = new HttpPost("http://localhost:3000/customers");
			req.setEntity(new StringEntity(postObj.toString()));
			req.addHeader("Content-Type", "application/json");
			HttpResponse resp = httpClient.execute(req);
			
			execution.setVariable("creditRating", -1);
			execution.setVariable("purchaseVolume", 0);
			
			//System.out.println(resp.getStatusLine());	
			
		} catch (Exception e) {
			//System.out.println("Error" + e.toString());
			throw new BpmnError("Error_Connection_Failed");
		}
	}

}
