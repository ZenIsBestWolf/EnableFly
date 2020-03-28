package me.zenisbestwolf.enablefly;

import org.bukkit.plugin.java.JavaPlugin;
import me.zenisbestwolf.enablefly.commands.*;

public class Main extends JavaPlugin {
	public void onEnable() {
		new FlyCommand(this);
	}
}
