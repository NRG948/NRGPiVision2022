package vision;

import java.util.HashMap;
import java.util.Map;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Mat;

import edu.wpi.first.vision.VisionPipeline;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SwitchedPipeline implements VisionPipeline, ImageAccessor{
    private Map<String, VisionPipeline> pipelines = new HashMap<>();

    public SwitchedPipeline(Map<String, VisionPipeline> pipelines) {
        this.pipelines = pipelines;

    }

    private VisionPipeline getCurrentPipeline() {
        String pipelineName = SmartDashboard.getString("Vision/Target/PipelineName", "BlueCargoPipeline");
        return pipelines.get(pipelineName);
    }

    @Override
    public Mat getImage() {
        VisionPipeline currentPipeline = getCurrentPipeline();
        if (currentPipeline == null) {
            return null;
        } 
        return ((ImageAccessor)currentPipeline).getImage();
    }

    @Override
    public void process(Mat arg0) {
        VisionPipeline currentPipeline = getCurrentPipeline();
        if (currentPipeline != null) {
            currentPipeline.process(arg0);
        }
    }

    @Override
    public MatOfKeyPoint findBlobsOutput() {
        VisionPipeline currentPipeline = getCurrentPipeline();
        if (currentPipeline == null) {
            return null;
        }
        return ((ImageAccessor)currentPipeline).findBlobsOutput();
    }
}
