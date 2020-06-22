package com.vincent.demo.design.create.factory;

public class TestFactoryPattern {
	public static void main(String[] args) {
		SimpleFactory factory = new SimpleFactory();
		
		Shape circle = factory.getShape("circle");
		circle.draw();
		
		Shape rect = factory.getShape("rectangle");
		rect.draw();
	}
}
