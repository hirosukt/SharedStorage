package works.hirosuke.sharedstorage.command.commands

import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import works.hirosuke.sharedstorage.command.Command

object OpenStorage: Command("openstorage") {
    override fun onCommand(sender: CommandSender, label: String, args: Array<out String>) {
        var err = if (sender !is Player) {
            "Please do command in world."
        } else if (!sender.hasPermission("sharedstorage.command.openstorage")) {
            "You don't have permission."
        } else {
            null
        }

        if (err != null) {
            sender.sendMessage("§c$err")
        }


    }

    override fun onTabComplete(sender: CommandSender, label: String, args: Array<out String>): List<String>? {
        TODO("Not yet implemented")
    }
}