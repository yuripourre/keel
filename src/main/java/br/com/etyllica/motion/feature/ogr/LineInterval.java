package br.com.etyllica.motion.feature.ogr;

public class LineInterval {

	private int height = 1;
	
	private int start = 0;
	
	private int length = 0;
	
	public LineInterval(int start, int length) {
		super();
		
		this.start = start;
		this.length = length;
	}
	
	public LineInterval(int start, int length, int height) {
		super();
		
		this.start = start;
		this.length = length;
		this.height = height;
	}

	public int getStart() {
		return start;
	}
	
	public int getEnd() {
		return start+length-1;
	}

	public int getLength() {
		return length;
	}
	
	public int getCenter() {
		return start+length/2;
	}

	public int getHeight() {
		return height;
	}
	
	public int expand() {
		return length++;
	}
	
}
