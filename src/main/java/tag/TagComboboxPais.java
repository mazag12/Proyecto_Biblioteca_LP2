package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Pais;
import dao.DAOFactory;
import interfaces.PaisInterface;

public class TagComboboxPais extends TagSupport {

	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		PaisInterface dao = daoFactory.getPais();
		
		try {
			
			List<Pais> listPais= dao.getListPaisCombo();
			out.print("<select class='form-control' name='txtpais' id='paisnombre'>");
			String codigo = "";
			for(Pais pais: listPais) {
				if(codigo.equals(pais.getCodpais())) {	
				}else {
					out.print("<option value="+pais.getCodpais()+">"+pais.getNompais()+"</option>");
					codigo = pais.getCodpais();
				}
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}
	
}
