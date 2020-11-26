package button_actions;

import window_builders.IntroWindowBuilder;
import window_builders.SortWindowBuilder;
import window_builders.UtilBuilder;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.List;

public class EnterButtonAction extends AbstractAction {
   private UtilBuilder builder = new UtilBuilder();
   private SortWindowBuilder sortWindowBuilder = new SortWindowBuilder();
   private IntroWindowBuilder introWindowBuilder = new IntroWindowBuilder();
   private JFrame introWindow = new JFrame();
   private JFrame sortWindow = new JFrame();

    public void actionPerformed(ActionEvent e) {
      IntroWindowBuilder.introJFrame.dispose();

        if (IntroWindowBuilder.jTextField.getText()==null||!IntroWindowBuilder.jTextField.getText().matches("^\\d+$")||Integer.parseInt(IntroWindowBuilder.jTextField.getText())>1000){
            IntroWindowBuilder.jTextField =  new JTextField("You entered incorrect data. Enter any number", 24);
            introWindow = introWindowBuilder.createIntroWindow();

        } else {
            int count = Integer.parseInt(IntroWindowBuilder.jTextField.getText().trim());
            List <Integer> originRandomCollection = builder.getRandomGenerateCollection(count);
            sortWindow =  sortWindowBuilder.createSortWindow(originRandomCollection);
        }

    }
}
