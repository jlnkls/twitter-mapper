package ui;


import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import util.Util;

import java.awt.*;
import java.awt.image.BufferedImage;

public class MapMarkerCircleIcon extends MapMarkerCircle {

    public static final double defaultMarkerSize = 20.0;
    private final String tweetImageUrl;
    private final String tweetText;

    public MapMarkerCircleIcon(Layer layer, Coordinate coord, Color color, String tweetImageUrl, String tweetText) {
        super(layer, null, coord, defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(color);
        setBackColor(color);
        this.tweetImageUrl = tweetImageUrl;
        this.tweetText = tweetText;
    }

    @Override
    public void paint(Graphics g, Point position, int radius) {
        super.paint(g, position, radius);
        g.drawImage(this.getTweetImage(), position.x - (radius/2), position.y - (radius/2), radius, radius,null);
    }

    public String getTweetImageUrl() { return this.tweetImageUrl; }

    public BufferedImage getTweetImage() { return Util.imageFromURL(this.tweetImageUrl); }

    public String getTweetText() { return this.tweetText; }

}
