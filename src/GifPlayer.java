import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jline.ConsoleReader;

public class GifPlayer extends SequencePlayer {

	public GifPlayer(File path) {
		super(path);
	}


// tozi metod se izpolzva6e v prednata versiq, v momenta trqbva da se polzva
// samo loadingImages()
	public List<BufferedImage> getImages() {
		List<BufferedImage> images = new ArrayList<>();
		GifDecoder d = new GifDecoder();
		d.read(this.path.toString());
		int n = d.getFrameCount();
		for (int i = 0; i < n; i++) {
			BufferedImage frame = d.getFrame(i); // frame i
//			int t = d.getDelay(i); // display duration of frame in milliseconds
			images.add(frame);
		}
		return images;
	}

	@Override
	public void loadingImages() {
		GifDecoder d = new GifDecoder();
		d.read(this.path.toString());
		int n = d.getFrameCount();
		for (int i = 0; i < n; i++) {
			BufferedImage frame = d.getFrame(i); // frame i
			super.addImage(frame);
		}
		
	}

}
