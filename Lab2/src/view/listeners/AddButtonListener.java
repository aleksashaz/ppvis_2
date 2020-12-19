package view.listeners;

import controller.Controller;
import controller.PageController;
import view.SeeTable;
import model.DoctorReport;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AddButtonListener extends SelectionAdapter {
    PageController pageControl;
    Table tableView = null;
    Controller controller = null;
    Label pagesLabel = null;
    Text[] arrayOfText = new Text[6];

    public AddButtonListener(Table table, PageController tempValue, Controller tempController, Label tempLabel, Text[] tempArrayOfText) {
        tableView = table;
        controller = tempController;
        pagesLabel = tempLabel;
        pageControl = tempValue;
        arrayOfText = tempArrayOfText;
    }

    public void widgetSelected(SelectionEvent event1) {
        DateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        DoctorReport newItem = new DoctorReport();
        newItem.setPatientName(arrayOfText[0].getText());
        newItem.setPlaceOfResidence(arrayOfText[1].getText());
        try {
            newItem.setDateOfBirth(format.parse(arrayOfText[2].getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            newItem.setDateOfReceipt(format.parse(arrayOfText[3].getText()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newItem.setDoctorName(arrayOfText[4].getText());
        newItem.setConclusion(arrayOfText[5].getText());

        controller.setItemOfTable(newItem);

        SeeTable view = new SeeTable();
        view.seeTable(tableView, pageControl.getPage(), controller.getTable(), pagesLabel);
    }
}
