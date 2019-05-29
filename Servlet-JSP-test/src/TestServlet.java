
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

	    PrintWriter out = response.getWriter();

	    Enumeration<String> names = request.getParameterNames();

	    while(names.hasMoreElements()) {
	    	String name = names.nextElement();
	    	String values[] = request.getParameterValues(name);
	    	for(int i=0;i<values.length;i++) {
	    		out.println(name+"="+values[i]);
	    	}
	    }



	    String testStr = request.getParameter("HelloJSP_text");


	    out.println("<p>TestServletにて出力→"+testStr+"</p>");


	    request.setAttribute("testmessage", "TestServletから受け渡した文章");
	    request.setAttribute("HelloJSP_text",testStr);
	    RequestDispatcher dispatcher = request.getRequestDispatcher("./ForwardServlet");
	    dispatcher.include(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
