package estacionamento.cod;

import java.util.ArrayList;
import java.util.List;

public class CupomEntrada
{
	private ArrayList<Entrada> entradas = new ArrayList<>();
	
	public CupomEntrada(){}
	
	public CupomEntrada( Entrada entrada )
	{
		entradas.add(entrada);
	}
	
	public List<Entrada> getCuponsDeEntrada() {
		return entradas;
	}
	
	public void removeEntrada( Entrada entre )
	{
		for (Entrada entrada : entradas) {
			if( entrada.getPlaca().equals(entre.getPlaca()) )
				entradas.remove(entre);
		}
	}
	
	public void insereEntrada( Entrada entre )
	{
		entradas.add(entre);
	}
}
