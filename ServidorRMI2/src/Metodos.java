
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class Metodos extends UnicastRemoteObject implements Interface {

	public List<Aluno> alunos = new ArrayList<>();

	public Metodos() throws RemoteException, IOException, FileNotFoundException, ClassNotFoundException {
		try {
			recuperar();
		} catch (Exception ex) {
			System.out.println("Erro 08: " + ex.getMessage());
		}

	}

	public boolean Adicionar(String nome, String sobrenome, String email, String residencia, String formacao,
			String habilidades, String experiencia) {
		// boolean status = false;
		try {
			Aluno aluno_aux = new Aluno(nome, sobrenome, email, residencia, formacao, habilidades, experiencia);
			if (alunos.add(aluno_aux)) {
				gravar();
				return true;
			}

		} catch (IOException e) {
			System.out.println("Erro 01: " + e.getMessage());
		}
		return false;
	}

	@Override
	public String Listar() throws FileNotFoundException, IOException, RemoteException {
		try {
			int i;
			String lista_alunos = "";
			for (i = 0; i < alunos.size(); i++) {
				lista_alunos = lista_alunos + "Exemplo de Perfil: \n"
						+ "__________________________________________________\n" + "Email: " + alunos.get(i).getEmail()
						+ "\n" + "Nome: " + alunos.get(i).getNome() + "\t" + " Sobrenome: "
						+ alunos.get(i).getSobrenome() + "\n" + "Residência: " + alunos.get(i).getResidencia() + "\n"
						+ "Formação Acadêmica: " + alunos.get(i).getFormacaoAcademica() + "\n" + "Habilidades: "
						+ alunos.get(i).getHabilidades() + "\n" + "Experiência: "
						+ alunos.get(i).getExperienciaProfissional() + "\n"
						+ "__________________________________________________\n";
			}

			return lista_alunos;
		} catch (Exception ex) {
			System.out.println("Erro 02: " + ex.getMessage());
		}
		return null;
	}

	public String buscaFormacaoCurso(String formacao) throws FileNotFoundException, IOException, RemoteException {

		int i;
		String lista = "";
			
			for (i = 0; i < alunos.size(); i++) {
				if (alunos.get(i).getFormacaoAcademica().equals(formacao)) {
					
					lista = lista + "__________________________________________________\n"
							+ "Lista de formação no curso " + formacao + " : \n" + "Nome: " + alunos.get(i).getNome() + "\n"
							+ "Sobrenome: " + alunos.get(i).getSobrenome()+"\n"
									+ "__________________________________________________\n";

				}else {
					System.out.println("não encontrado");
				}
		}
		return lista;

	}

	

	public String buscaHabilidadeCidade(String cidade) {
		int i;
		String lista = "";
		for (i =0; i< alunos.size(); i++) {
			if (alunos.get(i).getResidencia().equals(cidade)) {
				lista = lista + "__________________________________________________\n"
						+ "Lista de Habilidades na cidade de " + cidade + " : \n" + "Nome: " + alunos.get(i).getNome() + "\n"
						+ "Sobrenome: " + alunos.get(i).getSobrenome() + "\n" + "Habilidades: " + alunos.get(i).getHabilidades()
						+ "\n__________________________________________________";

				
			}else {
				System.out.println("Não encontrado");
			}
		}
		return lista;
	}
	
	public String buscaExperienciaEmail (String email) {
		
		String lista = "";
		for (int i=0; i<alunos.size(); i++) {
			if (alunos.get(i).getEmail().equals(email)) {
				lista = lista + "__________________________________________________\n"
						+ "Lista de Experiências" + "\n"+  "Nome: " + alunos.get(i).getNome() + "\n"
						+ "Sobrenome: " + alunos.get(i).getSobrenome() + "\n" + "Experiência : " + alunos.get(i).getExperienciaProfissional()
						+ "\n__________________________________________________";

				
			}else {
				System.out.println("Não encontrado");
			}
		}
		return lista;
	}

	@Override
	public boolean Editar(String email, String nome_novo) throws FileNotFoundException, IOException, RemoteException {

		try {
			int i;

			Aluno aluno_aux;

			for (i = 0; i < alunos.size(); i++) {

				aluno_aux = alunos.get(i);
				if (aluno_aux.getEmail() == email) {
					aluno_aux.setNome(nome_novo);
					gravar();
					return true;
				}
			}
			return false;
		} catch (Exception ex) {
			System.out.println("erro 05: " + ex.getMessage());
		}
		return false;
	}

	public void recuperar() throws FileNotFoundException, IOException, ClassNotFoundException {
		FileInputStream file = new FileInputStream("arquivo.dat");
		ObjectInputStream obj_rec = new ObjectInputStream(file);
		alunos = (ArrayList) obj_rec.readObject();
	}

	public void gravar() throws FileNotFoundException, IOException {
		FileOutputStream file = new FileOutputStream("arquivo.dat");
		ObjectOutputStream obj_gravar = new ObjectOutputStream(file);
		obj_gravar.writeObject(alunos);
		obj_gravar.flush();
		obj_gravar.close();
	}

}
