package estacionamento.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import estacionamento.cod.*;

@WebServlet(urlPatterns = "/clientes")
public class ClientesServlet extends HttpServlet 
{
	private static final long	serialVersionUID = 1L;
	public static CupomEntrada cupomEntrada = new CupomEntrada();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		PrintWriter writer = resp.getWriter();
		
		writer.write(mostraClientes());
		
	}
	
	private String mostraClientes( )
	{
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html lang=\"pt-br\">");
		sb.append("<head>");
		sb.append("<meta charset=\"Windows-1252\">");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/bootstrap-3.3.5-dist/css/bootstrap-theme.min.css'>");
		sb.append("<link rel='stylesheet' href='resources/style.css'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<div class='container'>");
		sb.append("<div class='panel panel-default'>");
		sb.append("<div class='panel-heading'>");
		sb.append("<h3 class='panel-title'>Nota de Serviço</h3>");
		sb.append("</div>");
		sb.append("<div class='panel-body'>");
		sb.append("<a href='index.html'><button type='button' class='btn btn-link'>Ir para entrada</button></a>");
		sb.append("<a href='saida.html'><button type='button' class='btn btn-link'>Ir para saída</button></a>");
		sb.append("<table>");
		if( !EntradaServlet.cupomEntrada.getCuponsDeEntrada().isEmpty() )
		{
			for (Entrada c : EntradaServlet.cupomEntrada.getCuponsDeEntrada())
			{
				CupomSaida saida = new CupomSaida(c);
	
				sb.append("<tr><td>Cliente: "+c.getNome()+"<br>");
				sb.append("Placa: " + c.getPlaca()+"<br>");
				sb.append(c.getDataHora().getDiaSemana()+", "+c.getDataHora().getDia()+" de " +
							c.getDataHora().getMes()+" de " + c.getDataHora().getAno()+", as "
							+c.getDataHora().getStringHora()+"</tr></td><br/><br><br>");
				sb.append("<tr><td>Tempo permanencia: "+saida.getTempoPermanecido()+" minutos</td></tr><br/>");
			}
		}else
			sb.append("<tr><td>Nenhum Cliente</td></tr>");
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
}

