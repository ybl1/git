package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class EditUser
 */
@WebServlet("/EditUser")
public class EditUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid=Integer.valueOf(request.getParameter("uid"));		
		String username= request.getParameter("userName");
		String password= request.getParameter("userPwd");
		int role = Integer.valueOf(request.getParameter("userRole"));
		boolean status= Boolean.valueOf(request.getParameter("userStatus"));
		
		User user = new User();
		user.setUserId(userid);
		user.setUserName(username);
		user.setPassword(password);
		user.setRole(role);
		user.setStatus(status);
		
		UserDao userdao = new UserDao();
		int i = userdao.updateUserinfo(user);
		if(i>0) {
			response.sendRedirect("userinfo.jsp");
		}
	}

}
