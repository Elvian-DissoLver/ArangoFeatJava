package com.ArangoTest;

import java.io.Closeable;
import java.util.List;

public interface ArangoTest<T> extends Closeable {
    List<String> getHeader();

    SampleFile getSample();
}
