package button_actions;

import window_builders.SortWindowBuilder;
import window_builders.UtilBuilder;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.util.Collections;
import java.util.List;

public class SortButtonAction extends AbstractAction {
    public static int clickCount = 0;
    public  JFrame descendingOrderJFrame = new JFrame();
    public  JFrame ascendingOrderJFrame = new JFrame();
    SortWindowBuilder sortWindowBuilder = new SortWindowBuilder();

    public List<Integer> getAscendingOrderSortedCollection (List <Integer> source){
        List <Integer> integerList = source;
        Collections.sort(integerList);
        return integerList;
    }

    public List<Integer> getDescendingOrderSortedCollection (List <Integer> source){
        List <Integer> integerList = getAscendingOrderSortedCollection(source);
        Collections.reverse(integerList);
        return integerList;
    }

    public void actionPerformed(ActionEvent e) {
    clickCount = clickCount+1;
        SortWindowBuilder.sortWindow.dispose();

    if (clickCount%2==1){
        List<Integer> descendingOrderCollection = getDescendingOrderSortedCollection(UtilBuilder.randomGenerateCollection);
        descendingOrderJFrame=sortWindowBuilder.createSortWindow(descendingOrderCollection);

    } else if (clickCount%2==0){
        List<Integer> ascendingOrderSortedCollection = getAscendingOrderSortedCollection(UtilBuilder.randomGenerateCollection);
        ascendingOrderJFrame= sortWindowBuilder.createSortWindow(ascendingOrderSortedCollection);
    }
}}
