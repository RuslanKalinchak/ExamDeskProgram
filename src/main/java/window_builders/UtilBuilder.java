package window_builders;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class UtilBuilder {
    public static final int minN = 1;
    public static final int maxN = 1000;
    public static final int minValue = 1;
    public static final int maxValue = 30;
    public static List<Integer> randomGenerateCollection = new ArrayList<Integer>();


    public JFrame getWindow(String title){
        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        // jFrame.setBounds(0, 0, 700, 500);
        jFrame.setBounds(dimension.width/2-380, dimension.height/2-300, 700, 500);
        jFrame.setTitle(title);
        return jFrame;
    }

    public java.util.List<Integer> getRandomGenerateCollection (int count){
        randomGenerateCollection = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            randomGenerateCollection.add((int) (Math.random()*(maxN-minN+1))+minN);
        }

        boolean isChecked = checkedCollectionValue(randomGenerateCollection);
        if (isChecked == false){
            randomGenerateCollection.remove(0);
            randomGenerateCollection.add((int) (Math.random()*(maxValue-minValue+1))+minValue);
        }
        return randomGenerateCollection;
    }

    public Boolean checkedCollectionValue (List<Integer> uncheckedList){
        Boolean isChecked = false;
        for (int i = 0; i < uncheckedList.size(); i++) {
            if (uncheckedList.get(i)<=30){
                isChecked = true;
            }
        }
        return isChecked;
    }

    public GridBagConstraints getGridBagConstraints (double weightX, double weightY, int gridX, int gridY, int gridWidth, int gridHeight){
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.weightx = weightX;
        gridBagConstraints.weighty = weightY;
        gridBagConstraints.gridx = gridX;
        gridBagConstraints.gridy = gridY;
        gridBagConstraints.gridwidth = gridWidth;
        gridBagConstraints.gridheight = gridHeight;
        return gridBagConstraints;
    }

}
