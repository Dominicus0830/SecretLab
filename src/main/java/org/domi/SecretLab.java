package org.domi;


import org.CatAndDomi.CatFish;
import org.CatAndDomi.components.CatFishBuilder;
import org.CatAndDomi.components.ComponentType;
import org.CatAndDomi.components.command.ArgsTypes;
import org.CatAndDomi.components.command.CommandComponent;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.domi.commands.Command;

public class SecretLab extends JavaPlugin{
    private static SecretLab plugin;
    public CatFish cf;
    public CommandComponent component;
    private static Command command = new Command();

    public static SecretLab getInstance() {
        return plugin;
    }

    public void setUpCatFish() {
        if(Bukkit.getPluginManager().isPluginEnabled("CatFish")) {
            cf = (CatFish) Bukkit.getPluginManager().getPlugin("CatFish");
        }
    }

    @Override
    public void onEnable() {
        plugin = this;
        setUpCatFish();
        new CatFishBuilder(this).addComponents(ComponentType.COMMAND).build();
        component = (CommandComponent) cf.getComponent(this, ComponentType.COMMAND);
        try {
            component.addCommand(command.getClass().getMethod("bossBar", CommandSender.class, String.class) ,new ArgsTypes[]{ArgsTypes.STRING}, "/게임시작", "게임시작");
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        component.load();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

}