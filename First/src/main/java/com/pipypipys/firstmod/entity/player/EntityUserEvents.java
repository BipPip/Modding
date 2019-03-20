package com.pipypipys.firstmod.entity.player;

import javafx.scene.input.KeyCode;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;

public class EntityUserEvents {

	@SubscribeEvent
	public static void onKeyInput(InputEvent.KeyInputEvent event) {
		
		 //if ((KeyCode.NUMPAD0)) {
		//	 
		 //}
		
		System.out.println("                           f");
		System.out.println(event);
		
	}
	
	
	
}
