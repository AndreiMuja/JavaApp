package clase;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Server implements Runnable{

	public static ServerSocket ss;
	public static Socket s;
	
	@Override
	public void run() {
		while(true){
			try{
				Class.forName("org.sqlite.JDBC");
				Connection con=DriverManager.getConnection("jdbc:sqlite:BazaDate.db");
				Statement st=con.createStatement();
				s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Object o=ois.readObject();
				if(o instanceof AvionPasageri){
					AvionPasageri ap=(AvionPasageri) o;
					String s="";
					for(String sir:ap.cnpPasageri){
						s+=sir;
					}
					st.executeUpdate("INSERT INTO AvionPasageri(serie,tonaj,marca,capacitate,CNP) VALUES('"+ap.getSerie()+"',"+ap.getTonaj()+",'"+ap.getMarca()+"',"+ap.getCapacitate()+",'"+s+"')");
					System.out.println("inserat");
                    con.close();
				}
				if(o instanceof AvionCargo){
					AvionCargo ac=(AvionCargo) o;
					String s="";
					for(String sir:ac.serieMarfuri){
						s+=sir;
					}
					st.executeUpdate("INSERT INTO AvionCargo(serie,tonaj,marca,capacitate,SERII) VALUES('"+ac.getSerie()+"',"+ac.getTonaj()+",'"+ac.getMarca()+"',"+ac.getCapacitate()+",'"+s+"')");
					System.out.println("Inserat");
					con.close();
				}
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws IOException{
		ss=new ServerSocket(4444);
		Server server=new Server();
		Thread t=new Thread(server);
		t.start();
	}
}
