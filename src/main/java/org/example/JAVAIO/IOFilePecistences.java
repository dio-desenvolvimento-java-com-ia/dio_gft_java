package org.example.JAVAIO;

import java.io.*;
import java.util.ArrayList;
import java.util.stream.Stream;

public class IOFilePecistences implements FilePercistence {

    /*
        Retorna o diretorio atual do nosso projeto
     */
    private final String currentDir = System.getProperty("user.dir");

    private final String storedDir = "/managedFiles/IO/";

    private final String fileName;

    public IOFilePecistences(String fileName) throws IOException {
        this.fileName = fileName;
        File file = new File(currentDir + storedDir);

        if (!file.exists() && !file.mkdirs()) throw new IOException("Erro ao criar arquivo");
        clearFile();
    }

    @Override
    public String write(String data) {
        //Fazendo escrita no arquivo
        try (var fileWrite = new FileWriter(currentDir + storedDir + fileName, true); var bufferedWrite = new BufferedWriter(fileWrite); var printWriter = new PrintWriter(bufferedWrite);) {
            printWriter.println(data);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    @Override
    public boolean remove(String sentence) {
        var content = findAll();
        var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
        if (contentList.stream().noneMatch(c -> c.contains(sentence))) return  false;
        clearFile();
        contentList.stream().filter(c -> !c.contains(sentence))
                .forEach(this::write);
        return  true;

    }

    @Override
    public String replace(String oldContent, String newContent) {
       var content = findAll();
       var contentList = new ArrayList<>(Stream.of(content.split(System.lineSeparator())).toList());
       if (contentList.stream().noneMatch(c -> c.contains(oldContent))) return  "";
       clearFile();
       contentList.stream()
               .map(c -> c.contains(oldContent) ? newContent : c)
               .forEach(this::write);
       return newContent;
    }

    @Override
    public String findAll() {
        StringBuilder content = new StringBuilder();
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line;
            do{
                line = reader.readLine();
                if (line != null) content.append(line).append(System.lineSeparator());
            }while (line != null);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content.toString();
    }

    @Override
    public String findBy(String sentence) {
        String found="";
        try (var reader = new BufferedReader(new FileReader(currentDir + storedDir + fileName))) {
            String line = reader.readLine();
            while (line != null) {
                if (line.contains(sentence)) {
                    found = line;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return found;
    }

    private void clearFile() {
        try (OutputStream outputStream = new FileOutputStream(currentDir + storedDir + fileName)) {
            System.out.println("Inicializando Recursos");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
