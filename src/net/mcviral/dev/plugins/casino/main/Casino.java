package net.mcviral.dev.plugins.casino.main;

import net.mcviral.dev.plugins.casino.slots.SlotMachineController;
import org.bukkit.plugin.java.JavaPlugin;

public class Casino extends JavaPlugin {

	private SlotMachineController controller;
	
	public void onEnable(){
		controller = new SlotMachineController(this);
	}
	
	public void onDisable(){
		
	}
	
	
	
}
