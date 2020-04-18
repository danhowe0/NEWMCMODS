package net.mcreator.firstmodyay.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.CommandEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.firstmodyay.FIRSTMODYAYElements;

@FIRSTMODYAYElements.ModElement.Tag
public class GmcCommandExecutedProcedure extends FIRSTMODYAYElements.ModElement {
	public GmcCommandExecutedProcedure(FIRSTMODYAYElements instance) {
		super(instance, 8);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure GmcCommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).setGameType(GameType.CREATIVE);
	}

	@SubscribeEvent
	public void onCommand(CommandEvent event) {
		Entity entity = event.getParseResults().getContext().getSource().getEntity();
		if (entity != null) {
			int i = (int) entity.getPosition().getX();
			int j = (int) entity.getPosition().getY();
			int k = (int) entity.getPosition().getZ();
			String command = event.getParseResults().getReader().getString();
			java.util.HashMap<String, Object> dependencies = new java.util.HashMap<>();
			dependencies.put("x", i);
			dependencies.put("y", j);
			dependencies.put("z", k);
			dependencies.put("world", entity.world);
			dependencies.put("entity", entity);
			dependencies.put("command", command);
			dependencies.put("event", event);
			this.executeProcedure(dependencies);
		}
	}
}
