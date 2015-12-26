package com.serial;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
/**
 * java序列化
 * 
 * @author -琴兽-
 * 
 */
public class JAVA2Bytes {

	/**
	 * 序列化
	 * 
	 * @throws IOException
	 */
	public static byte[] tobytes() throws IOException {
		// 玩家
		Player player = new Player(1, 20, "peter");
		player.getSkills().add(1001);

		// 创建对象流
		ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(arrayOutputStream);

		// 写入对象
		objectOutputStream.writeObject(player);

		// 获取字节数组
		byte[] byteArray = arrayOutputStream.toByteArray();
		System.out.println(Arrays.toString(byteArray));

		return byteArray;
	}

	/**
	 * 反序列化
	 * 
	 * @param byteArray
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */
	public static Player toPlayer(byte[] byteArray) throws Exception {
		// 创建输入流
		ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(byteArray));
		Player player = (Player) inputStream.readObject();
		// 打印
		System.out.print("playerId：" + player.getPlayerId() + "    ");
		System.out.print("age：" + player.getAge() + "    ");
		System.out.print("name：" + player.getName() + "    ");
		System.out.println("skills：" + Arrays.toString(player.getSkills().toArray()) + "    ");
		return player;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			byte[] tobytes = tobytes();
			Player player = toPlayer(tobytes);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
