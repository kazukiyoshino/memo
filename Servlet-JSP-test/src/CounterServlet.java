

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class counter
 */
@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
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

		//セッションからオブジェクトを取得
		Integer counter = (Integer) session.getAttribute("count");

		//空なら0、そうでなければ+1
				if(counter==null) {
					counter = 0;
				}
				counter = counter.intValue()+1;

			 session.setAttribute("count",counter);

		//セッションにオブジェクトを格納
		session.setAttribute("count", counter);


		//applicationVer.
		ServletContext application = getServletContext();

		Integer count = (Integer)application.getAttribute("count");

		if(count==null) {
			count = 0;
		}
		count = count.intValue()+1;

		application.setAttribute("count",count);


	 	//cookieVer.
		Cookie[] cookies = request.getCookies();

		Integer counts = null;

		//cookiesからカウントを探し出す作業
		if(cookies !=null) {
			for(int i=0;i<cookies.length;i++) {
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("counts")) {
					String value = cookie.getValue();
					counts = Integer.valueOf(value);
					break;
				}
			}
		}

		if(counts==null) {
			counts = 0;
		}

		counts = counts.intValue()+1;

		//セット
		request.setAttribute("counts",counts.toString());

		response.setContentType("text/html; charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    out.println(counts);


		Cookie cookie = new Cookie("counts",counts.toString());
		cookie.setMaxAge(60*60*24*5);
		response.addCookie(cookie);

		RequestDispatcher dispatcher = request.getRequestDispatcher("./HelloJSP.jsp");
	    dispatcher.forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
