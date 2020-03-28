package me.zenisbestwolf.enablefly.commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import me.zenisbestwolf.enablefly.Main;
import org.bukkit.Bukkit;

public class FlyCommand implements CommandExecutor {
	private Main plugin;
	
	public FlyCommand(Main plugin) {
		this.plugin = plugin;
		plugin.getCommand("fly").setExecutor(this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender.hasPermission("enablefly.fly")) {
			Player target;
			boolean same = false;
			String action = "";
			if (args.length == 0 && sender instanceof Player) {
				target = (Player) sender;
				same = true;
			}
			else if (args.length == 0 && !(sender instanceof Player)) {
				sender.sendMessage("Error: please specify a player.");
				return true;
			}
			else {
				target = Bukkit.getPlayer(args[0]);
				if (target!=null && target.getDisplayName() == sender.getName())
					same = true;
			}
			if (target == null) {
				sender.sendMessage("Error: Cannot find that player!");
				return true;
			}
			if (target.getAllowFlight()) {
				target.setAllowFlight(false);
				target.setFlying(false);
				action = "disabled";
			} else if (!(target.getAllowFlight())) {
				target.setAllowFlight(true);
				action = "enabled";
			}
			if (!(same))
				sender.sendMessage("Flight was " + action + " for " + target.getDisplayName() + ".");
			target.sendMessage("Flight is now " + action + ".");
			return true;
		} else
			sender.sendMessage("You do not have permission to execute this command.");
		return false;
	}
}
