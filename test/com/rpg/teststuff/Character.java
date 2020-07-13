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

import java.util.ArrayList;

/**
 *
 * @author Dard
 */
public class Character {
    public String firstName;
    public String lastName;
    public Title title;
    public Sex sex;
    public Personality personality;
    public Race race;
    public Faction faction;
    public CharacterClass characterClass;
    public int age;
    public int weight;
    
    public float attractiveness;
    public float heat;    
    public float reputation;
    public float alignment;
    
    public int experience;
    public int level;
    
    public int strength;
    public int intelligence;
    public int charisma;
    public int constitution;
    public int wisdom;
    public int dexterity;
    
    public int maxHealth;
    public int health;
    public int maxMana;
    public int mana;
    public int maxStamina;
    public int stamina;
    
    public ArrayList<Perk> perks;
    public ArrayList<Disease> diseases;
    public ArrayList<Effect> effects;
    public ArrayList<Character> friends;
    public ArrayList<Character> family;
    public ArrayList<Character> enemies;
    public ArrayList<Item> inventory;
    
    public Location homeCity;
    public Location home;
    public Location work;
    public Location destination;
    public ArrayList<Location> favorites;
    
    public boolean isEssential;
    public boolean isDead;

    public Character(CharacterBuilder cb){
        this.firstName = cb.firstName;
        this.lastName = cb.lastName;
        this.title = cb.title;
        this.sex = cb.sex;
        this.personality = cb.personality;
        this.race = cb.race;
        this.faction = cb.faction;
        this.characterClass = cb.characterClass;
        this.age = age;
        this.weight = weight;
        this.attractiveness = attractiveness;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.maxMana = maxMana;
        this.mana = maxMana;
        this.reputation = reputation;
        this.alignment = alignment;
        this.experience = experience;
        this.strength = strength;
        this.intelligence = intelligence;
        this.charisma = charisma;
        this.constitution = constitution;
        this.wisdom = wisdom;
        this.dexterity = dexterity;
        this.isEssential = isEssential;
        this.isDead = isDead;
    }
    
    public static class CharacterBuilder {
        private String firstName;
        private String lastName;
        private Title title;
        private Sex sex;
        private Personality personality;
        private Race race;
        private Faction faction;
        private CharacterClass characterClass;
        
        public CharacterBuilder(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
        }
         
        public CharacterBuilder title(Title title){
            this.title = title;
            return this;
        }
         
        public CharacterBuilder sex(Sex sex){
            this.sex = sex;
            return this;
        }
        
        public CharacterBuilder personality(Personality personality){
            this.personality = personality;
            return this;
        }
        
        public CharacterBuilder race(Race race){
            this.race = race;
            return this;
        }
        
        public CharacterBuilder faction(Faction faction){
            this.faction = faction;
            return this;
        }
                
        public CharacterBuilder characterClass(CharacterClass characterClass){
            this.characterClass = characterClass;
            return this;
        }
        
        
        public void validateCharacter(Character character){

        }
         
        public Character build(){
           Character character = new Character(this);
           validateCharacter(character);
           return character;
        }
    }
}