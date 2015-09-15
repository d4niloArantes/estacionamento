package estacionamento.cod;

public class Entrada 
{
	//simple date format. pega a data e transforma
	private String placa;
	private String nome;
	private DataHora dataHora;

	public Entrada() {}

	public Entrada(String placa, String nome) {
		this.placa = placa.toUpperCase();
		this.nome = nome.toUpperCase();
		this.dataHora = new DataHora();
	}

	public String getPlaca() {
		return placa;
	}
	
	public String getNome() {
		return nome;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public DataHora getDataHora() {
		return dataHora;
	}
}
