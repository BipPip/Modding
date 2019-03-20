package com.pipypipys.firstmod.util;

import java.util.ArrayList;

import org.lwjgl.input.Keyboard;

//import net.java.games.input.Keyboard;

import net.minecraft.client.settings.KeyBinding;

import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@EventBusSubscriber (Side.CLIENT)
public class KeyBindings {



  // Declare two KeyBindings, ping and pong

  public static KeyBinding ability1;

  public static KeyBinding ability2;

  ArrayList<KeyBinding> KeyBindings;



  public KeyBindings() {
	  ArrayList<KeyBinding> KeyBindings = new ArrayList<KeyBinding>();
	  KeyBindings.add(ability1);
      KeyBindings.add(ability2);
      
  }
  
  
  public static void init() {

      // Define the "ping" binding, with (unlocalized) name "key.ping" and

      // the category with (unlocalized) name "key.categories.mymod" and

      // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)

	  ability1 = new KeyBinding("Ability 1", Keyboard.KEY_NUMPAD0, "FirstMod");

      // Define the "pong" binding, with (unlocalized) name "key.pong" and

      // the category with (unlocalized) name "key.categories.mymod" and

      // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)

	  ability2 = new KeyBinding("Ability 2", Keyboard.KEY_NUMPAD1, "FirstMod");



      // Register both KeyBindings to the ClientRegistry

      ClientRegistry.registerKeyBinding(ability1);

      ClientRegistry.registerKeyBinding(ability2);

     
      
      
  }

public ArrayList<KeyBinding> getKeyBindings() {
	return KeyBindings;
}










}