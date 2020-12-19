package view;

import controller.Controller;
import model.DoctorReport;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.RowData;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class DeleteMenu {
    List<DoctorReport> vectorOfAnswers = new ArrayList<>(0);
    List<DoctorReport> findVector = null;

    public void setWorkSpace(List<DoctorReport> base, Controller mainController) {
        Controller findController = new Controller();
        findVector = base;

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

        Label answer = new Label(shell, SWT.NONE);
        RowData size = new RowData();
        size.height = 30;
        size.width = 250;
        answer.setLayoutData(size);

        Button deleteButton = new Button(shell, SWT.NONE);
        deleteButton.setText("Удалить");
        deleteButton.addSelectionListener(new SelectionAdapter() {
            public void widgetSelected(SelectionEvent event1) {
                findVector = base;
                if (!arrayOfText[0].getText().equals("")) {

                    vectorOfAnswers = findController.findNoteByLastNamesPatient(arrayOfText[0].getText(), findVector);
                    findVector = vectorOfAnswers;

                }
                if (!arrayOfText[1].getText().equals("")) {

                    vectorOfAnswers = findController.findNoteByPlaceOfResidence(arrayOfText[1].getText(), findVector);
                    findVector = vectorOfAnswers;

                }
                if (!arrayOfText[2].getText().equals("")) {


                    try {
                        vectorOfAnswers = findController.findNoteByDateOfBirth(arrayOfText[2].getText(), findVector);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }

                    findVector = vectorOfAnswers;

                }
                if (!arrayOfText[3].getText().equals("")) {

                    try {
                        vectorOfAnswers = findController.findNoteByDateOfReceipt(arrayOfText[3].getText(), findVector);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    findVector = vectorOfAnswers;

                }
                if (!arrayOfText[4].getText().equals("")) {

                    vectorOfAnswers = findController.findNoteByDoctorName(arrayOfText[4].getText(), findVector);
                    findVector = vectorOfAnswers;

                }
                if (vectorOfAnswers.size() == 0)
                    answer.setText("нечего удалить");
                else
                    answer.setText(vectorOfAnswers.size() + " элементов удалено");
                mainController.deleteElementsOfBase(vectorOfAnswers);

            }
        });

        shell.pack();
        shell.open();
    }
}
