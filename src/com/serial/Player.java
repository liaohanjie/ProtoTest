package com.serial;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 * 玩家
 * @author -琴兽-
 *
 */
public class Player implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5480964566191483794L;

	/**
	 * 玩家id
	 */
	private long playerId;
	
	/**
	 * 年龄
	 */
	private int age;
	
	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 技能
	 */
	private List<Integer> skills = new ArrayList<>();
	
	public Player() {
	}
	
	public Player(long playerId, int age, String name) {
		this.playerId = playerId;
		this.age = age;
		this.name = name;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getSkills() {
		return skills;
	}

	public void setSkills(List<Integer> skills) {
		this.skills = skills;
	}
}
