import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
	public static boolean labirinto(char[][] arrayDoLabirinto) throws IllegalArgumentException {
		if(arrayDoLabirinto == null) {
			//lemnrar de subcrever o erro para tratar a saida
			throw new IllegalArgumentException();
		}
		return Labirinto.labirinto(arrayDoLabirinto, 0, 0);
	}
	private static boolean labirinto(char[][] arrayDoLabirinto, int linha, int coluna) {
		//verificar se tem caminho aberto
		return true;
		
	}
	
	

}
