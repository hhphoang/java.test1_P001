package org.example.utils;


import org.example.entities.Department;
import org.example.entities.Employee;

import java.util.Arrays;
import java.util.List;

public class Validator {

    private static final List<String> VALID_TITLES = Arrays.asList("Mr", "Mrs", "Ms");
    private static final List<String> VALID_DOMAINS = Arrays.asList("FIN", "MAR", "ADM", "HRM", "CRM", "TCD", "TOD");
    
    public static boolean validateId(String id, String object) {
        if (id.length() != 7) {
            return false;
        }

        String prefix = id.substring(0, 2);
        if (object.equals("employee")) {
            if (!prefix.equals("EM")) return false;
        }
        else if (object.equals("department")) {
            if (!prefix.equals("DE")) return false;
        }

        String digits = id.substring(2);
        return digits.matches("^\\d{5}$");
    }

    public static boolean validateTitleEmployee(String title) {
        return VALID_TITLES.contains(title);
    }

    public static boolean validateDomain(String domain) {
        return VALID_DOMAINS.contains(domain);
    }

    public static boolean isSameDomain(Employee e, Department d) {
        return e.getWorkingDomain().equalsIgnoreCase(d.getDomain());
    }

    public static boolean isStringNotNull(String input) {
        return !input.isEmpty();
    }

}
