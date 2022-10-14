package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A filter that represents the logical or of its child filters
 */
public class OrFilter implements Filter {
    private final ArrayList<Filter> children;

    public OrFilter(Filter firstChild, Filter secondChild) {
        children = new ArrayList<>();
        children.add(firstChild);
        children.add(secondChild);
    }

    /**
     * An or filter matches when either of its children match
     * @param s     the tweet to check
     * @return      whether or not it matches
     */
    @Override
    public boolean matches(Status s) {
        return children.get(0).matches(s) || children.get(1).matches(s);
    }

    @Override
    public List<String> terms() {
        List<String> newList = Stream.concat(children.get(0).terms().stream(), children.get(1).terms().stream())
                .collect(Collectors.toList());
        return newList;
    }

    public String toString() {
        return "(" + children.get(0).toString() + " or " + children.get(1).toString() + ")";
    }
}
