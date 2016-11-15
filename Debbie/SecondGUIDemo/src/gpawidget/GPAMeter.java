/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpawidget;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

/**
 *
 * @author MQ0162246
 */
public class GPAMeter extends Pane 
{
    
    // GPAMeter characteristics
    private double minValue = 0.00;
    private double maxValue = 100.00;
    private double centerX ;
    private double centerY ; 
    private double meterRadius;   
    private final double hand_percentage=0.90;
    
    //how to display the incrments from min to max
    private double delta= 10; 
    
    private double currentValue_1 = 0.00;
    private double currentValue_2 = 0.00;
    
    // Rotation parameter
    private int meterRotationAngleinDegrees =0;

    // Clock pane's width and height
    private double w = 600, h = 600;
    
    // GPAMeter start and end angles
    private int meterStartAngle=0;
    private int meterEndAngle  =180;
    
    
    // hand image
    Image handImage;
    ImageView handImageView;

    /**
     * Construct a default clock with the current time
     */
    public GPAMeter(double width, double height) {
        this.w = width;
        this.h = height;
    }


    public GPAMeter(double width, double height, double v1, double v2, double v3, double delta)
    {
        this.w = width;
        this.h = height;

        this.setMinWidth(w);
        this.setMaxWidth(w);
        
        this.setMaxHeight(.6 * h);
        this.setMinHeight(.6 * h);
        
        setCurrentValues(v1, v2, v3, delta);
    }

    public void setMinMaxValues(double v1, double v2) {
        setMinvalue(v1);
        setMaxValue(v2);
        paintMeter(currentValue_1);
    }   

    public void setCurrentValues(double v1, double v2, double v3,double delta) {
        
        setMinvalue(v1);
        setMaxValue(v2);
        setCurrentValue(v3);
        if (delta == -1) 
            setDelta(this.delta);
        else
            setDelta(delta);
        
        paintMeter(currentValue_1);
    }

    
    
