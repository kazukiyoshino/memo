

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ServiceServlet
 */
@WebServlet("/ServiceServlet")
public class ServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());

		//セッションの取得(セッション作成)
		HttpSession session = request.getSession();

		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();

		out.println("<html><body>");

		//セッションIDの表示
		out.println("<p>sessionId="+session.getId());

		//自分へのリンク表示
		String linkUrl = request.getRequestURI();
		out.println("<p><a href=\""+linkUrl+"\">reload</a>");
		//out.println("</body></html>");

		String keyParam = request.getParameter("key");
		String valueParam = request.getParameter("value");

		if(keyParam != null) {
			session.setAttribute(keyParam, valueParam);
		}

		out.println("<form action= \"\">");
		out.println("<p>key<input type=\"text\" name=\"key\"></p>");
		out.println("<p>value<input type=\"text\" name=\"value\"></p>");
		out.println("<input type=\"submit\" value=\"登録\">");
		out.println("</form>");


		//Iteratorは使わないほうがいい？
		Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements()) {
			String key = names.nextElement();
			Object value = session.getAttribute(key);
			out.println(key+"="+value+"</br>");
		}
		out.println("</body></html>");



	}

}
