package test;

import javafx.application.Platform;
import javafx.beans.property.SimpleListProperty;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.layout.GridPane;

import javax.swing.*;
import java.awt.*;
import javafx.scene.layout.AnchorPane;

public class JavaChartDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ChartFrame mainFrame = new ChartFrame();
                mainFrame.setVisible(true);
            }
        });
    }
}

class ChartFrame extends JFrame {

    JFXPanel fxPanel;

    final static String austria = "Austria";
    final static String brazil = "Brazil";
    final static String france = "France";
    final static String italy = "Italy";
    final static String usa = "USA";

    public ChartFrame() {
        initSwingComponents();

        initFxComponents();
    }

    private void initSwingComponents() {
        JPanel mainPanel = new JPanel(new BorderLayout());
        fxPanel = new JFXPanel();
        mainPanel.add(fxPanel, BorderLayout.CENTER);

        JLabel titleLabel = new JLabel("Charts in Swing applications");
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        this.add(mainPanel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
    }

    private void initFxComponents() {

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                AnchorPane grid = new AnchorPane();

                final CategoryAxis xAxis = new CategoryAxis();
                final NumberAxis yAxis = new NumberAxis();
                final BarChart<String, Number> bc
                        = new BarChart<String, Number>(xAxis, yAxis);
                bc.setTitle("Country Summary");
                xAxis.setLabel("Country");
                yAxis.setLabel("Value");

                XYChart.Series series1 = new XYChart.Series();
                series1.setName("2003");
                series1.getData().add(new XYChart.Data(austria, 25601.34));
                series1.getData().add(new XYChart.Data(brazil, 20148.82));
                series1.getData().add(new XYChart.Data(france, 10000));
                series1.getData().add(new XYChart.Data(italy, 35407.15));
                series1.getData().add(new XYChart.Data(usa, 12000));

                XYChart.Series series2 = new XYChart.Series();
                series2.setName("2004");
                series2.getData().add(new XYChart.Data(austria, 57401.85));
                series2.getData().add(new XYChart.Data(brazil, 41941.19));
                series2.getData().add(new XYChart.Data(france, 45263.37));
                series2.getData().add(new XYChart.Data(italy, 117320.16));
                series2.getData().add(new XYChart.Data(usa, 14845.27));

                XYChart.Series series3 = new XYChart.Series();
                series3.setName("2005");
                series3.getData().add(new XYChart.Data(austria, 45000.65));
                series3.getData().add(new XYChart.Data(brazil, 44835.76));
                series3.getData().add(new XYChart.Data(france, 18722.18));
                series3.getData().add(new XYChart.Data(italy, 17557.31));
                series3.getData().add(new XYChart.Data(usa, 92633.68));

                Scene scene = new Scene(grid, 800, 600);

                bc.getData().addAll(series1, series2, series3);

                bc.setBarGap(3);
                bc.setCategoryGap(20);

                grid.getChildren().clear();
                grid.getChildren().add(bc);
                AnchorPane.setTopAnchor(bc, 0.0);
                AnchorPane.setBottomAnchor(bc, 0.0);
                AnchorPane.setLeftAnchor(bc, 0.0);
                AnchorPane.setRightAnchor(bc, 0.0);
                fxPanel.setScene(scene);
            }
        });

    }

    private XYChart.Data getData(double x, double y) {
        XYChart.Data data = new XYChart.Data<>();
        data.setXValue(x);
        data.setYValue(y);
        return data;
    }

    private XYChart.Data getData(double x, String y) {
        XYChart.Data data = new XYChart.Data<>();
        data.setYValue(x);
        data.setXValue(y);
        return data;
    }
}
