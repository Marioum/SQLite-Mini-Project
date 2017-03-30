package com.example.dell.osapp;



import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 24/11/2016.
 */

public class XMLHandler {
    List<Os> oss;
    private Os os;
    private String text;

    public XMLHandler() {oss = new ArrayList<Os>();}
    public List<Os> getEmployees() {
        return oss;
    }

    public List<Os> parse(XmlPullParser myParser) {

        try {
            int eventType = myParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagname = myParser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagname.equalsIgnoreCase("os")) {
                            os = new Os();
                        }
                        break;

                    case XmlPullParser.TEXT:
                        text = myParser.getText();
                        break;

                    case XmlPullParser.END_TAG:
                        if (tagname.equalsIgnoreCase("os")) {
                            oss.add(os);
                        } else if (tagname.equalsIgnoreCase("name")) {
                            os.setName(text);
                        } else if (tagname.equalsIgnoreCase("image")) {
                            os.setImg(text);
                        } else if (tagname.equalsIgnoreCase("information")) {
                            os.setInfo(text);
                        }
                        break;

                    default:
                        break;
                }
                eventType = myParser.next();
            }

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return oss;
    }
}
