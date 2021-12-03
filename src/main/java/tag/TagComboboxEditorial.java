package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Editorial;
import dao.DAOFactory;
import interfaces.EditorialInterface;

public class TagComboboxEditorial extends TagSupport{

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		EditorialInterface dao = daoFactory.getEditorial();
		
		try {
			
			List<Editorial> listEditorial= dao.getListEditorial();
			out.print("<select class='form-control' name='txtditorial'>");
			for(Editorial autor: listEditorial) {
				
				out.print("<option value="+autor.getCodEditorial()+">"+autor.getNomEditorial()+"</option>");
				
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
