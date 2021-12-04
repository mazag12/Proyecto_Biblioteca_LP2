package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Idioma;
import dao.DAOFactory;
import interfaces.IdiomaInterface;

public class TagNombreIdioma extends TagSupport{
	
	private String idioma;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		try {
			IdiomaInterface dao = daoFactory.getIdioma();
			Idioma idio = dao.getdatosIdioma("marco");
			
			out.print("<td>"+idio.getNomIdioma()+"</td>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	
	
}
