package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Autor;
import model.AutorModel;

/**
 * Servlet implementation class AutorServlet
 */
@WebServlet("/AutorServlet")
public class AutorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	AutorModel autorModel = new AutorModel();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("list")) {
    		listAutor(request, response);
    	} else if (type.equals("register")) {
    		String idSubject = request.getParameter("idSubject");
    		if(idSubject.isEmpty()) {
    			///registerAutor(request, response);
    		} else {
    			///editAutor(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getSubject(request, response);
    	} else if (type.equals("delete")) {
    		//deleteAutor(request, response);
    	} 
    }
    
    protected void listAutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	List<Autor> data = autorModel.getListAutor();
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Autor.jsp").forward(request, response);
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
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
