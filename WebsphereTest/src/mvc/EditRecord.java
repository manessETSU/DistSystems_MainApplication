package mvc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import db.MySQL;

/**
 * Servlet implementation class EditRecord
 */
@WebServlet("/EditRecord")
public class EditRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection conn;
	ResultSet rs;
	Statement stmt;	
	String id, query;
	
    public EditRecord() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		try{				
			id = request.getParameter("id");
			conn = MySQL.connect();
			stmt = conn.createStatement();
			query = "select * from patient_info.patient where id = " + id;			
			rs = stmt.executeQuery(query);	
			request.setAttribute("EditData",rs);
			RequestDispatcher rd = request.getRequestDispatcher("editData.jsp");
			rd.forward(request, response);
			conn.close();
			
		} catch(Exception e) {
			
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	
	protected void procesRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			System.out.print("hehre");
			id = request.getParameter("id");
			conn = MySQL.connect();
			stmt = conn.createStatement();
			query = "select * from pateint_info.users where id = " + id;
			rs = stmt.executeQuery(query);
			request.setAttribute("EditData",response);
			RequestDispatcher rd = request.getRequestDispatcher("editData.jsp");
			rd.forward(request, response);
			conn.close();
			
		} catch(Exception e) {
			
		}
	}

}
