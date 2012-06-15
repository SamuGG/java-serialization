package example.com;

import java.io.ByteArrayOutputStream;

public class MainClass {

	public static void main(String[] args) {

		Sport_e sport_e = new Sport_e((byte)5, "Deporte5");
		Sport_s sport_s = new Sport_s((byte)5, "Deporte5");
		long startTime = 0;
		long endTime = 0;
		
		try
		{
			// Externalizable
			System.out.println("[E]xternalizable");
			
			startTime = System.nanoTime();
			byte[] serializedObject = Sport_e.serializeObject(sport_e);
			endTime = System.nanoTime();

			System.out.println("[E] Serialization Time(nanosec): " + String.valueOf(endTime - startTime));
			
			System.out.println("[E] Data Length (bytes): " + String.valueOf(serializedObject.length));

			startTime = System.nanoTime();
			sport_e = (Sport_e)Sport_e.deserializeObject(serializedObject);
			endTime = System.nanoTime();

			System.out.println("[E] Deserialization Time(nanosec): " + String.valueOf(endTime - startTime));
			System.out.println();
			
			// Serializable
			System.out.println("[S]erializable");
			startTime = System.nanoTime();
			serializedObject = Sport_s.serializeObject(sport_s);
			endTime = System.nanoTime();

			System.out.println("[S] Serialization Time(nanosec): " + String.valueOf(endTime - startTime));
			
			System.out.println("[S] Data Length (bytes): " + String.valueOf(serializedObject.length));

			startTime = System.nanoTime();
			sport_s = (Sport_s)Sport_s.deserializeObject(serializedObject);
			endTime = System.nanoTime();

			System.out.println("[S] Deserialization Time(nanosec): " + String.valueOf(endTime - startTime));
			System.out.println();
			
			// Protocol Buffers
			System.out.println("[P]rotoBuf");
			Sport_p.sport sport_p = Sport_p.sport.newBuilder().setId(5).setName("Deporte5").build();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			startTime = System.nanoTime();
			sport_p.writeTo(baos);
			serializedObject = baos.toByteArray();
			baos.close();
			endTime = System.nanoTime();

			System.out.println("[P] Serialization Time(nanosec): " + String.valueOf(endTime - startTime));
			
			System.out.println("[P] Data Length (bytes): " + String.valueOf(serializedObject.length));

			startTime = System.nanoTime();
			sport_p = Sport_p.sport.parseFrom(serializedObject);
			endTime = System.nanoTime();

			System.out.println("[P] Deserialization Time(nanosec): " + String.valueOf(endTime - startTime));
			
		}
		catch (Exception e){
			e.printStackTrace();
		}
		finally {
			
			
		}
	}

}
