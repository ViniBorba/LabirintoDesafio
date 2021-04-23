import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.plaf.synth.SynthScrollBarUI;

public class Labirinto {
	
	//metodo para ler arquivo e criar array do labirinto
	public static char[][] carregaLabirinto(String fileName){
		char[][] arrayDoLabirinto = null;
		
		try {
			FileReader fr = new FileReader(fileName);//ler o arquivo
			BufferedReader in = new BufferedReader(fr);//guardar o arquivo no buffer de memoria
			
			String line = in.readLine();
			int linha = Integer.valueOf(line).intValue();//converte string em int
			
			line = in.readLine();
			int coluna = Integer.valueOf(line).intValue();//converte string em int
			
			arrayDoLabirinto = new char[linha][coluna];//coloca linhas e colunas no array
			
			line = in.readLine();//proxima linha
			//preencher array com os dados do fileName
			while(line != null) {
				for(int lineFor = 0; lineFor < arrayDoLabirinto.length; lineFor++) {
					for(int column = 0; column < arrayDoLabirinto[lineFor].length; column++ ) {
						arrayDoLabirinto[lineFor][column] = line.charAt(column);//colocar char no array
					}
					line = in.readLine();//ler proxima linha
				}
			}
			
			in.close();//fechar o arquivo guardado no buffer de memoria
		} catch(FileNotFoundException e) {
			System.out.println("Arquivo não encontrado");
		} catch (IOException e) {
			System.out.println("Erro na leitura do arquivo");
		} catch (StringIndexOutOfBoundsException a) {
			System.out.println("Erro ao tentar inserir caracteres no Array");
		} catch (NumberFormatException e) {
			System.out.println("Erro em pegar a quantia de linhas e colunas");
		} catch (NullPointerException e) {
			System.out.println("Erro ao tentar inserir caracteres no Array");
		}
		
		return arrayDoLabirinto;
	}
	
	//metodo para vereficar o caminho no labirinto
	public static boolean labirinto(char[][] arrayDoLabirinto) throws IllegalArgumentException, PrimeiroCaractereInvalido {
		if(arrayDoLabirinto == null) {
			throw new IllegalArgumentException();
		}
		if(arrayDoLabirinto[0][0] != ' ') {
			throw new PrimeiroCaractereInvalido();
		}
		return Labirinto.labirinto(arrayDoLabirinto, 0, 0);
	}
	private static boolean labirinto(char[][] arrayDoLabirinto, int linha, int coluna) {
		//Verefica se encntrou a letra D
		//if(arrayDoLabirinto[linha][coluna] == 'D' || arrayDoLabirinto[linha +1][coluna] == 'D' || arrayDoLabirinto[linha][coluna + 1] == 'D') {
			//return true;
		//} else 
		//Primeiro tem que verificar se o proximo é D
		//Para baixo d DOWN
		if(linha +1 < arrayDoLabirinto.length && arrayDoLabirinto[linha +1][coluna] == 'D'){
			return true;
		}
		
		//para direita r RIGHT
		if(coluna +1 < arrayDoLabirinto[linha].length && arrayDoLabirinto[linha][coluna + 1] == 'D') {
			return true;
		}
		
		//para cima u UP
		if(linha -1 >= 0 && arrayDoLabirinto[linha -1][coluna] == 'D') { 
			return true;
		}
		
		//para esquerda l LEFT
		if(coluna -1 >= 0 && arrayDoLabirinto[linha][coluna -1] == 'D') { 
			return true;
		}
		
		//verificar se tem caminho aberto
		//Para baixo d DOWN
		if(linha +1 < arrayDoLabirinto.length && arrayDoLabirinto[linha + 1][coluna] == ' ') {
				arrayDoLabirinto[linha + 1][coluna] = 'd';
				return labirinto(arrayDoLabirinto, linha +1, coluna);			
		}
		
		//para direita r RIGHT
		if(coluna +1 < arrayDoLabirinto[linha].length && arrayDoLabirinto[linha][coluna + 1] == ' ') {
				arrayDoLabirinto[linha][coluna +1] = 'r';
				return labirinto(arrayDoLabirinto, linha, coluna +1);
		}

		//para cima u UP
		if(linha -1 >= 0 && arrayDoLabirinto[linha -1][coluna] == ' ' || arrayDoLabirinto[linha -1][coluna] == 'd' || arrayDoLabirinto[linha -1][coluna] == 'r') {
				arrayDoLabirinto[linha -1][coluna] = 'u';
				return labirinto(arrayDoLabirinto, linha -1, coluna);
		}
		
		//para esquerda l LEFT acho que não precisa do ' ' nem do if do D, pq para left sempre vai ter r ou u ou 
		if(coluna -1 >= 0 && arrayDoLabirinto[linha][coluna -1] == ' ' || arrayDoLabirinto[linha][coluna -1] == 'r' || arrayDoLabirinto[linha][coluna -1] == 'u' || arrayDoLabirinto[linha][coluna -1] == 'd') {
				arrayDoLabirinto[linha][coluna -1] = 'l';
				return labirinto(arrayDoLabirinto, linha, coluna -1);
		}
		
		//Para baixo caso voltando de um caminho errado b DOWN
		if(linha +1 < arrayDoLabirinto.length && arrayDoLabirinto[linha + 1][coluna] == 'u' || arrayDoLabirinto[linha + 1][coluna] == 'r') {
				arrayDoLabirinto[linha + 1][coluna] = 'b';
				return labirinto(arrayDoLabirinto, linha +1, coluna);			
		}
		
		//se não entrou em nem um if é pq é falso	
		return false;
	}
	
	public static void imprimeArquivo(boolean labirinto, char[][] arrayDoLabirinto) {
		//Cria um arquivo
		File arquivoCriado = new File("arquivoCriado.txt");
		
		try {
			//Escreve no ARQUIVO
			FileWriter fr = new FileWriter(arquivoCriado);
			
			//Classe para printar no arquivo
			PrintWriter escrever = new PrintWriter (fr);
			
			//if(labirinto) {
				//escrever.println("Existe um caminho para o labirinto");
			//} else {
				//escrever.println("Não existe um caminho para o labirinto");
			//}
			
			//Usando ternario
			escrever.println(labirinto ? "Existe um caminho para o labirinto" : "Não existe um caminho para o labirinto"); 
			
			escrever.println("\nO labirinto usado no teste foi o seguinte\n");
			
			for(int linha = 0; linha < arrayDoLabirinto.length; linha++) {
				for(int coluna = 0; coluna < arrayDoLabirinto[linha].length; coluna++) {
					if(arrayDoLabirinto[linha][coluna] == ' ') {
						arrayDoLabirinto[linha][coluna] = '*';
					}
					escrever.print(arrayDoLabirinto[linha][coluna]);
				}
				escrever.println();
			}
			escrever.close();//fechar o arquivo
		} catch (IOException e) {
			//e.printStackTrace();
			System.out.println("Erro ao escrever arquivo");
		}
		

		
		
	}

}
