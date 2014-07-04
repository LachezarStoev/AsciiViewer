import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

public class VideoPlayer extends SequencePlayer {
	public VideoPlayer(File path) {
		super(path);
	}
	@Override
	public List<BufferedImage> getImages() {
		List<BufferedImage> images = new ArrayList<>();
		int frames = 0;
		try {
			SeekableByteChannel sbc = NIOUtils.readableFileChannel(super.path);
			FrameGrab frameGrab = new FrameGrab(sbc);
			BufferedImage image = null;
			while ((image = frameGrab.getFrame()) != null && frames < 250) {
				images.add(image);
				frames++;
			}

		} catch (IOException e) {
			e.printStackTrace();

		} catch (JCodecException e) {
			e.printStackTrace();
		}

		return images;
	}

}
