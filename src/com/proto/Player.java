package com.proto;

import java.io.Serializable;

public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5480964566191483794L;

	private int playerId;
	
	private String name;
	
	private int age;

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
