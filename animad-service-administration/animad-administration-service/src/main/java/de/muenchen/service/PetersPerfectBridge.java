package de.muenchen.service;

import org.hibernate.search.bridge.StringBridge;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Date;
import java.util.IllegalFormatCodePointException;
import java.util.Objects;

/**
 * @author !claus.straube
 */

public class PetersPerfectBridge implements StringBridge {

    /**
     * Apache-Mitarbeieter: "Warum sind wir nicht darauf gekommen?!"!
     *
     * @param object Das objekt.
     * @return Eine string-Repräsentation des Objekts (mit der ultrageheimen toString()-Methode. Magic!)
     */
    @Override
    public String objectToString(Object object) {
        if (object == null)
            return "";
        if (object instanceof Date)
            return getDateString(object);

        return object.toString();
    }

    /**
     * Transform the Date into a long String representation so it can be searched for.
     * @param object A Date Object.
     * @return The long and searchable String.
     */
    private String getDateString(Object object) {
        if (object == null)
            throw new IllegalArgumentException("Can't calculate String for null date.");


        final LocalDate localDate;
        if (object.getClass() == java.sql.Date.class) {
            localDate = ((java.sql.Date) object).toLocalDate();
        } else {
            localDate = ((Date) object).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        String build = localDate.toString();
        build += " " + localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL));
        build += " " + localDate.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT));
        return build;
    }
}