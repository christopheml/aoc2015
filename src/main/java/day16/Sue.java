package day16;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sue {

    private static final Pattern DESCRIPTION_PATTERN = Pattern.compile("^Sue (\\d+): (\\w+): (\\d+), (\\w+): (\\d+), (\\w+): (\\d+)$");

    private final Map<String, Integer> attributes = new HashMap<>();

    private final String name;

    public Sue(String name) {
        this.name = name;
    }

    private void setAttribute(String name, int value) {
        attributes.put(name, value);
    }

    boolean hasAttribute(String name, int value) {
        var attributeValue = attributes.get(name);
        return attributeValue == null || attributeValue == value;
    }

    static Sue parse(String description) {
        Matcher matcher = DESCRIPTION_PATTERN.matcher(description);
        if (matcher.matches()) {
            var sue = new Sue(matcher.group(1));
            sue.setAttribute(matcher.group(2), Integer.parseInt(matcher.group(3)));
            sue.setAttribute(matcher.group(4), Integer.parseInt(matcher.group(5)));
            sue.setAttribute(matcher.group(6), Integer.parseInt(matcher.group(7)));
            return sue;
        }
        throw new IllegalArgumentException(description);
    }

    public String getName() {
        return name;
    }

}
