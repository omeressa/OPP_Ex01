package GUI;

import javax.swing.JFrame;
import myMath.Monom;
import myMath.Polynom;
import de.erichseifert.gral.data.DataTable;
import de.erichseifert.gral.plots.XYPlot;
import de.erichseifert.gral.plots.lines.DefaultLineRenderer2D;
import de.erichseifert.gral.plots.lines.LineRenderer;
import de.erichseifert.gral.ui.InteractivePanel;

public class LinePlotTest extends JFrame {
    public LinePlotTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);

        DataTable data = new DataTable(Double.class, Double.class);
        Polynom p1 = new Polynom();
        p1.add(new Monom(17,4));
        p1.add(new Monom(-0.04,5.60));
        p1.add(new Monom(0.2,2.50));
        p1.add(new Monom(2.4,1));
        p1.add(new Monom(7.4,0));
        for (double x = 10.0; x <= 24.0; x+=0.5) {
            double y = p1.f(x);
            data.add(x, y);
            System.out.println(x+", "+y);
        }
        XYPlot plot = new XYPlot(data);
        getContentPane().add(new InteractivePanel(plot));
        LineRenderer lines = new DefaultLineRenderer2D();
        plot.setLineRenderers(data, lines);
       // Color color = new Color(0.0f, 0.3f, 1.0f);
    }
    public static void main(String[] args) {
        LinePlotTest frame = new LinePlotTest();
        frame.setVisible(true);
    }
}