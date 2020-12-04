package zip.lingalazip4j;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.io.inputstream.ZipInputStream;
import net.lingala.zip4j.model.FileHeader;
import net.lingala.zip4j.model.LocalFileHeader;
import net.lingala.zip4j.util.Zip4jUtil;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.TimeZone;

import static org.apache.commons.io.FilenameUtils.getExtension;

public class Unzip {

    public static void main(String[] args) throws ZipException, FileNotFoundException {

//        String targetFilePath = "/home/gbozsik/Documents/efd_allomanyok/zip/SummaryHUN202007.xls.zip";
        String targetFilePath = "/home/gbozsik/Documents/efd_allomanyok/zip/SummaryHUN202007.xls.zip";
        String destinationFilePath = "/home/gbozsik/Documents/efd_allomanyok/zip/with_my_password/extracted";
//        String destinationFilePath = "/home/gbozsik/Documents/efd_allomanyok/zip/SummaryHUN202007.xls.zip";
//        String password = "hun@7935";
        String password = "hun@7935";
//        Unzip.unzip(targetFilePath, targetFolderPath, password);
//        Unzip.unZipItems(targetFilePath, destinationFilePath, password);
//        Unzip.unZipFromFile(targetFilePath, destinationFilePath, password);
        Unzip.readFromStream();
    }

    public static void unzip(String targetZipFilePath, String destinationFolderPath, String password) {
        if (!Zip4jUtil.isStringNotNullAndNotEmpty(targetZipFilePath) || !Zip4jUtil.isStringNotNullAndNotEmpty(destinationFolderPath)) {
//            if (callback != null) callback.onFinish(false);
            return;
        }
//        ZipLog.debug("unzip: targetZipFilePath=" + targetZipFilePath + " , destinationFolderPath=" + destinationFolderPath + " , password=" + password);
        try {
            ZipFile zipFile = new ZipFile(targetZipFilePath);
            if (zipFile.isEncrypted() && Zip4jUtil.isStringNotNullAndNotEmpty(password)) {
                zipFile.setPassword(password.toCharArray());
            }
            zipFile.setRunInThread(true);
//            zipFile.extractAll(destinationFolderPath);
            zipFile.extractFile("SummaryHUN202007.xls.zip", destinationFolderPath, "unzippedFile");
//            timerMsg(callback, zipFile);
        } catch (Exception e) {
//            if (callback != null) callback.onFinish(false);
//            ZipLog.debug("unzip: Exception=" + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public static void unZipItems(final String filePath, final String outputFolder, final String password) {

        if (getExtension(filePath).equals("zip")) {
            try {
                ZipFile zipFile = new ZipFile(filePath);
                zipFile.setPassword(password.toCharArray());
                zipFile.extractAll(outputFolder);
                List<File> files = zipFile.getSplitZipFiles();
                files.forEach(file -> System.out.println("file name: " + file.getName()));
                List<File> filesSplit = zipFile.getSplitZipFiles();
                filesSplit.forEach(file -> System.out.println("file split name: " + file.getName()));
                List<FileHeader> fileHeaders = zipFile.getFileHeaders();
                fileHeaders.forEach(fileHeader -> System.out.println("toString: " + fileHeader.toString()));
                fileHeaders.forEach(fileHeader -> System.out.println("filename: " + fileHeader.getFileName()));
//                zipFile.getInputStream();
//                IO_LOGGER.info("All files have been successfully extracted!");
//                response = Status.OK;
            } catch (ZipException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("not found");
        }
    }

    public static void unZipFromFile(String targetFilepath, String outputFolder, String password) throws ZipException {
        if (password != null) {
            File file = writeFile(targetFilepath);
            ZipFile zipFile = new ZipFile(file);
            zipFile.setPassword(password.toCharArray());
            zipFile.getFileHeaders().forEach(fileHeader -> {
                System.out.println(fileHeader);
                System.out.println("last mod: " + fileHeader.getLastModifiedTime());
                System.out.println("zone id: " + fileHeader.getUncompressedSize());
                System.out.println("last mod: " + LocalDateTime.ofInstant(Instant.ofEpochMilli(Zip4jUtil.dosToJavaTme(fileHeader.getLastModifiedTime())), ZoneId.systemDefault()));
                System.out.println("last mod 2: " + LocalDateTime.ofInstant(Instant.ofEpochSecond(fileHeader.getLastModifiedTime()), TimeZone.getDefault().toZoneId()));

            });
            zipFile.extractAll(outputFolder);

        }
    }

    private static File writeFile(String targetFilePath) {
        try {
            InputStream fileInputStream = new FileInputStream(targetFilePath);
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
//            ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);

//            File file = new File("/home/gbozsik/Documents/efd_allomanyok/zip/with_my_password/fromStream");
            File file = File.createTempFile("tmpFileName", "");
            OutputStream outStream = new FileOutputStream(file);
            IOUtils.copy(fileInputStream, outStream);
            outStream.close();
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void readFromStream() throws FileNotFoundException {


        LocalFileHeader localFileHeader;
        int readLen;
        byte[] readBuffer = new byte[4096];
        String password = "t";
        InputStream inputStream = new FileInputStream("/home/gbozsik/Documents/efd_allomanyok/zip/withPassAndSubFolder.zip");


        try (ZipInputStream zipInputStream = new ZipInputStream(inputStream, password.toCharArray())) {
            while ((localFileHeader = zipInputStream.getNextEntry()) != null) {
                while ((readLen = zipInputStream.read(readBuffer)) != -1) {

                }
                System.out.println("file: " + localFileHeader.getFileName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
