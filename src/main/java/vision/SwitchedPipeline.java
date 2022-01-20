package vision;

import java.util.HashMap;
import java.util.Map;

import org.opencv.core.Mat;

import edu.wpi.first.vision.VisionPipeline;

public class SwitchedPipeline implements VisionPipeline, ImageAccessor{
    private Map<String, VisionPipeline> pipelines = new HashMap<>();
    private VisionPipeline currentPipeline;

    public SwitchedPipeline(Map<String, VisionPipeline> pipelines) {
        this.pipelines = pipelines;

    }

    public void setPipeline(String name) {
        this.currentPipeline = pipelines.get(name);
    }

    @Override
    public Mat getImage() {
        if (currentPipeline == null) {
            return null;
        } 
        return ((ImageAccessor)currentPipeline).getImage();
    }

    @Override
    public void process(Mat arg0) {
        if (currentPipeline != null) {
            currentPipeline.process(arg0);
        }
    }
}
