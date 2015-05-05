package net.mcviral.dev.plugins.casino.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;

import java.util.HashMap;
import java.util.Map;

public class SerializableLocation implements ConfigurationSerializable {

    private final Location location;

    public SerializableLocation(Location l) {
        this.location = l;
    }

    public SerializableLocation(Map<String, Object> m) {
        location =  new Location(Bukkit.getWorld((String)m.get("world")), (Double)m.get("x"), (Double)m.get("y"), (Double)m.get("z"));
    }

    public Location getLocation() {
        return this.location;
    }

    public Map<String, Object> serialize() {
        Map<String, Object> map = new HashMap<String, Object>();

        return map;
    }
}
