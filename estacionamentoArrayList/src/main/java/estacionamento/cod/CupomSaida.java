package estacionamento.cod;

import java.util.Calendar;

public class CupomSaida 
{
	private DataHora dataHora;
	private Entrada entrada;
	private Double valor     = 0.0;
	private Double horas     = 5.0;
	private Double adicional = 2.0;
	private long tempoFree   = 15;
	private long tempoHora   = 2;
	private long tempoPermanecido;
	
	public CupomSaida() {}
	
	public CupomSaida(Entrada entrada) 
	{
		this.entrada = entrada;
		this.dataHora = new DataHora();
		calculaValor(this.entrada);
	}
	
	private Double calculaValor(Entrada entr)
	{		
		Calendar dataInicial = Calendar.getInstance();  
		dataInicial.setTime(entr.getDataHora().getHora());
		long diferenca = System.currentTimeMillis() - dataInicial.getTimeInMillis();
		long diferencaMin = diferenca / (60 * 1000);    //DIFERENCA EM MINUTOS     
		long diferencaHoras = diferenca / (60 * 60 * 1000);    // DIFERENCA EM HORAS
		//long diferencaSeg = diferenca / 1000;    //DIFERENCA EM SEGUNDOS
		if( diferencaMin < this.tempoFree){
			this.tempoPermanecido = diferencaMin;
			return this.valor;
		}else{
			if( diferencaHoras <= this.tempoHora ){
				this.tempoPermanecido = diferencaMin;
				this.valor = this.horas;
			}else{
				//acrescentar R$2 a cada uma hora
				this.tempoPermanecido = diferencaMin;
				this.valor = this.horas;
				long aux = diferencaHoras - this.tempoHora;
				for( int i = 0; i <= aux; i++ )
				{
					this.valor += adicional;
				}
			}
		}		
		return valor;
	}

	public Double getValor() {
		return valor;
	}

	public long getTempoPermanecido() {
		return tempoPermanecido;
	}
	
	public DataHora getDataHora() {
		return dataHora;
	}
}
