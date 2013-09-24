package com.fing.pis.bizativiti.plugin.xpdl.test;

import java.io.FileInputStream;
import java.io.InputStream;

import org.junit.Test;

import com.fing.pis.bizativiti.plugin.xpdl.Facade;

public class TranslatorTest {

    @Test
    public void testLoad() throws Exception {
        InputStream is = new FileInputStream("resources/startevent.xpdl");
        Facade xpdlPlugin = new Facade();
        xpdlPlugin.parse(is);
    }

}