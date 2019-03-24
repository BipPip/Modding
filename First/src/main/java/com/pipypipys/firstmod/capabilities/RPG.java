package com.pipypipys.firstmod.capabilities;

/**
 * Default implementation of IMana
 */
public class RPG implements IRPG
{
	
	// private float mana = 250.0F;
	private String playerClass = null;
	
	@Override
	public String getPlayerClass() {
		
		return this.playerClass;
	}
  
	
	
	@Override
	public void setPlayerClass(String playerClass) {
		
		this.playerClass = playerClass;
	}
  
	
	
	
	
	/*

    @Override
    public void consume(float points)
    {
        this.mana -= points;

        if (this.mana < 0.0F) this.mana = 0.0F;
    }

    @Override
    public void fill(float points)
    {
        this.mana += points;
    }

    @Override
    public void set(float points)
    {
        this.mana = points;
    }

    @Override
    public float getMana()
    {
        return this.mana;
    }*/
	
}