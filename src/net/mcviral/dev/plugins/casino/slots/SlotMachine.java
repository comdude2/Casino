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
        Map map = new HashMap<String, Object>();
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

    /* incase you want to revert
	public int getLeverX() {
		return leverX;
	}

	public void setLeverX(int leverX) {
		this.leverX = leverX;
	}

	public int getLeverY() {
		return leverY;
	}

	public void setLeverY(int leverY) {
		this.leverY = leverY;
	}

	public int getLeverZ() {
		return leverZ;
	}

	public void setLeverZ(int leverZ) {
		this.leverZ = leverZ;
	}

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

	public int getFrameZ() {
		return frameZ;
	}

	public void setFrameZ(int frameZ) {
		this.frameZ = frameZ;
	}
	*/
	
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
