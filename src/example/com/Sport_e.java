package example.com;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public final class Sport_e implements Externalizable {

	private byte id;
	private String name;
	
	public Sport_e() {
	}
	
	public Sport_e(byte id, String name) {
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
	
	@Override
	public void readExternal(ObjectInput objectInput) throws IOException, ClassNotFoundException {
		this.id = objectInput.readByte();
		this.name = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeByte(this.id);
		objectOutput.writeUTF(this.name);
	}

	public static byte[] serializeObject(Externalizable object) throws Exception {
		ByteArrayOutputStream baos = null;
		ObjectOutputStream oos = null;
		byte[] res = new byte[0];
  
		try {
			baos = new ByteArrayOutputStream();
			oos = new ObjectOutputStream(baos);
			   
			object.writeExternal(oos);
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

	public static Externalizable deserializeObject(byte[] objectBytes) throws Exception {
		ObjectInputStream ois = null;
		Externalizable res = null;
  
		try {
		   
			ois = new ObjectInputStream(new ByteArrayInputStream(objectBytes));
			   
			res = new Sport_e();
			res.readExternal(ois);
		  
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
