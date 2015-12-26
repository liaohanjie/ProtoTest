package com.proto;

import java.util.Arrays;
import com.proto.PlayerModule.PBPlayer;
import com.proto.PlayerModule.PBPlayer.Builder;
/**
 * protobuf序列化
 * @author -琴兽-
 *
 */
public class PB2Bytes {
	
	/**
	 * 序列化
	 */
	public static byte[]  tobytes(){
		
		//获取构造器
		Builder newBuilder = PlayerModule.PBPlayer.newBuilder();
		//设置参数
		newBuilder.setPlayerId(1).setAge(20).setName("peter").addSkills(1001);
		//构造出player
		PBPlayer player = newBuilder.build();
		//序列化成字节
		byte[] byteArray = player.toByteArray();
		System.out.println(Arrays.toString(byteArray));
		return byteArray;
	}
	
	
	/**
	 * 反序列化
	 * @param byteArray
	 */
	public static PBPlayer toPlayer(byte[] byteArray){
		
		try {
			//解析成player
			PBPlayer player = PlayerModule.PBPlayer.parseFrom(byteArray);
			//打印
			System.out.print("playerId："+player.getPlayerId() + "    ");
			System.out.print("age："+player.getAge() + "    ");
			System.out.print("name："+player.getName() + "    ");
			System.out.println("skills："+ Arrays.toString(player.getSkillsList().toArray()) + "    ");
			
			return player;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	@SuppressWarnings("unused")
	public static void main(String agrs[]){
		byte[] tobytes = tobytes();
		PBPlayer player = toPlayer(tobytes);
	}

}
