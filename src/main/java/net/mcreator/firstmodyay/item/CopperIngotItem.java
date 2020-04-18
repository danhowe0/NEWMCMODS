
package net.mcreator.firstmodyay.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.block.BlockState;

import net.mcreator.firstmodyay.itemgroup.MyModItemGroup;
import net.mcreator.firstmodyay.FIRSTMODYAYElements;

@FIRSTMODYAYElements.ModElement.Tag
public class CopperIngotItem extends FIRSTMODYAYElements.ModElement {
	@ObjectHolder("firstmodyay:copperingot")
	public static final Item block = null;
	public CopperIngotItem(FIRSTMODYAYElements instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			super(new Item.Properties().group(MyModItemGroup.tab).maxStackSize(64));
			setRegistryName("copperingot");
		}

		@Override
		public int getItemEnchantability() {
			return 0;
		}

		@Override
		public int getUseDuration(ItemStack itemstack) {
			return 0;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, BlockState par2Block) {
			return 1F;
		}
	}
}
