package view;

import controller.Controller;
import controller.PageController;
import model.DoctorReport;
import view.listeners.FirstButtonListener;
import view.listeners.LastButtonListener;
import view.listeners.NextButtonListener;
import view.listeners.PrevButtonListener;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class FindMenu {
    List<DoctorReport> vectorOfAnswers = new ArrayList<>(0);
    List<DoctorReport> findVector = null;
    PageController pageControl = new PageController();

    public void setWorkSpace(List<DoctorReport> base, Display display) {
        Controller findController = new Controller();
        findVector = base;

        Controller controller = new Controller();
        for (int i = 0; i < findVector.size(); i++) {
            controller.setItemOfTable(findVector.get(i));
        }

        Shell shell = new Shell();
        shell.setLayout(new RowLayout(SWT.VERTICAL));

        Composite group0 = new Composite(shell, SWT.NONE);

        String[] arrayOfButtonsNames = {
                "ФИО пациента",
                "Адрес прописки",
                "Дата рождения",
                "Дата приёма",
                "ФИО врача"
        };

        Composite[] arrayOfComposites = new Composite[5];
        Label[] arrayOfLabels = new Label[5];
        Text[] arrayOfText = new Text[5];

        for (int i = 0; i < 5; i++) {
            arrayOfComposites[i] = new Composite(group0, SWT.NONE);
            arrayOfComposites[i].setLayout(new RowLayout(SWT.VERTICAL));
            arrayOfLabels[i] = new Label(arrayOfComposites[i], SWT.NONE);
            arrayOfLabels[i].setText(arrayOfButtonsNames[i]);
            arrayOfText[i] = new Text(arrayOfComposites[i], SWT.NONE);
        }

        group0.setLayout(new RowLayout(SWT.HORIZONTAL));

        Button startFindButton = new Button(group0, SWT.NONE);
        startFindButton.setText("поиск записи");


            Table tableView = new Table(shell, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
            tableView.setHeaderVisible(true);

            TableColumn column1 = new TableColumn(tableView, SWT.NONE);
            column1.setText("ФИО пациента");
            column1.setWidth(140);

            TableColumn column2 = new TableColumn(tableView, SWT.NONE);
            column2.setText("Место прописки");
            column2.setWidth(140);

            TableColumn column3 = new TableColumn(tableView, SWT.NONE);
            column3.setText("Дата рождения");
            column3.setWidth(240);

            TableColumn column4 = new TableColumn(tableView, SWT.NONE);
            column4.setText("Дата приёма");
            column4.setWidth(240);

            TableColumn column5 = new TableColumn(tableView, SWT.NONE);
            column5.setText("ФИО доктора");
            column5.setWidth(140);

            TableColumn column6 = new TableColumn(tableView, SWT.NONE);
            column6.setText("Заключение");
            column6.setWidth(140);


            for (int i = 0; i < 10; i++) {
                TableItem item = new TableItem(tableView, SWT.NONE);
            }

            Composite controlButtons = new Composite(shell, SWT.NONE);
            controlButtons.setLayout(new RowLayout());

            Button firstButton = new Button(controlButtons, SWT.NONE);
            Button prevPage = new Button(controlButtons, SWT.NONE);
            Button nextPage = new Button(controlButtons, SWT.NONE);
            Button lastButton = new Button(controlButtons, SWT.NONE);
            Label pagesLabel = new Label(controlButtons, SWT.NONE);

            Image image1 = new Image(display, "button1.0.png");
            Image image2 = new Image(display, "button2.0.png");
            Image image3 = new Image(display, "button1.png");
            Image image4 = new Image(display, "button2.png");

            firstButton.setImage(image1);
            lastButton.setImage(image2);
            prevPage.setImage(image3);
            nextPage.setImage(image4);

            pagesLabel.setText("0/0");

            firstButton.addSelectionListener(new FirstButtonListener(tableView, pageControl, controller, pagesLabel));

            firstButton.addSelectionListener(new FirstButtonListener(tableView, pageControl, controller, pagesLabel));

            lastButton.addSelectionListener(new LastButtonListener(tableView, pageControl, controller, pagesLabel));

            nextPage.addSelectionListener(new NextButtonListener(tableView, pageControl, controller, pagesLabel));

            prevPage.addSelectionListener(new PrevButtonListener(tableView, pageControl, controller, pagesLabel));

            startFindButton.addSelectionListener(new SelectionAdapter() {
                public void widgetSelected(SelectionEvent event1) {
                    findVector = base;
                    if (!arrayOfText[0].getText().equals("")) {
                        controller.deleteElementsOfBase(findVector);

                        vectorOfAnswers = findController.findNoteByLastNamesPatient(arrayOfText[0].getText(), findVector);
                        findVector = vectorOfAnswers;

                        for (int i = 0; i < findVector.size(); i++) {
                            controller.setItemOfTable(findVector.get(i));
                        }
                    }

                    if (!arrayOfText[1].getText().equals("")) {
                        controller.deleteElementsOfBase(findVector);

                        vectorOfAnswers = findController.findNoteByPlaceOfResidence(arrayOfText[1].getText(), findVector);
                        findVector = vectorOfAnswers;

                        for (int i = 0; i < findVector.size(); i++) {
                            controller.setItemOfTable(findVector.get(i));
                        }
                    }
                    if (!arrayOfText[2].getText().equals("")) {
                        controller.deleteElementsOfBase(findVector);

                        try {
                            vectorOfAnswers = findController.findNoteByDateOfBirth(arrayOfText[2].getText(), findVector);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        findVector = vectorOfAnswers;

                        for (int i = 0; i < findVector.size(); i++) {
                            controller.setItemOfTable(findVector.get(i));
                        }
                    }
                    if (!arrayOfText[3].getText().equals("")) {
                        controller.deleteElementsOfBase(findVector);

                        try {
                            vectorOfAnswers = findController.findNoteByDateOfReceipt(arrayOfText[3].getText(), findVector);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                        findVector = vectorOfAnswers;

                        for (int i = 0; i < findVector.size(); i++) {
                            controller.setItemOfTable(findVector.get(i));
                        }
                    }
                    if (!arrayOfText[4].getText().equals("")) {
                        controller.deleteElementsOfBase(findVector);

                        vectorOfAnswers = findController.findNoteByDoctorName(arrayOfText[4].getText(), findVector);
                        findVector = vectorOfAnswers;

                        for (int i = 0; i < findVector.size(); i++) {
                            controller.setItemOfTable(findVector.get(i));
                        }
                    }


                    SeeTable seeTable = new SeeTable();
                    seeTable.seeTable(tableView, pageControl.getPage(), vectorOfAnswers, pagesLabel);


                }
            });

            shell.pack();
            shell.open();
        }
    }

