package io.github.pallavjain01;

import io.github.pallavjain01.data.ColorRegion;
import io.github.pallavjain01.data.Span;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageUtils {

	public static BufferedImage createImage(int width, int height) {
		return createImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	public static BufferedImage createImage(int width, int height, int imageType) {
		return new BufferedImage(
				width,
				height,
				imageType
		);
	}

	public static BufferedImage createImageWithBackground(int width, int height, Color color) {
		BufferedImage image = createImage(width, height);
		ColorRegion region = new ColorRegion(color, new Span(0, 0, width - 1, height - 1));
		region.applyToImage(image);
		return image;
	}
}