package me.exz.wailanbt.commands;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ChatComponentTranslation;

public class CommandName extends CommandBase {
    @Override
    public String getCommandName() {
        return "wnn";
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender sender) {
        return true;
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "/wnn";
    }

    @Override
    public void processCommand(ICommandSender sender, String[] array) {
        EntityPlayer player = (EntityPlayer) sender;
        ItemStack holdItem = player.getHeldItem();
        if (holdItem == null) {
            player.addChatComponentMessage(new ChatComponentTranslation("wailanbt.info.notholding"));
            return;
        }
        player.addChatComponentMessage(new ChatComponentText(Item.itemRegistry.getNameForObject(holdItem.getItem())));
    }
}
