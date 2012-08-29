package com.sixthcolumn.web;



import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import com.sciencenetwork.data.type1.Type1;


@Controller
public class ScienceNetController {
	
	private String SOURCE_FILE = "/Users/8xo/software/tomcat/apache-tomcat-6.0.35/bin/type1.xml";

	
	@RequestMapping(method=RequestMethod.GET,
					value="/type2")
	public void type2(HttpServletRequest request,final HttpServletResponse response) {
		
		String format = getFormat(request);
		
		
		
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/{scientific_person}/discoveries")
    public void postPersonDiscoveries(HttpServletRequest request,final HttpServletResponse response,
    		@PathVariable String scientific_person,@RequestBody String body)  {
	
	
		System.out.println("Posting " + body);
	
		try {

            DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(body));

            Document doc = db.parse(is);
            
            doc.getDocumentElement().normalize();
            
            org.w3c.dom.Element docElement = doc.getDocumentElement();
            
            
            System.out.println(docElement.getNodeName());
            //this.readHelper(docElement);
            
        } catch(Exception e) {
            e.printStackTrace();
        }
		
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/{scientific_person}/discoveries")
    public void getPersonDiscoveries(HttpServletRequest request,final HttpServletResponse response,
    		@PathVariable String scientific_person)  {
		
		String format = request.getParameter("format");
		
		if(format == null) {
			format = "xml";
		}
		
		
		String payload = null;
		
		
		Type1 newType1 = new Type1();
		
		newType1.fromFile(SOURCE_FILE);
		
		System.out.println("person: " + newType1.getScientificPerson());
		
		if(format.equals("xml")) {
			payload = newType1.toXML();
			
			response.setContentType("text/xml");
			
			try {
				response.getWriter().write( payload );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if(format.equals("json")) {
			payload = newType1.toJSON();
			
			response.setContentType("text/json");
			
			try {
				response.getWriter().write( payload );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			payload = format + " is not supported at this time";
			
			response.setContentType("text/html");
			
			try {
				response.getWriter().write( payload );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		/*
		String modelName = request.getParameter("model");
		
		if(modelName == null) {
			modelName = "nullModel";
		}
		
		String format = request.getParameter("format");
		if(format == null) {
			format = "xml";
		}
		
		String type = request.getParameter("type");
		if(type == null) {
			type = "fgdc";
		}
		
		SolrModelRecordReader reader = new SolrModelRecordReader(modelName);
		reader.doQueries();
		Model model = reader.getModel();
		
		FGDCModelRecordWriter fgdc = new FGDCModelRecordWriter(true);
		
		fgdc.setModel(model);

		fgdc.setFileName("fgdc-" + model.getModelName() + ".xml");
		
		fgdc.writeFGDC();
		
		Metadata metadata = fgdc.getMetadata();
		
		
		if(format.equalsIgnoreCase("json")) {
			response1.setContentType("text/json");
			try {
				response = metadata.toJSON();
				
				response1.getWriter().write( response );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			response1.setContentType("text/xml");
			try {
				response = metadata.toXML();
				
				response1.getWriter().write( response );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		//return response;
	}
	
	
	private String getFormat(HttpServletRequest request) {
		String format = request.getParameter("format");
		
		if(format == null) {
			format = "xml";
		}
		
		return format;
	}
	
	
	
	/**
	 * For testing purpose only      
	 *
	 * A dummy main program to be used for testing purpose
	 *     
	 */
	
	public static void main(String args[]){
		final MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		final MockHttpServletResponse mockResponse = new MockHttpServletResponse();

		mockRequest.setParameter("model", "ACCESS1.0");
		
		//Set dummy parameter for testing purpose.
		ScienceNetController trans = new ScienceNetController();
		
		//trans.getMetadataRequest(mockRequest,mockResponse);
		
		
		//System.out.println(response);
	}
	
	
}
