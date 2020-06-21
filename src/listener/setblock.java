package listener;

import cn.nukkit.Player;
import cn.nukkit.command.CommandSender;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerInteractEvent;
import cn.nukkit.item.Item;
import cn.nukkit.utils.Config;
import main.ItemCMDmain;

public class setblock implements Listener {
	private ItemCMDmain plugin;
	
	@EventHandler
	public void onplayerplace(PlayerInteractEvent e) {
		Player player = e.getPlayer();
		Item item = e.getItem();
		
		Config config = this.plugin.getConfig();
		String Command = config.getString(""+item.getId()).replace("/", "");
		if(Command.equals(null)) {
			player.sendMessage("O nein!");
		}
		try {
			if(player.hasPermission("ItemCMD."+item.getId())) {
				this.plugin.getServer().dispatchCommand((CommandSender)player, Command);
			}
		} catch (Exception e2) {
			player.sendMessage("Ein Fehler!");
		}
	}

}
