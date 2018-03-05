
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.util.*;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {

	static Integer count=0;
	static final String loc = "/home/sapient/Documents/workspace-sts-3.9.2.RELEASE/newsroom/favrt.json";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MainServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HashMap<String, String> data = new HashMap<String, String>();
		JSONArray json = new JSONArray();
		JSONObject js = new JSONObject();

	

		
			
			JSONParser parser = new JSONParser();
			
			try {
				js = (JSONObject) parser.parse(new FileReader(loc));
				count = Integer.parseInt(String.valueOf(js.get("Count")));

				
				json = (JSONArray) js.get("news");

			} catch (Exception e) {

				e.printStackTrace();
			}
			
		if (count < 10) {	

			try {
				count++;
				js.put("Count", count);
				data.put("source", request.getParameter("source"));
				data.put("title", request.getParameter("title"));
				data.put("description", request.getParameter("description"));
				
				json.add(data);
				js.put("news",json);

				FileWriter jsonFileWriter = new FileWriter(loc);
			
				jsonFileWriter.write(js.toString());
				jsonFileWriter.flush();
				jsonFileWriter.close();

			} catch (Exception e) {

				e.printStackTrace();

			}

			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Data Added");

		} else {
			response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write("Limit Exceeded");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
