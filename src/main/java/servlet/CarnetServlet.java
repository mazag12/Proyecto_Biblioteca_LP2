package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Carnet;
import beans.Cliente;
import beans.Libro;
import dao.DAOFactory;
import interfaces.CarnetInterface;
import interfaces.ClienteInterface;
import interfaces.LibroInterface;

/**
 * Servlet implementation class CarnetServlet
 */
@WebServlet("/CarnetServlet")
public class CarnetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public CarnetServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listCarnet(request, response);
    	} else if (type.equals("register")) {
    		String numero = request.getParameter("numero");
    		if(numero.isEmpty()) {
    			//registerCarnet(request, response);
    		} else {
    			///editCarnet(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getCarnet(request, response);
    	} else if (type.equals("delete")) {
    		//deleteCarnet(request, response);
    	} 
    }
    
    protected void listCarnet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	CarnetInterface dao = daoFactory.getCarnet();
    	
    	List<Carnet> data = dao.getListCarnet();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Carnet.jsp").forward(request, response);
    }
    
    protected void registerCarnet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		String status = request.getParameter("txtestado");
    		
    		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
        	CarnetInterface dao = daoFactory.getCarnet();
        	Carnet carnet = dao.getCarnet(status);
        	
         	if(carnet.getNumero() == "No hay datos") {
       		 Carnet c = new Carnet();
       		 c.setNumero("Sin Numero");
       		 c.setFecha_emision("NO hay fecha");
       		 c.setFecha_caducidad("NO hay fecha");
       		 c.setEstado(status);
       		 c.setCodcategoria("Sin ID");
       		 
       		int value = dao.createCarnet(c);
   		 if(value == 1) {
   			 listCarnet(request, response);
   			 
   		 }else {
				listCarnet(request, response);
			}
   		 

   	} else {
   		// error 
   		listCarnet(request, response);
   	}
       		 
   }
    
    protected void getCarnet(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException{
    	
		String numero = request.getParameter("id");
		    	
		    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		    	CarnetInterface dao = daoFactory.getCarnet();
		    	
		    	Carnet carnet = dao.getCarnet(numero);
		    	List<Carnet> listCarnet = dao.getListCarnet();
		    	request.setAttribute("usuarioData", carnet);
		    	request.setAttribute("data", listCarnet);
		    	request.getRequestDispatcher("Carnet.jsp").forward(request, response);
		    	
    	
    }
    
    protected void editCarnet(HttpServletRequest request, HttpServletResponse response)  
    		throws ServletException, IOException{
    	
    	String num = request.getParameter("txtnumero");
    	String femi = request.getParameter("txtfechemision");
    	String fcad = request.getParameter("txtfechcaduci");
    	String est = request.getParameter("txtestado");
    	String cat = request.getParameter("txtcategoria");
    	
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	CarnetInterface dao = daoFactory.getCarnet();
    	Carnet carnet = dao.getCarnet(est);
    	
    	if(carnet.getNumero() == "No hay datos") {
    		Carnet c = new Carnet();
    		c.setNumero(num);
    		c.setFecha_emision(femi);;
    		c.setFecha_caducidad(fcad);
    		c.setEstado(est);
    		c.setCodcategoria(cat);
    	
    		
    		int flagResponde = dao.editCarnet(c);
    		if (flagResponde ==1) {
				listCarnet(request, response);
				
			}else {
				listCarnet(request, response);
			}	
    	}else if (carnet.getNumero() == num) {
    		
    		Carnet c = new Carnet();
    		c.setNumero(num);
    		c.setFecha_emision(femi);;
    		c.setFecha_caducidad(fcad);
    		c.setEstado(est);
    		c.setCodcategoria(cat);
    		
    		int flagResponde = dao.editCarnet(c);
    		
    		if (flagResponde == 1) {
	    		listCarnet(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listCarnet(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
    		listCarnet(request, response);
			
		}
    	
    }
    
    protected void deleteCarnet(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
    	
    	String num = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	CarnetInterface dao = daoFactory.getCarnet();
    	
    	int flagResponse = dao.removeCarnet(num); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listCarnet(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listCarnet(request, response);
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
