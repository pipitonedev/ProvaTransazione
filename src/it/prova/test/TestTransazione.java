package it.prova.test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import it.prova.connection.MyConnection;

public class TestTransazione {

	public static void main(String[] args) {
		
		Connection con = MyConnection.getConnection();
		
		try {
			
			con.setAutoCommit(false);
			Statement st = con.createStatement();
			st.executeUpdate("INSERT INTO motocicletta(marca,modello,cilindrata) VALUES('Aprilia','Scarabeo','50')");
			st.executeUpdate("INSERT INTO motocicletta(marca,modello,cilindrata) VALUES('Piaggio','Zip SP','50')");
			con.commit();
			st.close();
			System.out.println("I valori sono stati impostati all'interno del Database");
		}catch (SQLException ex) {
	        ex.printStackTrace();
	        try {
	            System.out.println("Transazione non è andata a buon fine!");
	            con.rollback();
	        }
	        catch (SQLException se) {
	            se.printStackTrace();
	        }
	    }

	}

}
