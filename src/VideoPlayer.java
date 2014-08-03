import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.jcodec.api.FrameGrab;
import org.jcodec.api.JCodecException;
import org.jcodec.common.NIOUtils;
import org.jcodec.common.SeekableByteChannel;

public class VideoPlayer extends SequencePlayer {

	public VideoPlayer(File path) {
		super(path);
	}

	@Override
	public void loadingImages() {
		try {
			SeekableByteChannel sbc = NIOUtils.readableFileChannel(super.path);
			FrameGrab frameGrab = new FrameGrab(sbc);
			BufferedImage image = null;
			while ((image = frameGrab.getFrame()) != null) {
				super.addImage(image);
			}
		} catch (IOException | JCodecException e) {
			e.printStackTrace();
		}
	}

}
