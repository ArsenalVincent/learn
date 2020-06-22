package com.vincent.demo.design.create.factory;

public interface Shape {
	void draw();
}

class Rectangle implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("drawing a rectangle");
	}
	
}

class Circle implements Shape{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("drawing a circle");
	}
	
}

//class Shapefactory{
//	public Shape getShape(String type) {
//		if(type.equalsIgnoreCase("circle")) {
//			return new Circle();
//		}
//		else if{
//			
//		}
//	}
//}