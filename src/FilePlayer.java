import java.io.File;

public abstract class FilePlayer implements Player {
	
	protected File path;
	
	public FilePlayer(File path) {
		this.path = path;
	}
	
}
