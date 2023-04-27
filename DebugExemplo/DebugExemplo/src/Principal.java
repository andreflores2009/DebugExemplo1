import java.util.Scanner;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

	public static void main(String[] args) throws IOException {
		
		//LOGGER
		Log meuLogger = new Log("Log.txt");
		try {
			//Log meuLogger = new Log("Log.txt");
			meuLogger.logger.setLevel(Level.FINE);
			meuLogger.logger.info("Log de informação");
			meuLogger.logger.warning("Log de Aviso");
			meuLogger.logger.severe("Log Severo");
			

		} catch (Exception e) {
			meuLogger.logger.info("Exception:" + e.getMessage()); //escrever no arquivo de log o erro
            e.printStackTrace();//escrever no console o erro

		}
		
		
		//Mensagens escritas no Log
		meuLogger.logger.info("\n O programa iniciou a chamada da Calculadora!!");//escrever no log
		
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			
			System.out.printf("O resultado de " + a + " " + operador + " " + b + ": %.2f", resultado);
			System.out.printf("\n");
			
			//Mensagens escritas no Log
			meuLogger.logger.info("\n O programa terminou as operações da calculadora com Resultado="+resultado);//escrever no log
		}

	}

}
