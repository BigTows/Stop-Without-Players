package SWP.Main;

import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable(){
		saveDefaultConfig();
		
		getServer().getScheduler().runTaskTimer(this, new Runnable() {
			@Override
			public void run() {
				if(getServer().getOnlinePlayers().size() == 0){
					getServer().shutdown();
				}
			}
		}, 10, getConfig().getInt("Timer"));
	}
}