    /**
     * Paint the meter
     */
    public void paintMeter(double currentValuexx) {
        // Initialize clock parameters
        handImage= new Image("hand.png");
        handImageView= new ImageView(handImage);
        meterRadius = Math.min(w, h) * 0.8 * 0.5;
        
        centerX = w / 2;
        centerY = h / 2;
        double xOuter, yOuter,  xInner,  yInner;

        Line valueLine1; Line valueLine2; Line valueLine3; Line valueLine4; Line valueLine5;
        Line valueLine6; Line valueLine7;
        
        double text_d, tick;
        double text_d_180, tick_180;
        double percent;
        // Set pane properties
        this.setStyle("-fx-background-color: CORNSILK");
        this.setStyle("-fx-border-color: red");
        this.setPrefSize(300, 300);
        
        // Draw GPAMeter
        Arc meter = new Arc(centerX, centerY, meterRadius, meterRadius, meterStartAngle, meterEndAngle); // Create an arc
        meter.setFill(Color.AZURE); // Set fill color
        meter.setStroke(Color.WHITE);
        meter.setType(ArcType.ROUND); // Set arc type

        // Draw zones
        Color[]  mycolors1={Color.rgb(220,0,0),Color.rgb(255,0,0), Color.LIGHTGREEN, Color.GREEN};
        double[] myvalues={0.25,0.25,0.25,0.25};
        
        // Draw value
        if (currentValuexx < minValue || currentValuexx > maxValue) {
            currentValue_1 = (maxValue + minValue) / 2;
        } else {
            currentValue_1 = currentValuexx;
        }

        double valueLength = meterRadius * hand_percentage;
        double valueX = centerX - valueLength * Math.cos(((currentValue_1 - minValue) / (maxValue - minValue)) * (Math.PI));
        double valueY = centerY - valueLength * Math.sin(((currentValue_1 - minValue) / (maxValue - minValue)) * (Math.PI));     

        if (Math.abs(currentValue_1 - minValue) <= 0.01 || Math.abs(currentValue_1 - maxValue) <= 0.01) {
            valueLine1 = new Line(centerX, centerY, valueX, valueY);
            valueLine2 = new Line(centerX, centerY + 1, valueX, valueY);
            valueLine3 = new Line(centerX, centerY - 1, valueX, valueY);
            valueLine4 = new Line(centerX, centerY + 2, valueX, valueY);
            valueLine5 = new Line(centerX, centerY - 2, valueX, valueY);
            valueLine6 = new Line(centerX, centerY + 3, valueX, valueY);
            valueLine7 = new Line(centerX, centerY - 3, valueX, valueY);

        } else {
            valueLine1 = new Line(centerX, centerY, valueX, valueY);
            valueLine2 = new Line(centerX + 1, centerY, valueX, valueY);
            valueLine3 = new Line(centerX - 1, centerY, valueX, valueY);
            valueLine4 = new Line(centerX + 2, centerY, valueX, valueY);
            valueLine5 = new Line(centerX - 2, centerY, valueX, valueY);
            valueLine6 = new Line(centerX + 3, centerY, valueX, valueY);
            valueLine7 = new Line(centerX - 3, centerY, valueX, valueY);
        }

        valueLine1.setStroke(Color.NAVY);
        valueLine2.setStroke(Color.NAVY);
        valueLine3.setStroke(Color.NAVY);
        valueLine4.setStroke(Color.NAVY);
        valueLine5.setStroke(Color.NAVY);
        valueLine6.setStroke(Color.NAVY);
        valueLine7.setStroke(Color.NAVY);

        getChildren().clear();
        getChildren().add(meter);
        
        ColorZone gpaWidgents=new ColorZone(mycolors1,myvalues);
        int[] widgetsLength = gpaWidgents.calcDegrees();
        Color[]  mycolors   = gpaWidgents.getColors();
        
        int start; int length, sum=0;
        for (int i = 0; i < widgetsLength.length; i++) 
        {
            if (i==0)
                start=180;
            else
                start=180 - sum;
            
            length= -widgetsLength[i];
           
            sum +=widgetsLength[i];
            
            Arc widget =  new Arc(centerX, centerY, meterRadius, meterRadius,start,length); 
            widget.setFill(mycolors[i]);   // Set fill color
            widget.setType(ArcType.ROUND); // Set arc type
            getChildren().add(widget);  
        }
        getChildren().addAll(valueLine1, valueLine2, valueLine3, valueLine4, valueLine5, valueLine6, valueLine7);        
       


        // no of major ticks
        int nOfPoints= (int) ((maxValue - minValue) /(delta)) ;
        if (delta > ((maxValue - minValue)/2) || nOfPoints > 180)
        {
            delta= (maxValue - minValue)/10;
        }
        System.out.println("No of points :"+ nOfPoints );

        // Display the Ticks
        for (int i = 0; i <nOfPoints ; i += 1)
        {
            //Major Ticks at deltas
            tick = minValue + i*delta;
            tick_180 =  ((tick-minValue ) / (maxValue - minValue))* 180.00;
            percent = 0.90;
            xOuter = centerX - meterRadius * Math.cos(tick_180 * (Math.PI / 180));
            yOuter = centerY - meterRadius * Math.sin(tick_180 * (Math.PI / 180));
            xInner = centerX - percent * meterRadius * Math.cos(tick_180 * (Math.PI / 180));
            yInner = centerY - percent * meterRadius * Math.sin(tick_180 * (Math.PI / 180));
            getChildren().add(new Line(xOuter, yOuter, xInner, yInner));
            
            //Drawr minro-ticks, if any
             percent = 0.95;
             int subticks = 11;
             double sub_delta = delta /subticks;
             for (int j = 0; j <subticks; j += 1)
             {
                 tick = minValue+i*delta+ j*sub_delta;
                 tick_180 =  ((tick-minValue ) / (maxValue - minValue))* 180.00;
                 xOuter = centerX - meterRadius * Math.cos(tick_180 * (Math.PI / 180));
                 yOuter = centerY - meterRadius * Math.sin(tick_180 * (Math.PI / 180));
                 xInner = centerX - percent * meterRadius * Math.cos(tick_180 * (Math.PI / 180));
                 yInner = centerY - percent * meterRadius * Math.sin(tick_180 * (Math.PI / 180));
                 getChildren().add(new Line(xOuter, yOuter, xInner, yInner));
             }
             
        }
        
//        // Display the Ticks
//        for (int i = 0; i <= 180; i += 1)
//        {
//            double percent;
//            if (i % 20 == 0) {
//                percent = 0.9;
//            } else {
//                percent = 0.95;
//            }
//            
//            xOuter = centerX - meterRadius * Math.cos(i * (Math.PI / 180));
//            yOuter = centerY - meterRadius * Math.sin(i * (Math.PI / 180));
//            xInner = centerX - percent * meterRadius * Math.cos(i * (Math.PI / 180));
//            yInner = centerY - percent * meterRadius * Math.sin(i * (Math.PI / 180));
//            getChildren().add(new Line(xOuter, yOuter, xInner, yInner));
//        }        

//        // Display the Numbers
//        for (int i = 0; i <= 180; i += 10) {
//            double text_d =  (((maxValue - minValue) * i / 180.00) + minValue);
//            double x = centerX - 1.1 * meterRadius * Math.cos(i * (Math.PI / 180));
//            double y = centerY - 1.1 * meterRadius * Math.sin(i * (Math.PI / 180));
//            String s = String.format("%.2f", text_d);
//
//            Text text = new Text(x - 8, y, "" + s);
//            text.setFill(Color.INDIGO);
//            getChildren().add(text);
//        }
        
        // Display the Numbers starting with the range not the 0-180 as above...
        //double delta= (maxValue - minValue) /(nOfPoints-1);
        
        
        for (int i = 0; i <= nOfPoints; i++)
        {
            //text display
            text_d = minValue + i*delta;
            text_d_180 =  ((text_d-minValue ) / (maxValue - minValue))* 180.00;
            double x = centerX - 1.1 * meterRadius * Math.cos(text_d_180 * (Math.PI / 180));
            double y = centerY - 1.1 * meterRadius * Math.sin(text_d_180 * (Math.PI / 180));
            String s = String.format("%.2f", text_d);
            Text text = new Text(x - 8, y, "" + s);
            text.setFill(Color.INDIGO);
            getChildren().add(text);
        }   
    }
  /**
     * Paint the meter
     */
    public void paintMeter(double currentValuexx,double currentValuexx2)
    {
        paintMeter(currentValuexx);
        
        // Add second hand
        Line valueLine1; Line valueLine2; Line valueLine3; Line valueLine4; Line valueLine5;
        Line valueLine6; Line valueLine7;

        // Draw value
        if (currentValuexx2 < minValue || currentValuexx2 > maxValue) {
            currentValue_2 = (maxValue + minValue) / 2;
        } else {
            currentValue_2 = currentValuexx2;
        }

        double valueLength = meterRadius * hand_percentage;
        double valueX = centerX - valueLength * Math.cos(((currentValue_2 - minValue) / (maxValue - minValue)) * (Math.PI));
        double valueY = centerY - valueLength * Math.sin(((currentValue_2 - minValue) / (maxValue - minValue)) * (Math.PI));     

        if (Math.abs(currentValue_2 - minValue) <= 0.01 || Math.abs(currentValue_2 - maxValue) <= 0.01) {
            valueLine1 = new Line(centerX, centerY, valueX, valueY);
            valueLine2 = new Line(centerX, centerY + 1, valueX, valueY);
            valueLine3 = new Line(centerX, centerY - 1, valueX, valueY);
            valueLine4 = new Line(centerX, centerY + 2, valueX, valueY);
            valueLine5 = new Line(centerX, centerY - 2, valueX, valueY);
            valueLine6 = new Line(centerX, centerY + 3, valueX, valueY);
            valueLine7 = new Line(centerX, centerY - 3, valueX, valueY);

        } else {
            valueLine1 = new Line(centerX, centerY, valueX, valueY);
            valueLine2 = new Line(centerX + 1, centerY, valueX, valueY);
            valueLine3 = new Line(centerX - 1, centerY, valueX, valueY);
            valueLine4 = new Line(centerX + 2, centerY, valueX, valueY);
            valueLine5 = new Line(centerX - 2, centerY, valueX, valueY);
            valueLine6 = new Line(centerX + 3, centerY, valueX, valueY);
            valueLine7 = new Line(centerX - 3, centerY, valueX, valueY);
        }

        valueLine1.setStroke(Color.ALICEBLUE);
        valueLine2.setStroke(Color.ALICEBLUE);
        valueLine3.setStroke(Color.ALICEBLUE);
        valueLine4.setStroke(Color.ALICEBLUE);
        valueLine5.setStroke(Color.ALICEBLUE);
        valueLine6.setStroke(Color.ALICEBLUE);
        valueLine7.setStroke(Color.ALICEBLUE);
        getChildren().addAll(valueLine1, valueLine2, valueLine3, valueLine4, valueLine5, valueLine6, valueLine7);          
    }    

