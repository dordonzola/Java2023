package org.starmap.view;

import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DrawAxisView {
    public static void DrawAxis(StarMapView starMapView, double lowerX, double upperX, double lowerY, double upperY) {

        NumberAxis xAxis = starMapView.getXAxis();
        NumberAxis yAxis = starMapView.getYAxis();

        yAxis.setStyle("-fx-stroke: white;");
        xAxis.setStyle("-fx-stroke: white;");

        xAxis.setLowerBound(lowerX);
        xAxis.setUpperBound(upperX);
        yAxis.setLowerBound(lowerY);
        yAxis.setUpperBound(upperY);

        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 2));
        series.getData().add(new XYChart.Data<>(2, 4));
        series.getData().add(new XYChart.Data<>(3, 1));

        starMapView.addDataSeries(series);
    }
}
