package space2.Modelo;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Tiro {

    private Image imagem;
    private int x, y;
    private int largura, altura;
    private boolean isVisivel;

    /* configurando onde o tiro ira sumir */
    private static final int LARGURA = 938;

    /* configurando velocidade do tiro */
    private static int VELOCIDADE = 6;

    /* para a posição do tiro sair da localização da nave */

    public Tiro(int x, int y) {
        this.x = x;
        this.y = y;
        isVisivel = true;
    }

    /* função para receber a imagem do tiro */
    public void load() {
        ImageIcon referencia = new ImageIcon("res/TiroShotDireita.png");
        imagem = referencia.getImage();

        this.largura = imagem.getWidth(null);
        this.altura = imagem.getHeight(null);
    }

    /* atualização do tiro na tela */
    public void update() {

        this.x += VELOCIDADE;
        if (this.x > LARGURA) {
            isVisivel = false;

        }

    }

    public boolean isVisivel() {
        return isVisivel;
    }

    public void setVisivel(boolean isVisivel) {
        this.isVisivel = isVisivel;
    }

    public static int getVELOCIDADE() {
        return VELOCIDADE;
    }

    public static void setVELOCIDADE(int vELOCIDADE) {
        VELOCIDADE = vELOCIDADE;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

}
