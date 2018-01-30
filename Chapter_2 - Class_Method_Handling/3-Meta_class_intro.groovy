// Adding ordinalIndexOf as metaclass to String Objects
import org.apache.commons.lang3.StringUtils

class Line_Access{
        Line_Access()
        {
            String.metaClass.ordinalIndexOf { String searchStr, int ordinal ->
                StringUtils.ordinalIndexOf(delegate, searchStr, ordinal)
            }
        }
}
