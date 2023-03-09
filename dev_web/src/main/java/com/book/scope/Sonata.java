package com.book.scope;
//생성자의 메소드 오버로딩
public class Sonata {
	public int speed = 10;
	public String carName = "2023년형 소나타";
	public int wheelNum = 4;
	public Sonata() {
		//10,2023년형 소나타, 4
		System.out.println("디폴트 생성자");
	}
	public Sonata(int speed, String carName) {
		//speed, carName, 4
		this.speed = speed;
		this.carName = carName;
	}
	public Sonata(int speed, String carName, int wheelNum) {
		//speed, carName, wheelNum
		this.speed = speed;
		this.carName = carName;
		this.wheelNum = wheelNum;
	}
}