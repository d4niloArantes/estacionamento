package estacionamento.cod;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataHora 
{
    private Calendar cal = Calendar.getInstance();
    private String diaSemana; 
    private String mes;
    private Date horaAtual = new Date();
    
    public String getStringHora()
    {
    	SimpleDateFormat formHora = new SimpleDateFormat("HH:mm:ss");
    	return formHora.format(this.horaAtual);
    }    
    
    public String getDiaSemana()
	{
		if(cal.get(Calendar.DAY_OF_WEEK) == 1){
	    	diaSemana = "Domingo";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 2){
	    	diaSemana = "Segunda";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 3 ){
	    	diaSemana = "Terça";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 4 ){
	    	diaSemana = "Quarta";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 5 ){
	    	diaSemana = "Quinta";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 6 ){
	    	diaSemana = "Sexta";
	    }else if( cal.get(Calendar.DAY_OF_WEEK) == 7 ){
	    	diaSemana = "Sábado";
	    } 
		return diaSemana;
    }
    
    public String getMes()
    {
		if( cal.get(Calendar.MONTH) == 0 ){
		    mes = "Janeiro";
		}else if( cal.get(Calendar.MONTH) == 1 ){
		    mes = "Fevereiro";
		}else if( cal.get(Calendar.MONTH) == 2 ){
		    mes = "Março";
		}else if( cal.get(Calendar.MONTH) == 3 ){
		    mes = "Abril";
		}else if( cal.get(Calendar.MONTH) == 4 ){
		    mes = "Maio";
		}else if( cal.get(Calendar.MONTH) == 5 ){
		    mes = "Junho";
		}else if( cal.get(Calendar.MONTH) == 6 ){
		    mes = "Julho";
		}else if( cal.get(Calendar.MONTH) == 7 ){
		    mes = "Agosto";
		}else if( cal.get(Calendar.MONTH) == 8 ){
		    mes = "Setembro";
		}else if( cal.get(Calendar.MONTH) == 9 ){
		    mes = "Outubro";
		}else if( cal.get(Calendar.MONTH) == 10 ){
		    mes = "Novembro";
		}else if( cal.get(Calendar.MONTH) == 11 ){
		    mes = "Dezembro";
		}
		return mes;
	}
    
    public int getAno()
    {
    	return cal.get(Calendar.YEAR);
    }
    
    public int getDia()
    {
    	return cal.get(Calendar.DAY_OF_MONTH);
    }
    
    public Date getHora()
    {
    	return horaAtual;
    }
}
