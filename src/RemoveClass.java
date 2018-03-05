

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Servlet implementation class RemoveClass
 */
@WebServlet("/RemoveClass")
public class RemoveClass extends HttpServlet {
	
	static final String loc = "/home/sapient/Documents/workspace-sts-3.9.2.RELEASE/newsroom/favrt.json";
	static int count;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveClass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		HashMap<String, String> data = new HashMap<String, String>();
		JSONArray json = new JSONArray();
		JSONObject js = new JSONObject();
		
		JSONParser parser = new JSONParser();
		
		
		try {
			js = (JSONObject) parser.parse(new FileReader(loc));
			count = Integer.parseInt(String.valueOf(js.get("Count")));
			
			
			json = (JSONArray) js.get("news");
			
			
			json.remove(Integer.parseInt(request.getParameter("id")));
			
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
		
		if(count!=0) {
			
			count--;
			
			js.put("Count", count);
			js.put("news",json);
			
			FileWriter jsonFileWriter = new FileWriter(loc);
			
			jsonFileWriter.write(js.toString());
			jsonFileWriter.flush();
			jsonFileWriter.close();
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Data Removed");
			
		}else {
			
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("No Data To Remove");
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
