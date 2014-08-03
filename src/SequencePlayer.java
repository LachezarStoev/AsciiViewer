import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import jline.ConsoleReader;

public abstract class SequencePlayer extends FilePlayer {

	private List<BufferedImage> images;
	private boolean loadedToEnd;

	public SequencePlayer(File path) {
		super(path);
		images = Collections.synchronizedList(new LinkedList<BufferedImage>());
		loadedToEnd = false;
	}

	public abstract void loadingImages();
	// Vij kak az sym go implementiral vyv VideoPlayer
	// prosto razbivash GifPlayera na Images i
	// v edin cikyl izvikvash addImage(BufferedImage image)

	@Override
	public void play() {
		Thread  executeImages = new Thread() {
			@Override
			public void run() {
				executeImages();
			};
		};
		Thread loadingImages = new Thread() {
			@Override
			public void run() {
				loadingImages();
				loadedToEnd(true);
			};
		};
		loadingImages.start();
		executeImages.start();
	}

	public void executeImages() {
		try {
			ConsoleReader reader = new ConsoleReader();
			while (!loadedToEnd) {
				if (this.hasImage()) {
					RenderUtils.printImage(this.popImage());
					Thread.sleep(50);
					reader.clearScreen();
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void addImage(BufferedImage image) {
		images.add(image);
	}

	public BufferedImage popImage() {
		return images.remove(0);
	}

	public boolean hasImage() {
		return !images.isEmpty();
	}

	public void loadedToEnd(boolean loaded) {
		this.loadedToEnd = loaded;
	}

}
