package view;

import model.DoctorReport;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableItem;

import java.util.List;

public class SeeTable {
    public void seeTable(Table workSpace, int pageControl, List<DoctorReport> controller, Label pagesLabel) {
        int maxPage = 0;
        String pages;
        if (controller.size() % 10 == 0)
            maxPage = controller.size() / 10;
        else
            maxPage = controller.size() / 10 + 1;
        int temp = pageControl + 1;
        pages = "" + temp + "/" + maxPage;
        pagesLabel.setText(pages);

        TableItem[] arrayOfItems = workSpace.getItems();
        for (int i = 0; i < 10; i++) {
            if (controller.size() - 10 * pageControl > i) {
                arrayOfItems[i].setText(0, controller.get(i + pageControl * 10).getPatientName());
                arrayOfItems[i].setText(1, controller.get(i + pageControl * 10).getPlaceOfResidence());
                arrayOfItems[i].setText(2, controller.get(i + pageControl * 10).getDateOfBirth());
                arrayOfItems[i].setText(3, controller.get(i + pageControl * 10).getDateOfReceipt());
                arrayOfItems[i].setText(4, controller.get(i + pageControl * 10).getDoctorName());
                arrayOfItems[i].setText(5, controller.get(i + pageControl * 10).getConclusion());

            } else {
                arrayOfItems[i].setText(0, "");
                arrayOfItems[i].setText(1, "");
                arrayOfItems[i].setText(2, "");
                arrayOfItems[i].setText(3, "");
                arrayOfItems[i].setText(4, "");
                arrayOfItems[i].setText(5, "");
            }

        }
    }
}
