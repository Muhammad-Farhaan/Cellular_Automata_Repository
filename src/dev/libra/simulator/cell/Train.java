package dev.libra.simulator.cell;

import java.awt.Color;
import java.awt.Graphics2D;

public class Train extends Cell{
	
	protected float currentSpeed, acc, block;
	
	public Train(float x, float y, float acc) {
		super(x, y);
		this.acc = acc;
	}

	public void move(){
		currentSpeed += acc;
		
		if(currentSpeed % width == 0){
			x = (int)currentSpeed;
		}
		
		if(currentSpeed % width == 0){
			block = (int)x;
		}
		
		if(x >= 630){
			x = 0;
			block = (int)x;
			currentSpeed = 0;
		}
		
	}
	
	@Override
	public void tick() {
		move();
	}

	@Override
	public void render(Graphics2D g) {
		//g.setColor(Color.RED);
		//g.fillRect((int)x-20, (int)y, width, height);
		
		g.setColor(Color.BLUE);
		g.fillRect((int)x+4, (int)y+3, width-6, height-6);
		
		//g.setColor(Color.RED);
		//g.fillRect((int)x+20, (int)y, width, height);
	}
	
	//GETTER AND SETTER

	public float getAcc() {
		return acc;
	}

	public void setAcc(float acc) {
		this.acc = acc;
	}
}
