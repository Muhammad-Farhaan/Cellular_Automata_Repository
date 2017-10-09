package dev.libra.simulator.cell;

import java.awt.Color;
import java.awt.Graphics2D;

public class Block extends Cell{
	
	public static final boolean DEFAULT_BLOCK_STATE = false;
	private boolean state;

	private Train t;
	
	public Block(float x, float y, Train t) {
		super(x, y);
		state = DEFAULT_BLOCK_STATE;
		this.t = t;
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	@Override
	public void tick() {
		//isActive(t);
		//isActive2(t);
	}

	@Override
	public void render(Graphics2D g) {
		g.setColor(Color.BLACK);
		g.drawRect((int)x, (int)y, width, height);
		
		if(state == true){
			
			g.setColor(Color.RED);
			g.fillRect((int)x+4, (int)y+3, DEFAULT_CELL_WIDTH-6, DEFAULT_CELL_HEIGHT-6);
			g.fillRect((int)x+DEFAULT_CELL_WIDTH+4, (int)y+3, DEFAULT_CELL_WIDTH-6, DEFAULT_CELL_HEIGHT-6);
			
			g.setColor(Color.ORANGE);
			g.fillRect((int)x-DEFAULT_CELL_WIDTH+4, (int)y+3, DEFAULT_CELL_WIDTH-6, DEFAULT_CELL_HEIGHT-6);
			g.fillRect((int)x+DEFAULT_CELL_WIDTH+DEFAULT_CELL_WIDTH+4, (int)y+3, DEFAULT_CELL_WIDTH-6, DEFAULT_CELL_HEIGHT-6);
		}
	}
	
	public void isActive(Train t){
		if(t != null){
			if(this.x == /*t.getX()*/ t.block && this.y == t.getY()){
				state = true;
				return;
			}
		}
		state = false;
	}
	
	public void isActive2(Train t){
		if(t != null){
			if(this.x == /*t.getX()*/ t.block-DEFAULT_CELL_WIDTH && this.y == t.getY()){
				state = true;
				return;
			}
		}
		state = false;
	}
}
