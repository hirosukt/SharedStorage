package works.hirosuke.sharedstorage

import org.bukkit.Bukkit
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryMoveItemEvent
import org.bukkit.plugin.java.JavaPlugin

class SharedStorage : JavaPlugin(), Listener {

    companion object {
        lateinit var plugin: JavaPlugin
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
        saveResource("config.yml", false)
        InfinityInventory.infinityStorage = Bukkit.createInventory(null, 54, "Infinity Storage")
        logger.info("plugin has loaded.")
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    fun on(e: InventoryMoveItemEvent) {
        if (e.source != InfinityInventory.infinityStorage) return

        server.onlinePlayers.forEach {
            it.updateInventory()
        }
    }
}