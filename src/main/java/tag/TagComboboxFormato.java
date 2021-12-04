package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Formato;
import dao.DAOFactory;
import interfaces.FormatoInterface;

public class TagComboboxFormato extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		FormatoInterface dao = daoFactory.getFormato();
		
		try {
			
			List<Formato> listFormato= dao.getListFormato();
			out.print("<select class='form-control' name='txtformato' id='formato'>");
			for(Formato autor: listFormato) {
				
				out.print("<option value="+autor.getCodformato()+">"+autor.getNomformato()+"</option>");
				
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
