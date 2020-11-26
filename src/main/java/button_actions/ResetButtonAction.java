package button_actions;

import window_builders.IntroWindowBuilder;
import window_builders.SortWindowBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ResetButtonAction extends AbstractAction {
    IntroWindowBuilder introWindowBuilder = new IntroWindowBuilder();
    public void actionPerformed(ActionEvent e) {
        SortWindowBuilder.sortWindow.dispose();
        IntroWindowBuilder.jTextField.setText("");
        JFrame newIntroWindow = introWindowBuilder.createIntroWindow();
    }
}
