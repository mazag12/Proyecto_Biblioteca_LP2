package tag;

import java.io.IOException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import beans.Departamento;
import dao.DAOFactory;
import interfaces.DepartamentoInterface;

public class TagComboboxDepartamentoAgregar extends TagSupport {

	private String pais;
	
	@Override
	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		DAOFactory daoFactory = DAOFactory.getFactory(DAOFactory.MYSQL);
		DepartamentoInterface dao = daoFactory.getDepartamento();
		
		try {
			
			List<Departamento> listDepartamento = dao.getDepartamento(pais);
			out.print("<select class='form-control' name='txtpais' id='pais'>");
			String codigo = "";
			for(Departamento departamento: listDepartamento) {
					out.print("<option value="+departamento.getCoddepartamento()+">"+departamento.getNomdepartamento()+"</option>");
			}
			out.print("</select>");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return super.doStartTag();
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
