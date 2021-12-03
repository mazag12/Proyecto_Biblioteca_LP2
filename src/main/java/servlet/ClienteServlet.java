package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Cliente;
import dao.DAOFactory;
import interfaces.ClienteInterface;

/**
 * Servlet implementation class ClienteServlet
 */
@WebServlet("/ClienteServlet")
public class ClienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listCliente(request, response);
    	} else if (type.equals("register")) {
    		String codCliente = request.getParameter("codcliente");
    		if(codCliente.isEmpty()) {
    			registerCliente(request, response);
    		} else {
    			///editCliente(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getCliente(request, response);
    	} else if (type.equals("delete")) {
    		//deleteCliente(request, response);
    	} 
    }
    
    protected void listCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
  
    	List<Cliente> data = dao.getListCliente();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Cliente.jsp").forward(request, response);
    }
    
    protected void registerCliente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	String code = request.getParameter("txtCode");
    	String codfam = request.getParameter("txtCodfam");
    	String number = request.getParameter("txtNumber");
    	String codjob = request.getParameter("txtCodjob");
    	String codstudy = request.getParameter("txtCodstudy");
    	String codperson = request.getParameter("txtCodperson");
    	
    	Cliente cl = new Cliente();
    	cl.setCodcliente(code);
    	cl.setCodfamilia(codfam);
    	cl.setNumero(number);
    	cl.setCodtrabajo(codjob);
    	cl.setCodestudio(codstudy);
    	cl.setCodperson(codperson);
    	
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
    	
    	int value = dao.createCliente(cl); // subjectModel.createSubject(subject);
    	if (value == 1) {
    		listCliente(request, response);
    	} else {
    		// error 
    	}
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
