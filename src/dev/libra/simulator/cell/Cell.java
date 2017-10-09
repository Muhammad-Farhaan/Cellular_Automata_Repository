package dev.libra.simulator.cell;

import java.awt.Graphics2D;

public abstract class Cell {
	
	public static final int	DEFAULT_CELL_WIDTH = 70,
							DEFAULT_CELL_HEIGHT = 20;
	
	protected float x, y;
	protected int width, height;
	
	public Cell(float x, float y){
		this.x = x;
		this.y = y;
		width = DEFAULT_CELL_WIDTH;
		height = DEFAULT_CELL_HEIGHT;
	}
	
	public abstract void tick();
	
	public abstract void render(Graphics2D g);

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	

}
