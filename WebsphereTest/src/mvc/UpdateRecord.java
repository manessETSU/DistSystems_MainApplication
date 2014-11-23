package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MySQL;


@WebServlet("/UpdateRecord")
public class UpdateRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;       

    public UpdateRecord() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String first_name = request.getParameter("first_name");
		String last_name = request.getParameter("last_name");
		String dob = request.getParameter("dob");
		Connection conn = MySQL.connect();
		PreparedStatement pstatement = null;
		try{	
			
			String queryString = "UPDATE patient_info.patient SET id = ?, "
					   + " first_name = ?, "
		               + " last_name = ?, "
		               + " dob = ? "
		               + " WHERE id =" + id ;
			pstatement = conn.prepareStatement(queryString);
			pstatement.setString(1, id);
			pstatement.setString(2, first_name);
			pstatement.setString(3, last_name);
			pstatement.setString(4, dob);			
			pstatement.execute();
			
		} catch (Exception e){
			throw new Error(e);
		}
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
