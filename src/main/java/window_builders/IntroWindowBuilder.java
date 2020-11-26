package window_builders;

import button_actions.EnterButtonAction;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class IntroWindowBuilder {

    UtilBuilder builder = new UtilBuilder();
    public static  JTextField jTextField = new JTextField("", 10);
    public static JFrame introJFrame = new JFrame();

    public JFrame createIntroWindow() {
        introJFrame =  builder.getWindow("Intro screen");
        JPanel introWindowJPanel = createIntroWindowJPanel();
        introJFrame.add(introWindowJPanel);
        introWindowJPanel.revalidate();
        return introJFrame;
    }

    public JPanel createIntroWindowJPanel (){
        JPanel introWindowJPanel = new JPanel();
        GridBagLayout introScreenGridBagLayout = new GridBagLayout();
        introWindowJPanel.setLayout(introScreenGridBagLayout);

        KeyStroke keyStroke = KeyStroke.getKeyStroke((char) KeyEvent.VK_ENTER);
        InputMap inputMap = introWindowJPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inputMap.put(keyStroke, "changeScreen");
        ActionMap actionMap = introWindowJPanel.getActionMap();
        AbstractAction enterButtonAction = new EnterButtonAction();
        actionMap.put("changeScreen", enterButtonAction);

        jTextField.addActionListener(enterButtonAction);

        introWindowJPanel.add(createIntroWindowJLabel(), getJLabelConstrains());
        introWindowJPanel.add(jTextField, getJTextFieldConstraints());
        introWindowJPanel.add(createEnterJButton(), getEnterJButtonConstraints());

        return introWindowJPanel;
    }

    public JLabel createIntroWindowJLabel(){
        JLabel jLabel = new JLabel("How many numbers to display?");
        return jLabel;
    }

    public GridBagConstraints getJLabelConstrains (){
        GridBagConstraints constraintsJLabel = builder.getGridBagConstraints(0, 0, 0,0,1,1);
        constraintsJLabel.insets = new Insets(5, 5, 5, 5);
        return constraintsJLabel;
    }

    public JButton createEnterJButton(){
        JButton enterButton = new JButton("Enter");
        AbstractAction enterButtonAction = new EnterButtonAction();
        enterButton.addActionListener(enterButtonAction);
        return enterButton;
    }

    public GridBagConstraints getEnterJButtonConstraints(){
        GridBagConstraints constraintsEnterButton = builder.getGridBagConstraints(0, 0, 0,4,1,1);
        constraintsEnterButton.insets = new Insets(5, 5, 5, 5);
        return constraintsEnterButton;
    }
    public GridBagConstraints getJTextFieldConstraints(){
        GridBagConstraints constraintsJTextField = builder.getGridBagConstraints(0, 0, 0,2,1,1);
        constraintsJTextField.insets = new Insets(5, 5, 5, 5);
        return constraintsJTextField;
    }

  }
