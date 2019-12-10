package com.pipypipys.firstmod.client.gui;

import com.pipypipys.firstmod.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;

public class GuiMana extends Gui {
	String text;

	
	public GuiMana(Minecraft mc) {
		
	
		text = "Mana: " + Reference.mana;
		
		ScaledResolution scaled = new ScaledResolution(mc);
		int width = scaled.getScaledWidth();
		int height = scaled.getScaledHeight();
		
		drawString(mc.fontRenderer, text, 5, 5, Integer.parseInt("FFAA00", 16));
		
	}
	
}
