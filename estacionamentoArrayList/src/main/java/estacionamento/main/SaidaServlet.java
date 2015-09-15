package estacionamento.main;

import java.io.IOException;

import estacionamento.main.EntradaServlet;

import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import estacionamento.cod.CupomSaida;
import estacionamento.cod.Entrada;

@WebServlet(urlPatterns = "/gerarFatura")
public class SaidaServlet extends HttpServlet 
{
	private static final long	serialVersionUID	= 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		String placa = req.getParameter("placa");
		placa = placa.toUpperCase();
		PrintWriter writer = resp.getWriter();
		
		if ( !placa.isEmpty() ) 
		{
			writer.write(fatura( placa ));
		} else {
			writer.write("Erro, falta de parametros");
		}		
	}
	
	private String fatura( String placa )
	{
		boolean tem = false;
		StringBuilder sb = new StringBuilder();
		for (Entrada c : EntradaServlet.cupomEntrada.getCuponsDeEntrada()) 
		{
			if( c.getPlaca().equals(placa) )
			{
				CupomSaida saida = new CupomSaida(c);
				tem = true;
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
				sb.append("<tr><td>ENTRADA:<br/>");
				sb.append("Cliente: "+c.getNome()+"<br/>");
				sb.append("Placa: " + c.getPlaca()+"<br/>");
				sb.append(c.getDataHora().getDiaSemana()+", "+c.getDataHora().getDia()+" de " +
							c.getDataHora().getMes()+" de " + c.getDataHora().getAno()+", as "
							+c.getDataHora().getStringHora()+"</tr></td>");
				
				sb.append("<tr><td>SAÍDA:<br/>");
				sb.append(saida.getDataHora().getDiaSemana()+", "+saida.getDataHora().getDia()+" de " +
						saida.getDataHora().getMes()+" de " + saida.getDataHora().getAno()+", as "
						+saida.getDataHora().getStringHora()+"</td></tr>");
				
				sb.append("<tr><td>Tempo permanecido: "+saida.getTempoPermanecido()+" minutos</td></tr>");
				sb.append("<tr><td>TOTAL: R$ "+saida.getValor()+"</td></tr>");
				sb.append("</table>");
				sb.append("</body>");				
				sb.append("</html>");
				break;
			}			
		}
		if( tem == false )
			sb.append("Placa inesistente! Volte e tente novamente.");
		
		return sb.toString();
	}
}
