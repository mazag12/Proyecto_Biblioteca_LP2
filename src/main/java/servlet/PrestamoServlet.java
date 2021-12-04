package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Autor;
import beans.Libro;
import beans.Prestamo;
import dao.DAOFactory;
import interfaces.AutorInterface;
import interfaces.LibroInterface;
import interfaces.PrestamoInterface;

/**
 * Servlet implementation class PrestamoServlet
 */
@WebServlet("/PrestamoServlet")
public class PrestamoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PrestamoServlet() {
        // TODO Auto-generated constructor stub
    }
    
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String type = request.getParameter("type");
    	
    	if (type.equals("lista")) {
    		listPrestamo(request, response);
    	} else if (type.equals("register")) {
    		String codPrestamo = request.getParameter("codPrestamo");
    		if(codPrestamo.isEmpty()) {
    			//registerPrestamo(request, response);
    		} else {
    			///editPrestamo(request, response);
    		}
    	} else if (type.equals("info")) {
    		//getPrestamo(request, response);
    	} else if (type.equals("delete")) {
    		//deletePrestamo(request, response);
    	} 
    }
    
    
    protected void listPrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PrestamoInterface dao = daoFactory.getPrestamo();
    	
    	List<Prestamo> data = dao.getListPrestamo();
    	
    	request.setAttribute("data", data);
    	request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
    }
    
    protected void registePrestamo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	String fpres = request.getParameter("txtfprestamo");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);    	
    	PrestamoInterface dao = daoFactory.getPrestamo();
    	Prestamo pres = dao.getPrestamo(fpres); 
    	
    	if(pres.getCodprestamo() == "SNDATA") {
    		
    		Prestamo p = new Prestamo();
        	p.setCodprestamo("Sin ID");
        	p.setFechaentrega("Sin fecha");
        	p.setFechaprestamo(fpres);
        	p.setFechadevolucion("Sin fecha");
        	p.setCodcliente("Sin ID");
        	p.setCodigoemple("Sin ID");
        	
    		
    		int value = dao.createPrestamo(p);
    		
    		if (value == 1) {
        		listPrestamo(request, response);
        	} else {
        		//request.setAttribute("message", "Ocurrio un problema");
        		listPrestamo(request, response);
        	}
    		
    	}else{
    		//request.setAttribute("message", "Ocurrio un problema");
    		listPrestamo(request, response);
    	}
    	
    }
    
    protected void getPrestamo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codpres = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PrestamoInterface dao = daoFactory.getPrestamo();
    	
    	Prestamo pres = dao.getPrestamo(codpres); 
    	List<Prestamo> listUsuario = dao.getListPrestamo(); 
    	request.setAttribute("usuarioData", pres);
    	request.setAttribute("data", listUsuario);
    	request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
    }
    
    protected void editPrestamo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codp = request.getParameter("txtcodigoprestamo");
    	String fent = request.getParameter("txtfechaentrega");
    	String fpres = request.getParameter("txtfechaprestamo");
    	String fdev = request.getParameter("txtfechadevolucion");
    	String codc = request.getParameter("txtcodcliente");
    	String code = request.getParameter("txtcodemple");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PrestamoInterface dao = daoFactory.getPrestamo();
    	Prestamo pres = dao.getPrestamo(fpres);
    	    	
    	if(pres.getCodprestamo() == "SNDATA") {
    		Prestamo p = new Prestamo();
    		p.setCodprestamo(codp);
    		p.setFechaentrega(fent);
    		p.setFechaprestamo(fpres);
    		p.setFechadevolucion(fdev);
    		p.setCodcliente(codc);
    		p.setCodigoemple(code);
    	
    		
	    	int flagResponde = dao.editPrestamo(p); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listPrestamo(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listPrestamo(request, response);
	    	}
    	}else if(pres.getCodprestamo() ==  codp){
    		Prestamo p = new Prestamo();
    		p.setCodprestamo(codp);
    		p.setFechaentrega(fent);
    		p.setFechaprestamo(fpres);
    		p.setFechadevolucion(fdev);
    		p.setCodcliente(codc);
    		p.setCodigoemple(code);

    		
	    	int flagResponde = dao.editPrestamo(p); // subjectModel.editSubject(subject);
	    	
	    	if (flagResponde == 1) {
	    		listPrestamo(request, response);
	    	} else {
	    		//request.setAttribute("message", "Ocurrio un problema");
	    		listPrestamo(request, response);
	    	}
	    }else {
	    	//request.setAttribute("message", "Ocurrio un problema");
    		listPrestamo(request, response);
	    }
    	
    }
    
    protected void deletePrestampo(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException  {
    	
    	String codigo = request.getParameter("id");
    	
    	DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
    	PrestamoInterface dao = daoFactory.getPrestamo();

    	
    	int flagResponse = dao.removePrestamo(codigo); // subjectModel.removeSubject(idSubject);
    	
    	if (flagResponse == 1) {
    		listPrestamo(request, response);
    	} else {
    		//request.setAttribute("message", "Ocurrio un problema");
    		listPrestamo(request, response);
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
