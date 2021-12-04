package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Tematica;
import dao.DAOFactory;
import interfaces.TematicaInterface;

public class TagComboboxTematica extends TagSupport{
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		TematicaInterface dao = daoFactory.getTematica();
		
		try {
			
			List<Tematica> listTematica= dao.getListTematica();
			out.print("<select class='form-control' name='txttematica' id='tematica'>");
			for(Tematica autor: listTematica) {
				
				out.print("<option value="+autor.getCodTematica()+">"+autor.getNomTematica()+"</option>");
				
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
}
