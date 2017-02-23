/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jefferson
 */
public class ControleRemoto implements Controlador{
    //Atributos
    private int volume;
    private boolean ligado;
    private boolean tocando;
    
    //Métodos Especiais

    public ControleRemoto() {
        this.volume = 50;
        this.tocando = false;
        this.ligado= false;
    }

    private int getVolume() {
        return volume;
    }

    private void setVolume(int volume) {
        this.volume = volume;
    }

    private boolean getLigado() {
        return ligado;
    }

    private void setLigado(boolean ligado) {
        this.ligado = ligado;
    }

    private boolean getTocando() {
        return tocando;
    }

    private void setTocando(boolean tocando) {
        this.tocando = tocando;
    }
    
    //Métodos abstratos
    @Override
    public void ligar() {
        this.setLigado(true);
    }

    @Override
    public void desligar() {
        this.setLigado(false);
    }

    @Override
    public void abrirMenu() {
        System.out.println("Está ligado " + this.getLigado());
        System.out.println("Está tocando " + this.getTocando());
        System.out.println("Volume: " + this.getVolume());
        for (int i = 0; i <= this.getVolume(); i+=10) {
            System.out.println("|");
            
        }
    }

    @Override
    public void fecharMenu() {
        System.out.println("Fechando Menu");
    }

    @Override
    public void maisVolume() {
        if (this.getLigado()) {
            this.setVolume(this.getVolume() + 5);
        }else{
            System.out.println("Impossível aumentar volume, aparelho desligado");
        }
    }

    @Override
    public void menosVolume() {
        if (this.getLigado()){
            this.setVolume(this.getVolume() - 5);
        }else{
            System.out.println("Impossível diminuir volume. Aparelho desligado");
        }
    }

    @Override
    public void ligarMudo() {
        if (this.getLigado()) {
            if (this.getTocando()) {
                this.setVolume(0);                
            }else{
                System.out.println("Aparelho está ligado mas não está tocando...");
            }
        }else{
            System.out.println("Aparelho está desligado");
        }
    }

    @Override
    public void desligarMudo() {
        if (this.getLigado() && this.getTocando() && this.getVolume() == 0) {
            this.setVolume(50);            
        }
    }

    @Override
    public void play() {
        this.setTocando(true);
    }

    @Override
    public void pause() {
        this.setTocando(false);
    }
     
}
