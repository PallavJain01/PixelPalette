package io.github.pallavjain01.data;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;

public record ColorRegion(
		Color color,
		List<Span> spans
) {
	public void applyToImage(BufferedImage image) {
		spans.forEach(span -> {
			span.applyToImage(image, color);
		});
	}

	public static void applyRegionToImage(BufferedImage image, ColorRegion region) {
		region.applyToImage(image);
	}

	public static void applyRegionsToImage(BufferedImage image, ColorRegion... regions) {
		for (ColorRegion region: regions) {
			region.applyToImage(image);
		}
	}

	public ColorRegion(Color color, Span span) {
		this(color, List.of(span));
	}
}
