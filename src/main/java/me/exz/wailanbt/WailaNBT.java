package me.exz.wailanbt;

import codechicken.nei.guihook.GuiContainerManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import me.exz.wailanbt.commands.CommandEntity;
import me.exz.wailanbt.commands.CommandName;
import me.exz.wailanbt.commands.CommandReload;
import me.exz.wailanbt.configuration.ConfigEvent;
import me.exz.wailanbt.configuration.config;
import me.exz.wailanbt.handler.TooltipHandler;
import me.exz.wailanbt.reference.Reference;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:Waila;required-after:NotEnoughItems")
public class WailaNBT {

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        config.modConfigurationDirectory = event.getModConfigurationDirectory();
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void init(@SuppressWarnings("UnusedParameters") FMLInitializationEvent event) {
        FMLInterModComms.sendMessage("Waila", "register", "me.exz.wailanbt.handler.BlockHandler.callbackRegister");
        FMLInterModComms.sendMessage("Waila", "register", "me.exz.wailanbt.handler.EntityHandler.callbackRegister");
        ClientCommandHandler.instance.registerCommand(new CommandReload());
        ClientCommandHandler.instance.registerCommand(new CommandName());
        ClientCommandHandler.instance.registerCommand(new CommandEntity());
        MinecraftForge.EVENT_BUS.register(new ConfigEvent());
    }
    @SuppressWarnings("UnusedDeclaration")
    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event){
        GuiContainerManager.addTooltipHandler(new TooltipHandler());

    }
}
