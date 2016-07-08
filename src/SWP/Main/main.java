package SWP.Main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener{
	boolean WakeUp;
	public void onEnable(){
		this.saveDefaultConfig();
		int Timer = this.getConfig().getInt("Timer");
		this.getServer().getPluginManager().registerEvents(this, this);
		WakeUp=true;
		Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
			@Override
			public void run() {
				if (Bukkit.getOnlinePlayers().isEmpty() && !WakeUp){
				getServer().shutdown();
				}
			}
		},10,Timer);
	}
	
	@EventHandler
	public void onLeave(PlayerQuitEvent e){
		if (Bukkit.getOnlinePlayers().size()-1==0){
			WakeUp=false;
		}
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e){
		WakeUp=true;
	}
	
	public void onDisable(){
	}
}
