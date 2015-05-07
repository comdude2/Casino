package net.mcviral.dev.plugins.casino.slots;

import java.util.LinkedList;

import org.bukkit.Material;
import org.bukkit.entity.ItemFrame;

public class SlotMachineTimer implements Runnable{
	
	private boolean stop = false;
	private boolean done = false;
	private LinkedList <ItemFrame> frames = new LinkedList <ItemFrame> ();
	private LinkedList <Material> combinations = new LinkedList <Material> ();
	
	public SlotMachineTimer(LinkedList <ItemFrame> frames){
		this.frames = frames;
	}
	
	public boolean isFinished(){
		return done;
	}
	
	public void stop(){
		stop = true;
	}
	
	@Override
	public void run() {
		if (!stop){
			for (ItemFrame f : frames){
				pickBlock(f);
			}
		}
	}
	
	private synchronized ItemFrame pickBlock(ItemFrame f){
		randomBlock();
		return null;
	}
	
	private int randomBlock(){
		return -1;
	}
	
}
