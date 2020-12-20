import java.sql.SQLException;

/**
 * Created in HalleInterface : PACKAGE_NAME
 * on 20.12.2020 : 13:58 .
 */
public class Main {
    public static void main(String[] args) {
        try {
            InteractionInterface interactionInterface = new InteractionInterface();


            for (AnalysedData data : interactionInterface.getAnalysedData()) {
                printData(data);
            }

            System.out.println("With User Select");
            for (AnalysedData data : interactionInterface.getAnalysedData("1", "2", "3", "4", "5")) {
                printData(data);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void printData(AnalysedData data) {
        System.out.println("From %s to %s with the values: duration: %f, flow: %f ".formatted(
                data.getFrom(),
                data.getTo(),
                data.getInteractionWeight(),
                data.getFlowDistance()));
    }

}
