/*------------------------------------------------------------------------------
 Copyright (c) CovertJaguar, 2011-2017
 http://railcraft.info

 This code is the property of CovertJaguar
 and may only be used with explicit written
 permission unless otherwise specified on the
 license page at http://railcraft.info/wiki/info:license.
 -----------------------------------------------------------------------------*/
package mods.railcraft.common.gui.widgets;

import mods.railcraft.common.gui.tooltips.ToolTip;

/**
 * @author CovertJaguar <http://www.railcraft.info>
 */
public interface IIndicatorController {

    ToolTip getToolTip();

    double getMeasurement();

    double getServerValue();

    void setClientValue(double value);
}
