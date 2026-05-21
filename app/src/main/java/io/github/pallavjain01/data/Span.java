package io.github.pallavjain01.data;

import java.awt.Color;
import java.awt.image.BufferedImage;

public record Span(
		int x1, int y1, int x2, int y2
) {
	public void applyToImage(BufferedImage image, Color color) {
		int width = image.getWidth();
		int height = image.getHeight();

		int startX = Math.max(0, Math.min(x1, x2));
		int startY = Math.max(0, Math.min(y1, y2));

		int endX = Math.min(width - 1, Math.max(x1, x2));
		int endY = Math.min(height - 1, Math.max(y1, y2));

		if (startX > endX || startY > endY) {
			return;
		}

		int rgb = color.getRGB();

		for (int y = startY; y <= endY; y++) {
			for (int x = startX; x <= endX; x++) {
				image.setRGB(x, y, rgb);
			}
		}
	}
}