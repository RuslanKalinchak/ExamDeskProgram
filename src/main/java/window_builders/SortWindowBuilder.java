package window_builders;

import button_actions.NumberButtonAction;
import button_actions.ResetButtonAction;
import button_actions.SortButtonAction;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class SortWindowBuilder {
    IntroWindowBuilder introWindowBuilder = new IntroWindowBuilder();
    UtilBuilder builder = new UtilBuilder();
    public static JFrame sortWindow = new JFrame();

        public JFrame createSortWindow (List<Integer> source){
            sortWindow =  builder.getWindow("Sort Screen");
            sortWindow.setLayout(new FlowLayout(FlowLayout.LEFT));

            JPanel sortScreenJPanel = createTableJPanel(source);
            JPanel functionalJPanel = createFunctionalJPanel();

            JScrollPane pane = new JScrollPane(sortScreenJPanel, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            pane.setPreferredSize(new Dimension(565, 430));

            sortWindow.add(pane);
            sortWindow.add(functionalJPanel);

            sortScreenJPanel.revalidate();
            functionalJPanel.revalidate();
            sortWindow.repaint();
            sortWindow.pack();

            return sortWindow;
        }

       public JPanel createTableJPanel(List<Integer> source){
        JPanel tableJPanel = new JPanel();
        GridBagLayout gridBagLayout = new GridBagLayout();
        tableJPanel.setLayout(gridBagLayout);

        int gridX = 0;
        int gridY = 0;

        for (int i = 0; i < source.size() ; i++) {

            if ((gridY)%10==0){
                gridX = gridX + 1;
                gridY = 0;
            }
            GridBagConstraints gridBagConstraints = builder.getGridBagConstraints(0,0,gridX, gridY, 1,1);
            gridBagConstraints.anchor = GridBagConstraints.NORTHWEST;
            gridBagConstraints.fill = GridBagConstraints.REMAINDER;
            gridBagConstraints.insets = new Insets(2, 2, 2, 2);
            gridBagConstraints.ipadx = 1;
            gridBagConstraints.ipady = 1;
            JButton jButton = new JButton(String.valueOf(source.get(i)));
            jButton.setPreferredSize(new Dimension(65, 35));
            AbstractAction numberButtonAction = new NumberButtonAction();
            jButton.addActionListener(numberButtonAction);
            tableJPanel.add(jButton, gridBagConstraints);

            gridY+=1;
        }
        return tableJPanel;
    }

    public JPanel createFunctionalJPanel (){
        GridBagLayout functionalJPanelGridBagLayout = new GridBagLayout();
        JPanel functionalJPanel = new JPanel(functionalJPanelGridBagLayout);

        functionalJPanel.add(createSortJButton(), getSortJButtonConstraints());
        functionalJPanel.add(createResetJButton(), getResetJButtonConstraints());

        return functionalJPanel;
    }

    public JButton createSortJButton (){
        JButton sortButton = new JButton("sort");
        AbstractAction sortButtonAction = new SortButtonAction();
        sortButton.addActionListener(sortButtonAction);
        return sortButton;
    }

    public GridBagConstraints getSortJButtonConstraints(){
        GridBagConstraints sortJButtonGridBagConstraints = builder.getGridBagConstraints(1,1,0,1,1,1);
        sortJButtonGridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        sortJButtonGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        sortJButtonGridBagConstraints.insets = new Insets(2, 35, 2, 2);
        return sortJButtonGridBagConstraints;
    }

    public JButton createResetJButton (){
        JButton resetButton = new JButton("reset");
        AbstractAction resetButtonAction = new ResetButtonAction();
        resetButton.addActionListener(resetButtonAction);
        return resetButton;
    }
    public GridBagConstraints getResetJButtonConstraints(){
        GridBagConstraints resetJButtonGridBagConstraints = builder.getGridBagConstraints(1,1,0,2,1,1);
        resetJButtonGridBagConstraints.anchor = GridBagConstraints.NORTHEAST;
        resetJButtonGridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        resetJButtonGridBagConstraints.insets = new Insets(2, 35, 240, 2);
        return resetJButtonGridBagConstraints;
    }
}
