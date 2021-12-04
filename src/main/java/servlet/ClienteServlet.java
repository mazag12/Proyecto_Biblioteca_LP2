package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Autor;
import beans.Cliente;
import dao.DAOFactory;
import interfaces.AutorInterface;
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
    	String name = request.getParameter("txtnumero");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
    	Cliente cliente = dao.Cliente(name);
    	
    	if(cliente.getCodcliente() == "No hay datos") {
    		 Cliente c = new Cliente();
    		 c.setCodcliente("Sin ID");
    		 c.setCodfamilia("Sin Id");
    		 c.setNumero(name);
    		 c.setCodtrabajo("Sin ID");
    		 c.setCodestudio("SinID");
    		 c.setCodperson("SinID");
    		 
    		 int value = dao.createCliente(c);
    		 if(value == 1) {
    			 listCliente(request, response);
    			 
    		 }else {
				listCliente(request, response);
			}
    		 
 
    	} else {
    		// error 
    		listCliente(request, response);
    	}
    }
    
    protected void getCliente(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException  {
    	
    	String codCliente = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
    	
    	Cliente cliente = dao.Cliente(codCliente);
    	List<Cliente> listCliente = dao.getListCliente();
    	request.setAttribute("usuarioData", cliente);
    	request.setAttribute("data", listCliente);
    	request.getRequestDispatcher("Cliente.jsp").forward(request, response);
    	
    }
    
    protected void editCliente(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException {
    	
    	String codC = request.getParameter("txtcodigoC");
    	String codF = request.getParameter("txtcodigoF");
    	String num = request.getParameter("txtnumero");
    	String codT = request.getParameter("txtcodigoT");
    	String codE = request.getParameter("txtcodigoE");
    	String codP = request.getParameter("txtcodigoP");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
    	Cliente cliente = dao.Cliente(num);
    	
    	if(cliente.getCodcliente() == "No hay datos") {
    		Cliente c = new Cliente();
    		c.setCodcliente(codC);
    		c.setCodfamilia(codF);
    		c.setNumero(num);
    		c.setCodtrabajo(codT);
    		c.setCodestudio(codE);
    		c.setCodperson(codP);
    		
    		int flagResponde = dao.editCliente(c);
    		if (flagResponde ==1) {
				listCliente(request, response);
				
			}else {
				listCliente(request, response);
			}	
    	}else if (cliente.getCodcliente() == codC) {
    		
    		Cliente c = new Cliente();
    		c.setCodcliente(codC);
    		c.setCodfamilia(codF);
    		c.setNumero(num);
    		c.setCodtrabajo(codT);
    		c.setCodestudio(codE);
    		c.setCodperson(codP);
    		
    		int flagResponde = dao.editCliente(c);
    		
    		if (flagResponde == 1) {
	    		listCliente(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listCliente(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
    		listCliente(request, response);
			
		}
	
    	
    }
    
    protected void deleteCliente(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String cod = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	ClienteInterface dao = daoFactory.getCliente();
    	
    	int flagResponse = dao.removeCliente(cod); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listCliente(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listCliente(request, response);
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
