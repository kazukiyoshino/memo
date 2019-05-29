import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class HelloServlet extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException, ServletException{

	ServletConfig config = getServletConfig();
	String initParam= config.getInitParameter("key");

	ServletContext context = getServletContext();
	String initValue= context.getInitParameter("appkey");

	String path = context.getRealPath("/WEB-INF/init.properties");

	InputStream in = new FileInputStream(path);
	Properties prop = new Properties();
	prop.load(in);
	in.close();

	URL url =HelloServlet.class.getResource("init.properties");
	InputStream in2 = url.openStream();
	Properties prop2 = new Properties();
	prop2.load(in2);
	in2.close();

	response.setContentType("text/html; charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<HTML>");
    out.println("<head>");
    out.println("<title>サーブレット練習</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>1から100までランダム→"+new Dice().dice()+"</h1>");
    out.println("<p>クラス分け動作確認→"+Sentence.text()+"</p>");
    out.println("<p>xmlでHelloServletに設定した初期値→"+initParam+"</p>");
    out.println("<p>appに設定した初期値→"+initValue+"</p>");
    out.println("<p>propertiesファイルの中身の読み込み(物理パスによる)</p>");
    out.println("<p>properties→"+prop.getProperty("name")+"</p>");
    out.println("<p>path="+path+"</p>");
    prop.list(out);
    out.println("<p>クラスパスからファイル読み込み");
    out.println("<p>url="+url+"</p>");
    prop2.list(out);
    out.println("</body>");
    out.println("</HTML>");

  }
}
