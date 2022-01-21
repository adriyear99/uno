package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SQLConnect {
	
	String server, database, user, password;
	ArrayList<String> dados = new ArrayList<String>(Arrays.asList("servidor","banco de dados","usuário","senha"));
	
	SQLConnect(){
		
		ArrayList<String> valores = new ArrayList<String>();
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<dados.size();i++) {
			String temp = scan.next();
			System.out.print("Digite o nome do " + dados.get(i) + ":");
			valores.add(temp);
		}
		
		server = valores.get(0);
		database = valores.get(1);
		user = valores.get(2);
		password = valores.get(3);
		
		
        String connectionUrl =
                "jdbc:sqlserver://" + server + ".database.windows.net:1433;"
                        + database
                        + user + "@" + server + ";"
                        + password
                        + "encrypt=true;"
                        + "trustServerCertificate=false;"
                        + "loginTimeout=30;";

        try (Connection connection = DriverManager.getConnection(connectionUrl);) {
            // Code here.
        }
        // Handle any errors that may have occurred.
        catch (SQLException e) {
            e.printStackTrace();
        }
	}

    public static void main(String[] args) {
    	new SQLConnect();
    }
}
