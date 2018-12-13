/**
 * Copyright 2012 Andy Turner, The University of Leeds, UK
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package uk.ac.leeds.ccg.andyt.generic.io;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.TreeSet;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author geoagdt
 */
public class Generic_IOTest {

    public Generic_IOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void tests() {
        //testRecursiveFileList();
        //testRecursiveFileList_2args
        testGetArchiveLeafFiles();
    }

    /**
     * Test of recursiveFileList method, of class Generic_IO.
     */
    public void testRecursiveFileList() {
        System.out.println("recursiveFileList");
        File file = new File("/scratch01/test/testdir/");
        file.mkdirs();
        File newfile;
        for (int i = 0; i < 2; i++) {
            newfile = new File(file, "dir" + i);
            newfile.mkdirs();
            for (int j = 0; j < 2; j++) {
                File newnewfile = new File(newfile, "file" + j);
                try {
                    newnewfile.createNewFile();
                } catch (IOException e) {
                }
            }
        }
        TreeSet expResult = null;
        TreeSet result = Generic_IO.recursiveFileList(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recursiveFileList method, of class Generic_IO.
     */
    public void testRecursiveFileList_2args() {
        System.out.println("recursiveFileList_2args");
        File file = new File("/");
//        File file = new File("/scratch01/test/testdir/");
//        file.mkdirs();
//        File newfile;
//        for (int i = 0; i < 2; i++) {
//            newfile = new File(file, "dir" + i);
//            newfile.mkdirs();
//            for (int j = 0; j < 2; j++) {
//                File newnewfile = new File(newfile, "file" + j);
//                try {
//                    newnewfile.createNewFile();
//                } catch (IOException e){}
//            }
//        }
        TreeSet expResult = null;
        TreeSet result = Generic_IO.recursiveFileList(file, 1);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of writeObject method, of class Generic_IO.
     */
    public void testGetArchiveLeafFiles() {
        String tmpdir = System.getProperty("java.io.tmpdir");
        File dir = new File(tmpdir);
        File f = new File(dir, "tmpArchive");
        System.out.println(f);
        f.mkdirs();
        long range = 100;
        long sizeOfArchive = 1001; //1000;
        Generic_IO.initialiseArchive(f, range);
        for (long id = 0; id < sizeOfArchive; id++) {
            Generic_IO.addToArchive(f, range, id);
        }
        System.out.println(
                "initialised archive with " + sizeOfArchive + " files");
        String underscore = "_";
        HashSet<File> leaves = Generic_IO.getArchiveLeafFilesSet(f, underscore);
        System.out.println(leaves.size());
        long[] deletedCounts = Generic_IO.delete(f);
        System.out.println(
                "deleted archive which contained " + deletedCounts[0]
                + " files and " + deletedCounts[1] + " directories");
    }

//    /**
//     * Test of writeObject method, of class Generic_IO.
//     */
//    @Test
//    public void testWriteObject() {
//        System.out.println("writeObject");
//        Object object = null;
//        File file = null;
//        Generic_IO.writeObject(object, file);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of readObject method, of class Generic_IO.
//     */
//    @Test
//    public void testReadObject() {
//        System.out.println("readObject");
//        File file = null;
//        Object expResult = null;
//        Object result = Generic_IO.readObject(file);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copyFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCopyFile_File_File() {
//        System.out.println("copyFile");
//        File input_File = null;
//        File outputDirectory_File = null;
//        Generic_IO.copyFile(input_File, outputDirectory_File);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copyFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCopyFile_3args() {
//        System.out.println("copyFile");
//        File input_File = null;
//        File outputDirectory_File = null;
//        String outputFileName = "";
//        Generic_IO.copyFile(input_File, outputDirectory_File, outputFileName);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copyDirectory method, of class Generic_IO.
//     */
//    @Test
//    public void testCopyDirectory() {
//        System.out.println("copyDirectory");
//        File a_DirectoryToCopy_File = null;
//        File a_DirectoryToCopyInto_File = null;
//        Generic_IO.copyDirectory(a_DirectoryToCopy_File, a_DirectoryToCopyInto_File);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of copy method, of class Generic_IO.
//     */
//    @Test
//    public void testCopy() {
//        System.out.println("copy");
//        File a_FileOrDirectoryToCopy_File = null;
//        File a_DirectoryToCopyInto_File = null;
//        Generic_IO.copy(a_FileOrDirectoryToCopy_File, a_DirectoryToCopyInto_File);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteDirectory method, of class Generic_IO.
//     */
//    @Test
//    public void testDeleteDirectory() {
//        System.out.println("deleteDirectory");
//        File _Directory = null;
//        long[] expResult = null;
//        long[] result = Generic_IO.deleteDirectory(_Directory);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTempFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateTempFile_0args() {
//        System.out.println("createTempFile");
//        File expResult = null;
//        File result = Generic_IO.createTempFile();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTempFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateTempFile_File() {
//        System.out.println("createTempFile");
//        File parentDirectory = null;
//        File expResult = null;
//        File result = Generic_IO.createTempFile(parentDirectory);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createTempFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateTempFile_3args() {
//        System.out.println("createTempFile");
//        File parentDirectory = null;
//        String prefix = "";
//        String suffix = "";
//        File expResult = null;
//        File result = Generic_IO.createTempFile(parentDirectory, prefix, suffix);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createNewFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateNewFile_0args() {
//        System.out.println("createNewFile");
//        File expResult = null;
//        File result = Generic_IO.createNewFile();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createNewFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateNewFile_File() {
//        System.out.println("createNewFile");
//        File parentDirectory = null;
//        File expResult = null;
//        File result = Generic_IO.createNewFile(parentDirectory);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createNewFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateNewFile_3args() {
//        System.out.println("createNewFile");
//        File parentDirectory = null;
//        String prefix = "";
//        String suffix = "";
//        File expResult = null;
//        File result = Generic_IO.createNewFile(parentDirectory, prefix, suffix);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createNewFile method, of class Generic_IO.
//     */
//    @Test
//    public void testCreateNewFile_File_String() {
//        System.out.println("createNewFile");
//        File parentDirectory = null;
//        String filename = "";
//        File expResult = null;
//        File result = Generic_IO.createNewFile(parentDirectory, filename);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStreamTokenizerSyntax1 method, of class Generic_IO.
//     */
//    @Test
//    public void testSetStreamTokenizerSyntax1() {
//        System.out.println("setStreamTokenizerSyntax1");
//        StreamTokenizer aStreamTokenizer = null;
//        Generic_IO.setStreamTokenizerSyntax1(aStreamTokenizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStreamTokenizerSyntax2 method, of class Generic_IO.
//     */
//    @Test
//    public void testSetStreamTokenizerSyntax2() {
//        System.out.println("setStreamTokenizerSyntax2");
//        StreamTokenizer aStreamTokenizer = null;
//        Generic_IO.setStreamTokenizerSyntax2(aStreamTokenizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStreamTokenizerSyntax3 method, of class Generic_IO.
//     */
//    @Test
//    public void testSetStreamTokenizerSyntax3() {
//        System.out.println("setStreamTokenizerSyntax3");
//        StreamTokenizer aStreamTokenizer = null;
//        Generic_IO.setStreamTokenizerSyntax3(aStreamTokenizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStreamTokenizerSyntax4 method, of class Generic_IO.
//     */
//    @Test
//    public void testSetStreamTokenizerSyntax4() {
//        System.out.println("setStreamTokenizerSyntax4");
//        StreamTokenizer aStreamTokenizer = null;
//        Generic_IO.setStreamTokenizerSyntax4(aStreamTokenizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of setStreamTokenizerSyntax5 method, of class Generic_IO.
//     */
//    @Test
//    public void testSetStreamTokenizerSyntax5() {
//        System.out.println("setStreamTokenizerSyntax5");
//        StreamTokenizer aStreamTokenizer = null;
//        Generic_IO.setStreamTokenizerSyntax5(aStreamTokenizer);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getObjectDirectory method, of class Generic_IO.
//     */
//    @Test
//    public void testGetObjectDirectory() {
//        System.out.println("getObjectDirectory");
//        File directory = null;
//        long a_ID = 0L;
//        long max_ID = 0L;
//        long range = 0L;
//        File expResult = null;
//        File result = Generic_IO.getObjectDirectory(directory, a_ID, max_ID, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of initialiseArchive method, of class Generic_IO.
//     */
//    @Test
//    public void testInitialiseArchive() {
//        System.out.println("initialiseArchive");
//        File directory = null;
//        long range = 0L;
//        File expResult = null;
//        File result = Generic_IO.initialiseArchive(directory, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getArchiveHighestLeaf method, of class Generic_IO.
//     */
//    @Test
//    public void testGetHighestLeaf() {
//        System.out.println("getHighestLeaf");
//        File directory = null;
//        String underscore = "";
//        Long expResult = null;
//        Long result = Generic_IO.getArchiveHighestLeaf(directory, underscore);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getArchiveRange method, of class Generic_IO.
//     */
//    @Test
//    public void testGetArchiveRange() {
//        System.out.println("getArchiveRange");
//        File directory = null;
//        String underscore = "";
//        long expResult = 0L;
//        long result = Generic_IO.getArchiveRange(directory, underscore);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getArchiveHighestLeafFile method, of class Generic_IO.
//     */
//    @Test
//    public void testGetHighestLeafFile() {
//        System.out.println("getHighestLeafFile");
//        File directory = null;
//        String underscore = "";
//        File expResult = null;
//        File result = Generic_IO.getArchiveHighestLeafFile(directory, underscore);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of growArchiveBase method, of class Generic_IO.
//     */
//    @Test
//    public void testGrowArchiveBase_File_long() {
//        System.out.println("growArchiveBase");
//        File directory = null;
//        long range = 0L;
//        File expResult = null;
//        File result = Generic_IO.growArchiveBase(directory, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of growArchiveBase method, of class Generic_IO.
//     */
//    @Test
//    public void testGrowArchiveBase_3args() {
//        System.out.println("growArchiveBase");
//        File directory = null;
//        long range = 0L;
//        long next_ID = 0L;
//        File expResult = null;
//        File result = Generic_IO.growArchiveBase(directory, range, next_ID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addToArchive method, of class Generic_IO.
//     */
//    @Test
//    public void testAddToArchive_File_long() {
//        System.out.println("addToArchive");
//        File directory0 = null;
//        long range = 0L;
//        File expResult = null;
//        File result = Generic_IO.addToArchive(directory0, range);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addToArchive method, of class Generic_IO.
//     */
//    @Test
//    public void testAddToArchive_3args() {
//        System.out.println("addToArchive");
//        File directory0 = null;
//        long range = 0L;
//        long next_ID = 0L;
//        File expResult = null;
//        File result = Generic_IO.addToArchive(directory0, range, next_ID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFilename method, of class Generic_IO.
//     */
//    @Test
//    public void testGetFilename() {
//        System.out.println("getFilename");
//        File directory = null;
//        File a_File = null;
//        String expResult = "";
//        String result = Generic_IO.getFilename(directory, a_File);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumericalOrderFilesWithNumericalFilenames_TreeMap method, of class Generic_IO.
//     */
//    @Test
//    public void testGetNumericalOrderFilesWithNumericalFilenames_TreeMap() {
//        System.out.println("getNumericalOrderFilesWithNumericalFilenames_TreeMap");
//        File[] files = null;
//        TreeMap expResult = null;
//        TreeMap result = Generic_IO.getNumericalOrderFilesWithNumericalFilenames_TreeMap(files);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumericalOrderFilesWithNumericalUnderscoreFilenames_TreeMap method, of class Generic_IO.
//     */
//    @Test
//    public void testGetNumericalOrderFilesWithNumericalUnderscoreFilenames_TreeMap() {
//        System.out.println("getNumericalOrderFilesWithNumericalUnderscoreFilenames_TreeMap");
//        File[] files = null;
//        String underscore = "";
//        TreeMap expResult = null;
//        TreeMap result = Generic_IO.getNumericalOrderFilesWithNumericalUnderscoreFilenames_TreeMap(files, underscore);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getNumericalAndNumericalUnderscoreFilenames_HashMap method, of class Generic_IO.
//     */
//    @Test
//    public void testGetNumericalAndNumericalUnderscoreFilenames_HashMap() {
//        System.out.println("getNumericalAndNumericalUnderscoreFilenames_HashMap");
//        File directory = null;
//        String underscore = "";
//        HashMap expResult = null;
//        HashMap result = Generic_IO.getNumericalAndNumericalUnderscoreFilenames_HashMap(directory, underscore);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
