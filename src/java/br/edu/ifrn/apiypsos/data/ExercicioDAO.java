package br.edu.ifrn.apiypsos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import br.edu.ifrn.apiypsos.domain.Exercicio;

public class ExercicioDAO {

	public boolean inserir(Exercicio e){

		boolean resultado = false;
		String inserir = "INSERT INTO Exercicio(nome_exercicio, id_Exercicio, id_grupo) VALUES(?,?,?)";


		Connection con = ConnectionFactory.conectar();

		try {
		
			PreparedStatement ps = con.prepareStatement(inserir);
			ps.setString(1, e.getNomeExercicio());
			ps.setInt(2, e.getIdExercicio());
			
			ps.setInt(3, e.getGrupoMuscular().getIdGrupo());

			int linhas = ps.executeUpdate();
			resultado = (linhas > 0) ? true : false;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.desconectar();
		}
		
		return resultado;
	}

	/*public boolean atualizar(Exercicio ae){

		boolean resultado = false;

		String atualizar = "UPDATE Exercicio set nome_exercicio = ? WHERE id_exercicio = ? AND id_grupo = ?";


		Connection con = ConnectionFactory.conectar();
		try {

			//manipula os elementos onde tem interrogação

			PreparedStatement ps = con.prepareStatement(atualizar);
			ps.setString(1, ae.getNomeExercicio());
			//ps.setInt(2, ae.getIdExercicio());
			//ps.setInt(3, ae.getGrupoMuscular().getIdGrupo());
			ps.execute();
			resultado = true;

		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		finally {
			ConnectionFactory.desconectar(); 

		}
		return resultado;
	}*/

	/*public boolean removerExercicio(Exercicio e){
		String remover = "DELETE FROM Exercicio WHERE nome_exercicio = ? AND id_exercicio = ? AND id_grupo = ?";

		boolean resultado = false;

		Connection con = ConnectionFactory.conectar();

		try {

			//manipula os elementos onde tem interrogação

			PreparedStatement ps = con.prepareStatement(remover);
			ps.setString(1, e.getNomeExercicio());
			ps.setInt(2, e.getIdExercicio());
			ps.setInt(3, e.getGrupoMuscular().getIdGrupo());
			ps.execute();
			resultado = true;

		}catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}

		finally {
			ConnectionFactory.desconectar();
		}


		return resultado;
	}*/

	public ArrayList<Exercicio> buscarExercicios() {

		ArrayList<Exercicio> lista = new ArrayList<Exercicio>();

		String query = "SELECT id_exercicio, nome_exercicio FROM Exercicio;";


		Connection con = ConnectionFactory.conectar();

		try {

			PreparedStatement ps = con.prepareStatement(query);


			ResultSet tuplasBD = ps.executeQuery();

			while(tuplasBD.next()){

				Exercicio objExercicio = new Exercicio();

				objExercicio.setIdExercicio(tuplasBD.getInt("id_exercicio") );
				objExercicio.setNomeExercicio(tuplasBD.getString("nome_exercicio"));

				lista.add(objExercicio);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.desconectar();
		}
		
		return lista;
	}
}

