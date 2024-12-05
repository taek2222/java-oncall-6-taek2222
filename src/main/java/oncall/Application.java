package oncall;

import oncall.controller.OncallController;
import oncall.view.InputView;
import oncall.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OncallController oncallController = new OncallController(
                new InputView(),
                new OutputView()
        );

        oncallController.run();
    }
}
