package example.com;

public class Sport_c {

	private byte id;
	private String name;
	
	public Sport_c() {
	}
	
	public Sport_c(byte id, String name) {
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
	
}
