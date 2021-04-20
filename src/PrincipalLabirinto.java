import java.util.Scanner;

public class PrincipalLabirinto {

	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		
		System.out.println("Informa o nome do arquivo a ser lido: ");
		//Labirinto.carregaLabirinto(entrada.next());
		
		System.out.println(Labirinto.labirinto(Labirinto.carregaLabirinto(entrada.next())));
		
		//Criar arquivo com o resultado
		
	}

}
