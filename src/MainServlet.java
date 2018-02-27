

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
	ArrayList<String> data=new ArrayList<String>();
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
		int i=0;
		source=request.getParameter("source");
		title=request.getParameter("title");
		description=request.getParameter("description");
		data.add(source);
		data.add(title);
		data.add(description);
		json.put(i++,data);
		
		
		try {  

            // Writing to a file  
            File file=new File("http://localhost:8081/newsroom/WebContent/WEB-INF/favrt.json");  
            file.createNewFile();  
            FileWriter fileWriter = new FileWriter(file);  
          
            fileWriter.write(json.toJSONString());  
            fileWriter.flush();  
            fileWriter.close();  

        } catch (IOException e) {  
            e.printStackTrace();  
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
