//Draw and hide number axis

package org.starmap.view;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class DrawAxisView {
    private NumberAxis xAxis;
    private NumberAxis yAxis;
    public LineChart<Number, Number> DrawAxis(){
        xAxis = new NumberAxis();
        yAxis = new NumberAxis();

        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.getData().add(new XYChart.Data<>(1, 2));
        series.getData().add(new XYChart.Data<>(2, 4));
        series.getData().add(new XYChart.Data<>(3, 1));
        lineChart.getData().add(series);

        return lineChart;
    }

    public void HideAxis(){
        if (xAxis != null && yAxis != null) {
            xAxis.setOpacity(0);
            yAxis.setOpacity(0);
        }

    }
}
