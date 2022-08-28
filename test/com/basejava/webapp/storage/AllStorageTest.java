package com.basejava.webapp.storage;

import org.junit.platform.suite.api.*;

@Suite
@SelectClasses({ArrayStorageTest.class, SortedArrayStorage.class, ListStorageTest.class,
        MapResumeStorageTest.class, MapUuidStorageTest.class})
public class AllStorageTest {
}
