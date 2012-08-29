package com.sixthcolumn;



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.sixthcolumn.utils.json.JSONException;
import com.sixthcolumn.utils.json.JSONObject;
import com.sixthcolumn.utils.json.XML;



@Controller
public class ScienceNetworkGraphController {

	
	@RequestMapping(method=RequestMethod.GET, value="/sn/{id}")
    public @ResponseBody String getSN(HttpServletRequest request,@PathVariable String id) throws Exception {
		
		System.out.println("\n---------In getSD---------");
		
		System.out.println("TIME OF INVOCATION: "+System.currentTimeMillis());
		
		if(id == null) {
			id = "null";
		}
		
		
		String returnType = request.getParameter("returnType");
		if(returnType == null) {
			returnType = "json";
		}
 		
		String response = "";
		if(returnType.equals("xml")) {
			
			System.out.println("returntype is xml");
			
			response = "<SD>" + id + "/SD>";

			return response;
			
			
		} else {
			response = "<SD>" + id + "</SD>";
			
			System.out.println("xml response: " + response);
			
			JSONObject json = null;
	        String jsonString = "";
	        try {
	            json = XML.toJSONObject(response);
	            jsonString = json.toString(3);
	            
	            System.out.println("The json being returned: " + jsonString);

	    		System.out.println("\n---------End getSD---------");
	        } catch (JSONException e) {
	            System.out.println("Problem in toJSONObject");
	            e.printStackTrace();
	        }
	        
	        return jsonString;
		}
		
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST,value="/sn/node")
	public @ResponseBody void putNode(HttpServletRequest request) throws Exception {
		
		System.out.println("In putNode");
		
		System.out.println("TIME OF INVOCATION: "+System.currentTimeMillis());
		
		
		/*
		String response = "<response>See tomcat console</response>\n";
		
		return response;
		*/
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/testpage")
	public ModelAndView getEmployees() {
		
		Map<String,Object> model = new TreeMap<String,Object>();

		
		return new ModelAndView("testpage", model);
		
	}
	
	
	/**
	 * For testing purpose only      
	 *
	 * A dummy main program to be used for testing purpose
	 *     
	 */
	
	public static void main(String args[]){
		final MockHttpServletRequest mockRequest = new MockHttpServletRequest();

		//Set dummy parameter for testing purpose.
		
	}
	
	
}
