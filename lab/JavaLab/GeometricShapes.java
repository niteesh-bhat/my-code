package java_lab;

import java.util.Scanner;

interface Geometry2D {
	public void readDimensions();
	public double Perimeter();
	public double Area();
}

interface Geometry3D {
	public void readDimensions();
	public double SurfaceArea();
	public double Volume();
}

class Rectangle implements Geometry2D {
	double length, breadth;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter length: ");
		length = s.nextDouble();
		System.out.print("Enter breadth: ");
		breadth = s.nextDouble();
	}

	@Override
	public double Perimeter() {
		return 2*(length + breadth);
	}

	@Override
	public double Area() {
		return length * breadth;
	}
}

class Square implements Geometry2D {
	double side;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter side: ");
		side = s.nextDouble();
	}

	@Override
	public double Perimeter() {
		return 4*side;
	}

	@Override
	public double Area() {
		return side * side;
	}
}

class Circle implements Geometry2D {
	double radius;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter radius: ");
		radius = s.nextDouble();
	}

	@Override
	public double Perimeter() {
		return 2*Math.PI*radius;
	}

	@Override
	public double Area() {
		return Math.PI * radius * radius;
	}
}

class Triangle implements Geometry2D {
	double a, b, c;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter side 1: ");
		a = s.nextDouble();
		System.out.print("Enter side 2: ");
		b = s.nextDouble();
		System.out.print("Enter side 3: ");
		c = s.nextDouble();
	}

	@Override
	public double Perimeter() {
		return a+b+c;
	}

	@Override
	public double Area() {
		double s = (a + b + c)/2;
		return Math.sqrt(Math.abs(s * (s-a) * (s-b) * (s-c)));
	}
}

class Cuboid3D implements Geometry3D {
	double length, breadth, height;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter length: ");
		length = s.nextDouble();
		System.out.print("Enter breadth: ");
		breadth = s.nextDouble();
		System.out.print("Enter height: ");
		height = s.nextDouble();
	}

	@Override
	public double SurfaceArea() {
		return 2 * (length * breadth + breadth * height + length * height);
	}

	@Override
	public double Volume() {
		return length * breadth * height;
	}
}

class Cube implements Geometry3D {
	double side;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter side: ");
		side = s.nextDouble();
	}

	@Override
	public double SurfaceArea() {
		return 6*side*side;
	}

	@Override
	public double Volume() {
		return side*side*side;
	}
}

class Cylinder implements Geometry3D {
	double baseRadius, height;
	
	@Override
	public void readDimensions() {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter base radius: ");
		baseRadius = s.nextDouble();
		System.out.print("Enter height: ");
		height = s.nextDouble();
	}

	@Override
	public double SurfaceArea() {
		return 2 * Math.PI * baseRadius * height + 2 * Math.PI * baseRadius * baseRadius;
	}

	@Override
	public double Volume() {
		return Math.PI * baseRadius * baseRadius * height;
	}
}

public class GeometricShapes {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int choice;
		System.out.println("1. 2D\n2. 3D");
		choice = s.nextInt();
		
		if (choice == 1) {
			System.out.println("1. Rect, 2. Triangle, 3. Square, 4. Circle");
			Geometry2D geo;
			choice = s.nextInt();
			switch(choice) {
			case 1: geo = new Rectangle();
					break;
			case 2: geo = new Triangle();
					break;
			case 3: geo = new Square();
					break;
			case 4: geo = new Circle();
					break;
			default:System.out.println("Invalid choice. Defaulting to rect.");
					geo = new Rectangle();
			}
			geo.readDimensions();
			System.out.println("Area = " + geo.Area());
			System.out.println("Perimeter = " + geo.Perimeter());
		} else {
			System.out.println("1. Cuboid, 2. Cube, 3. Cylinder");
			Geometry3D geo;
			choice = s.nextInt();
			switch(choice) {
			case 1: geo = new Cuboid3D();
					break;
			case 2: geo = new Cube();
					break;
			case 3: geo = new Cylinder();
					break;
			default:System.out.println("Invalid choice. Defaulting to rect.");
					geo = new Cuboid3D();
			}
			geo.readDimensions();
			System.out.println("SurfaceArea = " + geo.SurfaceArea());
			System.out.println("Volume = " + geo.Volume());
		}
				
		s.close();
	}
}
