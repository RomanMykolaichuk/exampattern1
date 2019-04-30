/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.e4x.exampattern1.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.util.ResourceUtils;

/**
 *
 * @author User
 */
public class FilesReadWrite {

    private String fileName = "classpath:config/file1.txt";

    public FilesReadWrite() {
    }

    public FilesReadWrite(String fileName) {
        this.setFileName(fileName);
    }

    public String readFile() {
        File file;
        try {
            file = ResourceUtils.getFile(getFileName());
            return new String(Files.readAllBytes(file.toPath()));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FilesReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FilesReadWrite.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void writeFile(String content) throws FileNotFoundException, IOException {
        File file = ResourceUtils.getFile(getFileName());
        Files.write(file.toPath(), content.getBytes());
    }

    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
