package com.pipypipys.firstmod.network;

import com.pipypipys.firstmod.network.messages.MessageCapabilities;
import com.pipypipys.firstmod.network.messages.MessageExplode;
import com.pipypipys.firstmod.network.messages.MessageInvisibilityEffect;
import com.pipypipys.firstmod.network.messages.MessageSpeedEffect;
import com.pipypipys.firstmod.util.Reference;

import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class NetworkHandler {

	private static SimpleNetworkWrapper INSTANCE;
	
	public static void init() {
		INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
		
		INSTANCE.registerMessage(MessageExplode.class, MessageExplode.class, 0, Side.SERVER);
		INSTANCE.registerMessage(MessageInvisibilityEffect.class, MessageInvisibilityEffect.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageSpeedEffect.class, MessageSpeedEffect.class, 2, Side.SERVER);
		INSTANCE.registerMessage(MessageCapabilities.class, MessageCapabilities.class, 3, Side.SERVER);
		
	}
	
	
	public static void sendToServer(IMessage message) {
		INSTANCE.sendToServer(message);
	}
	
}
