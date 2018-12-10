package br.edu.ifrn.apiypsos.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

import br.edu.ifrn.apiypsos.domain.AvaliacaoFisica;


public class AvaliacaoFisicaDAO {

	public boolean inserirAvaliacao(AvaliacaoFisica af){

		boolean resultado = false;
		String inserir = "INSERT INTO AvaliacaoFisica(data_avaliacao, email, altura, peso) VALUES(?,?,?,?,?)";


		Connection con = ConnectionFactory.conectar();

		try {
			
			PreparedStatement ps = con.prepareStatement(inserir);
			ps.setTimestamp(1, new Timestamp(af.getDataAvaliacao()));
			ps.setString(2, af.getAluno().getEmail());
			ps.setDouble(3, af.getAltura());
			ps.setDouble(4, af.getPeso());

			int linhas = ps.executeUpdate();
			resultado = (linhas > 0);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.desconectar();
		}
		return resultado;
	}


	public boolean atualizarAvaliacao(AvaliacaoFisica af){

		boolean resultado = false;

		String atualizar = "UPDATE AvaliacaoFisica set data_avaliacao = ? AND altura = ? AND peso = ?   WHERE id_avaliacao = ?  AND login_aluno = ? ";

		Connection con = ConnectionFactory.conectar();
		
		try {

			PreparedStatement ps = con.prepareStatement(atualizar);
			ps.setTimestamp(1, new Timestamp(af.getDataAvaliacao()));
			ps.setDouble(2, af.getAltura());
			ps.setDouble(3, af.getPeso());
			ps.setInt(4, af.getIdAvaliacao());
			
			int linhas = ps.executeUpdate();
			resultado = (linhas > 0) ? true : false;

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.desconectar(); 
		}
		return resultado;
	}

	public boolean removerAvaliacao(AvaliacaoFisica af){
		String remover = "DELETE FROM AvaliacaoFisica WHERE data_avaliacao = ? AND altura = ? AND peso = ?";

		boolean resultado = false;

		Connection con = ConnectionFactory.conectar();

		try {

			PreparedStatement ps = con.prepareStatement(remover);
			ps.setTimestamp(1, new Timestamp(af.getDataAvaliacao()));
			ps.setDouble(2, af.getAltura());
			ps.setDouble(3, af.getPeso());
			ps.setInt(4, af.getIdAvaliacao());
			
			int linhas = ps.executeUpdate();
			resultado = (linhas > 0);

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			ConnectionFactory.desconectar();
		}
		return resultado;
	}

	public ArrayList<AvaliacaoFisica> buscarAvaliacoes() {

		ArrayList<AvaliacaoFisica> lista = new ArrayList<AvaliacaoFisica>();

		String query = "SELECT email, data_avaliacao, peso, altura FROM AvalicaoFisica;";


		Connection con = ConnectionFactory.conectar();

		try {

			PreparedStatement ps = con.prepareStatement(query);


			ResultSet tuplasBD = ps.executeQuery();

			while(tuplasBD.next()){

				AvaliacaoFisica objAvaliacaoFisica = new AvaliacaoFisica();

				objAvaliacaoFisica.getAluno().setEmail(tuplasBD.getString("email") );
				objAvaliacaoFisica.setDataAvaliacao(tuplasBD.getTimestamp("data_avaliacao").getTime());
				objAvaliacaoFisica.setPeso(tuplasBD.getInt("peso"));
				objAvaliacaoFisica.setAltura(tuplasBD.getDouble("altura"));

				lista.add(objAvaliacaoFisica);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			ConnectionFactory.desconectar();
		}
		return lista;
	}

}

