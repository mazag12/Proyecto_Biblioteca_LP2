package tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Tematica;
import dao.DAOFactory;
import interfaces.TematicaInterface;

public class TagNombreTematica extends TagSupport {

	private String tematica;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		try {
			TematicaInterface dao = daoFactory.getTematica();
			Tematica te = dao.getdatosTematica(tematica);
			out.print("<td>"+te.getNomTematica()+"</td>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	public String getTematica() {
		return tematica;
	}

	public void setTematica(String tematica) {
		this.tematica = tematica;
	} 
	
	
}
