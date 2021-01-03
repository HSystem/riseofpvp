package fi.heikkitoivanen.riseofpvp.entities;

import com.mojang.authlib.GameProfile;
import net.minecraft.server.v1_16_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftServer;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import com.mojang.authlib.properties.Property;

import java.io.IOException;
import java.util.*;
import java.util.logging.Level;

public class NpcManager {

    private static List<EntityPlayer> npcs;
    private static Map<String, Set<String>> npcGreetings;

    public NpcManager() {
        npcs = new ArrayList<EntityPlayer>();
        npcGreetings = new HashMap<>();
        createBattleMerchant();
        createBoosterMerchant();
    }


    public static String getGreetingDialogByNPCName(String npcName) {
        if (npcGreetings.get(npcName)!=null) {
            Set greetings = npcGreetings.get(npcName);
            int rnd = 0 + (int)(Math.random() * ((greetings.size() - 0)));
            return (String) greetings.toArray()[rnd];
        }
        return "Hi!";
    }

    public void createBattleMerchant() {
        // battleshop npc 1 'Battle Merchant',  x=265,y=94,z=-46
        String npcName = "battlemerc";
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld)Bukkit.getWorld("world")).getHandle(); // Change "world" to the world the NPC should be spawned in.
        //GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npcName); // Change "playername" to the name the NPC should have, max 16 characters.

        // Skin #359214302 generated on Jan 3, 2021 6:36:54 PM via MineSkin.org - https://minesk.in/359214302
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npcName);
        gameProfile.getProperties().put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYwOTY5MTgxMzM3MCwKICAicHJvZmlsZUlkIiA6ICIzM2ViZDMyYmIzMzk0YWQ5YWM2NzBjOTZjNTQ5YmE3ZSIsCiAgInByb2ZpbGVOYW1lIiA6ICJEYW5ub0JhbmFubm9YRCIsCiAgInNpZ25hdHVyZVJlcXVpcmVkIiA6IHRydWUsCiAgInRleHR1cmVzIiA6IHsKICAgICJTS0lOIiA6IHsKICAgICAgInVybCIgOiAiaHR0cDovL3RleHR1cmVzLm1pbmVjcmFmdC5uZXQvdGV4dHVyZS83ZTVkYzZjYmI2ZDg0Y2FkMTZmZjVjMzMyNzI5YzU5MzNlMTZjYzM0MmM1MWM5MzcwNWY5ZDdmZjEyNzc5YTU4IgogICAgfQogIH0KfQ==", "fkoDdr24xNTyP2HZsW8N+qIH3FOZ6l7S67rRU85rEQaWlPj0OUOGbt2Jr5JU/IfdR2bDNfbCCfddSDoiyUIVFLcat7qb+62IsO0g5DKuFlJSEDlEfBN5606q4lK5Ym1h7RM5I4nYttvFIzPeUNON5eBhwiV+gqhfTCWq5jKr6pLdxX8B0q7qgQhywXqR1GamNNuu5gNC8oVb6GmNFwIQ3RBAg31mwOb/TlyCfni6ndB34yCie7kh5hg4O0JQb1rmZd81DxXFpHVYZJczUtm/u5edm3mNa5WMeijhC6LclsXigEAV09AjGqIGY9CeMPOrdDP0QE3iDsUrZomuOV2p1YNh23i9acZfty3aYjhtxnKfvt6rXgUysGAnrhbB9WRECSsIIs4JNuoS1xxM7lHjp09ErNk/B6FnLt2taopXW2hX0yf15SIAOHchJvKyevLq272MG08/+Tx18S3btO9uV7A1r6KnJRA0X6xuPg5oKjuBsKnbYVozEhuyG3qX8yffF5AbjpCcU4iraUGkCx92rGwRr2jnlvD3AH3VReF4OwH3K/aM2zaWULzThbjta3km7NUQF4+yzwkqmRXk+ZLYT1KS1AWq6AMTFf1/4zEvepb7uP7kosbfiB3mtsD0ulFURMvrkJj2rk/dphJPa+4MrqLPt4aSHIB4MJ/I3ljdClg="));

        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld)); // This will be the EntityPlayer (NPC) we send with the sendNPCPacket method.
        npc.setLocation(265.5, 95, -45.5, 180, 0);
        npcs.add(npc);
        //System.out.println("created BattleMerchant!");
        Set greetings = new HashSet();
        greetings.add("Hi! I am "+npcName+" would you like to see my shop?");
        greetings.add("Hi! You look new? Would you like to see "+npcName+"'s shop?");
        greetings.add("Well met traveller, please buy some of "+npcName+"'s wares!");
        npcGreetings.put(npcName,greetings);
        addNPCPacket(npc);
    }


    public void createBoosterMerchant() {
        // battleshop npc 2 'Booster Merchant', x=267,y=94,z=-46
        String npcName = "boostmerc";
        MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
        WorldServer nmsWorld = ((CraftWorld)Bukkit.getWorld("world")).getHandle(); // Change "world" to the world the NPC should be spawned in.
        //GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npcName); // Change "playername" to the name the NPC should have, max 16 characters.

        // Skin #1278745703 generated on Jan 3, 2021 6:43:19 PM via MineSkin.org - https://minesk.in/1278745703
        GameProfile gameProfile = new GameProfile(UUID.randomUUID(), npcName);
        gameProfile.getProperties().put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTYwOTY5MjE5ODQ0NSwKICAicHJvZmlsZUlkIiA6ICIzYTNmNzhkZmExZjQ0OTllYjE5NjlmYzlkOTEwZGYwYyIsCiAgInByb2ZpbGVOYW1lIiA6ICJUaGVyb2Ryb2dvIiwKICAic2lnbmF0dXJlUmVxdWlyZWQiIDogdHJ1ZSwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzYzYTY3NjM2OTE5YzRlZWE0NjZiMDdlMTBkMWVkOTc3YWE4ZTM5OGQ5YjExOWI0Nzc1M2Q1Mjk2OTMwMTJjYWYiCiAgICB9CiAgfQp9", "WrMIJN/yY3ikkgiVRyHkplBSlyBeuJMrmTUTc5omcMWmjsaeFfmVHHGuSwBeaesa5laRKukQVDT7IWfrtmcESInjCvdmkYUi0KrvDe7+dWRzmgRNE9ImoVitIwiF+EuWrMgREYnYZeydyffLQl9exIo59Ap6wlFP9sRH13bH7hZ9FbnmFrwIxDq3k+/DPxbRn0mWeaCp+3PB+1fCcPzWg/r9q8Dtv3Z2xFD4VLJC9E5vjhvlFNluUQy52azYX8ieiQolqPWl8By2yFYDYG8RxiciurYZTVIrMKbrkfkVyeTvuIJGHsYFwrbbiKrbOrmCJnFmIKfFi9J6Vk8YgWS3yMADLrTil0SOZC1c+tQEsmO+2tuhmlrLMbAyU/DqbfVtP14Ke2eAs5mQVExlzNAK2ARgJkbXJ0k6uJvqxfaRtDU1YJmN6FfG7OOeuJlpSeAELtlsk+fcXJIxGmbFSpghU5ly9wfUZjluvl5N1/7h9+/C6jMOl31QLQldkMkaRT9aTf9w294rF0NmMbdatl9CLvRWjxehyHlZqhmXxDu9CgAZHRP41CiRRZWphp/PBAMX4eEUeIeFfyZ+BxfG41Icq4ISLCgYT0Iv5TL3pGtEIYKXd1eb/q2L8NM+yIborTvJ+Xo9upvp1l2u10FPG/UWb3trbtA+QcvZw+6Zh4CT0yI="));

        EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile, new PlayerInteractManager(nmsWorld)); // This will be the EntityPlayer (NPC) we send with the sendNPCPacket method.
        npc.setLocation(267.5, 95, -45.5, 180, 0);
        npcs.add(npc);
        //System.out.println("created BoosterMerchant!");
        Set greetings = new HashSet();
        greetings.add("Hi! I am "+npcName+" would you like to see my shop?");
        greetings.add("Hi! You look new? Would you like to see "+npcName+"'s shop?");
        greetings.add("Well met traveller, please buy some of "+npcName+"'s wares!");
        npcGreetings.put(npcName,greetings);
        addNPCPacket(npc);
    }

    public static void addNPCPacket(EntityPlayer npc) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
        }
    }

    public void addJoinPacket(Player player) {
        for (EntityPlayer npc : npcs) {
            PlayerConnection connection = ((CraftPlayer)player).getHandle().playerConnection;
            connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
            connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
            connection.sendPacket(new PacketPlayOutEntityHeadRotation(npc, (byte) (npc.yaw * 256 / 360)));
            //player.sendMessage("created npc "+npc.displayName);
        }
    }

    public static List<EntityPlayer> getNpcs() {
        return npcs;
    }
}