    /**
     * @return the Minvalue
     */
    public double getMinvalue() {
        return minValue;
    }

    /**
     * @param minvalue the minValue to set
     */
    public void setMinvalue(double minvalue) {
        this.minValue = minvalue;
        paintMeter(currentValue_1);

    }

    /**
     * @return the maxValue
     */
    public double getMaxValue() {
        return maxValue;
    }

    /**
     * @param maxValue the maxValue to set
     */
    public void setMaxValue(double maxValue) {
        this.maxValue = maxValue;
        paintMeter(currentValue_1);

    }

    /**
     * @return the currentValue_1
     */
    public double getCurrentValue() {
        return currentValue_1;
    }

    /**
     * @param currentValue the currentValue_1 to set
     */
    public void setCurrentValue(double currentValue) {
        this.currentValue_1 = currentValue;
        paintMeter(currentValue);

    }

    /**
     * @return the w
     */
    public double getW() {
        return w;
    }

    /**
     * @param w the w to set
     */
    public void setW(double w) {
        this.w = w;
    }

    /**
     * @return the h
     */
    public double getH() {
        return h;
    }

    /**
     * @param h the h to set
     */
    public void setH(double h) {
        this.h = h;
    }

    /**
     * @return the meterRotationAngleinDegrees
     */
    public int getMeterRotationAngleinDegrees() {
        return meterRotationAngleinDegrees;
    }

