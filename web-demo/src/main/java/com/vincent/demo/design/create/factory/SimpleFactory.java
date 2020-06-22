package com.vincent.demo.design.create.factory;

public class SimpleFactory {
	
	public Shape getShape(String type) {
		if(type == null) {
			return null;
		}else if (type.equalsIgnoreCase("circle")) {
			return new Circle();
		}else if (type.equalsIgnoreCase("rectangle")) {
			return new Rectangle();
		}else {
			return null;
		}
	}
}
