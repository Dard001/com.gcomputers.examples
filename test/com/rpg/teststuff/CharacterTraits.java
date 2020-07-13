/*
 * Copyright (C) 2020 Dard
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.rpg.teststuff;

/**
 *
 * @author Dard
 */
interface CharacterTraits {    
    public void setFirstName(String name);
    public void setLastName(String name);
    public void setTitle(Title title);
    public void setSex(Sex sex);
    public void setPersonality(Personality personality);
    public void setRace(Race race);
    public void setFaction(Faction faction);
    public void setCharacterClass(CharacterClass characterClass);
    public void setAge(int age);
    public void setWeight(int weight);
    public void setAttractiveness(Float attractiveness);
    
    public void setHeat(Float heat);
    public void addHeat(Float heat);
    public void setWetness(Float wetness);
    public void addWetness(Float wetness);
    public void setReputation(Float reputation);
    public void addReputation(Float reputation);
    public void setAlignment(Float alignment);
    public void addAlignment(Float alignment);
    
    public void setExperience(int exp);
    public void addExperience(int exp);
    public void setLevel(int level);
    public void addLevel(int level);
    
    public void setStrength(int strength);
    public void addStrength(int strength);
    public void setIntelligence(int intelligence);
    public void addIntelligence(int intelligence);
    public void setCharisma(int charisma);
    public void addCharisma(int charisma);
    public void setConstitution(int constitution);
    public void addConstitution(int constitution);
    public void setWisdom(int wisdom);
    public void addWisdom(int wisdom);
    public void setDexterity(int dexterity);
    public void addDexterity(int dexterity);
    
    public void setMaxHealth(int maxHealth);
    public void setHealth(int health);
    public void addHealth(int health);
    public void setMaxMana(int maxMana);
    public void setMana(int mana);
    public void addMana(int mana);
    public void setMaxStamina(int maxStamina);
    public void setStamina(int stamina);
    public void addStamina(int stamina);
    
    public void addPerk(Perk perk);
    public void removePerk(Perk perk);
    public void addDisease(Disease disease);
    public void removeDisease(Disease disease);
    public void addEffect(Effect effect);
    public void removeEffect(Effect effect);
    
    public void setHome(Location location);
    public void setWork(Location location);
    public void setDestination(Location location);
    public void setFavorites(Location[] locations);
    
    public void setIsEssential(boolean isEssential);
    public void setIsDead(boolean isDead);
}
