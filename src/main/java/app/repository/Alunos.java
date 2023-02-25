/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.repository;

import app.model.Aluno;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author mac
 */
public class Alunos {

    private static final String ARQUIVO_ALUNOS = "src/main/java/app/data/alunos.txt";

    private TreeSet<Aluno> alunos = null;
    private File arquivo;

    public Alunos() {
        if (alunos == null) {
            alunos = new TreeSet<Aluno>();
        }
        arquivo = new File(ARQUIVO_ALUNOS);
        carregaAlunos();
    }

    public void carregaAlunos() {
        try {
            Scanner scan = new Scanner(arquivo);
            while (scan.hasNextLine()) {
                String linha = scan.nextLine();
                Scanner scanline = new Scanner(linha);
                scanline.useDelimiter(",");
                while (scanline.hasNext()) {
                    String nome = scanline.next();
                    String telefone = scanline.next();
                    alunos.add(new Aluno(nome, telefone));
                }
            }
            arquivo.delete();

        } catch (Exception e) {
        }
    }

    public boolean add(Aluno p) {
        boolean add = this.alunos.add(p);
        if (add) try {
            FileWriter w = new FileWriter(arquivo, true);
            BufferedWriter bf = new BufferedWriter(w);
            bf.write(p.toString());
            bf.newLine();
            bf.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return add;
    }

    public void addAll(Collection ps) {
        this.alunos.addAll(ps);
    }

    public boolean contains(Aluno p) {

        return this.alunos.contains(p);
    }

    public TreeSet<Aluno> getTreeSet() {
        return alunos;
    }

    public Iterator<Aluno> iterator() {
        return this.alunos.iterator();
    }

}
