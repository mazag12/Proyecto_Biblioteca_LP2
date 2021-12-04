package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Idioma;
import dao.DAOFactory;
import interfaces.IdiomaInterface;

public class TagComboboxIdioma extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		IdiomaInterface dao = daoFactory.getIdioma();
		
		try {
			
			List<Idioma> listIdioma= dao.getListIdioma();
			out.print("<select class='form-control' name='txtidioma'>");
			for(Idioma autor: listIdioma) {
				
				out.print("<option value="+autor.getCodIdioma()+">"+autor.getNomIdioma()+"</option>");
				
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
