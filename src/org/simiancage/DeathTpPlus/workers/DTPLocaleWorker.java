package org.simiancage.DeathTpPlus.workers;

/**
 * PluginName: DeathTpPlus
 * Class: DTPLocaleWorker
 * User: DonRedhorse
 * Date: 14.11.11
 * Time: 20:34
 */

import org.bukkit.util.config.Configuration;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class DTPLocaleWorker {
    Configuration localeFile;
    HashMap<String, ArrayList<String>> locales = new HashMap<String, ArrayList<String>>();
    private static DTPLocaleWorker instance;
    private static DTPConfig config;
    private static DTPLogger log;

    public static DTPLocaleWorker getInstance() {
        if (instance == null){
            instance = new DTPLocaleWorker();
            log = DTPLogger.getLogger();
            config = DTPConfig.getInstance();
        }
        return instance;
    }

    /**
     *
     */
    @SuppressWarnings("unchecked")
    private DTPLocaleWorker() {
        File configFile = new File(DTPTombWorker.getInstance().getPlugin()
                .getDataFolder().getPath()
                + File.separator + "locales.yml");
        localeFile = new Configuration(configFile);
        localeFile.load();
        if (!configFile.exists()) {
            ArrayList<String> tmp = new ArrayList<String>();
            tmp.add("Tried to fly");
            tmp.add("Love the ground");
            localeFile.setProperty("locale.fall",
                    (ArrayList<String>) tmp.clone());
            locales.put("fall", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Has drowned");
            tmp.add("Love fishing");
            tmp.add("Drunk the sea");
            localeFile.setProperty("locale.drowning",
                    (ArrayList<String>) tmp.clone());
            locales.put("drowning", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Toasted");
            tmp.add("Burned");
            tmp.add("Fire! Fire!");
            localeFile.setProperty("locale.fire",
                    (ArrayList<String>) tmp.clone());
            locales.put("fire", (ArrayList<String>) tmp.clone());
            localeFile.setProperty("locale.fire_tick",
                    (ArrayList<String>) tmp.clone());
            locales.put("fire_tick", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Swim in lava");
            tmp.add("Now obsidian");
            localeFile.setProperty("locale.lava",
                    (ArrayList<String>) tmp.clone());
            locales.put("lava", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Ksss BOUM");
            tmp.add("CREEEEPPPPERRR");
            tmp.add("Creeper Lover");
            localeFile.setProperty("locale.creeper",
                    (ArrayList<String>) tmp.clone());
            locales.put("creeper", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Skeleton Bow");
            tmp.add("Arrow in Head");
            localeFile.setProperty("locale.skeleton",
                    (ArrayList<String>) tmp.clone());
            locales.put("skeleton", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Spider venom");
            tmp.add("Arachnophobia");
            localeFile.setProperty("locale.spider",
                    (ArrayList<String>) tmp.clone());
            locales.put("spider", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("L4D");
            tmp.add("Braaaiiin");
            tmp.add("Zombie rules");
            localeFile.setProperty("locale.zombie",
                    (ArrayList<String>) tmp.clone());
            locales.put("zombie", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Killed by %k");
            localeFile.setProperty("locale.pvp",
                    (ArrayList<String>) tmp.clone());
            locales.put("pvp", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("BOUM");
            tmp.add("TNT");
            tmp.add("Dynamite");
            localeFile.setProperty("locale.block_explosion",
                    (ArrayList<String>) tmp.clone());
            locales.put("block_explosion", (ArrayList<String>) tmp.clone());
            localeFile.setProperty("locale.entity_explosion",
                    (ArrayList<String>) tmp.clone());
            locales.put("entity_explosion", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Cactus");
            tmp.add("Poked a Cactus");
            tmp.add("Hug a Cactus");
            localeFile.setProperty("locale.contact",
                    (ArrayList<String>) tmp.clone());
            locales.put("contact", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("In Nether");
            tmp.add("Ghast");
            localeFile.setProperty("locale.ghast",
                    (ArrayList<String>) tmp.clone());
            locales.put("ghast", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Splouched");
            tmp.add("Slime won");
            localeFile.setProperty("locale.slime",
                    (ArrayList<String>) tmp.clone());
            locales.put("slime", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Suffocated");
            tmp.add("Sand's breath");
            tmp.add("Sand worm");
            localeFile.setProperty("locale.suffocation",
                    (ArrayList<String>) tmp.clone());
            locales.put("suffocation", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Zombie-Pig");
            localeFile.setProperty("locale.pigzombie",
                    (ArrayList<String>) tmp.clone());
            locales.put("pigzombie", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Became Void");
            tmp.add("End of World");
            localeFile.setProperty("locale.void",
                    (ArrayList<String>) tmp.clone());
            locales.put("void", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Eat by Wolf");
            tmp.add("Wolf meal");
            tmp.add("Wolf lunch");
            localeFile.setProperty("locale.wolf",
                    (ArrayList<String>) tmp.clone());
            locales.put("wolf", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("By Zeus");
            tmp.add("By Thor");
            tmp.add("Lighting");
            localeFile.setProperty("locale.lighting",
                    (ArrayList<String>) tmp.clone());
            locales.put("lighting", (ArrayList<String>) tmp.clone());
            tmp.clear();
            tmp.add("Unknown");
            localeFile.setProperty("locale.unknown",
                    (ArrayList<String>) tmp.clone());
            locales.put("unknown", (ArrayList<String>) tmp.clone());
            tmp.clear();
            localeFile.save();

        } else {
            for (String locale : new String[] { "fall", "drowning", "fire",
                    "fire_tick", "lava", "creeper", "skeleton", "spider",
                    "zombie", "pvp", "block_explosion", "entity_explosion",
                    "contact", "ghast", "slime", "suffocation", "pigzombie",
                    "void", "wolf", "unknown" })
                locales.put(
                        locale,
                        (ArrayList<String>) localeFile.getStringList("locale."
                                + locale, new ArrayList<String>()));

        }

    }

    public String getPvpLocale(String killer) {
        String msg = getLocale("pvp");
        return msg.replace("%k", killer);
    }

    /**
     * Get the locale
     *
     * @param death
     * @return
     */
    public String getLocale(String death) {
        Random rand = new Random();
        if (locales.containsKey(death)) {
            ArrayList<String> deaths = locales.get(death);
            return deaths.get(rand.nextInt(deaths.size()));
        } else if (locales.containsKey("unknown")) {
            ArrayList<String> unknowns = locales.get("unknown");
            return unknowns.get(rand.nextInt(unknowns.size()));
        } else
            return "";
    }
}


