package org.simiancage.DeathTpPlus.listeners;

//java imports

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.simiancage.DeathTpPlus.DeathTpPlus;
import org.simiancage.DeathTpPlus.events.onEntityDeathDTP;
import org.simiancage.DeathTpPlus.helpers.ConfigDTP;
import org.simiancage.DeathTpPlus.helpers.LoggerDTP;
import org.simiancage.DeathTpPlus.helpers.TombStoneHelperDTP;
import org.simiancage.DeathTpPlus.models.TombStoneBlockDTP;

import java.util.ArrayList;

//bukkit imports

public class EntityListenerDTP implements Listener {
	private DeathTpPlus plugin;
	private ArrayList<String> lastDamageType = new ArrayList<String>();
	private String beforedamage = "";
	private PlayerDeathEvent playerDeathEvent = null;

	private ConfigDTP config;
	private LoggerDTP log;
	private onEntityDeathDTP oedea;
	private EntityListenerDTP instance;
	private TombStoneHelperDTP tombStoneHelper;

	public EntityListenerDTP(DeathTpPlus plugin) {
		this.plugin = plugin;
		log = LoggerDTP.getLogger();
		config = ConfigDTP.getInstance();
		tombStoneHelper = TombStoneHelperDTP.getInstance();
		log.debug("EntityListener active");
		instance = this;
	}

	@EventHandler(priority = EventPriority.HIGH)
	public void onEntityDeath(EntityDeathEvent event) {

		if (event.getEntity() instanceof Player) {

			if (plugin.isMobArenaEnabled()) {
				if (plugin.getMaHandler().inRegion(event.getEntity().getLocation())) {
					log.debug("Player in MobArena Region");
					return;
				}


			}
			if (config.isEnableDeathtp()) {
				oedea = new onEntityDeathDTP(plugin);
				oedea.oEDeaDeathTp(plugin, instance, event);
			}

			if (config.isShowDeathNotify() || config.isShowStreaks() || config.isAllowDeathLog() || config.isEnableTombStone() || config.isEnableTomb()) {
				oedea = new onEntityDeathDTP(plugin);
				oedea.oEDeaGeneralDeath(plugin, instance, event);
			}
		}

	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {
		if (event.isCancelled()) {
			return;
		}
		if (!config.isCreeperProtection()) {
			return;
		}
		for (Block block : event.blockList()) {
			TombStoneBlockDTP tStoneBlockDTP = tombStoneHelper.getTombStoneBlockList(block.getLocation());
			if (tStoneBlockDTP != null) {
				event.setCancelled(true);
			}
		}
	}

}
