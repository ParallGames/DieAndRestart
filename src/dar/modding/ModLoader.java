package dar.modding;

import java.util.HashMap;

import dar.darMod.DieAndRestart;

public class ModLoader {
	private static final HashMap<String, Mod> mods = new HashMap<>();

	private static void loadMod(Mod mod) {
		if (mods.containsKey(mod.getModID())) {
			throw new RuntimeException(
					"The mod " + mod.getModName() + " or another mod with the same id has already been loaded.");
		}

		mod.load();

		mods.put(mod.getModID(), mod);
	}

	public static void loadMods() {
		loadMod(new DieAndRestart());
	}
}
