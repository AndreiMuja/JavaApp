package clase;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {

	public void transmite(Object o) throws UnknownHostException, IOException{
		Socket s=new Socket("localhost",4444);
		ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
		oos.writeObject(o);
		s.close();
	}
}
