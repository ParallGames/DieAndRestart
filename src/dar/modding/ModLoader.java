package dar.modding;

import java.util.HashMap;

import dar.darMod.DieAndRestart;

public class ModLoader {
	private static final HashMap<String, Mod> mods = new HashMap<>();

	private static void loadMod(Mod mod) {
		if (mods.containsKey(mod.getModID())) {
			throw new RuntimeException(
					"This mod " + mod.getModName() + " of another mod with the same id is already loaded.");
		}

		mod.load();

		mods.put(mod.getModID(), mod);
	}

	public static void loadMods() {
		loadMod(new DieAndRestart());
	}
}
