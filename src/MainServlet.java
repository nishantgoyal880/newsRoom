

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.*;
import java.util.*;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	String source=null;
	String title=null;
	String description=null;
    JSONObject json=new JSONObject();
	HashMap<String,String> data=new HashMap<String,String>();
	static Integer count=1;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		source=request.getParameter("source");
		title=request.getParameter("title");
		description=request.getParameter("description");
		data.put("source",source);
		data.put("title",title);
		data.put("description",description);
		
		if (count < 10) {
			json.put(count++, data);
			System.out.println(json.get(count - 1));

			try {

				// Writing to a file
				File file = new File("/home/sapient/Documents/workspace-sts-3.9.2.RELEASE/newsroom/favrt.json");

				if (!file.exists()) {
					file.createNewFile();
				}
				FileWriter fileWriter = new FileWriter(file, true);

				fileWriter.write(json.toJSONString());
				fileWriter.flush();
				fileWriter.close();

			} catch (IOException e) {
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
