import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

import jline.ConsoleReader;

public abstract class SequencePlayer extends FilePlayer {

	public SequencePlayer(File path) {
		super(path);
	}
	@Override
	public void play() {
		try {
		ConsoleReader reader = new ConsoleReader();
		for (BufferedImage image : getImages()){
				RenderUtils.printImage(image);
				Thread.sleep(50);
				reader.clearScreen();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
		
		
	}
	
	public abstract List<BufferedImage> getImages();

}
