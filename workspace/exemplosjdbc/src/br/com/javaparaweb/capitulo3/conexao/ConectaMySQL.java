package br.com.javaparaweb.capitulo3.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectaMySQL {
	public static void main(String[] args) {
		Connection conexao = null;
		try {
			// Registrando a classe JDBC, e os parâmetros de conexão em tempo de execução
			String url = "jdbc:mysql://localhost/agenda";
			String usuario = "root";
			String senha = "123456";

			conexao = DriverManager.getConnection(url, usuario, senha); 
			System.out.println("Conectou!");
			conexao.close();
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro ao criar a conexão. Erro: " + e.getMessage());
		}
	}
} 

