package com.rest.test;

import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestMethdTest 
{
	//@Test
	public void getTest()
	{
		Response resp=RestAssured.get("http://localhost:3000/posts");
		System.out.println("done");
		//display content of the Responce Body
		System.out.println(resp.asString());
		System.out.println(resp.statusCode());
		Assert.assertEquals(resp.statusCode(),200);
	}
	//@Test
	public void postTest()
	{
		RequestSpecification req = RestAssured.given();
		req.contentType("application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("id","5");
		jobj.put("title","Devloper");
		jobj.put("author","sonali");
		req.body(jobj);
		Response res=req.post("http://localhost:3000/posts");
		//display the content of responce body
		System.out.println(res.asString());
		System.out.println(res.statusCode());		
	}
	//@Test
	public void putTest()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.contentType("application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("id","5");
		jobj.put("title","Tester");
		jobj.put("author","Seema");
		reqs.body(jobj);
		Response res=reqs.put("http://localhost:3000/posts/5");
		System.out.println(res.asString());
		System.out.println(res.statusCode());
	}
	//@Test
	public void DeleteTest()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.contentType("application/json");
		Response res=reqs.delete("http://localhost:3000/posts/3");
		System.out.println(res.asString());
		System.out.println(res.statusCode());
	}
	//@Test
	public void patchTest()
	{
		RequestSpecification reqs=RestAssured.given();
		reqs.contentType("application/json");
		JSONObject jobj=new JSONObject();
		jobj.put("id","5");
		jobj.put("title","desingner");
		reqs.body(jobj);
		Response res=reqs.patch("http://localhost:3000/posts/5");
		System.out.println(res.asString());
		System.out.println(res.statusCode());
	}
	@Test
	public void searchTest()
	{
		Response res=RestAssured.get("http://localhost:3000/posts");
		System.out.println("done");
		System.out.println(res.asString());
		ArrayList lst=res.jsonPath().get("author");
		System.out.println(lst);
	}
	
	
}

	


