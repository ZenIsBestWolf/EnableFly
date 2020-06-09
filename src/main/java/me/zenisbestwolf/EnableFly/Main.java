package me.zenisbestwolf.EnableFly;

import org.bukkit.plugin.java.JavaPlugin;

import me.zenisbestwolf.EnableFly.commands.FlyCommand;

public class Main extends JavaPlugin {
	public void onEnable() {
		new FlyCommand(this);
	}
}
