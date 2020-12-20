/**
 * Data from Analyse
 */
public class AnalysedData {
    private String from;
    private String to;
    private double interactionDuration;
    private double flowDistance;

    public AnalysedData(String from, String to, double interactionDuration, double flowDistance) {
        this.from = from;
        this.to = to;
        this.interactionDuration = interactionDuration;
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

    public double getInteractionDuration() {
        return interactionDuration;
    }

    public void setInteractionDuration(double interactionDuration) {
        this.interactionDuration = interactionDuration;
    }

    public double getFlowDistance() {
        return flowDistance;
    }

    public void setFlowDistance(double flowDistance) {
        this.flowDistance = flowDistance;
    }
}
