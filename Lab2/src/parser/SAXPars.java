package parser;

import model.DoctorReport;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class SAXPars extends DefaultHandler {
    Vector<DoctorReport> array = new Vector<DoctorReport>(0);
    DoctorReport item = null;
    String thisElement = "";

    public Vector<DoctorReport> getResult() {
        return array;
    }


    public void startDocument() {
        System.out.println("Start parse XML...");
    }


    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {

        thisElement = qName;
        if (thisElement.equals("note"))
            item = new DoctorReport();
    }


    public void endElement(String namespaceURI, String localName, String qName) {
        if (qName.equals("note"))
            array.addElement(item);
        thisElement = "";
    }


    public void characters(char[] ch, int start, int length) {
        DateFormat format = new SimpleDateFormat("dd:MM:yyyy");
        if (thisElement.equals("patientName")) {
            item.setPatientName(new String(ch, start, length));
        }
        if (thisElement.equals("placeOfResidence")) {
            item.setPlaceOfResidence(new String(ch, start, length));
        }
        if (thisElement.equals("dateOfBirth")) {
            try {
                item.setDateOfBirth(format.parse(new String(ch, start, length)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals("dateOfReceipt")) {
            try {
                item.setDateOfReceipt(format.parse(new String(ch, start, length)));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (thisElement.equals("doctorName")) {
            item.setDoctorName(new String(ch, start, length));
        }
        if (thisElement.equals("conclusion")) {
            item.setConclusion(new String(ch, start, length));
        }
    }


    public void endDocument() {
        System.out.println("Stop parse XML...");
    }
}
