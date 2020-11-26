package button_actions;

import window_builders.SortWindowBuilder;
import window_builders.UtilBuilder;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class NumberButtonAction extends AbstractAction {
    UtilBuilder utilBuilder = new UtilBuilder();
    SortWindowBuilder sortWindowBuilder = new SortWindowBuilder();
    String message = "Select a value smaller or equal to 30";
    public void actionPerformed(ActionEvent e) {
        int buttonNumber = Integer.parseInt(e.getActionCommand());
        if (buttonNumber<=30){
            SortWindowBuilder.sortWindow.dispose();
            List<Integer> newRandomGeneratedCollection = utilBuilder.getRandomGenerateCollection(buttonNumber);
            JFrame newSortJFrame = sortWindowBuilder.createSortWindow(newRandomGeneratedCollection);
        } else if (buttonNumber>30){
            JOptionPane.showMessageDialog(SortWindowBuilder.sortWindow, message);
        }
    }


}
