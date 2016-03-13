package modelo;

public class Calculadora {
    
	int primeiro;
	int segundo;
	int operacao;
	double result;
	
	public double calcular(){
		
		switch(operacao){
		case 1:
			result = primeiro + segundo;
			break;
		case 2:
			result = primeiro - segundo;
			break;
		case 3:
			result = primeiro * segundo;
			break;
		case 4:
			result = primeiro / segundo;
			break;
		default:
			System.out.println("Opção Inválida");
		}
				
			
		return result;
	}

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public int getPrimeiro() {
		return primeiro;
	}

	public void setPrimeiro(int primeiro) {
		this.primeiro = primeiro;
	}

	public int getSegundo() {
		return segundo;
	}

	public void setSegundo(int segundo) {
		this.segundo = segundo;
	}

	public int getOperacao() {
		return operacao;
	}

	public void setOperacao(int operacao) {
		this.operacao = operacao;
	}
	
	
	
	
	
	
	
	
}
