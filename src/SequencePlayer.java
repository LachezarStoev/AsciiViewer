import java.awt.image.BufferedImage;
import java.util.List;


public abstract class SequencePlayer extends FilePlayer {

	@Override
	public void play() {
		for (BufferedImage image : getImages()){
			
		}
	}
	
	public abstract List<BufferedImage> getImages(); 

}
