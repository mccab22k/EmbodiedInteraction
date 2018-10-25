package util;

import processing.core.PVector;

public abstract class Selectable {
	
	protected boolean isSelected;
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void deselect() {
		isSelected = false;
	}
	
	
	/**
	 * select checks to see if the object is selected by a mouse down event at 
	 * mouseX, mouseY and selects object if it needs to be selected.
	 * 
	 * @param mouseX
	 * @param mouseY
	 * @return true if selected, else false.
	 */
	abstract public boolean select(PVector mouseLoc);
	
	

}
