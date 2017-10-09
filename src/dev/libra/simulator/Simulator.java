package dev.libra.simulator;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import dev.libra.simulator.cell.Block;
import dev.libra.simulator.cell.Train;
import dev.libra.simulator.display.Display;

public class Simulator implements Runnable{

	private Display display;
	public int width, height;
	public String title;
	
	private boolean running = false;
	private Thread thread;
	
	private BufferStrategy bs;
	private Graphics2D g;
	
	private Train t1, t2;
	private Block[] blocks = new Block[9];	
	private Block[] blocks2 = new Block[9];
	
	public Simulator(String title, int width, int height){
		this.title = title;
		this.width = width;
		this.height = height;
	}
	
	private void init(){
		display = new Display(title, width, height);
		t1 = new Train(0, 0, 0.5f);
		t2 = new Train(0, 40, 1);
		
		t2.setAcc(10);
		
		for(int i = 0; i<9; i++){
			blocks[i] = new Block(i*70, 0, t1);
			blocks2[i] = new Block(i*70, 40, t2);
			
		}
		
		//t1.setAcc(1);
		//t2.setAcc(2f);
	}
	
	private void tick(){	//update all variables, position of objects, etc
		t1.tick();
		t2.tick();
		
		for(int i = 0; i<9; i++){
			blocks[i].tick();
			blocks2[i].tick();
		}
		
	}

	private void render(){	//render (draw) everything to the screen
		bs = display.getCanvas().getBufferStrategy();
		if(bs == null){
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		
		g = (Graphics2D) bs.getDrawGraphics();
		//Clear Screen
		g.clearRect(0, 0, width, height);
		
		//Draw Here
		
		for(int i = 0; i<9; i++){
			blocks[i].render(g);
			blocks2[i].render(g);
		}
		
		
		t1.render(g);
		t2.render(g);
		
		//End Drawing
		
		bs.show();
		g.dispose();
		
	}

	@Override
	public void run() {
		init();
		
		int fps = 60;								//no. of time you wan to call the tick and render method
		double timePerTick = 1000000000 / fps;		//1000000000 ns in 1 s max amt of time in ns that we have to execute the tick and render methods that way to achieve the x fps target 
		double delta = 0;							//amt of time we have until we have to call the tick and render method again
		long now;									//current time of computer
		long lastTime =System.nanoTime();			//return the amt of time in nano seconds that the pc is running at
		long timer = 0;
		int ticks = 0;
		
		while(running){
			now = System.nanoTime();				//setting "now" to the current time of pc in nano seconds
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;
			
			if(delta >= 1){
				tick();
				render();
				ticks++;
				delta--;
			}
			
			if(timer >= 1000000000){
				System.out.println("Ticks and Frame: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		
		//while(running){
			//tick();
			//render();
		//}
		
		stop();		//just in case thread has not already been stopped
	}
	
	public synchronized void start(){	//synchronized: so that nothing get messed up in the process
		if(running){		//in case thread is already running; return before continuing to next code 
			return;			//exit method "start"; next code is avoided
		}
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop(){
		if(!running){
			return;
		}
		
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
