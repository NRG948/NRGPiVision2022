package vision;

import org.opencv.core.Mat;
import org.opencv.core.MatOfKeyPoint;

public interface ImageAccessor {

    public Mat getImage();
    public MatOfKeyPoint findBlobsOutput();
    
}
