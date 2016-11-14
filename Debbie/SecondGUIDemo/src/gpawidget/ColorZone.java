/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import java.util.ArrayList;
import javafx.scene.paint.Color;

/**
 *
 * @author MQ0162246
 */
public class ColorZone {

    private Color[]  colors=null;
    private double[] values =null;
    private int[] valuesDegrees=null;

    public ColorZone(Color[] mycolors, double[] myvalues) 
    {
        colors = mycolors;
        values = myvalues;
  
    }
    public int[] calcDegrees()
    {
        double sum=0;
        int[] degrees=null;
        
        //Convert percntagfe to 0-180 degrees length
 
            degrees = new int[values.length];
            for (int i = 0; i < values.length; i++) 
            {
                double cSize=values[i];
                sum +=cSize;   
            }
            
            for (int i = 0; i < values.length; i++) 
            {
                int cSize= Math.round((float)((values[i]/sum) * 180)) ;
                degrees[i]=cSize;
            }
        valuesDegrees=degrees;
        return degrees;
    }

    /**
     * @return the colors
     */
    public Color[] getColors() {
        return colors;
    }

    /**
     * @param colors the colors to set
     */
    public void setColors(Color[] colors) {
        this.colors = colors;
    }

    /**
     * @return the values
     */
    public double[] getValues() {
        return values;
    }

    /**
     * @param values the values to set
     */
    public void setValues(double[] values) {
        this.values = values;
    }

    /**
     * @return the valuesDegrees
     */
    public int[] getValuesDegrees() {
        return valuesDegrees;
    }

    /**
     * @param valuesDegrees the valuesDegrees to set
     */
    public void setValuesDegrees(int[] valuesDegrees) {
        this.valuesDegrees = valuesDegrees;
    }
}
