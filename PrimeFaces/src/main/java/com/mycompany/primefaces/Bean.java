/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primefaces;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import com.mycompany.primefaces.Student;
import javax.annotation.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

/**
 *
 * @author Zosia
 */
@Named(value = "bean")
@ManagedBean
@RequestScoped
public class Bean {
    
    private int numberA;
    private int numberB;
    private int result;
    private Date currentDate;
    private ArrayList<Student> students;
    private LineChartModel degreeModel;

    /**
     * Creates a new instance of BackingBean
     */
    public Bean() {
        createLineChartModel();
        this.students = new ArrayList<>(Arrays.asList(
                new Student("Hermione", "Granger", 5.00), 
                new Student("Harry", "Potter", 3.45), 
                new Student("Ron", "Weasley", 3.25),
                new Student("Luna", "Lovegood", 4.50),
                new Student("Draco", "Malfoy", 4.00)
                ));
    }
    
    private void createLineChartModel() {
        degreeModel = new LineChartModel();
        
        LineChartSeries sin = new LineChartSeries();
        LineChartSeries cos = new LineChartSeries();
        for (int i=0; i<=360; i+=10) {
            sin.set(i, Math.sin(i));
            cos.set(i, Math.cos(i));
        }
        sin.setLabel("Sinus");
        cos.setLabel("Cosinus");
        
        degreeModel.addSeries(sin);
        degreeModel.addSeries(cos);
        
        degreeModel.setTitle("Chart");
        degreeModel.setLegendPosition("e");
        Axis yAxis = degreeModel.getAxis(AxisType.Y);
        degreeModel.getAxes().put(AxisType.X, new CategoryAxis("degrees"));
        
        yAxis.setMin(-1.2); 
        yAxis.setMax(1.2);
        
        degreeModel.setZoom(true);
        
        
       
        
        
        
        
    }
    
    public void addMessage(int a, int b, int c) {
        FacesContext context = FacesContext.getCurrentInstance();
         
        context.addMessage("growl-messages", new FacesMessage("Result",  a + "+" + b + "=" + c) );
 
    }
    
    public void add() {
        setResult(getNumberA() + getNumberB());
        addMessage(getNumberA(), getNumberB(), getResult());
    }
    


    /**
     * @return the numberA
     */
    public int getNumberA() {
        return numberA;
    }

    /**
     * @param numberA the numberA to set
     */
    public void setNumberA(int numberA) {
        this.numberA = numberA;
    }

    /**
     * @return the numberB
     */
    public int getNumberB() {
        return numberB;
    }

    /**
     * @param numberB the numberB to set
     */
    public void setNumberB(int numberB) {
        this.numberB = numberB;
    }

    /**
     * @return the sum
     */
    public int getResult() {
        return result;
    }

    /**
     * @param result the sum to set
     */
    public void setResult(int result) {
        this.result = result;
    }

    /**
     * @return the currentDate
     */
    public Date getCurrentDate() {
        return Date.from(Instant.now());
    }

    /**
     * @param currentDate the currentDate to set
     */
    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    /**
     * @return the students
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    /**
     * @param students the students to set
     */
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    /**
     * @return the degreeModel
     */
    public LineChartModel getDegreeModel() {
        return degreeModel;
    }

    /**
     * @param degreeModel the degreeModel to set
     */
    public void setDegreeModel(LineChartModel degreeModel) {
        this.degreeModel = degreeModel;
    }
    
}
