package atividadeQualitativaDAC.entidates;

public class Itinerario {
	private int id;
	private int id_aviao;
    private String origem;
    private String destino;
    private String dataVoo;
	
    public int getId() {
    	return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getId_aviao() {
		return id_aviao;
	}
	public void setId_aviao(int id_aviao) {
		this.id_aviao = id_aviao;
	}
	
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public String getDataVoo() {
		return dataVoo;
	}
	public void setDataVoo(String dataVoo) {
		this.dataVoo = dataVoo;
	} 
}
