package main;

import Commands.setitemcmd;
import cn.nukkit.command.SimpleCommandMap;
import cn.nukkit.plugin.PluginBase;
import listener.setblock;

public class ItemCMDmain extends PluginBase {
	@Override
	public void onEnable() {
		this.saveDefaultConfig();
		this.reloadConfig();
		this.getLogger().info("Das Plugin ItemCMD für Space Explorer wurde aktivier.");
		registerCommends();
		registerListener();
		super.onEnable();
	}
	
	@Override
	public void onDisable() {
		this.saveConfig();
		this.getLogger().info("Das Plugin ItemCMD für Space Explorer wurde deaktivier.");
		super.onDisable();
	}
	
	public void registerListener() {
		cn.nukkit.plugin.PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new setblock(), this);
	}
	
    private void registerCommends() {
        SimpleCommandMap commandMap = this.getServer().getCommandMap();
        commandMap.register("help", new setitemcmd("setcmd", "Setze den Command eines Blocks.", "/setcmd <Command>", this));
    }
}
