package Commands;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.utils.Config;
import main.ItemCMDmain;

public class setitemcmd extends Command {
	
    private ItemCMDmain plugin;

	public setitemcmd(String name, String description, String usageMessage, ItemCMDmain plugin) {
        super(name, description, usageMessage);
        this.plugin = plugin;
        this.setPermission("command.setLocation");
    }

	@Override
	public boolean execute(CommandSender sender, String a, String[] args) {
		Config config = this.plugin.getConfig();
		if(sender.isPlayer()) {
			Player player = (Player) sender;
			
			if(player.hasPermission("ItemCMD.addCMD")) {
				if(player.getInventory().getItemInHand().getId()==0) {
					player.sendMessage("Du musst ein Item in der Hand haben für diesen Befehl.");
					return false;
				}
				if(args[0].equals(null)) {
					player.sendMessage("Du musst einen Command angeben!");
					return false;
				}
				config.set(""+player.getInventory().getItemInHand().getId(), args[0]);
				player.sendMessage("Du hast den Befehl "+args[0]+" für den Block "+player.getInventory().getItemInHand().getBlock().getName()+" gesetzt.");
			} else {
				player.sendMessage("Du hast keine Berechtigung für diesen Befehl.");
			}
		} else {
			sender.sendMessage("Du musst für diesen Command Spieler sein.");
		}
		return false;
	}

}
