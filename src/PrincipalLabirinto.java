import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) throws IllegalArgumentException, PrimeiroCaractereInvalido {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informa o nome do arquivo a ser lido: ");
		//Labirinto.carregaLabirinto(entrada.next());
		String nomeDoArquivo = entrada.next();
		
		//System.out.println(Labirinto.labirinto(Labirinto.carregaLabirinto(nomeDoArquivo)));
		
		boolean aux;
		aux = Labirinto.labirinto(Labirinto.carregaLabirinto(nomeDoArquivo));
		
		//Criar arquivo com o resultado
		Labirinto.imprimeArquivo(Labirinto.labirinto(Labirinto.carregaLabirinto(nomeDoArquivo)), Labirinto.carregaLabirinto(nomeDoArquivo));
		
	}

}
