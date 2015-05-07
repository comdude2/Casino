package net.mcviral.dev.plugins.casino.slots;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.ItemFrame;

public class SlotMachine implements ConfigurationSerializable {
	
	private int id = -1;
	private String tier = null;
	private String world = null;
	private final Location leverLocation;
	private final Location frameLocation;
	private LinkedList <ItemFrame> frames = new LinkedList <ItemFrame> ();
	private SlotMachineTimer timer = null;
	
	public SlotMachine(int id, String tier, String world, Location lever, Location frame){
		this.id = id;
		this.tier = tier;
		this.world = world;
		leverLocation = lever;
		frameLocation = frame;
	}

    public SlotMachine(Map<String, Object> m) {
        leverLocation = (Location) m.get("leverLocation");
        frameLocation = (Location) m.get("frameLocation");
        world = (String) m.get("world");
        id = (Integer) m.get("id");
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("leverLocation", leverLocation);
        map.put("frameLocation", frameLocation);
        map.put("world", world);
        map.put("tier", tier);

        return map;
    }
	
	public void updateFrames(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTier() {
		return tier;
	}

	public void setTier(String tier) {
		this.tier = tier;
	}

	public String getWorld() {
		return world;
	}

	public void setWorld(String world) {
		this.world = world;
	}

    public Location getFrameLocation() {
        return this.frameLocation;
    }

    public Location getLeverLocation() {
        return this.leverLocation;
    }
    
	public boolean isBeingUsed(){
		if (timer == null){
			return true;
		}
		return timer.isFinished();
	}
	
	public void pull(UUID uuid){
		if (isBeingUsed() == false){
			timer = new SlotMachineTimer(frames);
		}
	}
	
	public void halt(){
		timer.stop();
	}
	
}
