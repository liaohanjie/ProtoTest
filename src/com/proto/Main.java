package com.proto;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

import com.proto.PlayerModule.Player;
import com.proto.PlayerModule.Player.Builder;
import com.proto.PlayerModule.Player.SEX;

public class Main {

	public static void main(String[] args) throws IOException {
		
		long start = System.currentTimeMillis();
		for(int i=0; i<1; i++){
			protoSerial();
			javaSerial();
		}
		System.out.println(System.currentTimeMillis()-start);
	}
	
	
	/**
	 * protobuf序列化
	 */
	public static void protoSerial(){
		
		Builder newBuilder = PlayerModule.Player.newBuilder();
		
		newBuilder.setPlayerId(1001).setName("peter").setSex(SEX.MALE);

		Player player = newBuilder.build();

		System.out.println(Arrays.toString(player.toByteArray()));
	}

	
	public static void javaSerial() throws IOException{
		
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
		
		com.proto.Player player = new com.proto.Player();
		
		player.setPlayerId(1001);
		
		player.setName("peter");
		
		objectOutputStream.writeObject(player);

		byte[] byteArray = byteArrayOutputStream.toByteArray();
		System.out.println(Arrays.toString(byteArray));
		
		ObjectInputStream inputStream  = new ObjectInputStream(new ByteArrayInputStream(byteArray));
		try {
			com.proto.Player readObject = (com.proto.Player) inputStream.readObject();
			System.out.println(readObject.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
