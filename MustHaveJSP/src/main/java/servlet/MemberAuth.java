package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import membership.MemberDAO;
import membership.MemberDTO;

@WebServlet(urlPatterns = "/13Servlet/MemberAuth.mvc",
			initParams = { @WebInitParam(name="admin_id", value="nakja")})
public class MemberAuth extends HttpServlet{

	private static final long serialVersionUID = 1L;  // MemberAuth에 마우스를 올리면 추천해줌.
	MemberDAO dao;
	
	@Override
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		
        String driver = application.getInitParameter("MysqlDriver");
        String connectUrl = application.getInitParameter("MysqlURL");
        String mId = application.getInitParameter("MysqlID");
        String mPass = application.getInitParameter("MysqlPwd");
        
        dao = new MemberDAO(driver, connectUrl, mId, mPass);
	}
	
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String admin_id = this.getInitParameter("admin_id");
        
        String id = req.getParameter("id");
        String pass = req.getParameter("pass");

        MemberDTO memberDTO = dao.getMemberDTO(id, pass);

        String memberName = memberDTO.getName();
        if (memberName != null) {
            req.setAttribute("authMessage", memberName + " 회원님, 안녕하세요!");
        }
        else {
            if (admin_id.equals(id))
                req.setAttribute("authMessage", admin_id + "는 최고 관리자입니다.");
            else
                req.setAttribute("authMessage", "귀하는 회원이 아닙니다.");
        }
//        req.getRequestDispatcher("/13Servlet/MemberAuth.jsp").forward(req, resp);  // 1
        req.getRequestDispatcher("/WEB-INF/view/MemberAuthView.jsp").forward(req, resp);  // 2
        
        // 둘의 기술적인 차이는?
        // 1. 주소창에 http://localhost:8080/MustHaveJSP/13Servlet/MemberAuth.jsp 입력하면 제대로 실행이 됨.
        // 2. 주소창에 http://localhost:8080/MustHaveJSP/WEB-INF/view/MemberAuthView.jsp 입력하면 404 에러 발생 / WEB-INF: 외부에서 접근할 수 없는 폴더
        // 2는 서블릿을 통해서만 실행이 됨. 즉, 외부에선 실행되지 않지만 내부에서만 실행이 됨.
        // 2를 사용하면 서블릿을 사용하는 것인 아닌지 전혀 알 수가 없어서 요즘에는 많이 쓰는 방식임.
    }

    @Override
    public void destroy() {
//        dao.close();  MemberDAO 파일의 getMemberDTO안에 이미 con.close();가 있기 때문에 destory()만 부르면 됨.
    }
}

