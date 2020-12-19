package controller;

import model.DoctorReport;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import parser.SAXPars;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Controller {
    private List<DoctorReport> table = new ArrayList<>(0);


    public List<DoctorReport> findNoteByLastNamesPatient(String patientName, List<DoctorReport> findingList) {
        List<DoctorReport> needToFind = new ArrayList<>(0);
        for (int i = 0; i < findingList.size(); i++) {
                if (patientName.contains(findingList.get(i).getPatientName()))
                    needToFind.add(findingList.get(i));
        }
        return needToFind;
    }
    public List<DoctorReport> findNoteByPlaceOfResidence(String placeOfResidence, List<DoctorReport> findingList) {
        List<DoctorReport> needToFind = new ArrayList<>(0);
        for (int i = 0; i < findingList.size(); i++) {
            if (placeOfResidence.contains(findingList.get(i).getPlaceOfResidence()))
                needToFind.add(findingList.get(i));
        }
        return needToFind;
    }
    public List<DoctorReport> findNoteByDateOfBirth(String dateOfBirth, List<DoctorReport> findingList) throws ParseException {
        List<DoctorReport> needToFind = new ArrayList<>(0);
        DateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        Date dateDateOfBirth  = format.parse(dateOfBirth);
        for (int i = 0; i < findingList.size(); i++) {
            if (String.valueOf(dateDateOfBirth).equals(findingList.get(i).getDateOfBirth()))
                needToFind.add(findingList.get(i));
        }
        return needToFind;
    }
    public List<DoctorReport> findNoteByDateOfReceipt(String dateOfReceipt, List<DoctorReport> findingList) throws ParseException {
        List<DoctorReport> needToFind = new ArrayList<>(0);
        DateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        Date dateDateOfReceipt  = format.parse(dateOfReceipt);
        for (int i = 0; i < findingList.size(); i++) {
            if (String.valueOf(dateDateOfReceipt).equals(findingList.get(i).getDateOfReceipt()))
                needToFind.add(findingList.get(i));
        }
        return needToFind;
    }
    public List<DoctorReport> findNoteByDoctorName(String doctorName, List<DoctorReport> findingList) {
        List<DoctorReport> needToFind = new ArrayList<>(0);
        for (int i = 0; i < findingList.size(); i++) {
            if (doctorName.contains(findingList.get(i).getDoctorName()))
                needToFind.add(findingList.get(i));
        }
        return needToFind;
    }




    public void deleteElementsOfBase(List<DoctorReport> needDeleteElements) {
        for (int i = 0; i < needDeleteElements.size(); i++)
            table.remove(needDeleteElements.get(i));
    }

    public void save(String nameOfFile) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = builder.newDocument();
        Element root = document.createElement("base");
        document.appendChild(root);
        DateFormat formatDate = new SimpleDateFormat("dd:MM:yyyy");
        for (int i = 0; i < table.size(); i++) {
            Element note = document.createElement("note");

            Element patientNameEl = document.createElement("patientName");
            Element placeOfResidenceEl = document.createElement("placeOfResidence");
            Element dateOfBirthEl = document.createElement("dateOfBirth");
            Element dateOfReceiptEl = document.createElement("dateOfReceipt");
            Element doctorNameExamEl = document.createElement("doctorName");
            Element conclusionEl = document.createElement("conclusion");



            Text patientName = document.createTextNode(table.get(i).getPatientName());
            Text placeOfResidence = document.createTextNode(table.get(i).getPlaceOfResidence());
            Text dateOfBirth = document.createTextNode(formatDate.format(table.get(i).getDateOfBirth()));
            Text dateOfReceipt = document.createTextNode(formatDate.format(table.get(i).getDateOfReceipt()));
            Text doctorNameExam = document.createTextNode(table.get(i).getDoctorName());
            Text conclusion = document.createTextNode(table.get(i).getConclusion());



            note.appendChild(patientNameEl);
            note.appendChild(placeOfResidenceEl);
            note.appendChild(dateOfBirthEl);
            note.appendChild(dateOfReceiptEl);
            note.appendChild(doctorNameExamEl);
            note.appendChild(conclusionEl);

            patientNameEl.appendChild(patientName);
            placeOfResidenceEl.appendChild(placeOfResidence);
            dateOfBirthEl.appendChild(dateOfBirth);
            dateOfReceiptEl.appendChild(dateOfReceipt);
            doctorNameExamEl.appendChild(doctorNameExam);
            conclusionEl.appendChild(conclusion);

            root.appendChild(note);
        }
        Transformer transformer = null;
        try {
            transformer = TransformerFactory.newInstance().newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        try {
            transformer.transform(new DOMSource(document), new StreamResult(new FileOutputStream(nameOfFile)));
        } catch (TransformerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void load(String nameOfFile) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            SAXPars saxp = new SAXPars();

            parser.parse(new File(nameOfFile), saxp);
            table = saxp.getResult();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setItemOfTable(DoctorReport item) {
        table.add(item);
    }

    public List<DoctorReport> getTable() {
        return table;
    }
}
