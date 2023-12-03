package view.generateView;

import interface_adapter.generate.GenerateController;
import interface_adapter.generate.GenerateViewModel;
import org.junit.Assert;
import org.junit.Test;
import use_case.generate.GenerateInputBoundary;
import view.GenerateView;

import javax.swing.*;

public class GenerateViewTest {

    @Test
    public void testGenerateView() {
        GenerateInputBoundary generateInputBoundary = null;

        GenerateController generateController = new GenerateController(null);
        GenerateViewModel generateViewModel = new GenerateViewModel();

        JPanel generateView = new GenerateView(generateController, generateViewModel);
        JFrame jf = new JFrame();
        jf.setContentPane(generateView);
        jf.pack();
        jf.setVisible(true);

        Assert.assertNotNull(generateView.getComponent(0));
    }
}
