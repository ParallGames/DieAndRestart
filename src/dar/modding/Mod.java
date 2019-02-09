package dar.modding;

public interface Mod {
	/**
	 * Give the name of the mod by exemple "Die and restart"
	 * 
	 * @return the mod name
	 */
	public String getModName();

	/**
	 * Give a string representing the mod by exemple "dar" for Die and restart
	 * 
	 * @return the mod id
	 */
	public String getModID();

	/**
	 * Function called during mod loading so the mod can register what it needs
	 */
	public void load();
}
