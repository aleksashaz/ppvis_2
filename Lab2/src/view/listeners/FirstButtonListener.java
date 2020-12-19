package view.listeners;

import controller.Controller;
import controller.PageController;
import view.SeeTable;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;

public class FirstButtonListener extends SelectionAdapter {
    PageController pageControl;
    Table tableView = null;
    Controller controller = null;
    Label pagesLabel = null;

    public FirstButtonListener(Table table, PageController tempValue, Controller tempController, Label tempLabel) {
        tableView = table;
        controller = tempController;
        pagesLabel = tempLabel;
        pageControl = tempValue;
    }

    public void widgetSelected(SelectionEvent event1) {
        pageControl.firsPage();
        SeeTable view = new SeeTable();
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(), pagesLabel);


    }

}
