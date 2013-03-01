package ru.fivestarter.orion.model.common;

/**
 * @author <a href='mailto:ystartsev@wiley.com'>Yury Startsev</a>
 * @version 01.03.13
 */
public class ModelConstraints {
    public static final int STRING_VARCHAR_255_LENGTH = 255;
    public static final int STRING_MEDIUM_TEXT_LENGTH = 2097152;


    private ModelConstraints() {
        throw new UnsupportedOperationException(getClass() + " is utility class and should never be instantiated");
    }
}
