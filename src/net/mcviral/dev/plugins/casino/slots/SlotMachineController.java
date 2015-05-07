package net.mcviral.dev.plugins.casino.slots;

import net.mcviral.dev.plugins.casino.main.Casino;
import net.mcviral.dev.plugins.casino.util.FileManager;
import org.bukkit.Location;

import java.io.File;
import java.util.HashSet;

public class SlotMachineController {

    private final HashSet<SlotMachine> machines = new HashSet<SlotMachine>();
    private final Casino main;
    private final String path = "/Casino/Slots/";

    public SlotMachineController(Casino casino) {
        this.main = casino;
    }

    public HashSet<SlotMachine> getMachines() {
        return this.machines;
    }

    public void mkSlotMachine(int id, String tier, String world, Location lever, Location frame) {
        SlotMachine sm  = new SlotMachine(id, tier, world, lever, frame);
        machines.add(sm);
    }

    //should be called on object creation
    public void loadFromDisk() {
        File slotsDir = new File(this.main.getDataFolder(), path);
        for(File f : slotsDir.listFiles()) {
            FileManager fm = new FileManager(this.main, path, f.getName() + ".yml");
            SlotMachine sm = (SlotMachine) fm.getYAML().get("object");
            machines.add(sm);
        }
    }

    //Save individually?
    public void saveToDisk() {
        File f = new File(this.main.getDataFolder(), path);
        for(SlotMachine sm : this.machines) {
            boolean found = false;
            for(String s : f.list()) {
                if(s.equals(Integer.toString(sm.getId()))) found = true;
            }
            if(!found) {
                FileManager fm = new FileManager(this.main, path, sm.getId() + ".yml");
                fm.getYAML().set("object", sm);
            }
        }
    }
}
