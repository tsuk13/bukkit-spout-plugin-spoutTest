package edu.unca.twreese.SpoutItemTutorial;

import java.util.logging.Level;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.getspout.spoutapi.SpoutManager;
import org.getspout.spoutapi.inventory.SpoutItemStack;
import org.getspout.spoutapi.inventory.SpoutShapedRecipe;
import org.getspout.spoutapi.material.MaterialData;

/*
 * This is the main class of the sample plug-in
 */
public class SpoutItemTutorial extends JavaPlugin {
	public TestItem Disk;
	public SpoutItemTutorialCommandExecutor executor;

	/*
	 * This is called when your plug-in is enabled
	 */
	@Override
	public void onEnable() {

		// from Spout tutorial
		SpoutManager.getFileManager().addToPreLoginCache(this,
				"http://i.imgur.com/bc3rh.png");
		Disk = new TestItem(this, "Disk",
				"http://i.imgur.com/bc3rh.png");
		addDiskRecipe();

		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Enabled!");

		// save the configuration file
		saveDefaultConfig();

		// Create the SampleListener
		new SpoutItemTutorialListener(this);

		// set the command executor for sample
		executor = new SpoutItemTutorialCommandExecutor(this);
		this.getCommand("message").setExecutor(executor);
		this.getCommand("changeMe").setExecutor(executor);
		this.getCommand("changeMeBack").setExecutor(executor);
	}

	/*
	 * This is called when your plug-in shuts down
	 */
	@Override
	public void onDisable() {
		PluginDescriptionFile pdfFile = this.getDescription();
		getLogger().log(Level.INFO, "[Spout Item Test Plugin] Disabled");
	}

	public void addDiskRecipe() {
		SpoutItemStack item = new SpoutItemStack(Disk, 1);
		SpoutShapedRecipe recipe = new SpoutShapedRecipe(item);
		recipe.shape("   ", "XXX", "   ");// top : middle : bottom
		recipe.setIngredient('X', MaterialData.blueWool);
		SpoutManager.getMaterialManager().registerSpoutRecipe(recipe);
	}

}
