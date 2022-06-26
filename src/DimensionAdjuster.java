import java.awt.*;

public class DimensionAdjuster {

    private final int systemHeight;
    private final int systemWidth;
    private final double displayRatio;

    public DimensionAdjuster() {
        systemHeight = (int)Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        systemWidth = (int)Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        displayRatio = (double)1920 / systemWidth;
    }

    public int adjustedFontSize(int fontSize) {
        return (int)(fontSize / displayRatio);
    }

    public int adjustedWidth(int width) {
        return (int)(width / displayRatio);
    }

    public int adjustedHeight(int height) {
        return (int)(height / displayRatio);
    }

    public int adjustedXBound(int xBound) {
        return (int)(xBound / displayRatio);
    }

    public int adjustedYBound(int yBound) {
        return (int)(yBound / displayRatio);
    }
}