    /**
     * @param meterRotationAngleinDegrees the meterRotationAngleinDegrees to set
     */
    public void setMeterRotationAngleinDegrees(int meterRotationAngleinDegrees) {
        this.meterRotationAngleinDegrees = meterRotationAngleinDegrees;
    }

    /**
     * @return the meterStartAngle
     */
    public int getMeterStartAngle() {
        return meterStartAngle;
    }

    /**
     * @param meterStartAngle the meterStartAngle to set
     */
    public void setMeterStartAngle(int meterStartAngle) {
        this.meterStartAngle = meterStartAngle;
    }

    /**
     * @return the meterEndAngle
     */
    public int getMeterEndAngle() {
        return meterEndAngle;
    }

    /**
     * @param meterEndAngle the meterEndAngle to set
     */
    public void setMeterEndAngle(int meterEndAngle) {
        this.meterEndAngle = meterEndAngle;
    }

    /**
     * @return the delta
     */
    public double getDelta() {
        return delta;
    }

    /**
     * @param delta the delta to set
     */
    public void setDelta(double delta) {
        this.delta = delta;
    }

    /**
     * @return the currentValue_2
     */
    public double getCurrentValue_2() {
        return currentValue_2;
    }

    /**
     * @param currentValue_2 the currentValue_2 to set
     */
    public void setCurrentValue_2(double currentValue_2) {
        this.currentValue_2 = currentValue_2;
    }
}
