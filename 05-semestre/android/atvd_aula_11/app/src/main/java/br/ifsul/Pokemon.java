package br.ifsul;

import androidx.annotation.Nullable;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private String nome;
    private int image;

    public Pokemon(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return nome;
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return this.nome.equals(((Pokemon)obj).getNome());
    }
}