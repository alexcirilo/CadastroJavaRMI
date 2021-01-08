
import java.io.IOException;
import javax.swing.JOptionPane;

public class view_aluno {

	public Controle controle_view;

	// construtor
	public view_aluno(Controle controle) throws IOException {
		controle_view = controle;
		opcao();
	}

	public void opcao() throws IOException {
		int opc;

		do {
			opc = Integer.parseInt(JOptionPane.showInputDialog(null,
					"" + "1 - Adicionar Perfil\n" + "2 - Listar Perfis \n" + "3 - Editar\n" + "4 - Listar Habilidades\n"
							+ "5 - Listar Forma��o \n" + "6 - Listar Experi�ncia  \n" + "7 - Sair "));

			switch (opc) {

			case 1:
				String nome = JOptionPane.showInputDialog("Entre com o nome: ");
				String sobrenome = JOptionPane.showInputDialog("Entre com o sobrenome: ");
				String email = JOptionPane.showInputDialog("Informe o E-mail: ");
				String residencia = JOptionPane.showInputDialog("Cidade : ");
				String formacao = JOptionPane.showInputDialog("Forma��o Acad�mica: ");
				String habilidades = JOptionPane.showInputDialog("Quais s�o suas Habilidades: ");
				String experiencia = JOptionPane.showInputDialog("Experi�ncia: ");

				if (controle_view.Adicionar(nome, sobrenome, email, residencia, formacao, habilidades, experiencia)) {
					JOptionPane.showMessageDialog(null, nome + ", adicionado com Sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Pessoa nao adicionada");
				}

				break;

			case 2:

				String lista = controle_view.Listar();
				JOptionPane.showMessageDialog(null, lista);
				break;

			case 3:
				email = (JOptionPane.showInputDialog("Entre com o email a ser alterado:"));
				String nome_novo = JOptionPane.showInputDialog("Entre com o novo nome: ");
				if (controle_view.Editar(email, nome_novo)) {
					JOptionPane.showMessageDialog(null, "Nome Modificado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "N�o modificado");
				}

				break;

			case 4:
				String aux = JOptionPane.showInputDialog("Informe a cidade para consultar: ");
				JOptionPane.showMessageDialog(null, controle_view.buscaHabilidadeCidade(aux));

				break;

			case 5:
				formacao = JOptionPane.showInputDialog("Qual Forma��o?");
				JOptionPane.showMessageDialog(null, controle_view.buscaFormacaoCurso(formacao));
				break;
				
			case 6:
				email = (JOptionPane.showInputDialog("Entre com o email"));
				JOptionPane.showMessageDialog(null, controle_view.buscaExperienciaEmail(email));
				
				break;

			}
			

		} while (opc != 7);
	}
}
