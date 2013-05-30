package com.sigmasys.bsinas.gwt.client.service.validator;

import com.allen_sauer.gwt.log.client.Log;
import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.extjs.gxt.ui.client.widget.form.Validator;
import com.sigmasys.bsinas.gwt.client.util.StringUtils;

/**
 * Validates against hardcoded datetime formats: HH24:MI:SS or HH24:MI:SS.FF3
 *
 * @author Michael Ivanov
 */
public class TimeFormatValidator implements Validator {

    public static enum TSFormatType {
        // seconds or milliseconds
        DEFAULT {
            @Override
            public String errorMessage() {
                return "Valid format is HH24:MI:SS or HH24:MI:SS.FF3";
            }

            @Override
            public int colonSeparatedParts() {
                return 3;
            }
        },
        SECONDS {
            @Override
            public String errorMessage() {
                return "Valid format is HH24:MI:SS";
            }

            @Override
            public int colonSeparatedParts() {
                return 3;
            }
        },
        MINUTES {
            @Override
            public String errorMessage() {
                return "Valid format is HH24:MI";
            }

            @Override
            public int colonSeparatedParts() {
                return 2;
            }
        };

        abstract String errorMessage();

        abstract int colonSeparatedParts();
    }

    private final TSFormatType type;

    public TimeFormatValidator() {
        this(TSFormatType.DEFAULT);
    }

    private TimeFormatValidator(TSFormatType type) {
        this.type = type;
    }

    public static TimeFormatValidator seconds() {
        return new TimeFormatValidator(TSFormatType.SECONDS);
    }

    public static TimeFormatValidator minutes() {
        return new TimeFormatValidator(TSFormatType.MINUTES);
    }

    public String validate(Field<?> field, String value) {

        if (StringUtils.isEmpty(value) && (field instanceof TextField)) {
            return ((TextField) field).getAllowBlank() ? null : "Time field cannot be empty";
        }

        String[] parts = value.split(":");
        if (parts.length != type.colonSeparatedParts()) {
            return type.errorMessage();
        }

        try {
            validate(parts[0], 2, 0, 23, "hours");

            validate(parts[1], 2, 0, 59, "minutes");

            if (parts.length == 3) {
                if (parts[2] == null || parts[2].contains(" ")) {
                    throw new IllegalArgumentException(type.errorMessage() + ", no white spaces allowed");
                }
                if (parts[2].endsWith(".")) {
                    throw new IllegalArgumentException(type.errorMessage() + ", enter milliseconds after dot");
                }
                String[] secondsParts = parts[2].split("\\.");
                if (secondsParts == null || secondsParts.length > 2) {
                    throw new IllegalArgumentException(type.errorMessage() + ", too many dots");
                }
                validate(secondsParts[0], 2, 0, 59, "seconds");
                if (secondsParts.length == 1) {
                    return null;
                }
                validate(secondsParts[1], 3, 0, 999, "milliseconds");
            }

        } catch (NumberFormatException e) {
            Log.debug("user input validation: " + e.getMessage());
            return type.errorMessage();
        } catch (IllegalArgumentException e) {
            Log.debug("user input validation: " + e.getMessage());
            return e.getMessage();
        } catch (Exception e) {
            Log.debug("user input validation: " + e.getMessage());
            return type.errorMessage();
        }

        return null;
    }

    private void validate(String part, int length, int min, int max, String obj) {
        if (part == null || part.contains(" ")) {
            throw new IllegalArgumentException(type.errorMessage() + ", no white spaces allowed");
        }
        if (part.length() != length) {
            throw new IllegalArgumentException(type.errorMessage() + ", enter two symbols for " + obj);
        }
        int hours = Integer.parseInt(part);
        if (hours < min || hours > max) {
            throw new IllegalArgumentException(type.errorMessage() + ", number of " + obj + " is incorrect");
        }
    }
}