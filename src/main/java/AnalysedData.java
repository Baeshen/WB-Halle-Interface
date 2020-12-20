/**
 * Data from Analyse
 */
public class AnalysedData {
    private String from;
    private String to;
    private double interactionWeight;
    private double flowDistance;

    public AnalysedData(String from, String to, double interactionWeight, double flowDistance) {
        this.from = from;
        this.to = to;
        this.interactionWeight = interactionWeight;
        this.flowDistance = flowDistance;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getInteractionWeight() {
        return interactionWeight;
    }

    public void setInteractionWeight(double interactionWeight) {
        this.interactionWeight = interactionWeight;
    }

    public double getFlowDistance() {
        return flowDistance;
    }

    public void setFlowDistance(double flowDistance) {
        this.flowDistance = flowDistance;
    }
}
