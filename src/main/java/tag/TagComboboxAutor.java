package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Autor;
import dao.DAOFactory;
import interfaces.AutorInterface;

public class TagComboboxAutor extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		AutorInterface dao = daoFactory.getAutor();
		
		try {
			
			List<Autor> listAutor = dao.getListAutor();
			out.print("<select class='form-control' name='txtautor' id='autor'>");
			for(Autor autor: listAutor) {
				
				out.print("<option value="+autor.getCodautor()+">"+autor.getNomautor()+"</option>");
				
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
