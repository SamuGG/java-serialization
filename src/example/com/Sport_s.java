package example.com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Sport_s implements Serializable {

	private static final long serialVersionUID = 1L;

	private byte id;
	private String name;
	
	public Sport_s() {
	}
	
	public Sport_s(byte id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public byte getId() {
		return this.id;
	}
	
	public void setId(byte id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public static byte[] serializeObject(Serializable object) throws Exception {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		byte[] res = null;
  
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			
			oos.writeObject(object);
			oos.flush();
			   
			res = baos.toByteArray();
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				if(oos != null) oos.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  
		return res;
	}

	public static Serializable deserializeObject(byte[] objectBytes) throws Exception {
		ObjectInputStream ois = null;
		Serializable res = null;
  
		try {
		   
			ois = new ObjectInputStream(new ByteArrayInputStream(objectBytes));
			res = (Serializable) ois.readObject();
		  
		} catch (Exception ex) {
			throw ex;
		} finally {
			try {
				if(ois != null) ois.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  
		return res;
	 }

}