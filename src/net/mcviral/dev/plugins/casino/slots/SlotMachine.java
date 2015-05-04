package net.mcviral.dev.plugins.casino.slots;

public class SlotMachine {
	
	private int id = -1;
	private String tier = null;
	private String world = null;
	private int leverX = -1;
	private int leverY = -1;
	private int leverZ = -1;
	private int frameX = -1;
	private int frameY = -1;
	private int frameZ = -1;
	private SlotMachineTimer timer = null;
	
	public SlotMachine(int id, String tier, String world, int leverX, int leverY, int leverZ, int frameX, int frameY, int frameZ){
		this.id = id;
		this.tier = tier;
		this.world = world;
		this.leverX = leverX;
		this.leverY = leverY;
		this.leverZ = leverZ;
		
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
	
	
	
}
