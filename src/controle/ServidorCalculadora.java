package controle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import modelo.Calculadora;

public class ServidorCalculadora {
	private ServerSocket sckServidor;

	public ServidorCalculadora() throws IOException {
		this.sckServidor = new ServerSocket(4000);
		for (;;) {
			Socket requisicao = this.sckServidor.accept();

			InputStream canalDeEntrada;
			OutputStream canalDeSaida;
			BufferedReader entrada;
			PrintWriter saida;

			try {
				canalDeEntrada = requisicao.getInputStream();
				canalDeSaida = requisicao.getOutputStream();
				entrada = new BufferedReader(new InputStreamReader(canalDeEntrada));
				saida = new PrintWriter(canalDeSaida, true);
				saida.println("Requisição Aceita pelo Servidor");
				Calculadora calc = new Calculadora();
				while (true) {
					//lê o primeiro numero
					String linhaDoPedido = entrada.readLine();
					if (linhaDoPedido == null || linhaDoPedido.length() == 0){
						break;
					}
					calc.setPrimeiro(Integer.parseInt(linhaDoPedido));
					
					//lê o segundo numero
					linhaDoPedido = entrada.readLine();
					calc.setSegundo(Integer.parseInt(linhaDoPedido));
					
					//lê a operação
					linhaDoPedido = entrada.readLine();
					calc.setOperacao(Integer.parseInt(linhaDoPedido));
					
					saida.println("Resultado da sua operação: " + calc.calcular());
				}
				requisicao.close();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
